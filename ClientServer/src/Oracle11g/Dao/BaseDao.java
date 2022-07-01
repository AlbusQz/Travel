package Oracle11g.Dao;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

import Oracle11g.Entity.*;

public abstract class BaseDao {

    private static BaseDao instance = null;

    private Connection cn = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    // private String oracle_forName = "oracle.jdbc.driver.OracleDriver";      //Oracle连接驱动地址
    private String oracle_userName = "traveltest";                          //暂定以硬编码的形式，下密码同。
    private String oracle_password = "travel";
    private String oracle_url = "jdbc:oracle:thin:@localhost:1521:orcl";    //1521 -> port

    private String pSelect = "SELECT * FROM ";
    private String pInsert = "INSERT INTO ";
    private String pInsert_postfix_prefix = " VALUES (";
    private String pInsert_postfix_postfix = " )";
    private String pDelete = "DELETE FROM ";
    private String pUpdate = "UPDATE ";
    private String pUpdate_postfix = " SET ";
    private String where_clause = " WHERE ";

    private Map<String, Integer> map = new HashMap<>();

    private boolean autoCommit = false;

    public BaseDao() /*throws ClassNotFoundException, SQLException*/
    {
        super();
        map.put("City", 1);
        map.put("Customer", 7);
        map.put("History", 8);
        map.put("Hotel", 6);
        map.put("Insurance", 7);
        map.put("Line", 10);
        map.put("Person", 6);
        map.put("Room", 5);
        map.put("Scenic", 8);
        map.put("Ticket", 9);
        map.put("Tips", 5);
        // Class.forName(this.oracle_forName);

    }

    public static BaseDao getInstance()
    {
        return instance;
    }

    public Map<String, Integer> getCountMap()
    {
        return this.map;
    }

    public void setAutoCommit(boolean ac) throws Exception
    {
        this.autoCommit = ac;
    }

    public boolean getAutoCommit()
    {
        return this.autoCommit;
    }

    private void setPst(String table, String[] data) throws SQLException
    {
        int size = map.get(table);
        for(int i = 0;i < size;i++){
            switch(table){
                case("City") : 
                    this.pst.setString(i + 1, data[i]);
                    break;
                case ("Customer") : 
                    if(i == 3)
                        this.pst.setDate(i + 1, java.sql.Date.valueOf(data[i]));
                    else
                        this.pst.setString(i + 1, data[i]);
                    break;
                case ("History") : 
                    if(i == 4)
                        this.pst.setTimestamp(i + 1, java.sql.Timestamp.valueOf(data[i]));
                    else if(i == 0 || i == 1 || i == 3)
                        this.pst.setInt(i + 1, Integer.valueOf(data[i]));
                    else if(i == 5)
                        this.pst.setBigDecimal(i + 1, new BigDecimal(data[i]));
                    else
                        this.pst.setString(i + 1, data[i]);
                    break;
                case ("Hotel") : 
                    if(i != 4)
                        this.pst.setString(i + 1, data[i]);
                    break;
                case ("Insurance") : 
                    if(i != 5)
                        this.pst.setString(i + 1, data[i]);
                    break;
                case ("Line") : 
                    if(i != 8){
                        if(i == 2 || i == 4)
                            this.pst.setDate(i + 1, java.sql.Date.valueOf(data[i]));
                        else
                            this.pst.setString(i + 1, data[i]);
                    }
                    break;
                case ("Person") :
                    if(i == 3)
                        this.pst.setDate(i + 1, java.sql.Date.valueOf(data[i]));
                    // else if(i == 0)
                    //     this.pst.setInt(i + 1, Integer.valueOf(data[i]));
                    else
                        this.pst.setString(i + 1, data[i]);
                    break;
                case ("Room") : 
                    if(i == 0 || i == 2 || i == 3)
                        this.pst.setInt(i + 1, Integer.valueOf(data[i]));
                    else if(i == 4)
                        this.pst.setBigDecimal(i + 1, new BigDecimal(data[i]));
                    else
                        this.pst.setString(i + 1, data[i]);
                    break;
                case ("Scenic") : 
                    if(i == 0 || i == 3 || i == 5)
                        this.pst.setInt(i + 1, Integer.valueOf(data[i]));
                    else if(i == 4)
                        this.pst.setBigDecimal(i + 1, new BigDecimal(data[i]));
                    else
                        this.pst.setString(i + 1, data[i]);
                    break;
                case ("Ticket") : 
                    if(i == 2 || i == 4)
                        this.pst.setDate(i + 1, java.sql.Date.valueOf(data[i]));
                    else
                        this.pst.setString(i + 1, data[i]);
                    break;
                case ("Tips") : 
                    if(i != 4){
                        if(i == 2)
                            this.pst.setDate(i + 1, java.sql.Date.valueOf(data[i]));
                        else if(i == 0 || i == 1)
                            this.pst.setInt(i + 1, Integer.valueOf(data[i]));
                        else
                            this.pst.setString(i + 1, data[i]);
                    }
                    break;
                default : 
                    throw new SQLException( "表或视图 : \'" + table + "\'不存在。");
            }
        }
    }

