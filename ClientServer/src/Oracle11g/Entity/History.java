package Oracle11g.Entity;

public class History {
    private String ID;
    private String C_ID;
    private String type;
    private String P_ID;
    private java.sql.Timestamp ctime;
    private double price;
    private String state;
    private String intro;

    private static java.util.List<String> contentList;

    static
    {
        contentList = new java.util.ArrayList<>();
        contentList.add("id");
        contentList.add("c_id");
        contentList.add("type");
        contentList.add("p_id");
        contentList.add("ctime");
        contentList.add("price");
        contentList.add("state");
        contentList.add("intro");
    }

    public static java.util.List<String> getContentList()
    {
        return History.contentList;
    }

    public History(String ID, String C_ID)
    {
        this(ID, C_ID, null, null, null, 0, null, null);
    }

    public History(java.util.List<Object> list, int i)
    {
        this((String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (java.sql.Timestamp)list.get(i++), (double)list.get(i++), (String)list.get(i++), (String)list.get(i++));
    }

    public History(String ID, String C_ID, String type, String P_ID, java.sql.Timestamp ctime, double price, String state, String intro)
    {
        this.setID(ID);
        this.setC_ID(C_ID);
        this.setType(type);
        this.setP_ID(P_ID);
        this.setCtime(ctime);
        this.setPrice(price);
        this.setState(state);
        this.setIntro(intro);
    }


    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setC_ID(String C_ID)
    {
        this.C_ID = C_ID;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setP_ID(String P_ID)
    {
        this.P_ID = P_ID;
    }

    public void setCtime(java.sql.Timestamp ctime)
    {
        this.ctime = ctime;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setIntro(String intro)
    {
        this.intro = intro;
    }

    public String getID()
    {
        return this.ID;
    }

    public String getC_ID()
    {
        return this.C_ID;
    }

    public String getType()
    {
        return this.type;
    }

    public String getP_ID()
    {
        return this.P_ID;
    }

    public java.sql.Timestamp getCtime()
    {
        return this.ctime;
    }

    public double getPrice()
    {
        return this.price;
    }

    public String getState()
    {
        return this.state;
    }

    public String getIntro()
    {
        return this.intro;
    }
}
