package services;

import client.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.RequestBrandModel;
import models.ResponseBrandModel;
import org.testng.Assert;
import types.EndpointType;
import types.RequestMethodType;
import types.ResponseStatusType;
import utils.LogUtility;

public class BrandService extends CommonService{

    public ResponseBrandModel createBrand(RequestBrandModel requestBody){
        LogUtility.infoLog("STEP 1: CREATE NEW BRAND");
        RequestSpecification request = RestAssured.given();
        request.body(requestBody);

        Response response = performRequest(RequestMethodType.REQUEST_POST,request, EndpointType.BRAND_CREATE_ENDPOINT);
        LogUtility.infoLog(response.getStatusLine());
        LogUtility.infoLog(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), ResponseStatusType.RESPONSE_CREATED);
        return response.getBody().as(ResponseBrandModel.class);
    }

    public void checkSpecificBrand(String brandID, int statusCode){
        LogUtility.infoLog("STEP 2: CHECK BRAND REQUEST");
        RequestSpecification request = RestAssured.given();

        Response response = performRequest(RequestMethodType.REQUEST_GET,request,EndpointType.BRAND_REQUEST_ENDPOINT+ brandID);
        LogUtility.infoLog(response.getStatusLine());
        LogUtility.infoLog(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    public void modifySpecificBrand(RequestBrandModel requestBody, String brandID){
        LogUtility.infoLog("STEP 3: UPDATE BRAND REQUEST");
        RequestSpecification request = RestAssured.given();
        request.body(requestBody);

        Response response = performRequest(RequestMethodType.REQUEST_PUT, request,EndpointType.BRAND_REQUEST_ENDPOINT+ brandID);
        LogUtility.infoLog(response.getStatusLine());
        LogUtility.infoLog(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), ResponseStatusType.RESPONSE_OK);
    }

    public void deleteSpecificBrand(String token, String brandID){
        LogUtility.infoLog("STEP 6: DELETE BRAND REQUEST");
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " +  token);

        Response response = performRequest(RequestMethodType.REQUEST_DELETE, request,EndpointType.BRAND_REQUEST_ENDPOINT+ brandID);
        LogUtility.infoLog(response.getStatusLine());
        LogUtility.infoLog(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), ResponseStatusType.RESPONSE_NO_CONTENT);
    }


}