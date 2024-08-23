import java.util.Random;
import java.util.Scanner;

class EmailApp {
    private String firstName;
    private String lastName;
    private String department;
    private String alternateEmail;
    private String email;
    private String companySuffix = "xyz.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private char[] password;

    // Constructor for first and last name
    public EmailApp(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("NEW EMPLOYEE: " + this.firstName + " " + this.lastName);

        // Method for calling department
        this.department = setDepartment();
        System.out.println("Your Department is: " + this.department);

        // Call method for random password
        this.password = generatePassword(defaultPasswordLength);
        System.out.println("Your password is: " + new String(this.password));

        // Combining email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        System.out.println("Your Email is: " + email);
    }

    // Method for asking department
    private String setDepartment() {
        System.out.println("Department Codes: \n1. Sales \n2. Development \n3. Accounts \nEnter your Department:");
        Scanner read = new Scanner(System.in);
        int depChoice = read.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "development";
        } else if (depChoice == 3) {
            return "accounts";
        } else {
            return "none";
        }
    }

    // Generate random password
    private char[] generatePassword(int len) {
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String values = capitalChars + smallChars + numbers;

        Random random = new Random();
        char[] password = new char[len];

        for (int i = 0; i < len; i++) {
            password[i] = values.charAt(random.nextInt(values.length()));
        }
        return password;
    }

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void setPassword(String password) {
        this.password = password.toCharArray();
    }

    // Change department
    public void changeDepartment(String newDepartment) {
        this.department = newDepartment;
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
    }

    // Get mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Get the alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Get the password
    public String getPassword() {
        return new String(password);
    }

    // Display employee information
    public String showInfo() {
        return "\nDISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }

    // Display all employee details
    public String displayAllDetails() {
        return showInfo() +
                "\nALTERNATE EMAIL: " + (alternateEmail != null ? alternateEmail : "Not Set") +
                "\nPASSWORD: " + new String(password);
    }
}

// Main Method
public class Email {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get employee's first and last name
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        EmailApp em1 = new EmailApp(firstName, lastName);

        // Admin Actions Menu
        while (true) {
            System.out.println("\n--- Admin Actions ---");
            System.out.println("1. Set Alternate Email");
            System.out.println("2. Set Mailbox Capacity");
            System.out.println("3. Change Department");
            System.out.println("4. Reset Password");
            System.out.println("5. Display All Details");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter alternate email: ");
                    String altEmail = scanner.nextLine();
                    em1.setAlternateEmail(altEmail);
                    System.out.println("Alternate Email Set: " + em1.getAlternateEmail());
                    break;
                case 2:
                    System.out.print("Enter new mailbox capacity: ");
                    int capacity = scanner.nextInt();
                    em1.setMailboxCapacity(capacity);
                    System.out.println("Mailbox Capacity Updated: " + em1.getMailboxCapacity() + "mb");
                    break;
                case 3:
                    System.out.print("Enter new department: ");
                    String newDepartment = scanner.nextLine();
                    em1.changeDepartment(newDepartment);
                    System.out.println("Department changed successfully to " + newDepartment);
                    System.out.println("Your new email is: " + em1.showInfo());
                    break;
                case 4:
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    em1.setPassword(newPassword);
                    System.out.println("Password Updated: " + em1.getPassword());
                    break;
                case 5:
                    System.out.println("\n--- Displaying All Details ---");
                    System.out.println(em1.displayAllDetails());
                    break;
                case 6:
                    System.out.println("Exiting Admin Actions.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
 
