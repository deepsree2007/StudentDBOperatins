import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        DBConnection dbCon = new DBConnection();
        //dbCon.listStudents();
        //dbCon.getStudent(2);
        //dbCon.createStudent(3,"Sruthi","Kerala","7878787878","sruthi@gmail.com");
        //dbCon.updateStudent(1,"newemail@gmail.com");

        Student student = new Student(4,"Swathi","TN","swathi@gmail.com","9090907878");
        dbCon.createStudent(student);
    }
}