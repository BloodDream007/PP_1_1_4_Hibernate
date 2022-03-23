package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService userService = new UserServiceImpl();
       // userService.createUsersTable();
        //userService.dropUsersTable();
        //List<User> userList = userService.getAllUsers();
        //System.out.println(userService.getAllUsers());
//        userService.saveUser("Tanya", "Timuraeva", (byte) 27);
//        userService.saveUser("Stanislav", "Timuraev", (byte) 34);
        //userService.cleanUsersTable();
        userService.removeUserById(3);
    }
}
