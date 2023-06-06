package src.test;

import org.junit.jupiter.api.Test;
import src.classes.User;
import src.classes.UserService;

import static org.junit.jupiter.api.Assertions.*;
public class UserServiceTest {
    @Test
    void testuser(){
        UserService service = new UserService();
        User user = service.login("joao@email.com", "2308");
        assertNotNull(user);
    }

    @Test
    void verifyInformation(){
        UserService service = new UserService();
        User user = service.login("joao@email.com", "2308");

        user.getNome().equals("Joao");

        assertNotNull(user);
    }
}
