package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            String SQL = "create table IF NOT EXISTS users(\n" +
                    "    id BIGINT NOT NULL AUTO_INCREMENT,\n" +
                    "    name varchar(50),\n" +
                    "    lastname varchar(50),\n" +
                    "    age TINYINT,\n" +
                    "\t\tPRIMARY KEY (id)\n" +
                    ");\n";

            Util.getConnection().createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            String SQL = "DROP TABLE IF EXISTS users";

            Util.getConnection().createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
         try {
            String SQL = "INSERT INTO users(name, lastname, age) value (?, ?, ?)";

            PreparedStatement preparedStatement = Util.getConnection().prepareStatement(SQL);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
//        long localId = id;
//        try {
//            String SQL = "delete from users where id = ";
//            Util.getConnection().createStatement().executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM users";

//            ResultSet resultSet = Util.getConnection().prepareStatement(SQL).executeQuery();
                ResultSet resultSet = Util.getConnection().createStatement().executeQuery(SQL);
                while (resultSet.next()){
                User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge((byte) resultSet.getInt("age"));

                allUsers.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
//        return null;
    }

    public void cleanUsersTable() {
        try {
            String SQL = "DELETE FROM new_db.users";
            Util.getConnection().createStatement().executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
