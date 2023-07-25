package Api;
import body.CreateCourseBody;
import body.LoginBody;
import body.UpdateCourseBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Courses {
    LoginBody loginBody;
    CreateCourseBody body;
    UpdateCourseBody updateCourseBody;
    public Courses(){
        RestAssured.baseURI = "http://localhost:3000/";
    }


    public Response getAuth(String email,String password){
        loginBody = new LoginBody();
        return RestAssured.given().log().all().header("Content-Type","application/json")
                .body(loginBody.loginBody(email,password)).post("login");

    }

    public Response createCourse(String title, String description,String token ){
        body = new CreateCourseBody();
        return RestAssured.given()
                .log().all()
                .header("Content-Type","application/json").header("Authorization","Bearer "+token)
                .body(body.createCourseBody(title,description))
                .when().post("660/courses");

    }

    public Response UpdateCourse(String title, String description,String token,int id ){
        updateCourseBody = new UpdateCourseBody();

        return RestAssured.given().log().all()
                .header("Content-Type","application/json").header("Authorization","Bearer "+token)
                        .pathParam("id",id).
                body(updateCourseBody.updateCourse(title,description)).when().put("660/courses/{id}");

    }

    public Response deleteCourse(String token , int id){
        return RestAssured.given().log().all()
                .header("Content-Type","application/json").header("Authorization","Bearer "+token)
                .pathParam("id",id).when().delete("660/courses/{id}");
    }




}
