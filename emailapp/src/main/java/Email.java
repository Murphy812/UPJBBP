import java.util.Scanner;

public class Email {
    public static final String COMPANY_DOMAIN = "achucompany.com";
    public static final int PASSWORD_DEFAULT_LENGTH = 10;
    private String firstName;
    private String lastName;

    private String password;
    private String department;


    private int mailboxCapacity = 500;
    private String email;


    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
        this.department = this.setDepartment();
        System.out.println("DEPARTMENT SET: " + this.department);

        this.password = generateRandomPassword(PASSWORD_DEFAULT_LENGTH);
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
                throw new IllegalStateException("Unexpected value: " + depChoice);
        }
    }

    private String generateRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
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
