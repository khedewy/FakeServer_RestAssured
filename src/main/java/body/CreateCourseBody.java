package body;

import org.json.simple.JSONObject;

public class CreateCourseBody {

    public JSONObject createCourseBody(String title, String description){
        JSONObject CourseBody = new JSONObject();

        CourseBody.put("title",title);
        CourseBody.put("description",description);

        return CourseBody;

    }
}
