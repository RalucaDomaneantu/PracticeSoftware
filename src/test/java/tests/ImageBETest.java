package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.RequestBrandModel;
import models.ResponseUserModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.ImageService;
import services.UserService;

public class ImageBETest {
    @Test
    public void testMethod() {

        ImageService imageService = new ImageService();
        imageService.obtainAllImages();

    }
}
