package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getListUser();
    void createUser(User user);
    void updateUser(User user);
    User readUser(long id);
    void deleteUser(long id);

}
