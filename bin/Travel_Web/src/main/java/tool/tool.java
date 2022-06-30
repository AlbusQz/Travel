package tool;

public class tool {
	static public String[] splitString(String s)
	{
		String[]output = s.split(" ");
		return output;
	}
	
	static public String getQuery(String s,String coloum)
	{
		String[]temp=tool.splitString(s);
		int len=temp.length;
		if(len<1)
			return null;
		String output=" "+coloum+" LIKE '%"+temp[0]+"%' ";
		for(int i=1;i<len;i++)
		{
			output+="AND "+coloum+" LIKE '%"+temp[i]+"%' ";
		}
		return output;
	}
	/*static public void main(String args[])
	{
		System.out.print(tool.getQuery("Çàµº º£¶û","INTRO"));;
	}*/
}
