package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesFile {
	
	Properties prop = new Properties();
	
	public static String getPropertyValuebyKey(String key) throws Exception {

		String workingDir = System.getProperty("user.dir");

		FileInputStream fis = new FileInputStream(workingDir+"/application.properties");
		Properties prop = new Properties();

		prop.load(fis);

		String value = prop.getProperty(key).toString();

		if(StringUtils.isEmpty(value))
		{
			throw new Exception("Value for key: "+key+ " is not specified in properties file");
		}

		return value;
	    }
	    
	}
	 