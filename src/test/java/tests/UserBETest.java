package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.AddressModel;
import models.RequestUserModel;
import models.ResponseUserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.UserService;
import sharedData.SharedData;

@Feature("@FEATURE-USER")
@Story("@STORY-USER-123")
public class UserBETest extends SharedData {
    @Test
     public void userTest(){
        AddressModel addressModel = new AddressModel("Street 1", "City","Country", "State", "1234AA");
        RequestUserModel requestBody = new RequestUserModel("Raluca", "Domaneantu", addressModel, "0987654321", "1970-01-01", "SuperSecure@123", "ralus@yahoo.com");

        UserService userService = new UserService();
        ResponseUserModel responseBody = userService.createUser(requestBody);

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(requestBody.getEmail(), requestBody.getPassword());
    }
}
