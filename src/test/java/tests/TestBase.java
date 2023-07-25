package tests;

import Api.Courses;
import data.ReadJsonData;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;

public class TestBase {

    Courses booking;
    ReadJsonData loginData;
    ReadJsonData createCourseBody;
    ReadJsonData updateCourse;

    @BeforeMethod
    public void setData() throws FileNotFoundException {
        booking = new Courses();
        loginData = new ReadJsonData("src/test/java/data/login.json");
        createCourseBody = new ReadJsonData("src/test/java/data/courseBody.json");
        updateCourse = new ReadJsonData("src/test/java/data/updateCourseData.json");


    }
}
