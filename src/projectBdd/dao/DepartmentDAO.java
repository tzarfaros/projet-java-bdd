package projectBdd.dao;

import projectBdd.module.Department;

import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDAO implements DAO<Integer, Department>{

    @Override
    public ArrayList<Department> findAll() throws SQLException {
        return null;
    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void delete(Integer id) {

    }
}
