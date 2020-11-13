// Person class, to be used for creating the customer, contractor, etc
public class Person {
    //instance variables
    String name;
    String telNumber;
    String emailAddress;
    String physicalAddress;

    //constructor
    public Person(String name, String telNumber, String emailAddress, String physicalAddress) {
        this.name = name;
        this.telNumber = telNumber;
        this.emailAddress = emailAddress;
        this.physicalAddress = physicalAddress;
    }

    //Change name
    public void changeName(String newName) {
        name = newName;
    } 

    //Change telephone number
    public void changeTelNumber(String newTelNumber) {
        telNumber = newTelNumber;
    }

    //Change email address
    public void changeEmail(String newEmail) {
        emailAddress = newEmail;
    }

    //Change physical address
    public void changePhysicalAddress(String newAddress) {
        physicalAddress = newAddress;
    }

    //To string method
    public String toString(){
        String output = "Name: \t\t" + name;
        output += "\nTelephone number: \t" + telNumber;
        output += "\nE-mail address: \t" + emailAddress;
        output += "\nPhysical address: \t" + physicalAddress;

        return output;
    }    
}
