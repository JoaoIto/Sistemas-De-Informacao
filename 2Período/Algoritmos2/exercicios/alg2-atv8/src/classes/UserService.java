package src.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    public static void main(String[] args) {
        UserService service = new UserService();
        service.login(null, null);
        User user = service.login("joao@email.com", "2308");
        System.out.println(user);
    }
    public User login(String email, String senha){
        List<User> userList = new ArrayList<User>();

        userList.add(new User("Joao", "joao@email.com", "2308"));
        userList.add(new User("Fredson", "joao@email.com", "2355436"));
        userList.add(new User("Janio", "joao@email.com", "46885"));

        Optional<User> user = userList.stream()
                .filter(u -> u.getEmail().equals(email))
                .filter(u -> u.getSenha().equals(senha))
                .findFirst();

        return user.orElse(null);
    }
}
