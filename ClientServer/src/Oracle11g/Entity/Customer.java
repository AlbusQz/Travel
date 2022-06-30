package Oracle11g.Entity;

public class Customer{
    private String ID;
    private String name;
    private String password;
    private java.sql.Date ctime;
    private String tel;
    private String email;
    private String person_id;

    private static java.util.List<String> contentList;

    static
    {
        contentList = new java.util.ArrayList<>();
        contentList.add("id");
        contentList.add("name");
        contentList.add("password");
        contentList.add("ctime");
        contentList.add("tel");
        contentList.add("email");
        contentList.add("person_id");
    }

    public static java.util.List<String> getContentList()
    {
        return Customer.contentList;
    }

    public Customer(String ID, String name, String password, String person_id)
    {
        this(ID, name, password, null, null, null, person_id);
    }

    public Customer(java.util.List<Object> list, int i)
    {
        this((String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (java.sql.Date)list.get(i++), (String)list.get(i++), (String)list.get(i++), (String)list.get(i++));
    }

    public Customer(String ID, String name, String password, java.sql.Date ctime, String tel, String email, String person_id)
    {
        this.setID(ID);
        this.setName(name);
        this.setPassword(password);
        this.setCtime(ctime);
        this.setTel(tel);
        this.setEmail(email);
        this.setPerson_id(person_id);
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setCtime(java.sql.Date ctime)
    {
        this.ctime = ctime;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPerson_id(String person_id)
    {
        this.person_id = person_id;
    }

    public String getID()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPassword()
    {
        return this.password;
    }

    public java.sql.Date getCtime()
    {
        return this.ctime;
    }

    public String getTel()
    {
        return this.tel;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPerson_id()
    {
        return this.person_id;
    }
}
