import java.time.LocalDate;
//Project class

public class Project {
    //Attributes
    int projectNumber;
    String projectName;
    String buildingType;
    String physicalAddress;
    String erfNumber;
    double amountCharged;
    double amountPaid;
    LocalDate projectDeadline;
    boolean finalised;
    String dateCompleted;
    
    //constructor
    public Project(int projectNumber, String projectName, String buildingType, String physicalAddress, String erfNumber, 
    double amountCharged, double amountPaid, LocalDate projectDeadline, boolean finalised, String dateCompleted) {
        this.projectNumber = projectNumber;
        this.projectName = projectName;
        this.buildingType = buildingType;
        this.physicalAddress = physicalAddress;
        this.erfNumber = erfNumber;
        this.amountCharged = amountCharged; 
        this.amountPaid = amountPaid;
        this.projectDeadline = projectDeadline; 
        this.finalised = finalised;
        this.dateCompleted = dateCompleted;
    }

    //Overloading constructor with default values for project finalised and date completed
    public Project(int projectNumber, String projectName, String buildingType, String physicalAddress, String erfNumber, 
    double amountCharged, double amountPaid, LocalDate projectDeadline) {
        this(projectNumber, projectName, buildingType, physicalAddress, erfNumber, amountCharged, amountPaid, projectDeadline, false, "N/A");
    }
    
    //change duedate method
    public void changeDate(LocalDate newDate) {
        projectDeadline = newDate;
    }

    //change amount paid to date
    public void changeAmountPaid(double newAmountPaid) {
        amountPaid = newAmountPaid;
    }

    //Finalise project and set date completed to current date
    public void finaliseProject() {
        finalised = true;
        dateCompleted = "" + LocalDate.now();
        System.out.println("Project: "+ projectName + " completed!");
    }

    //to string method
    public String toString() {
        String output = "Project number: \t" + projectNumber + "\n";
        output += "Project name: \t\t" + projectName + "\n";
        output += "Building type: \t\t" + buildingType + "\n";
        output += "Physical address: \t" + physicalAddress + "\n";
        output += "ERF number: \t\t" + erfNumber + "\n";
        output += "Amount charged: \t" + amountCharged + "\n";
        output += "Amount paid: \t\t" + amountPaid + "\n";
        output += "Amount owing: \t\t" + (amountCharged - amountPaid) + "\n";
        output += "Project deadline: \t" + projectDeadline + "\n";
        output += "Project finalised: \t" + finalised + "\n";
        output += "Date completed: \t" + dateCompleted + "\n";
        
        return output;
    }
}