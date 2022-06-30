package Oracle11g.Entity;

public class Hotel {
    private String ID;
    private String name;
    private String city;
    private String tel;
    private String intro;
    private java.sql.Blob pic;

    private static java.util.List<String> contentList;

    static
    {
        contentList = new java.util.ArrayList<>();
        contentList.add("id");
        contentList.add("name");
        contentList.add("city");
        contentList.add("tel");
        contentList.add("intro");
        contentList.add("pic");
    }

    public static java.util.List<String> getContentList()
    {
        return Hotel.contentList;
    }

    public Hotel(String ID, String name, String city)
    {
        this(ID, name, city, null, null, null);
    }

    public Hotel(java.util.List<Object> list, int i)
    {
        this((String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (java.sql.Blob)list.get(i++));
    }

    public Hotel(String ID, String name, String city, String tel, String intro, java.sql.Blob pic)
    {
        this.setID(ID);
        this.setName(name);
        this.setCity(city);
        this.setTel(tel);
        this.setIntro(intro);
        this.setPic(pic);
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public void setIntro(String intro)
    {
        this.intro = intro;
    }

    public void setPic(java.sql.Blob pic)
    {
        this.pic = pic;
    }

    public String getID()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCity()
    {
        return this.city;
    }

    public String getTel()
    {
        return this.tel;
    }

    public String getIntro()
    {
        return this.intro;
    }

    public java.sql.Blob getPic()
    {
        return this.pic;
    }
}
