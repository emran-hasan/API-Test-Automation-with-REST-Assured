package TestRunner;

import controller.UserController;
import org.testng.annotations.Test;
import setup.Setup;
import utlis.UserModel;

import java.io.IOException;

public class SystemTestRunner extends Setup {
    @Test(priority = 1,description = "Verify to successfully transaction from system to agent account")
    public void depositToAgent() throws IOException {
        String system = "System";
        String agent = props.getProperty("agentPhoneNumber");
        String amount = "2000";

        UserController userController = new UserController();
        UserModel model = new UserModel();
        model.setForm_account(system);
        model.setTo_account(agent);
        model.setAmount(amount);

        userController.depositToAgent(model);

    }
}
