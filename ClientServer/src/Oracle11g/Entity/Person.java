package Oracle11g.Entity;

public class Person{
    private String ID;
    private String name;
    private String sex;
    private java.sql.Date bday;
    private String address;
    private String nationality;

    private static java.util.List<String> contentList;

    static
    {
        contentList = new java.util.ArrayList<>();
        contentList.add("id");
        contentList.add("name");
        contentList.add("sex");
        contentList.add("bday");
        contentList.add("address");
        contentList.add("nationality");
    }

    public static java.util.List<String> getContentList()
    {
        return Person.contentList;
    }

    public Person(String ID, String name, String sex)
    {
        this(ID, name, sex, null, null, null);
    }

    public Person(java.util.List<Object> list, int i)
    {
        this((String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (java.sql.Date)list.get(i++), (String)list.get(i++), (String)list.get(i++));
    }

    public Person(String ID, String name, String sex, java.sql.Date bday, String address, String nationality)
    {
        this.setID(ID);
        this.setName(name);
        this.setSex(sex);
        this.setBday(bday);
        this.setAddress(address);
        this.setNationality(nationality);
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public void setBday(java.sql.Date bday)
    {
        this.bday = bday;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getID()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }

    public String getSex()
    {
        return this.sex;
    }

    public java.sql.Date getBday()
    {
        return this.bday;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getNationality()
    {
        return this.nationality;
    }
}
