package Oracle11g.Entity;

public class City{
    private String name;

    private static java.util.List<String> contentList;

    static
    {
        contentList = new java.util.ArrayList<>();
        contentList.add("name");
    }

    public static java.util.List<String> getContentList()
    {
        return City.contentList;
    }

    public City(String name)
    {
        this.setName(name);
    }

    public City(java.util.List<Object> list, int i)
    {
        this((String)list.get(i++));
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}
