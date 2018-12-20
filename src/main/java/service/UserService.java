package service;

import model.User;

public interface UserService {

    public User findByColumn(String column, String key);

}