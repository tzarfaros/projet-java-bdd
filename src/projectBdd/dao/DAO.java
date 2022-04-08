package projectBdd.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<K, T> {


    public ArrayList<T> findAll() throws SQLException;
    public T findById(K id) throws ClassNotFoundException;
    public void insert(T obj);
    public void update(T obj);
    public void delete(K id);
}
