package TestRunner;

import controller.UserController;
import org.testng.annotations.Test;
import setup.Setup;
import utlis.UserModel;

import java.io.IOException;

public class FirstCustomerTestRunner extends Setup {
    @Test(priority = 1, description = "Verify first customer can be login successfully")
    public void doLogin() throws IOException {
        UserController userController = new UserController();
        userController.doLogin(props.getProperty("customer1Email"), props.getProperty("customer1Password"));
    }
    @Test(priority = 2, description = "Verify withdraw 500 tk form customer to agent successfully")
    public void withdrawByCustomer() throws IOException {
        String customer = props.getProperty("customer1PhoneNumber");
        String agent = props.getProperty("agentPhoneNumber");
        String amount ="500";

        UserModel model = new UserModel();
        model.setForm_account(customer);
        model.setTo_account(agent);
        model.setAmount(amount);

        UserController userController = new UserController();
        userController.withdrawByCustomer(model);
    }
    @Test(priority = 3, description = "Verify send money 500 tk form first customer to second customer successfully")
    public void sendMoneySecondCustomer() throws IOException {
        String firstCustomer = props.getProperty("customer1PhoneNumber");
        String secondCustomer = props.getProperty("customer2PhoneNumber");
        String amount = "500";

        UserModel model = new UserModel();
        model.setTo_account(secondCustomer);
        model.setForm_account(firstCustomer);
        model.setAmount(amount);

        UserController userController= new UserController();
        userController.sendMoney(model);
    }
}
