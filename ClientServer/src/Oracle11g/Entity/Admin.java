package Oracle11g.Entity;

import Oracle11g.Dao.BaseDao;

public class Admin extends AbstractAdmin{       //staff

    public Admin(String errorMessage)
    {
        super(errorMessage);
    }

    public Admin(String ID, String password, BaseDao dao)
    {
        super(ID, password, dao);
    }

    public Admin(String ID, String password, String tel, String person_id, BaseDao dao)
    {
        super(ID, password, tel, person_id, dao);
    }

}
