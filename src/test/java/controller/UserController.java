package controller;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import setup.Setup;
import utlis.UserModel;
import utlis.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UserController extends Setup {
    public UserController() throws IOException {
        readConfigFile();
    }
    public JsonPath doLogin(String email, String password){
        RestAssured.baseURI = props.getProperty("baseUrl");
        UserModel model = new UserModel();
        model.setEmail(email);
        model.setPassword(password);
        Response res = given().contentType("application/json").body(model).when().post("/user/login");
        return res.jsonPath();
    }
    public JsonPath adminDoLogin(String email, String password) throws ConfigurationException {
        RestAssured.baseURI=props.getProperty("baseUrl");
        UserModel model = new UserModel();
        model.setEmail(email);
        model.setPassword(password);
        Response res = given().contentType("application/json").body(model).post("/user/login");
        System.out.println(res.asString());
        JsonPath jsonPath = res.jsonPath();
        String token = jsonPath.get("token");
        System.out.println(token);
        Utils.setEnvVer("token", token);
        return jsonPath;
    }
//    public JsonPath  searchUser(String userId) throws IOException {
//        RestAssured.baseURI=props.getProperty("baseUrl");
//        Response res = given().contentType("application/json").header("Authorization",props.get("token")).
//                when().get("/user/search/id/"+userId);
//        return res.jsonPath();
//    }
    public JsonPath createUser(UserModel model) throws ConfigurationException {
        RestAssured.baseURI= props.getProperty("baseUrl");
        Response res=given().contentType("application/json")
                .header("Authorization",props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",props.getProperty("partnerKey"))
                .body(model)
                .when().post("/user/create");
        System.out.println(res.asString());
        return res.jsonPath();

    }
    public JsonPath depositToAgent(UserModel model){
        RestAssured.baseURI= props.getProperty("baseUrl");
        Response res =given().contentType("application/jason")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .when().post("/transaction/deposit");
        return res.jsonPath();
    }
    public JsonPath depositFormAgent(UserModel model){
        RestAssured.baseURI=props.getProperty("baseUrl");
        Response res =given().contentType("application/jason")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .when().post("/transaction/deposit");
        return res.jsonPath();
    }
    public JsonPath withdrawByCustomer(UserModel model){
        RestAssured.baseURI=props.getProperty("baseUrl");
        Response res =given().contentType("application/jason")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .when().post("/transaction/withdraw");
        return res.jsonPath();
    }
    public JsonPath sendMoney(UserModel model){
        RestAssured.baseURI=props.getProperty("baseUrl");
        Response res =given().contentType("application/jason")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .when().post("/transaction/sendmoney");
        return res.jsonPath();
    }
    public JsonPath payment(UserModel model){
        RestAssured.baseURI=props.getProperty("baseUrl");
        Response res =given().contentType("application/jason")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .when().post("/transaction/payment");
        return res.jsonPath();
    }
    public JsonPath checkBalance(String PhoneNumber){
        RestAssured.baseURI=props.getProperty("baseUrl");
        Response res =given().contentType("application/jason")
                .header("Authorization", props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("partnerKey"))
                .when().post("/transaction/balance/"+ PhoneNumber);
        return res.jsonPath();
    }
}
