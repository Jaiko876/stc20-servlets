package com.inno.dao;

import com.inno.ConnectionManager.ConnectionManager;
import com.inno.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDao implements IUserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    private static final String REGISTER_USER = "INSERT INTO mobile.user values (DEFAULT, ?, ?, ?, ?)";
    private static final String GET_USER_BY_ID = "SELECT * FROM mobile.user where id = ?";
    private static final String GET_ALL_USERS = "SELECT * from mobile.user";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM mobile.user where login = ?";
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM mobile.user where email = ?";
    private ConnectionManager connectionManager;

    @Inject
    public UserDao(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean addUser(User user) {
        try(Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Something went wrong with adding user in db", e);
            return false;
        }
        return true;
    }

    @Override
    public User getUserById(int id) {
        try(Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Something went wrong with getting user by id", e);
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        try(Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Something went wrong with getting user by id", e);
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        try(Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Something went wrong with getting user by id", e);
        }
        return null;
    }

    @Override
    public Collection<User> showUsers() {
        List<User> list = new ArrayList<>();
        try(Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
            return list;
        } catch (SQLException e) {
            LOGGER.error("Something went wrong with getting user by id", e);
        }
        return new ArrayList<>();
    }
}
