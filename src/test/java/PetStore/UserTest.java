package PetStore;

import PetStore.models.User;
import com.google.gson.Gson;
import io.restassured.http.Method;
import io.restassured.response.Response;
import juiceShop.frameworkUtils.Utils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class UserTest extends BaseTest {
    // DataProvider comun pentru utilizatori
    @DataProvider(name = "userData")
    public Iterator<Object[]> userData() {
        return Arrays.asList(
                new Object[]{"100", "alex", "Alex", "Gatu", "alex@alex.com", "Alex@123", "0754845125", "0"},
                new Object[]{"101", "john", "John", "Doe", "john@doe.com", "John@123", "0754845126", "1"}
        ).iterator();
    }

    // POST /user
    @Test(dataProvider = "userData")
    public void createUser(String id, String username, String firstName, String lastName, String email, String password, String phone, String status) {
        User user = new User(Long.parseLong(id), username, firstName, lastName, email, password, phone, Integer.parseInt(status));
        Response response = BaseTest.sendRequest(Method.POST, "/user", user);
        validateResponse(response, 415, "User creation failed");
    }

    // GET /user/{username}
    @Test
    public void getUser() {
        String username = "alex";
        Response response = sendRequest(Method.GET, "/user/" + username, null);
        if (response.getStatusCode() == 200) {
            User fetchedUser = gson.fromJson(response.getBody().asString(), User.class);
            Assert.assertEquals(fetchedUser.getUsername(), username, "Username mismatch!");
        } else {
            validateResponse(response, 404, null);
        }
    }

    // POST /user/createWithList
    @Test(dataProvider = "userData")
    public void createWithList(String id, String username, String firstName, String lastName, String email, String password, String phone, String status) {
        User user = new User(Long.parseLong(id), username, firstName, lastName, email, password, phone, Integer.parseInt(status));
        List<User> userList = Collections.singletonList(user);
        Response response = sendRequest(Method.POST, "/user/createWithList", userList);
        validateResponse(response, 415, "List creation failed");
    }

    // POST /user/createWithArray
    @Test(dataProvider = "userData")
    public void createWithArray(String id, String username, String firstName, String lastName, String email, String password, String phone, String status) {
        User user = new User(Long.parseLong(id), username, firstName, lastName, email, password, phone, Integer.parseInt(status));
        User[] userArray = {user};
        Response response = sendRequest(Method.POST, "/user/createWithArray", userArray);
        validateResponse(response, 415, "Array creation failed");
    }

    // PUT /user/{username}
    @Test(dataProvider = "userData")
    public void updateUser(String id, String username, String firstName, String lastName, String email, String password, String phone, String status) {
        User user = new User(Long.parseLong(id), username, firstName, lastName, email, password, phone, Integer.parseInt(status));
        Response response = sendRequest(Method.PUT, "/user/" + username, user);
        validateResponse(response, 415, "User update failed");
    }

    // DELETE /user/{username}
    @Test
    public void deleteUser() {
        String username = "string";
        Response response = sendRequest(Method.DELETE, "/user/" + username, null);
        validateResponse(response, 200, "User deletion failed");
    }
}
