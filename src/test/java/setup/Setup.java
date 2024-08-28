package setup;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Setup {
    public Properties props;
    public FileInputStream fs;
    @BeforeTest
    public void readConfigFile() throws IOException {
        props = new Properties();
        fs = new FileInputStream("./src/test/resources/config.properties");
        props.load(fs);
    }
}
