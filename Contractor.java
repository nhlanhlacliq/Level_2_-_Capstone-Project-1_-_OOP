//Customer class, subclass of Person
public class Contractor extends Person {
    //instance variables
    String name;
    String telNumber;
    String emailAddress;
    String physicalAddress;

    //constructor
    public Contractor(String name, String telNumber, String emailAddress, String physicalAddress) {
        super(name, telNumber, emailAddress, physicalAddress);
    }
}