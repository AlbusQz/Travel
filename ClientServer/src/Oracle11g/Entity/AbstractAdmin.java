package Oracle11g.Entity;

import Oracle11g.Dao.BaseDao;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public abstract class AbstractAdmin{

    private static final Logger logger = LogManager.getLogger();

    private String ID;
    private String password;
    private String tel;
    private String person_id;
    private String errorMessage;

    private BaseDao dao;

    private static AbstractAdmin admin;

    static
    {
        AbstractAdmin.admin = null;
    }

    public AbstractAdmin(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public AbstractAdmin(String ID, String password, BaseDao dao)
    {
        this(ID, password, null, null, dao);
    }

    public AbstractAdmin(String ID, String password, String tel, String person_id, BaseDao dao)
    {
        this.setAdmin(ID, password, tel, person_id);
        this.setDao(dao);
    }

    public static void initAdmin(AbstractAdmin logedin_admin)
    {
        AbstractAdmin.admin = logedin_admin;
        logger.info("[登录]管理员 : " + admin.getID() + "\t登录成功。");
    }

    public static AbstractAdmin getAdmin()
    {
        return AbstractAdmin.admin;
    }

    public void setAutoCommit(boolean ac) throws Exception
    {
        try{
            if(this.dao != null)
                dao.setAutoCommit(ac);
            else
                throw new Exception("Dao类为空，无法设置自动提交。");
        } catch (Exception e){
            logger.error("[自动提交设置错误]" + e.getMessage());
            throw e;
        }
    }

    public void commit() throws Exception
    {
        try{
            if(this.dao != null){
                this.dao.commit();
                logger.info("[提交]" + "提交事务");
            }
            else
                throw new Exception("Dao类连接为空，无法提交。");
        } catch(Exception e){
            logger.error("[提交错误]" + e.getMessage());
            throw e;
        }
    }

    public void getConnection() throws Exception
    {
        try{
            if(this.dao != null)
                this.dao.getConnection();
            else
                throw new Exception("Dao类为空，无法获取数据库连接。");
        } catch(Exception e){
            logger.error("[获取数据库连接错误]" + e.getMessage());
            throw e;
        }
    }

    public void closeConnection() throws Exception
    {
        try{
            if(this.dao != null)
                this.dao.closeConnection();
            else
                throw new Exception("Dao类为空，无法关闭数据库连接。");
        } catch(Exception e){
            logger.error("[关闭数据库连接错误]" + e.getMessage());
            throw e;
        }
    }

    private void setAdmin(String ID, String password)
    {
        this.setID(ID);
        this.setPassword(password);
    }

    private void setAdmin(String ID, String password, String tel, String person_id)
    {
        this.setAdmin(ID, password);
        this.setTel(tel);
        this.setPerson_id(person_id);
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public void setPerson_id(String person_id)
    {
        this.person_id = person_id;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public void setDao(BaseDao dao)
    {
        this.dao = dao;
    }

    private String getDatas(String table, String[] data) throws Exception
    {
        List<?> list = (List<?>)Class.forName("Oracle11g.Entity." + table).getMethod("getContentList").invoke(null);
        int l = data.length;
        String result = "{";
        for(int i = 0;i < l;i++){
            result += (list.get(i) + " : " + data[i]);
            if(i != l - 1)
                result += ",";
        }
        result += "}";
        return result;
    }

    public int executeInsert(String table, String[] data) throws Exception      //traditional insert,String[] data represents data to be inserted
    {
        try{
            if(this.dao != null){
                int t = this.dao.executeInsert(table, data);
                String cmit = this.dao.getAutoCommit() ? "已自动提交" : "未提交";
                if(t == 1)
                    logger.info("[向表\'" + table + "中\'插入如下数据 " + cmit + "]\n插入数据 : " + this.getDatas(table, data));
                return t;
            }
            else
                throw new Exception("Dao类为空，无法执行插入操作");
        } catch(Exception e){
            logger.error("[插入表\'" + table + "\'中数据错误]" + e.getMessage());
            throw e;
        }
    }

    public int executeDelete(String table, String[] data) throws Exception      //traditional delete,String[] data represents original data
    {
        try{
            if(this.dao != null){
                int t = this.dao.executeDelete(table, data[0]);
                String cmit = this.dao.getAutoCommit() ? "已自动提交" : "未提交";
                if(t == 1)
                    logger.info("[删除表\'" + table + "\'中如下所示的数据 " + cmit + "]\n原始数据 : " + this.getDatas(table, data));
                return t;
            }
            else
                throw new Exception("Dao类为空，无法执行删除操作");
        } catch(Exception e){
            logger.error("[删除表\'" + table + "\'中数据错误]" + e.getMessage());
            throw e;
        }
    }

    public int executeDelete(String table, List<Tips> list, int slrow) throws Exception //delete from table which has blob and record it as well
    {
        try{
            if(this.dao != null){
                Tips tip = list.get(slrow);
                int t = this.dao.executeDelete(table, tip.getID());
                String cmit = this.dao.getAutoCommit() ? "已自动提交" : "未提交";
                if(t == 1){
                    String[] data = new String[]{
                        tip.getID(), tip.getC_ID(), tip.getCtime().toString(), tip.getText().toString(), this.dao.saveDeletedImage(tip)
                    };
                    logger.info("[删除表\'" + table + "\'中如下所示的数据 " + cmit + "]\n原始数据 : " + this.getDatas(table, data));
                }
                return t;
            }
            else{
                throw new Exception("Dao类为空，无法执行删除操作");
            }
        } catch(Exception e){
            logger.error("[删除表\'" + table + "\'中数据错误]" + e.getMessage());
            throw e;
        }
    }

    public int executeUpdate(String table, String[] data, String[] origin_data) throws Exception    //traditional update,
                                         //String[] data represents data to be inserted and String[] origin_data represents origin data used to be recorded
    {
        try{
            if(this.dao != null){
                int t = this.dao.executeUpdate(table, data);
                String cmit = this.dao.getAutoCommit() ? "已自动提交" : "未提交";
                if(t == 1)
                    logger.info("[更新表\'" + table + "\'中如下所示的数据 "+ cmit + "]\n原始数据 : " + this.getDatas(table, origin_data) + 
                    "\n更新数据 : " + this.getDatas(table, data));
                return t;
            }
            else
                throw new Exception("Dao类为空，无法执行更新操作");
        }catch(Exception e){
            logger.error("[更新表\'" + table + "\'中数据错误]" + e.getMessage());
            throw e;
        }
    }

    public int executeUpdate(String table, List<Tips> list, int slrow, String file_path) throws Exception   //insert blob pointed by Stirng file_path
    {
        try{
            if(this.dao != null){
                Tips tip = list.get(slrow);
                int t = this.dao.executeUpdate(table, tip.getID(), file_path);
                String cmit = this.dao.getAutoCommit() ? "已自动提交" : "未提交";
                if(t == 1){
                    logger.info("[更新表\'" + table + "\'中的如下所示的图片 " + cmit + "]\n原始数据 : " + this.dao.saveDeletedImage(tip) + 
                    "\n更新数据 : " + file_path);
                }
                return t;
            }
            else
                throw new Exception("Dao类为空，无法执行更新操作");
        } catch (Exception e){
            logger.error("[更新表\'" + table + "\'中数据错误]" + e.getMessage());
            throw e;
        }
    }

    public java.awt.Image previewPic(String table, List<Tips> list, int slrow) throws Exception //get the image from seleted row which contains blob
    {
        try{
            if(this.dao != null){
                return this.dao.previewPic(list.get(slrow));
            }
            else
                throw new Exception("Dao类为空，无法执行更新操作");
        } catch(Exception e){
            logger.error("[预览表\'" + table + "\'中图片数据错误]" + e.getMessage());
            throw e;
        }
    }

    public void savePreviewImage(String table, List<Tips> list, int slrow, String file_path) throws Exception //save the image which is under preview
                                                                                                            //in directory 'file_path'
    {
        try{
            if(this.dao != null)
                this.dao.savePreviewImage(file_path, list.get(slrow));
            else
                throw new Exception("Dao类为空，无法执行更新操作");
        } catch(Exception e){
            logger.error("[保存表\'" + table + "\'中图片数据错误]" + e.getMessage());
            throw e;
        }
    }

    public String getID()
    {
        return this.ID;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getTel()
    {
        return this.tel;
    }

    public String getPerson_id()
    {
        return this.person_id;
    }

    public String getErrorMessage()
    {
        return this.errorMessage;
    }

    public BaseDao getDao()
    {
        return this.dao;
    }

    public java.util.Map<String, Integer> getCountMap()
    {
        return this.dao.getCountMap();
    }

    public List<City> getCity(String condition) throws Exception
    {
        try{
            return this.dao.getCity(condition);
        } catch(Exception e){
            logger.error("[获取表\'City\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<Customer> getCustomer(String condition) throws Exception
    {
        try{
            return this.dao.getCustomer(condition);
        } catch(Exception e){
            logger.error("[获取表\'Customer\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<History> getHistory(String condition) throws Exception
    {
        try{
            return this.dao.getHistory(condition);
        } catch(Exception e){
            logger.error("[获取表\'History\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<Hotel> getHotel(String condition) throws Exception
    {
        try{
            return this.dao.getHotel(condition);
        } catch(Exception e){
            logger.error("[获取表\'Hotel\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<Insurance> getInsurance(String condition) throws Exception
    {
        try{
            return this.dao.getInsurance(condition);
        } catch(Exception e){
            logger.error("[获取表\'Insurance\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<Line> getLine(String condition) throws Exception
    {
        try{
            return this.dao.getLine(condition);
        } catch(Exception e){
            logger.error("[获取表\'Line\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<Person> getPerson(String condition) throws Exception
    {
        try{
            return this.dao.getPerson(condition); 
        } catch(Exception e){
            logger.error("[获取表\'Person\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<Room> getRoom(String condition) throws Exception
    {
        try{
            return this.dao.getRoom(condition);
        } catch(Exception e){
            logger.error("[获取表\'Room\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<Scenic> getScenic(String condition) throws Exception
    {
        try{
            return this.dao.getScenic(condition);
        } catch(Exception e){
            logger.error("[获取表\'Scenic\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<Ticket> getTicket(String condition) throws Exception
    {
        try{
            return this.dao.getTicket(condition);
        } catch(Exception e){
            logger.error("[获取表\'Ticket\'出错]" + e.getMessage());
            throw e;
        }
    }

    public List<Tips> getTips(String condition) throws Exception
    {
        try{
            return this.dao.getTips(condition);
        } catch(Exception e){
            logger.error("[获取表\'Tips\'出错]" + e.getMessage());
            throw e;
        }
    }

}
