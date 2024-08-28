package TestRunner;

import controller.UserController;
import io.restassured.path.json.JsonPath;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminLoginTestRunner {
    @Test(priority = 1, description = "Verify admin can login successfully")
    public void adminDoLogin() throws IOException, ConfigurationException {
        UserController userController = new UserController();
        JsonPath jsonObj = userController.adminDoLogin("admin@roadtocareer.net","1234");
        String messageActual = jsonObj.get("message");
        String messageExpected = "Login successfully";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
}
