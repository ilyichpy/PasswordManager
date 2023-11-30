package org.manager.service;

import org.manager.models.PasswordInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component("passwordRepository")
public class PasswordRepositoryIml implements PasswordRepository {
    private final NamedParameterJdbcTemplate dataSource;

    @Autowired
    public PasswordRepositoryIml(@Qualifier("getDataSource")DataSource dataSource) {
        this.dataSource = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<PasswordInfo> findAll() {
        String sql = "SELECT * FROM manager.info";
        return dataSource.query(sql, new RowMapper<>() {
            @Override
            public PasswordInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new PasswordInfo(rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"));
            }
        });
    }

    @Override
    public Optional<PasswordInfo> findById(Long id) {
        PasswordInfo user = dataSource.query("select * from manager.info where id=" + id,
                new BeanPropertyRowMapper<>(PasswordInfo.class)).stream().findAny().orElse(null);
        return user == null ? Optional.empty() : Optional.of(user);

    }

    @Override
    public List<PasswordInfo> findByEmail(String email) {
        return dataSource.query("select * from manager.info where email=:email",
                new MapSqlParameterSource().addValue("email", email),
                new BeanPropertyRowMapper<>(PasswordInfo.class));
    }

    @Override
    public List<PasswordInfo> findByPassword(String password) {
        return dataSource.query("select * from manager.info where password=:password",
                new MapSqlParameterSource().addValue("password", password),
                new BeanPropertyRowMapper<>(PasswordInfo.class));
    }

    @Override
    public void update(PasswordInfo element) {

    }

    @Override
    public void save(PasswordInfo element) {
        try {
            dataSource.update("insert into manager.info(id, email, password) values(:id, :email, :password)",
                    new MapSqlParameterSource().
                            addValue("id", element.getId()).
                            addValue("email", element.getEmail()).
                            addValue("password", element.getPassword()));
        } catch (DataAccessException e) {
            System.err.println("this path and email already exists");
        }
    }


    @Override
    public void delete(Long id) {

    }
}
