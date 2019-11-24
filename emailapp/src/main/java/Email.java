import java.util.Scanner;

public class Email {
    private static final String COMPANY_DOMAIN = "achucompany.com";
    private static final int PASSWORD_DEFAULT_LENGTH = 10;
    private String firstName;
    private String lastName;

    private String password;
    private String department;


    private int mailboxCapacity = 500;
    private String email;


    private String alternateEmail;

    Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
        this.department = this.setDepartment();
        System.out.println("DEPARTMENT SET: " + this.department);

        this.password = generateRandomPassword();
        System.out.println("PASSWORD SET: " + this.password);

        this.email = (this.firstName + "." + this.lastName.toLowerCase() + "@" + this.department + "." + COMPANY_DOMAIN).toLowerCase();
        System.out.println("YOUR EMAIL: " + this.email);

    }

    private String setDepartment() {
        System.out.println("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n"
                + "Enter the department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        switch (depChoice) {
            case 1:
                return "sl";
            case 2:
                return "dev";
            case 3:
                return "acc";
            default:
                return "";
        }
    }

    private String generateRandomPassword() {
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

    public int getMailboxCapacity() {
        return this.mailboxCapacity;
    }

    public void setMailboxCapacity(int mboxCapacity) {
        this.mailboxCapacity = mboxCapacity;
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

}
