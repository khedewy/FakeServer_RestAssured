package body;

import org.json.simple.JSONObject;

public class LoginBody {


    public JSONObject loginBody(String email, String password){
        JSONObject login = new JSONObject();
        login.put("email",email);
        login.put("password",password);
        return login;
    }
}
