package PetStore;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import juiceShop.frameworkUtils.Utils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static String petStoreBaseUrl = Utils.getConfigProperty("petStoreUrl");
    protected static RequestSpecification httpRequest;
    protected static final Gson gson = new Gson();

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = petStoreBaseUrl;
        httpRequest = RestAssured.given();
    }

    // Common method for send the HTTP request
    static Response sendRequest(Method method, String endpoint, Object body) {
        if (body != null) {
            httpRequest.body(gson.toJson(body));
        }
        return httpRequest.request(method, endpoint);
    }
    void validateResponse(Response response, int expectedStatusCode, String message) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
        if (message != null) {
            Assert.assertNotNull(response.jsonPath().getString("message"), "Message is null!");
        }
    }
}
