package TestRunner;

import controller.UserController;
import org.testng.annotations.Test;
import setup.Setup;
import utlis.UserModel;

import java.io.IOException;

public class AgentTestRunner extends Setup {
    @Test (priority = 1, description = "Verify agent can be login successfully")
    public void doLogin() throws IOException {
        UserController userController = new UserController();
        userController.doLogin(props.getProperty("agentEmail"), props.getProperty("agentPassword") );
    }
    @Test (priority = 2, description = "Verify to transaction from agent to a customer successfully")
    public void  depositToAgent() throws IOException {
        String agent = props.getProperty("agentPhoneNumber");
        String firstCustomer = props.getProperty("customer1PhoneNumber");
        String amount = "1500";

        UserController userController = new UserController();
        UserModel model = new UserModel();
        model.setForm_account(agent);
        model.setTo_account(firstCustomer);
        model.setAmount(amount);
        userController.depositFormAgent(model);
    }
}
