public class Student {
    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    private int rollno;
    private String name;
    private String address;
    private String email;
    private String mobile;

    public Student(int rollno, String name, String address, String email, String mobile) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
    }

}
