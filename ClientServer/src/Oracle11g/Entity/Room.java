package Oracle11g.Entity;

public class Room {
    private String ID;
    private String type;
    private String H_ID;
    private int capacity;
    private double price;

    private static java.util.List<String> contentList;

    static
    {
        contentList = new java.util.ArrayList<>();
        contentList.add("ID");
        contentList.add("type");
        contentList.add("h_id");
        contentList.add("capacity");
        contentList.add("price");
    }

    public static java.util.List<String> getContentList()
    {
        return Room.contentList;
    }

    public Room(String ID, String type, String H_ID)
    {
        this(ID, type, H_ID, 0, 0);
    }

    public Room(java.util.List<Object> list, int i)
    {
        this((String)list.get(i++), (String)list.get(i++), (String)list.get(i++), (int)list.get(i++), (double)list.get(i++));
    }

    public Room(String ID, String type, String H_ID, int capacity, double price)
    {
        this.setID(ID);
        this.setType(type);
        this.setH_ID(H_ID);
        this.setCapacity(capacity);
        this.setPrice(price);
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setH_ID(String H_ID)
    {
        this.H_ID = H_ID;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getID()
    {
        return this.ID;
    }

    public String getType()
    {
        return this.type;
    }

    public String getH_ID()
    {
        return this.H_ID;
    }

    public int getCapacity()
    {
        return this.capacity;
    }

    public double getPrice()
    {
        return this.price;
    }
}
