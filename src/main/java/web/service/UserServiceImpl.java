package web.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public List<User> getListUser() {
        return userDao.getListUser();
    }

    @Transactional
    @Override
    public void createUser(User user) {
      userDao.createUser(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
       userDao.updateUser(user);
    }
    @Transactional
    @Override
    public User readUser(long id) {
        return userDao.readUser(id);
    }
    @Transactional
    @Override
    public void deleteUser(long id) {
          userDao.deleteUser(id);
    }
}
