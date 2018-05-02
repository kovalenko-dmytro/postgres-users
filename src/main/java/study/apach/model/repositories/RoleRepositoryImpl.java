package study.apach.model.repositories;

import study.apach.model.db.DBManager;
import study.apach.model.entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoleRepositoryImpl implements RoleRepository {

    private static final String SELECT_ALL_ROLES ="SELECT id, description FROM roles";
    private static final String SELECT_BY_DESCRIPTION = "SELECT id, description FROM roles WHERE description = ?";

    @Override
    public Collection<Role> findAll() {

        List<Role> roles = new ArrayList<>();

        try (Connection connection = DBManager.createConnection();
             Statement selectAllStatement = connection.createStatement();
             ResultSet rs = selectAllStatement.executeQuery(SELECT_ALL_ROLES)) {

            while (rs.next()) {

                roles.add(new Role(
                        rs.getInt("id"),
                        rs.getString("description")
                ));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    @Override
    public Role findOne(Long id) {
        return null;
    }

    @Override
    public void save(Role entity) {

    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public Role findByDescription(String roleDescription) {

        Role role = new Role();

        try (Connection connection = DBManager.createConnection();
             PreparedStatement findStatement = connection.prepareStatement(SELECT_BY_DESCRIPTION)) {

            findStatement.setString(1, roleDescription);
            ResultSet rs = findStatement.executeQuery();

            while (rs.next()) {

                role.setId(rs.getInt("id"));
                role.setDescription(rs.getString("description"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }
}
