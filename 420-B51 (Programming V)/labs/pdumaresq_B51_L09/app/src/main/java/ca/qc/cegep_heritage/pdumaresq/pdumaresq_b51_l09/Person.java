package ca.qc.cegep_heritage.pdumaresq.pdumaresq_b51_l09;

/**
 * Created by 1523066 on 12/4/2017.
 */

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    public Person() {
        id = 0;
        firstName = "";
        lastName = "";
        emailAddress = "";
        phoneNumber = "";
    }

    public Person(int id) {
        this.id = id;
        firstName = "";
        lastName = "";
        emailAddress = "";
        phoneNumber = "";
    }

    public Person(int id, String first, String last) {
        this.id = id;
        firstName = first;
        lastName = last;
        emailAddress = "";
        phoneNumber = "";
    }

    public Person(String first, String last, String email, String phone) {
        this.id = -1;
        firstName = first;
        lastName = last;
        emailAddress = email;
        phoneNumber = phone;
    }

    public Person(int id, String first, String last, String email, String phone) {
        this.id = id;
        firstName = first;
        lastName = last;
        emailAddress = email;
        phoneNumber = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String first) {
        this.firstName = first;
    }

    public void setLastName(String last) {
        this.lastName = last;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }




}
