package PetStore;

import PetStore.models.Category;
import PetStore.models.Pet;
import PetStore.models.Tag;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;

public class PetTest extends BaseTest {
    @DataProvider(name = "FindPetById")
    public Iterator<Object[]> findPetDp (){
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"200","404",""});
        dp.add(new String[] {"10","200","doggie"});
        dp.add(new String[] {"9999","404",""});
        dp.add(new String[] {"101","200","khaire"});
        return dp.iterator();
    }
    @DataProvider(name = "FindPetByStatus")
    public Iterator<Object[]> findPetStatusDp (){
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"available","200"});
        dp.add(new String[] {"pending","200"});
        dp.add(new String[] {"sold","200"});
        return dp.iterator();
    }

    // GET /pet/{petId}
    @Test(dataProvider = "FindPetById")
    public void findPetById(String petId,String responseCode,String name){

        Response response = httpRequest.request(Method.GET,"/pet/" + petId);

        Assert.assertEquals(response.getStatusCode(),Integer.parseInt(responseCode));

        System.out.println(response.getStatusLine());
        assertThat(response.getStatusLine(), Matchers.containsStringIgnoringCase("HTTP/1.1"));
        Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
        Assert.assertEquals(response.getHeader("Access-Control-Allow-Methods"),"GET, POST, DELETE, PUT");
        // Partea de Body
        //System.out.println(response.getBody().asString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        if (response.getStatusCode() == 404){
            Assert.assertEquals(jsonPathEvaluator.getString("message"),"Pet not found");
        }
        if (response.getStatusCode() == 200){
            Assert.assertEquals(jsonPathEvaluator.getString("name"),name);
            // Assert.assertEquals(jsonPathEvaluator.getString("category.name"),"string");  //-nest Json
        }
        // Partea de Headers
        // Validarea Cookie-urilor din API
        Assert.assertEquals(response.getDetailedCookies().asList().size(),0);
        // Daca vrem sa vedem cookie-urile propriu zise
        /*
        Cookies cookies = response.getDetailedCookies();
        System.out.println("Found cookies: " + cookies.asList().size());
        for (Cookie c : cookies){
            System.out.println(c.getName()+": "+ c.getValue());
        }
         */
        // verificarea Headers din API
        /* Headers headers = response.getHeaders();
        for(Header h : headers){
            System.out.println(h.getName() + ": " + h.getValue());
        }
        */
       // System.out.println(response.prettyPrint());

    }
    // GET /pet/findByStatus
    @Test(dataProvider = "FindPetByStatus")
    public void findPetByStatus(String status,String responseCode){

        Response response ;
        if (status == null) {
            // Fără parametrul "status"
            response = httpRequest.request(Method.GET, "/pet/findByStatus");
        } else {
            // Cu parametrul "status"
            response = httpRequest
                    .queryParam("status", status)
                    .request(Method.GET, "/pet/findByStatus");
        }

        Assert.assertEquals(response.getStatusCode(),Integer.parseInt(responseCode),"The code is not what we expected");

        JsonPath jsonPathEvaluator = response.jsonPath();
        if (response.getStatusCode() == 400){
            Assert.assertEquals(jsonPathEvaluator.getString("message"),"Invalid status value");
        }
        if (response.getStatusCode() == 200){
            System.out.println("Response: " + response.prettyPrint());
            Assert.assertEquals(jsonPathEvaluator.getString("[0].status"),status);

        }


    }

    // POST /pet
    @Test
    public void createPet(){
        Category cat = new Category(231,"myName");
        Tag tag = new Tag(542,"tagName");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("http://myurl.com");
        Pet pet = new Pet(699,cat,"Bobita",photoUrls,tags,"available");

        // Serializare
        Gson gson = new Gson();
        System.out.println(gson.toJson(pet));

        Response response = sendRequest(Method.POST,"/pet",pet);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),415,"The code is not the same");

        // translatarea din json String inapoi in obiect
        // deserializare
        String jsonOutput = gson.toJson(pet);
        Pet myPet = gson.fromJson(jsonOutput,Pet.class);
        System.out.println(myPet.getName());
    }

    // Homework
    // PUT /pet
    @Test
    public void updatePet(){
        Category cat = new Category(231,"myName");
        Tag tag = new Tag(542,"tagName");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("http://myurl.com");
        Pet pet = new Pet(25,cat,"Eli",photoUrls,tags,"available");

        // Serializare
        Gson gson = new Gson();
        System.out.println(gson.toJson(pet));
        Response response = sendRequest(Method.PUT,"/pet",pet);
        System.out.println("Response Body: " + response.getBody().asString());

        String jsonOutput = gson.toJson(pet);
        Pet myPet = gson.fromJson(jsonOutput,Pet.class);
        System.out.println(response.getStatusCode());;

        Assert.assertEquals(myPet.getName(), pet.getName(), "Pet name not updated correctly!");
        Assert.assertEquals(response.getStatusCode(),415,"The code is not the same");



    }
    /*
    @Test
    public void createPet2(){
        // recomanda google json nu json
        // nu recomanda metoda asta
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "100");
        requestParams.put("name", "doggie");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toString());
        Response response = httpRequest.request(Method.POST,"/pet");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
    }

     */

    // POST /pet/{petId}/uploadImage
    @Test
    public void uploadImage() {
        int petId = 100;

        File imageFile = new File("src/test/resources/petImage.jpeg");
        Assert.assertTrue(imageFile.exists(), "Imaginea nu există!");

        Response response = httpRequest
                .multiPart("file", imageFile)
                .post("/pet/" + petId + "/uploadImage");

        validateResponse(response,200,"Status code is not 200");


        // Confirmarea succesului prin răspunsul API
        String message = response.jsonPath().getString("message");
        Assert.assertNotNull(message, "Mesajul din răspuns este null!");
        System.out.println(response.prettyPrint());
    }

    @Test
    public void deletePet(){
        int id = 7;
        Response response = sendRequest(Method.DELETE,"/pet/" + id,null);
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        if (response.getStatusCode() == 404){
            assertThat(response.getStatusLine(), Matchers.containsStringIgnoringCase("HTTP/1.1 404 Not Found"));
        }else{
        validateResponse(response,200,"The pet is not deleted");}
    }



}
