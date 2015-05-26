package lys.test.properties;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class MyProperties {

	private static Properties properties = null;

	static {
		loadProperties();
	}

	private static void loadProperties() {

		InputStream is = null;
		Throwable error = null;

		try {
			is = MyProperties.class.getResourceAsStream("/lys/test/properties/test.properties");
		} catch (Throwable t) {
			handleThrowable(t);
		}

		if (is != null) {
            try {
                properties = new Properties();
                properties.load(is);
                is.close();
            } catch (Throwable t) {
                handleThrowable(t);
                error = t;
            }
        }
		
		if ((is == null) || (error != null)) {
            // Do something
			System.out.println("load properties error!!!");
        }
		
	}

	private static void registerToSystem() {
		// Register the properties as system properties
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            String value = properties.getProperty(name);
            if (value != null) {
                System.setProperty(name, value);
            }
        }
	}
	
	/**
     * Return specified property value.
     */
    public static String getProperty(String name) {
        return properties.getProperty(name);
    }

    
	private static void handleThrowable(Throwable t) {
		if (t instanceof ThreadDeath) {
			throw (ThreadDeath) t;
		}
		if (t instanceof VirtualMachineError) {
			throw (VirtualMachineError) t;
		}
		// All other instances of Throwable will be silently swallowed
	}

	public static void main(String[] args) {
//		InputStream is = MyProperties.class
//				.getResourceAsStream("/lys/test/properties/test.properties");
		// C:\windows24\system32\config\systemprofile\git\testproject\bin\lys\test\properties\test.properties
		System.out.println(MyProperties.getProperty("package.definition"));
		System.out.println(MyProperties.getProperty("package.access"));
		System.out.println("===========================================");
		MyProperties.registerToSystem();
		System.out.println(System.getProperty("package.definition"));
		System.out.println(System.getProperty("package.access"));
	}
}
