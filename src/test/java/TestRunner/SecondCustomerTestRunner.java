package TestRunner;

import controller.UserController;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;
import utlis.UserModel;

import java.io.IOException;

public class SecondCustomerTestRunner extends Setup {
    @Test(priority = 1, description = "Verify first customer can be login successfully")
    public void doLogin() throws IOException {
        UserController userController = new UserController();
        userController.doLogin(props.getProperty("customer2Email"), props.getProperty("customer2Password"));
    }
    @Test(priority = 2, description = "Verify first customer payment to any merchant successfully")
    public void paymentToMerchant() throws IOException {
        String customer = props.getProperty("customer2PhoneNumber");
        String merchant = "01686606905";
        String amount = "100";

        UserModel model = new UserModel();
        model.setForm_account(customer);
        model.setTo_account(merchant);
        model.setAmount(amount);

        UserController userController = new UserController();
        userController.payment(model);
    }
    @Test(priority = 3, description = "Verify to check customer new balance successfully")
    public void checkBalance() throws IOException {
        UserController userController = new UserController();
        JsonPath balance = userController.checkBalance(props.getProperty("customer2PhoneNumber"));

//        String actualResult = balance.get("message");
//        String expectedResult = "User balance";
//        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
