package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop = new Properties();
	
	private static String browser;
	private static String baseUrl;
	private static String gridValue;
	
	public static void readPropertiesFile() {

		try {
			
			InputStream input = new FileInputStream("C:\\Users\\thandos\\eclipse-workspace\\rappidassurance\\src\\test\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("Browser");
			baseUrl = prop.getProperty("BaseUrl");
			gridValue = prop.getProperty("GridValue");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getBrowser()
	{
		//local - readPropertiesFile();
		//return browser;
		return System.getProperty("Browser");
	}
	
	public static String getBaseUrl()
	{
		//local - readPropertiesFile();
		//return baseUrl;
		return System.getProperty("BaseUrl");
	}
	
	public static String getGridValue()
	{
		//local - readPropertiesFile();
		//return gridValue;
		return System.getProperty("gridValue");
	}
	
}