    public ResultSet selectAll(String table, String condition) throws Exception
    {
        String query = this.pSelect + table;
        if(condition.equals("") == false){
            List<?> list = (List<?>)Class.forName("Oracle11g.Entity." + table).getMethod("getContentList").invoke(null);
            int size = list.size();
            query += this.where_clause;
            for(int i = 0;i < size;i++){
                query += list.get(i) + " like \'%%" + condition + "%%\'";
                if(i != size - 1)
                    query += " or ";
            }
        }
        return this.executeQuery(query);
    }

    public void getConnection() throws Exception
    {
        this.close();
        this.cn = DriverManager.getConnection(oracle_url, oracle_userName, oracle_password);
        // this.cn.setAutoCommit(autoCommit);
    }

    public void closeConnection() throws Exception
    {
        this.close();
    }

    public void commit() throws Exception
    {
        if(this.cn == null)
            throw new Exception("数据库链接为空，无法提交!");
        this.cn.commit();
    }

    public ResultSet executeQuery(String sql) throws SQLException
    {
        if(this.cn == null)
            throw new SQLException("无法连接到数据库，数据库连接为空!");
        this.cn.setAutoCommit(this.autoCommit);
        this.st = this.cn.createStatement();
        return this.st.executeQuery(sql);
    }

    public boolean execute(String sql) throws SQLException
    {
        if(this.cn == null)
            throw new SQLException("无法连接到数据库，数据库连接为空!");
        this.cn.setAutoCommit(this.autoCommit);
        this.st = this.cn.createStatement();
        return this.st.execute(sql);
    }

    public int executeInsert(String table, String[] data) throws Exception
    {
        if(this.cn == null)
            throw new SQLException("无法连接到数据库，数据库连接为空!");
        this.cn.setAutoCommit(this.autoCommit);
        String sql = this.pInsert + table + this.pInsert_postfix_prefix;
        int size = map.get(table);
        for(int i = 0;i < size;i++){
            sql += "?";
            if(i != size - 1)
                sql += ",";
        }
        sql += pInsert_postfix_postfix;
        this.pst = cn.prepareStatement(sql);

        this.setPst(table, data);

        return this.pst.executeUpdate();
    }

    public int executeDelete(String table, String id) throws Exception
    {
        if(this.cn == null)
            throw new SQLException("无法连接到数据库，数据库连接为空!");
        this.cn.setAutoCommit(this.autoCommit);
        String sql = this.pDelete + table + this.where_clause + "id = ?";
        this.pst = cn.prepareStatement(sql);            //remember to cancel label
        // if(table.equals("Person"))
        //     this.pst.setString(1, id);
        // else
            this.pst.setInt(1, Integer.valueOf(id));
        return this.pst.executeUpdate();
    }

