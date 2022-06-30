package temp;

import dao.*;
import entity.*;

public class test {
	static public void main(String args[])
	{
		persondao pd = new persondao();
		Person p= pd.findPerson("370313200201011010");
		System.out.println(p.getId());
	}
	

}
