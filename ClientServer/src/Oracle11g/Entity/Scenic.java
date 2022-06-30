package Oracle11g.Entity;

public class Scenic {
    private String ID;
    private String name;
    private String city;
    private int capacity;
    private double price;
    private int stars;
    private String intro;
    private java.sql.Blob pic;

    private static java.util.List<String> contentList;

    static
    {
        contentList = new java.util.ArrayList<>();
        contentList.add("ID");
        contentList.add("name");
        contentList.add("city");
        contentList.add("capacity");
        contentList.add("price");
        contentList.add("stars");
        contentList.add("intro");
        contentList.add("pic");
    }

    public static java.util.List<String> getContentList()
    {
        return Scenic.contentList;
    }

    public Scenic(String ID, String name, String city)
    {
        this(ID, name, city, 0, 0, 0, null, null);
    }

    public Scenic(java.util.List<Object> list, int i)
    {
        this((String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (int)list.get(i++), (double)list.get(i++), (int)list.get(i++), (String)list.get(i++), (java.sql.Blob)list.get(i++));
    }

    public Scenic(String ID, String name, String city, int capacity, double price, int stars, String intro, java.sql.Blob pic)
    {
        this.setID(ID);
        this.setName(name);
        this.setCity(city);
        this.setCapacity(capacity);
        this.setPrice(price);
        this.setStars(stars);
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

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setStars(int stars)
    {
        this.stars = stars;
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

    public int getCapacity()
    {
        return this.capacity;
    }

    public double getPrice()
    {
        return this.price;
    }

    public int getStars()
    {
        return this.stars;
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
