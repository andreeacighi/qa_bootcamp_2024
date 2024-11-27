package PetStore;

import PetStore.models.Store;
import PetStore.models.User;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StoreTest extends BaseTest{

    @DataProvider(name = "orderDp")
    public Iterator<Object[]> orderDp (){
        return Arrays.asList(
                new Object[]{10,100,120,"2024-11-27","placed",true},
                new Object[]{5,100,120,"2024-11-25","placed",true},
                new Object[]{8,100,120,"2024-10-27","placed",true},
                new Object[]{9,1550,125,"2025-08-27","placed",true}
        ).iterator();
    }

    // GET /store/inventory
    @Test
    public void getStoreInventory(){
        Response response = sendRequest(Method.GET,"/store/inventory",null);
        if (response.getStatusCode() == 200) {
            Assert.assertNotNull(response.getBody(),"The body is null");
            System.out.println(response.getBody());
            System.out.println(response.getStatusCode());
        } else {
            validateResponse(response, 404, null);
        }
    }

    // GET /store/order/{orderId}
    @Test
    public void getStoreOrder(){
        int orderId = 9;
        Response response = sendRequest(Method.GET,"/store/order/" + orderId,null);
        if (response.getStatusCode() == 200) {
            Assert.assertNotNull(response.getBody(),"The body is null");
            JsonPath jsonPath = response.jsonPath();
            Assert.assertEquals(Integer.parseInt(jsonPath.getString("id")),orderId,"The id is not the same");
           // System.out.println(response.getStatusCode());
        }if (response.getStatusCode() == 400 ){
            validateResponse(response,400,null);
        }if (response.getStatusCode() == 404){
            validateResponse(response, 404, null);
            System.out.println("Order not found");
        }
    }

    // POST /store/order
    @Test(dataProvider = "orderDp")
    public void placeOrder(int id, int petId, int quantity, String shipDate,String status,boolean complete){

        Store store = new Store(id,petId,quantity,shipDate,status,complete);
        Response response = sendRequest(Method.POST,"/store/order",store);
        validateResponse(response, 415, "User creation failed");
    }

    // DELETE /store/order/{orderId}
    @Test
    public void deleteOrder(){
        int orderId = 10;
        Response response = sendRequest(Method.DELETE,"/store/order/" + orderId,null);
        if (response.getStatusCode() == 200){
            validateResponse(response, 200, "Order deletion failed");
        }else {
            validateResponse(response, 404, "Miss order");
        }


    }


}
