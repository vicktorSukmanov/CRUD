package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getListUser();
    void createUser(User user);
    void updateUser(User user);
    User readUser(long id);
    void deleteUser(long id);

}
