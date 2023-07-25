package body;

import org.json.simple.JSONObject;

public class UpdateCourseBody {

    public JSONObject updateCourse(String title, String description){
        JSONObject updateBody = new JSONObject();

        updateBody.put("title",title);
        updateBody.put("description",description);
        return updateBody;
    }
}
