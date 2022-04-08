package projectBdd.dao;

import projectBdd.module.Employee;
import projectBdd.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeDAO implements DAO<Integer, Employee>{

    @Override
    public ArrayList<Employee> findAll() throws SQLException {
        ArrayList<Employee> emps = new ArrayList<>();

        Connection c = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            c = ConnectionManager.getInstance().getConnection();
            st = c.createStatement();
            rs = st.executeQuery("select * from emp");

            while(rs.next()) {
                emps.add(new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        new Date(rs.getDate(5).getTime()),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.getInstance().closeStatement(st);
            ConnectionManager.getInstance().closeResultSet(rs);
        }

        return emps;
    }

    @Override
    public Employee findById(Integer id) throws ClassNotFoundException {
        Employee emp = null;
        Connection c = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            c = ConnectionManager.getInstance().getConnection();
            st = c.prepareStatement("select * from emp WHERE empno = ?");
            st.setInt(1,id);
            rs = st.executeQuery();

            rs.next();
            emp = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        new Date(rs.getDate(5).getTime()),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(st);
            ConnectionManager.getInstance().closeResultSet(rs);
        }
        return emp;
    }

    @Override
    public void insert(Employee obj) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = ConnectionManager.getInstance().getConnection();

            ps = c.prepareStatement("INSERT INTO EMP VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, obj.getEmpno());
            ps.setString(2, obj.getEname());
            ps.setString(3, obj.getJob());
            ps.setInt(4, obj.getMgr());
            ps.setDate(5, new java.sql.Date(obj.getHiredate().getTime()));
            ps.setInt(6, obj.getSal());
            ps.setInt(7, obj.getComm());
            ps.setInt(8, obj.getDeptno());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(ps);
        }

        System.out.println("employé créer");
    }

    @Override
    public void update(Employee obj) {
        Connection c = null;
        PreparedStatement ps = null;


        try {
            c = ConnectionManager.getInstance().getConnection();

            ps = c.prepareStatement("UPDATE EMP SET " + "ename = ?," + "job = ?," + "mgr = ?," + "hiredate = ?," + "sal = ?," + "comm = ?," + "deptno = ?," + " WHERE empno = ?");
            ps.setString(1, obj.getEname());
            ps.setString(2, obj.getJob());
            ps.setInt(3, obj.getMgr());
            ps.setDate(4, new java.sql.Date(obj.getHiredate().getTime()));
            ps.setInt(5, obj.getSal());
            ps.setInt(6, obj.getComm());
            ps.setInt(7, obj.getDeptno());
            ps.setInt(8, obj.getDeptno());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(ps);
        }

            System.out.println("employé modifié");

    }

    @Override
    public void delete(Integer id) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = ConnectionManager.getInstance().getConnection();

            ps = c.prepareStatement("DELETE FROM EMP WHERE empno = ?");
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(ps);
        }

        System.out.println("employé supprimé");

    }
}
