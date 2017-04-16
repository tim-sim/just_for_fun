import java.util.List;

/**
 * Created by tim on 17.04.2017.
 */
public interface UserDataSource {
    List<User> getUsers();

    User getUserById(int id);

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
