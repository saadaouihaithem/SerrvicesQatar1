package com.smartTech.repositories;

import com.smartTech.Domain.Category;
import com.smartTech.Domain.User;
import com.smartTech.exeception.EtBadRequestException;
import com.smartTech.exeception.EtResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


@Repository
public class CategoryRepositoryImpl implements CategoryRepository {


    // Declare all the attribut to Access to the Data

    private static final String SQL_FIND_ALL = "SELECT C.CATEGORY_ID, C.USER_ID, C.TITLE, C.DESCRIPTION, " +
            "COALESCE(SUM(OP.price), 0) Price " +
            "FROM Operation OP RIGHT OUTER JOIN ET_CATEGORIES C ON C.CATEGORY_ID = OP.CATEGORY_ID " +
            "WHERE C.USER_ID = ? GROUP BY C.CATEGORY_ID";


    private static final String SQL_FIND_BY_ID = "SELECT C.CATEGORY_ID, C.USER_ID, C.TITLE, C.DESCRIPTION, " +
            "COALESCE(SUM(OP.price), 0) Price " +
            "FROM Operation OP RIGHT OUTER JOIN CATEGORY C ON C.CATEGORY_ID = C.CATEGORY_ID " +
            "WHERE C.USER_ID = ? AND C.CATEGORY_ID = ? GROUP BY C.CATEGORY_ID";

    private static final String SQL_CREATE = "INSERT INTO ET_CATEGORIES (CATEGORY_ID, USER_ID, TITLE, DESCRIPTION) VALUES(NEXTVAL('CATEGORY_SEQ'), ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE CATEGORY SET TITLE = ?, DESCRIPTION = ? " + "WHERE USER_ID = ? AND CATEGORY_ID = ?";
    private static final String SQL_DELETE_CATEGORY = "DELETE FROM CATEGORY WHERE USER_ID = ? AND CATEGORY_ID = ?";
    private static final String SQL_DELETE_ALL_Operation = "DELETE FROM OPERATION WHERE CATEGORY_ID = ?";
    private static final String SQL_FIND_BY_City = "SELECT CATEGORY_ID, PRICE  " +
            "FROM category  GROUP BY CATEGORY_ID" +
            " HAVING COUNT(DISTINCT city)=" +
            "(SELECT COUNT (DISTINCT city)FROM user)) ";


    //injection of jdbc template
    @Autowired
    JdbcTemplate jdbcTemplate;


//find all user byID OR Throw EXCEPTION
@Override
    public List<Category> findAll(Integer userId) throws EtResourceNotFoundException {
        return jdbcTemplate.query(SQL_FIND_ALL, new Object[]{userId},categoryRowMapper);
    }


// find all Category by id or throw exception resources not found
@Override
    public Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId, categoryId}, categoryRowMapper);
        } catch (Exception e) {
            throw new EtResourceNotFoundException("Category not found");
        }
    }

    // insert new user
    @Override
    public Integer create(Integer userId, String title, String description) throws EtBadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.setString(2, title);
                ps.setString(3, description);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("CATEGORY_ID");
        } catch (Exception e) {
            throw new EtBadRequestException("Invalid request");
        }
    }
    @Override
    public void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {
        try {
            jdbcTemplate.update(SQL_UPDATE, new Object[]{category.getTitle(), category.getDescription(), userId, categoryId});
        } catch (Exception e) {
            throw new EtBadRequestException("Invalid request");
        }
    }

    @Override
    public void removeById(Integer userId, Integer categoryId) {
        this.removeAllOperation(categoryId);
        jdbcTemplate.update(SQL_DELETE_CATEGORY, new Object[]{userId, categoryId});
    }
    //REMOVE ALL Category by id

    private void removeAllOperation(Integer categoryId) {
        jdbcTemplate.update(SQL_DELETE_ALL_Operation, new Object[]{categoryId});
    }


    private RowMapper<Category> categoryRowMapper = ((rs, rowNum) -> {
        return new Category(rs.getInt("CATEGORY_ID"),
                rs.getInt("USER_ID"),
                rs.getString("TITLE"),
                rs.getString("DESCRIPTION"),
                rs.getDouble("PRICE"));
    });


  }




