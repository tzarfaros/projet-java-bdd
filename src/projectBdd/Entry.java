package projectBdd;

import projectBdd.dao.EmployeeDAO;
import projectBdd.module.Employee;
import projectBdd.utils.ConnectionManager;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Entry {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        EmployeeDAO eDao = new EmployeeDAO();
        ArrayList<Employee> emps = eDao.findAll();

        for (Employee emp : emps) {
            System.out.println(emp);
        }

        System.out.println("------------");

        /*Employee e1 = eDao.findById(7499);
        System.out.println(e1);*/

        /*Employee e2 = new Employee(2526, "Vincent", "IT", 7500, new Date(), 800, 300, 30);
        eDao.insert(e2);*/

        //Employee e1 = eDao.findById(2526);
        //System.out.println(e1);
        /*e1.setJob("MANAGER");
        eDao.update(e1);

        System.out.println(e1);*/

        //eDao.delete(e1.getEmpno());

        ConnectionManager.getInstance().close();

    }

    public static void exo1() {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date d = sdf.parse("10/10/2012");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/scott", "root", "");

            // requête SELECT

            /*Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from emp");

            while(rs.next()) {
                System.out.println(rs.getString("ename") + rs.getString("sal"));
            }

            // requête SELECT avec condition

            PreparedStatement st1 = c.prepareStatement("select * from emp where sal > ? AND ename like ?");
            st1.setInt(1,1500);
            st1.setString(2,"%N%");
            ResultSet rs1 = st1.executeQuery();

            while(rs1.next()) {
                System.out.println(rs1.getString("ename") + rs1.getString("sal"));
            }*/

            // Code requête pour créer un employé : requête INSERT INTO

            /*PreparedStatement ps = c.prepareStatement("INSERT INTO EMP VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, 2626);
            ps.setString(2, "Vincent");
            ps.setString(3, "MANAGER");
            ps.setInt(4, 7839);
            ps.setDate(5, new java.sql.Date(d.getTime()));
            ps.setInt(6, 1900);
            ps.setInt(7, 1400);
            ps.setInt(8, 20);

            ps.executeUpdate();*/

            // Code requête pour modifier un employé : requête UPDATE

            /*PreparedStatement ps = c.prepareStatement("UPDATE EMP SET sal = ? WHERE empno = 2626");
            ps.setInt(1, 1000);

            ps.executeUpdate();*/

            // code requête pour supprimer un employé : requête DELETE

            /*PreparedStatement ps = c.prepareStatement("DELETE FROM emp WHERE empno = 2626");

            ps.executeUpdate();*/

            // requête SELECT avec condition

            /*PreparedStatement st2 = c.prepareStatement("select * from emp where (sal < ? AND job = ?) OR (sal < ? AND job = ?)");
            st2.setInt(1,2000);
            st2.setString(2,"SALESMAN");
            st2.setInt(3,2000);
            st2.setString(4,"MANAGER");
            ResultSet rs2 = st2.executeQuery();

            while(rs2.next()) {
                System.out.println(rs2.getString("ename") + rs2.getString("sal") + rs2.getString("job"));
            }*/

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
