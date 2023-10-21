package com.balenciigor.springboot.pp_3_1_2.DAO;


import com.balenciigor.springboot.pp_3_1_2.model.User;

import java.util.List;

public interface UserDAO {
    List<User> listUsers();
    void addUser(User user);
    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);
}
