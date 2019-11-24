public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("Alexander", "Chuprin");
        em1.setAlternateEmail("ac@gmail.com");
        System.out.println(em1.getAlternateEmail());
    }
}
