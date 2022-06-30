package Oracle11g.Entity;

public class Insurance {
    private String ID;
    private String name;
    private double price;
    private String agency;
    private String period;
    private String intro;
    private java.sql.Blob pic;

    private static java.util.List<String> contentList;

    static
    {
        contentList = new java.util.ArrayList<>();
        contentList.add("id");
        contentList.add("name");
        contentList.add("price");
        contentList.add("agency");
        contentList.add("period");
        contentList.add("intro");
        contentList.add("pic");
    }

    public static java.util.List<String> getContentList()
    {
        return Insurance.contentList;
    }

    public Insurance(String ID, String name)
    {
        this(ID, name, 0, null, null, null, null);
    }

    public Insurance(java.util.List<Object> list, int i)
    {
        this((String)list.get(i++), (String)list.get(i++), (double)list.get(i++), (String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (java.sql.Blob)list.get(i++));
    }

    public Insurance(String ID, String name, double price, String agency, String period, String intro, java.sql.Blob pic)
    {
        this.setID(ID);
        this.setName(name);
        this.setPrice(price);
        this.setAgency(agency);
        this.setPeriod(period);
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

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setAgency(String agency)
    {
        this.agency = agency;
    }

    public void setPeriod(String period)
    {
        this.period = period;
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

    public String getname()
    {
        return this.name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public String getAgency()
    {
        return this.agency;
    }

    public String getPeriod()
    {
        return this.period;
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
