import org.junit.Assert
import org.junit.Test

class EmailTest extends GroovyTestCase {

    @Test
    void testEmail() {
        def em1 = new Email("al", "chu")
        Assert.assertEquals("al", em1.getFirstName());
        Assert.assertEquals("chu", em1.getLastName());
        Assert.assertEquals("al.chu@" + Email.COMPANY_DOMAIN, em1.getEmail());
    }


    @Test
    void testGenerateRandomPassword() {
        def em1 = new Email("al", "chu")
        def password1 = em1.generateRandomPassword()
        def password2 = em1.generateRandomPassword()
        Assert.assertNotNull(password1)
        Assert.assertNotNull(password2)
        Assert.assertNotEquals(password1, password2)
    }
}
