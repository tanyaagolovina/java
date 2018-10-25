package model.entity;

public class Student {
    private String surname;
    private String name;
    private String dateOfBirth;
    private String phoneNumber;
    private String homeAddress;

    public Student(String surname, String name, String dateOfBirth, String phoneNumber, String homeAddress) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    @Override
    public String toString(){
        return "Student - " + name + " " + surname + ", date of birth - " + dateOfBirth +
                ", phone number - " + phoneNumber + ", home address - " + homeAddress;
    }
}

