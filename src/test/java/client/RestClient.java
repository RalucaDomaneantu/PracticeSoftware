package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
    //Trebuie sa fac 2 actiuni pe aceasta clasa:
        //1.Trebuie sa configurez clientul
        //2.Pe baza configurarilor trebuie sa pot sa execut orice actiune(get, post, put, delete)

    public Response performRequest(String requestType, RequestSpecification request, String endpoint){
        switch(requestType){
            case "POST":
                return prepareClient(request).post(endpoint);

            case "PUT":
                return prepareClient(request).put(endpoint);
            case "GET":
                return prepareClient(request).get(endpoint);

            case "DELETE":
                return prepareClient(request).delete(endpoint);

        }
        return null;
    }

    public RequestSpecification prepareClient(RequestSpecification request){
        request.baseUri("https://api.practicesoftwaretesting.com");
        request.header("Content-type", "application/json");
        request.header("Accept", "application/json");
        return request;

    }
}