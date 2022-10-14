import org.apache.log4j.PropertyConfigurator;

public class app {

	public static void main(String[] args) {
		
		String log4jConfPath = "src/test/resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
}
