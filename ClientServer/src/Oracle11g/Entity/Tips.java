package Oracle11g.Entity;

public class Tips {
    private String ID;
    private String C_ID;
    private java.sql.Date Ctime;
    private String text;
    private java.sql.Blob pic;

    private static java.util.List<String> contentList;

    static
    {
        contentList = new java.util.ArrayList<>();
        contentList.add("id");
        contentList.add("c_id");
        contentList.add("ctime");
        contentList.add("text");
        contentList.add("pic");
    }

    public static java.util.List<String> getContentList()
    {
        return Tips.contentList;
    }

    public Tips(String ID, String C_ID)
    {
        this(ID, C_ID, null, null, null);
    }

    public Tips(java.util.List<Object> list, int i)
    {
        this((String)list.get(i++), (String)list.get(i++), (java.sql.Date)list.get(i++), (String)list.get(i++), (java.sql.Blob)list.get(i++));
    }

    public Tips(String ID, String C_ID, java.sql.Date Ctime, String text, java.sql.Blob pic)
    {
        this.setID(ID);
        this.setC_ID(C_ID);
        this.setCtime(Ctime);
        this.setText(text);
        this.setPic(pic);
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setC_ID(String C_ID)
    {
        this.C_ID = C_ID;
    }

    public void setCtime(java.sql.Date Ctime)
    {
        this.Ctime = Ctime;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void setPic(java.sql.Blob pic)
    {
        this.pic = pic;
    }

    public String getID()
    {
        return this.ID;
    }

    public String getC_ID()
    {
        return this.C_ID;
    }

    public java.sql.Date getCtime()
    {
        return this.Ctime;
    }

    public String getText()
    {
        return this.text;
    }

    public java.sql.Blob getPic()
    {
        return this.pic;
    }
}
