package tests;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class CoursesTest extends TestBase{

    @Test
    public void TestFakeServer() throws FileNotFoundException {

        // get accessToken
        String response = booking
                .getAuth(loginData.getTestData
                                ("email"),
                        loginData.getTestData("password"))
                .then().extract().response().asString();


        JsonPath jsonPath = new JsonPath(response);
        String token = jsonPath.getString("accessToken");
        System.out.println(token);

        // create new course

        String createCourseResponse = booking
                .createCourse(createCourseBody.getTestData("title"),
                        createCourseBody.getTestData("description")
                        ,token).then().assertThat().statusCode(201).extract().body().asString();



        jsonPath = new JsonPath(createCourseResponse);
        String title = jsonPath.getString("title");
        int id = jsonPath.getInt("id");
        System.out.println(id);
        System.out.println(createCourseResponse);

        Assert.assertEquals(createCourseBody.getTestData("title"),title);

        // update course
        String updateCourseResponse = booking.UpdateCourse(
                updateCourse.getTestData("title"),
                updateCourse.getTestData("description"),
                token,
                id).then().assertThat().statusCode(200).extract().response().asString();

        System.out.println(updateCourseResponse);


        // delete course created and updated

        String deleteResponse = booking.deleteCourse(token,id).then().extract().response().asString();

        System.out.println(deleteResponse);

    }

   }
