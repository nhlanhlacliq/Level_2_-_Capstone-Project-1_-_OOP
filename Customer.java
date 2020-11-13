public class Customer extends Person {
    //instance variables
    String name;
    String telNumber;
    String emailAddress;
    String physicalAddress;

    //constructor
    public Customer(String name, String telNumber, String emailAddress, String physicalAddress) {
        super(name, telNumber, emailAddress, physicalAddress);
        this.name = name;
        this.telNumber = telNumber;
        this.emailAddress = emailAddress;
        this.physicalAddress = physicalAddress;
    }
}
