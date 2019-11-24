import java.util.Scanner;

public class Email {
    private static final String COMPANY_DOMAIN = "achucompany.com";
    private static final int PASSWORD_DEFAULT_LENGTH = 10;

    Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        this.password = generateRandomPassword();

        this.email = (this.firstName + "." + this.lastName + "@" + COMPANY_DOMAIN).toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String firstName;
    private String lastName;

    private String password;
    private String department;


    private int mailboxCapacity = 500;
    private String email;


    private String alternateEmail;

    public String getEmail() {
        return email;
    }

    void askDepartment() {
        System.out.println("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n"
                + "Enter the department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        String dep = "";
        switch (depChoice) {
            case 1:
                dep = "sl";
                break;
            case 2:
                dep = "dev";
                break;
            case 3:
                dep = "acc";
                break;
            default:
                dep = "";
        }
        this.setDepartment(dep);
    }


    private void setDepartment(String cDepartment) {
        this.department = cDepartment;
    }

    String generateRandomPassword() {
        String passwordSet = "ABCDEFGHIJKLMOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[Email.PASSWORD_DEFAULT_LENGTH];
        for (int i = 0; i < Email.PASSWORD_DEFAULT_LENGTH; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setPassword(String pssword) {
        this.password = pssword;
    }

    private int getMailboxCapacity() {
        return this.mailboxCapacity;
    }

    public void setMailboxCapacity(int mboxCapacity) {
        this.mailboxCapacity = mboxCapacity;
    }

    String getAlternateEmail() {
        return this.alternateEmail;
    }

    void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    String showInfo() {
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName + "\n"
                + "COMPANY EMAIL: " + this.email + "\n"
                + "DEPARTMENT: " + this.department + "\n"
                + "MAILBOX CAPACITY: " + this.getMailboxCapacity() + "mb\n"
                + "PRIVATE EMAIL: " + this.alternateEmail + "\n"
                ;
    }

}
