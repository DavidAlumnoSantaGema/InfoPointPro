package InfoPointPro;

import java.io.File;

import tools.jackson.databind.ObjectMapper;

public class JsonHandler
{
	private static final String ACCOUNTJSONFILENAME = "accounts.json";
	
	private static File accountJSON = new File(ACCOUNTJSONFILENAME);
	
	
	public JsonHandler()
	{
		
	}
	
	
	private static void main()
	{
		ObjectMapper mapper = new ObjectMapper();
		
		Test test1 = new Test(0, "Hola");
		Test test2 = new Test(12, "Adios");
		
		mapper.writeValue(accountJSON, test1);
		
	}
	
	
	public class Test
	{
		int num;
		String text;
		
		public Test(int num, String text)
		{
			this.num = num;
			this.text = text;
		}
	}
}