package TestRunner;

import com.github.javafaker.Faker;
import controller.UserController;
import io.restassured.path.json.JsonPath;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utlis.UserModel;
import utlis.Utils;

import java.io.IOException;

public class CreateUserTestRunner {
    @Test(priority = 1, enabled = true, description = "Verify to create first customer successfully")
    public void createFirstUser() throws IOException, ConfigurationException, ParseException {
        Faker faker=new Faker();
        UserController userController=new UserController();

        UserModel model=new UserModel();
        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
        model.setPassword("P@ssword123");
        String phoneNumber="01702"+ Utils.randomId(100000,999999);
        model.setPhone_number(phoneNumber);
        model.setNid(String.valueOf(Utils.randomId(100000000,999999999)));
        model.setRole("Customer");

        JsonPath jsonPath= userController.createUser(model);
        String Email = jsonPath.get("user.email");
        String PhoneNumber = jsonPath.get("user.phone_number");
        String Password = jsonPath.get("user.password");

        Utils.setEnvVer("customer1Email", Email);
        Utils.setEnvVer("customer1PhoneNumber", PhoneNumber);
        Utils.setEnvVer("customer1Password", Password);
        Utils.saveUsersInfo(model);
    }
    @Test(priority = 2, enabled = true, description = "Verify to create Second customer successfully")
    public void createSecondUser() throws IOException, ConfigurationException, ParseException {
        Faker faker=new Faker();
        UserController userController=new UserController();

        UserModel model=new UserModel();
        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
        model.setPassword("P@ssword123");
        String phoneNumber="01902"+ Utils.randomId(100000,999999);
        model.setPhone_number(phoneNumber);
        model.setNid(String.valueOf(Utils.randomId(100000000,999999999)));
        model.setRole("Customer");

        JsonPath jsonPath= userController.createUser(model);
        String Email = jsonPath.get("user.email");
        String PhoneNumber = jsonPath.get("user.phone_number");
        String Password = jsonPath.get("user.password");

        Utils.setEnvVer("customer2Email", Email);
        Utils.setEnvVer("customer2PhoneNumber", PhoneNumber);
        Utils.setEnvVer("customer2Password", Password);
        Utils.saveUsersInfo(model);
    }
    @Test(priority = 3, enabled = true, description = "Verify to create an agent successfully")
    public void createAgent() throws IOException, ConfigurationException, ParseException {
        Faker faker=new Faker();
        UserController userController=new UserController();

        UserModel model=new UserModel();
        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
        model.setPassword("P@ssword123");
        String phoneNumber="01502"+ Utils.randomId(100000,999999);
        model.setPhone_number(phoneNumber);
        model.setNid(String.valueOf(Utils.randomId(100000000,999999999)));
        model.setRole("Agent");

        JsonPath jsonPath= userController.createUser(model);
        String Email = jsonPath.get("user.email");
        String PhoneNumber = jsonPath.get("user.phone_number");
        String Password = jsonPath.get("user.password");

        Utils.setEnvVer("agentEmail", Email);
        Utils.setEnvVer("agentPhoneNumber", PhoneNumber);
        Utils.setEnvVer("agentPassword", Password);
        Utils.saveUsersInfo(model);
    }
}
