import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by tim on 15.04.2017.
 */
public class DummyData implements UserDataSource {
    private User one = User.builder().id(1).username("yoda").email("master.yoda@gmail.com").build();
    private User two = User.builder().id(2).username("dvader").email("darth.vader@gmail.com").build();
    private User three = User.builder().id(3).username("leia").email("leia.organa@gmail.com").build();

    private List<User> users = Lists.newArrayList(one, two, three);

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        return (id > users.size() - 1) ? null : users.get(id - 1);
    }

    public User createUser(User user) {
        user.setId(users.size());
        users.add(user);
        return user;
    }

    public void updateUser(User user) {
        users.set(user.getId() - 1, user);
    }

    public void deleteUser(int id) {
        users.remove(id - 1);
    }
}
