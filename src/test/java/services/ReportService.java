package services;

import client.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import types.EndpointType;
import types.RequestMethodType;
import types.ResponseStatusType;
import utils.LogUtility;

public class ReportService extends CommonService{
    public void generateAvarageSalesPerMonthReport(String token){
        //Pasul 2: Generam raportul de vanzari medii pe luna
        LogUtility.infoLog("STEP 2: GENERATE RAPORT");
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " +  token);

        Response response = performRequest(RequestMethodType.REQUEST_GET,request, EndpointType.REPORTS_AVERAGE_SALES_ENDPOINT);
        LogUtility.infoLog(response.getStatusLine());
        LogUtility.infoLog(response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), ResponseStatusType.RESPONSE_OK);
    }

}
