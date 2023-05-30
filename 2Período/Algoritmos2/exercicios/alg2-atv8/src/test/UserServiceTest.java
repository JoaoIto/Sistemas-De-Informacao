package src.test;

import org.junit.jupiter.api.Test;
import src.classes.User;
import src.classes.UserService;

import static org.junit.jupiter.api.Assertions.*;
public class UserServiceTest {
    @Test
    void test(){
        UserService service = new UserService();
        User user = service.login("joao@email.com", "2308");
        assertNotNull(user);
    }
}
