package study.apach.model.repositories;

import study.apach.model.db.DBManager;
import study.apach.model.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static final String SELECT_ALL_USERS = "SELECT u.id, u.name, u.age, r.description " +
                                                    "FROM users u, roles r " +
                                                    "WHERE r.id = u.role_id";

    private static final String SELECT_BY_ID = SELECT_ALL_USERS + " AND u.id = ?";

    private static final String INSERT_USER = "INSERT INTO users (name, age, role_id) " +
                                                "VALUES (?, ?, ?)";

    private static final String UPDATE_USER = "UPDATE users " +
                                                "SET name = ?, age = ?, role_id = ? " +
                                                "WHERE id = ?";

    private static final String DELETE_USER = "DELETE FROM users " +
                                                "WHERE id = ?";

    private static final String SEARCH_BY_ROLE = "SELECT u.id, u.name, u.age, r.description " +
                                                        "FROM users u, roles r " +
                                                        "WHERE u.role_id = ? AND r.id = u.role_id";

    @Override
    public Collection<User> findAll() {

        List<User> users = new ArrayList<>();

        try (Connection connection = DBManager.createConnection();
             Statement selectAllStatement = connection.createStatement();
             ResultSet rs = selectAllStatement.executeQuery(SELECT_ALL_USERS)) {

            while (rs.next()) {

                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("description")
                ));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User findOne(Long id) {

        User user = new User();

        try (Connection connection = DBManager.createConnection();
             PreparedStatement selectByIdStatement = connection.prepareStatement(SELECT_BY_ID)) {

            selectByIdStatement.setLong(1, id);
            ResultSet rs = selectByIdStatement.executeQuery();

            while (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setRoleDescription(rs.getString("description"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void save(User entity) {

        try (Connection connection = DBManager.createConnection();
             PreparedStatement insertStatement = entity.getId() == 0
                ? connection.prepareStatement(INSERT_USER)
                : connection.prepareStatement(UPDATE_USER)) {

            insertStatement.setString(1, entity.getName());
            insertStatement.setInt(2, entity.getAge());
            insertStatement.setLong(3, entity.getRoleId());
            if (entity.getId() != 0) {
                insertStatement.setLong(4, entity.getId());
            }
            insertStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {

        try (Connection connection = DBManager.createConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(DELETE_USER)) {

            deleteStatement.setLong(1, id);
            deleteStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<User> findByRole(long roleId) {

        List<User> users = new ArrayList<>();

        try (Connection connection = DBManager.createConnection();
             PreparedStatement searchStatement = connection.prepareStatement(SEARCH_BY_ROLE)) {

            searchStatement.setLong(1, roleId);
            ResultSet rs = searchStatement.executeQuery();

            while (rs.next()) {

                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("description")
                ));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void saveAll(List<User> users) {

        try (Connection connection = DBManager.createConnection();
             PreparedStatement insertStatement = connection.prepareStatement(INSERT_USER)) {

            for (User user : users) {

                insertStatement.setString(1, user.getName());
                insertStatement.setInt(2, user.getAge());
                insertStatement.setLong(3, user.getRoleId());

                insertStatement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
