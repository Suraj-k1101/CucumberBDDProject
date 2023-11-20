package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	
	Properties properties;
	
	String path = "config.properties";
	
	//constructor
	public ReadConfig()
	{
		try {
		properties = new Properties();
		String path = "config.properties";
		
         //to open config.properties file in input mode and load the file:-
			FileInputStream fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value!=null)
			return value;
	
		else
			throw new RuntimeException("url not specified inconfig file");
		
		
		
	}
	
}
