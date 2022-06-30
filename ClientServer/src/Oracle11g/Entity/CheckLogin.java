package Oracle11g.Entity;

import java.sql.*;

import Oracle11g.Dao.AdminDao;

public class CheckLogin{

    /**
    *
    * 用以检查客户端前端输入的账号密码是否符合数据库表中记录，以进行管理员的登录验证。
    * 结果为{@code ""}当且仅当参数非空且完成数据库中Staff表的查询等操作后核实账号密码无误。
    *
    * @param    ID
    *           待验证的用户名(或称为管理员的ID)
    *
    * @param    password
    *           待验证的与{@code ID}相匹配的密码
    *
    * @return   {@code String}若验证成功返回空字符串{@code ""}，否则返回
    *           带有错误信息的字符串
    *
    */

    public static AbstractAdmin checkLogin(String ID, String password)
    {
        String errorMessage = "";                                       //错误信息，无异常返回空字符串。
        String tel = null;
        String person_id = null;

        do{
            if(ID == null || password == null || ID != null && ID.length() == 0 || password != null && password.length() == 0){
                errorMessage += "账号或密码不能为空，请重新输入。";
                break;
            }

            String oracle_forName = "oracle.jdbc.driver.OracleDriver";      //Oracle连接驱动地址
            String oracle_userName = "traveltest";                          //暂定以硬编码的形式，下密码同。
            String oracle_password = "travel";
            String oracle_url = "jdbc:oracle:thin:@localhost:1521:orcl";    //1521 -> port

            Connection cn = null;
            Statement st = null;
            ResultSet rs = null;

            try{
                Class.forName(oracle_forName);
            } catch(ClassNotFoundException e){
                errorMessage += "加载Oracle数据库连接时出错，登陆失败。\n";
                break;
            }

            try{
                cn = DriverManager.getConnection(oracle_url, oracle_userName, oracle_password);
            } catch(SQLException e){
                errorMessage += "创建数据库连接实例时出错，登陆失败。\n";
                break;
            }

            try{
                st = cn.createStatement();
            } catch(SQLException e){
                errorMessage += "获取Statement对象时出错，登录失败。\n";
                if(cn != null){
                    try{
                        cn.close();
                        cn = null;
                    } catch(SQLException e0){
                        errorMessage += "关闭数据库连接时出错。\n";
                    }
                }
                break;
            }

            try{
                String sql = "SELECT password, tel, person_id FROM staff WHERE ID = " + ID ;
                rs = st.executeQuery(sql);
                if(rs.next()){
                    if(password.equals(rs.getString(1)) == false){
                        errorMessage += "密码错误，请检查密码后重试。\n";           //password wrong
                    }
                    else{
                        tel = rs.getString(2);
                        person_id = rs.getString(3);
                    }
                }
                else{
                    errorMessage += "此用户不存在，请检查用户名后重试。\n";         //user noExists;
                }

            } catch(SQLException e){
                errorMessage += "执行查询语句获取结果集核实账号密码时出错，登陆失败。\n";
                try{
                    if(cn != null){
                        cn.close();
                        cn = null;
                    }
                } catch(SQLException e0){
                    errorMessage += "关闭数据库连接时出错。\n";
                }

                try{
                    if(st != null){
                        st.close();
                        st = null;
                    }
                } catch(SQLException e0){
                    errorMessage += "关闭Statement对象时出错。\n";
                }

                break;
            }
            finally{
                if(cn != null){
                    try{
                        cn.close();
                        cn = null;
                    } catch(SQLException e){
                        errorMessage += "核实账号密码后关闭数据库连接时出错。\n";
                    }
                }

                if(st != null){
                    try{
                        st.close();
                        st = null;
                    } catch(SQLException e){
                        errorMessage += "核实账号密码后关闭Statement对象时出错。\n";
                    }
                }

                if(rs != null){
                    try{
                        rs.close();
                        rs = null;
                    } catch(SQLException e){
                        errorMessage += "核实账号密码后关闭查询结果集时出错。\n";
                    }
                }
            }

        }while(false);

        return errorMessage.length() == 0 ? new Admin(ID, password, tel, person_id, AdminDao.getInstance()) : new Admin(errorMessage);
    }

}
