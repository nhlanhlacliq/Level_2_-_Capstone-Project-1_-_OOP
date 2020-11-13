import java.time.LocalDate;
import java.util.Scanner;


//Capstone Project I - OOP


public class Main {
    
    //global project counter and contractorCreated bool
    public static int projectNumber;
    public static boolean contractorCreated = false;
    //initialize input scanner object
    public static Scanner sc = new Scanner(System.in);
    // declaring contractor and project objects
    static Contractor contractor1;
    static Project project1;

    //main method
    public static void main(String[] args) {

        //Welcome screen.
        System.out.println("Poised Engineering\n==============");
        //prompt user to creat new project 
        System.out.println("Press enter to create a new project\n("+projectNumber+" Project/s available)");        
        sc.nextLine();
        project1 = createProject();

        //open main menu
        displayMenu(project1);
    }
    
    //main menu
    public static void displayMenu(Project project) {
        //print options, view or finalise project
        System.out.println("\nMenu\n====\n("+projectNumber+" Project/s available)\n1. View project\n2. Finalise project");        
        int user_option = sc.nextInt();
        sc.nextLine();
        
        //run method depending on user option
        if (user_option == 1) {
            viewProject(project);
        } else if (user_option == 2) {
            finaliseProject(project);
        }
    }
    
    
    //view project method
    public static void viewProject(Project project) {
        System.out.println(project);
        //present user with options to change project details
        int user_option;
        System.out.println("1. Change due date \n2. Change amount paid\n3. Update contractor details\n4. Go back");

        user_option = sc.nextInt();
        sc.nextLine();
        //get user input and change necessary detail in project
        if (user_option == 1) {
            System.out.println("Old due date :" + project.projectDeadline);
            System.out.println("Enter new due date: (yyyy-mm-dd)");
            String newDeadline = sc.nextLine();
            LocalDate newDeadlineDate = LocalDate.parse(newDeadline);
            project.changeDate(newDeadlineDate);
            //return to view project
            viewProject(project);
        
        //changing amount paid to date
        } else if (user_option == 2) {
            System.out.println("Old amount :" + project.amountPaid);
            System.out.println("Enter new amount :");
            double newAmount  = sc.nextDouble();
            sc.nextLine();
            project.changeAmountPaid(newAmount);
            
            viewProject(project);

        //viewing contractor details - calling create method if not yet created - then viewing those details 
        } else if (user_option == 3) {
            if (contractorCreated == false) {
                contractor1 = createContractor();
            } 
            viewContractor(contractor1);

        //go back to main menu
        } else if (user_option == 4) {
            displayMenu(project);
        }
    }

    //create Contractor object
    public static Contractor createContractor() {
        String name ;
        String telNumber;
        String email;
        String physicalAddress;
        //get user input and create contractor object
        System.out.println("Enter Contractor's name");
        name = sc.nextLine();
        System.out.println("Enter telephone number");
        telNumber = sc.nextLine();
        System.out.println("Enter e-mail address");
        email = sc.nextLine();
        System.out.println("Enter physical address");
        physicalAddress = sc.nextLine();

        Contractor newContractor;
        newContractor = new Contractor(name, telNumber, email, physicalAddress);
        //notify other methods that will require it(view contractor) that contractor has been created
        contractorCreated = true;
        //return created contractor
        return newContractor;
    }

    //view and change contractor details
    public static void viewContractor(Contractor contractor) {
        System.out.println(contractor);
        //present options to user on which details to change
        int user_option;
        System.out.println("1. Change name \n2. Change telephone number\n3. Change e-mail address\n4. Change physical address\n5. Go back");

        user_option = sc.nextInt();
        sc.nextLine();
        //changing contractor name
        if (user_option == 1) {
            System.out.println("Enter new name");
            String newName = sc.nextLine();
            contractor1.changeName(newName);
            viewContractor(contractor);
        //changing telephone number
        } else if (user_option == 2) {
            System.out.println("Enter telephone number");
            String newNum = sc.nextLine();
            contractor1.changeTelNumber(newNum);
            viewContractor(contractor);
        //changing email address
        } else if (user_option == 3) {
            System.out.println("Enter e-mail address");
            String newEmail = sc.nextLine();
            contractor1.changeTelNumber(newEmail);
            viewContractor(contractor);
        //changing physical address
        } else if (user_option == 4) {
            System.out.println("Enter physical address");
            String newAddress = sc.nextLine();
            contractor1.changeTelNumber(newAddress);
            viewContractor(contractor);
        //go back to view project
        } else if (user_option == 5) {
            viewProject(project1);
        }   
    }


    //finalise project method called from project class, then views project
    public static void finaliseProject(Project project) {
        System.out.println(project);
        project.finaliseProject();
        viewProject(project);
    }

    //Create a project object and return that object
    public static Project createProject() {
        
        //Declaring Variables required for creating project object
        String projName ;
        String buildType;
        String address ;
        String erfNum ;
        String customerName ;
        double amountCharged ; 
        double amountPaid;
        String projDeadline;
        
        //Initializing Scanner object
        Scanner sc = new Scanner(System.in);
        
        //incrementing project counter
        projectNumber += 1;
        
        //Getting user input for above variables to be passed into the Project object constructor
        System.out.println("Project name: (Press Enter to Skip)");
        projName = sc.nextLine();
        System.out.println("Build type:");
        buildType = sc.nextLine();
        System.out.println("Proj address:");
        address = sc.nextLine();
        System.out.println("Proj erf Num:");
        erfNum = sc.nextLine();
        System.out.println("Customer's name:");
        customerName = sc.nextLine();
        System.out.println("Amount Charged:");
        amountCharged = sc.nextDouble();
        sc.nextLine();
        System.out.println("Amount Paid:");
        amountPaid = sc.nextDouble();
        sc.nextLine();
        System.out.println("Project deadline: (yyyy-mm-dd)");
        projDeadline = sc.nextLine();
        LocalDate projDeadlineDate = LocalDate.parse(projDeadline);
        
        //Declaring object to be created, as it will be inaccessible if declared within the following if statement
        Project newProject;
        
        //Creating project (creating a project name - if not provided - using the building type and customer name)
        if (projName.length() == 0) {
            String newProjName = buildType + " " + customerName;
            newProject = new Project(projectNumber, newProjName, buildType, address, erfNum, amountCharged, amountPaid, projDeadlineDate);
        }
        else {
            newProject = new Project(projectNumber, projName, buildType, address, erfNum, amountCharged, amountPaid, projDeadlineDate);
        }
        
        return newProject;
    }
}