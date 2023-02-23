public class Person {
    //Fields
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String SSN;
    private int id;

    //Constructors
    public Person(String fName, String lName, String email, String SSN) {
        firstName=fName;
        lastName=lName;
        this.emailAddress=email;
        this.SSN=SSN;
        this.id=id;
    }

    //Methods

    public  String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getSSN() {
        return SSN;
    }

    @Override
    public String toString() {
        return id+":"+firstName+":"+lastName+":"+emailAddress+":"+SSN;
    }
}
