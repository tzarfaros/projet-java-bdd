package projectBdd;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Entry {

    public static void main(String[] args) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date d = sdf.parse("10/10/2012");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/scott", "root", "");

            /*Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from emp");

            while(rs.next()) {
                System.out.println(rs.getString("ename") + rs.getString("sal"));
            }

            PreparedStatement st1 = c.prepareStatement("select * from emp where sal > ? AND ename like ?");
            st1.setInt(1,1500);
            st1.setString(2,"%N%");
            ResultSet rs1 = st1.executeQuery();

            while(rs1.next()) {
                System.out.println(rs1.getString("ename") + rs1.getString("sal"));
            }*/

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

            PreparedStatement ps = c.prepareStatement("UPDATE EMP SET sal = ? WHERE empno = 2626");
            ps.setInt(1, 1000);

            ps.executeUpdate();

            PreparedStatement st2 = c.prepareStatement("select * from emp where (sal < ? AND job = ?) OR (sal < ? AND job = ?)");
            st2.setInt(1,2000);
            st2.setString(2,"SALESMAN");
            st2.setInt(3,2000);
            st2.setString(4,"MANAGER");
            ResultSet rs2 = st2.executeQuery();

            while(rs2.next()) {
                System.out.println(rs2.getString("ename") + rs2.getString("sal") + rs2.getString("job"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
