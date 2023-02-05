import java.sql.*;

public class DBConnection {

    private Connection con;

    private String url = "jdbc:mysql://localhost:3306/student_data";
    private String username = "root";
    private String password = "";

    private PreparedStatement pstmt;
    private ResultSet rs;

    public DBConnection() throws ClassNotFoundException, SQLException {
        //register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver registered successfully");
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection to database is successful");
    }

    public void listStudents() throws SQLException {
        String query = "select * from student_details";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println("Name: " + rs.getString("name") + "\t" + "RollNo: " +
                    rs.getInt("rollno") + "\t" + "email: " + rs.getString("email"));
        }

    }

    public void getStudent(int rollNo) throws SQLException {
        String query = "select rollno, name, mobile, email from student_details where rollno=?";
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1,rollNo);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println("Name: " + rs.getString("name") + "\t" + "RollNo: " +
                    rs.getInt("rollno") + "\t" + "email: " + rs.getString("email")+
                    "\tMobile: "+rs.getString("mobile"));
        }
    }

    public void createStudent(int rollNo, String name, String address, String mobile, String email) throws SQLException {
        String sql = "insert into student_details (rollno,name,address,mobile,email) values (?,?,?,?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,rollNo);
        pstmt.setString(2,name);
        pstmt.setString(3,address);
        pstmt.setString(4,mobile);
        pstmt.setString(5,email);
        int rows = pstmt.executeUpdate();
        System.out.println("inserted "+rows+" rows to the table");
    }

    public void updateStudent(int rollNo, String email) throws SQLException {
        String query = "update student_details set email=? where rollno=?";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1,email);
        pstmt.setInt(2,rollNo);
        int rows = pstmt.executeUpdate();
        System.out.println(rows+" rows are updated");
    }

    public void createStudent(Student student) throws SQLException {
        String sql = "insert into student_details (rollno,name,address,mobile,email) values (?,?,?,?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,student.getRollno());
        pstmt.setString(2,student.getName());
        pstmt.setString(3, student.getAddress());
        pstmt.setString(4, student.getMobile());
        pstmt.setString(5, student.getEmail());
        int rows = pstmt.executeUpdate();
        System.out.println("inserted "+rows+" rows to the table");
    }


}