    public int executeUpdate(String table, String[] data) throws Exception
    {
        if(this.cn == null)
            throw new SQLException("无法连接到数据库，数据库连接为空!");
        this.cn.setAutoCommit(this.autoCommit);
        List<?> list = (List<?>)Class.forName("Oracle11g.Entity." + table).getMethod("getContentList").invoke(null);
        String sql = this.pUpdate + table + this.pUpdate_postfix;
        int size = data.length;
        for(int i = 0;i < size;i++){
            sql += (list.get(i) + " = ? ");
            if(i != size - 1)
                sql += ",";
        }
        sql += this.where_clause + "id = ?";

        this.pst = cn.prepareStatement(sql);

        this.setPst(table, data);

        this.pst.setString(size + 1, data[0]);
        return this.pst.executeUpdate();
    }

    public int executeUpdate(String table, String id, String file_path) throws Exception
    {
        if(this.cn == null)
            throw new SQLException("无法连接到数据库，数据库连接为空!");
        this.cn.setAutoCommit(this.autoCommit);
        String sql = this.pUpdate + table + this.pUpdate_postfix;
        sql += ("pic" + " = ? " + this.where_clause + "id = ?");
        this.pst = cn.prepareStatement(sql);
        File file = new File(file_path);
        BufferedInputStream imageInput = new BufferedInputStream(new FileInputStream(file));
        this.pst.setBinaryStream(1,imageInput,(int)file.length());
        this.pst.setString(2, id);
        return this.pst.executeUpdate();
    }

    private String getProperPath(File file)
    {
        String p = null;
        if(file != null){
            String path = file.getAbsolutePath();
            int index = path.indexOf(".");
            p = path.substring(0, index) + path.substring(index + 2);
        }
        return p;
    }

    public String saveDeletedImage(Tips tip) throws Exception
    {
        Blob blob = tip.getPic();
        String directory = ".\\DeletedPic";
        String path = blob == null ? null : directory + "\\Tips_" + tip.getC_ID() + "_" + tip.getCtime() + ".jpg";
        File file = null;
        if(path != null){
            file = new File(path);
            File dir = new File(directory);
            if(dir.exists() == false)
                if(dir.mkdir() == false)
                    throw new Exception("创建目录" + this.getProperPath(dir) + "时出错");
            InputStream inputStream = blob.getBinaryStream();
            FileOutputStream fo = new FileOutputStream(file);
            int c;
            while((c = inputStream.read()) != -1)
                fo.write(c);
            inputStream.close();
            fo.close();
        }
        
        return this.getProperPath(file);
    }

    public void savePreviewImage(String path, Tips tip) throws Exception
    {
        InputStream inputStream = tip.getPic().getBinaryStream();
        FileOutputStream fo = new FileOutputStream(new File(path));
        int c;
        while((c = inputStream.read()) != -1)
            fo.write(c);
        inputStream.close();
        fo.close();
    }

    public java.awt.Image previewPic(Tips tip) throws Exception
    {
        Blob blob = tip.getPic();
        return blob == null ? null : java.awt.Toolkit.getDefaultToolkit().createImage(blob.getBytes(1,(int)blob.length())).getScaledInstance(450,470,java.awt.Image.SCALE_DEFAULT);
    }

    public ResultSet getRs()
    {
        return this.rs;
    }

    private void close() throws SQLException
    {
        if(this.cn != null){
            this.cn.close();
            this.cn = null;
        }
        if(this.st != null){
            this.st.close();
            this.st = null;
        }
        if(this.pst != null){
            this.pst.close();
            this.pst = null;
        }
        if(this.rs != null){
            this.rs.close();
            this.rs = null;
        }
    }

