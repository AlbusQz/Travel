package Oracle11g.Dao;


public class AdminDao extends BaseDao{
    private AdminDao() /* throws ClassNotFoundException, SQLException*/
    {
        super();
    }

    public static BaseDao getInstance()
    {
        BaseDao dao = BaseDao.getInstance();
        if(dao == null)
            dao = new AdminDao();
        return dao;
    }

}
