package utlis;

import groovy.json.JsonParser;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void setEnvVer(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key, value);
        config.save();
    }
    public static int randomId(int min, int max){
    double random = Math.random()*(max-min)+min;
    int randomId = (int) random;
    return randomId;
    }
    public static void saveUsersInfo(UserModel model) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileLocation));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",model.getName());
        jsonObject.put("email",model.getEmail());
        jsonObject.put("password",model.getPassword());
        jsonObject.put("phoneNumber",model.getPhone_number());
        jsonObject.put("nid",model.getNid());
        jsonObject.put("role",model.getRole());

        jsonArray.add(jsonObject);

        FileWriter fw = new FileWriter(fileLocation);
        fw.write(jsonArray.toJSONString());
        fw.flush();
        fw.close();
    }
}