    public List<City> getCity(String condition) throws Exception
    {
        List<City> list = new ArrayList<>();
        String table = "City";
        
        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++)
                cityList.add(rs.getString(i + 1));
            list.add(new City(cityList, 0));
        }

        return list;
    }

    public List<Customer> getCustomer(String condition) throws Exception
    {
        List<Customer> list = new ArrayList<>();

        String table = "Customer";
        
        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 3)
                    cityList.add((rs.getDate(i + 1)));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new Customer(cityList, 0));
        }
        
        return list;
    }

    public List<History> getHistory(String condition) throws Exception
    {
        List<History> list = new ArrayList<>();

        String table = "History";
        
        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 4)
                    cityList.add(rs.getTimestamp(i + 1));
                else if(i == 5)
                    cityList.add(rs.getDouble(i + 1));
                // else if(i == 7)
                //     cityList.add(rs.getClob(i + 1));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new History(cityList, 0));
        }
        
        return list;
    }

    public List<Hotel> getHotel(String condition) throws Exception
    {
        List<Hotel> list = new ArrayList<>();

        String table = "Hotel";
        
        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 5)
                    cityList.add(rs.getBlob(i + 1));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new Hotel(cityList, 0));
        }
        
        return list;
    }

    public List<Insurance> getInsurance(String condition) throws Exception
    {
        List<Insurance> list = new ArrayList<>();

        String table = "Insurance";
        
        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 2)
                    cityList.add(rs.getDouble(i + 1));
                else if(i == 6)
                   cityList.add(rs.getBlob(i + 1));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new Insurance(cityList, 0));
        }
        
        return list;
    }

    public List<Line> getLine(String condition) throws Exception
    {
        List<Line> list = new ArrayList<>();

        String table = "Line";
        
        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 2 || i == 4)
                    cityList.add(rs.getDate(i + 1));
                else if(i == 6)
                    cityList.add(rs.getDouble(i + 1));
                else if( i == 9)
                    cityList.add(rs.getBlob(i + 1));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new Line(cityList, 0));
        }
        
        return list;
    }

    public List<Person> getPerson(String condition) throws Exception
    {
        List<Person> list = new ArrayList<>();
        String table = "Person";

        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 3)
                    cityList.add(rs.getDate(i + 1));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new Person(cityList, 0));
        }
        
        return list;
    }

    public List<Room> getRoom(String condition) throws Exception
    {
        List<Room> list = new ArrayList<>();

        String table = "Room";
        
        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 3)
                    cityList.add(rs.getInt(i + 1));
                else if(i == 4)
                    cityList.add(rs.getDouble(i + 1));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new Room(cityList, 0));
        }
        
        return list;
    }

    public List<Scenic> getScenic(String condition) throws Exception
    {
        List<Scenic> list = new ArrayList<>();

        String table = "Scenic";
        
        this.rs = this.selectAll(table,condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 3 || i == 5)
                  cityList.add(rs.getInt(i  + 1));
                else
                 if(i == 4)
                    cityList.add(rs.getDouble(i + 1));
                else if(i == 7)
                    cityList.add(rs.getBlob(i + 1));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new Scenic(cityList, 0));
        }
        
        return list;
    }

    public List<Ticket> getTicket(String condition) throws Exception
    {
        List<Ticket> list = new ArrayList<>();

        String table = "Ticket";
        
        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 2 || i == 4)
                    cityList.add(rs.getDate(i + 1));
                else if(i == 6)
                    cityList.add(rs.getDouble(i + 1));
                else if(i == 8)
                    cityList.add(rs.getBlob(i + 1));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new Ticket(cityList, 0));
        }
    
        return list;
    }

    public List<Tips> getTips(String condition) throws Exception
    {
        List<Tips> list = new ArrayList<>();

        String table = "Tips";
        
        this.rs = this.selectAll(table, condition);
        List<Object> cityList = new ArrayList<>();
        while(rs.next()){
            cityList.clear();
            for(int i = 0;i < this.map.get(table);i++){
                if(i == 2)
                    cityList.add(rs.getDate(i  + 1));
                else if(i == 4)
                    cityList.add(rs.getBlob(i + 1));
                else
                    cityList.add(rs.getString(i + 1));
            }
            list.add(new Tips(cityList, 0));
        }
        
        return list;
    }

}
