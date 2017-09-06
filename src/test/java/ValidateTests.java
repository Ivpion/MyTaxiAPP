import org.junit.*;
import validator.Validator;

public class ValidateTests {

    private String regexpLog1 = "!@#kwkg";
    private String regexpLog2 = "Brutto101";
    private String regexpPhone1 = "0966568317";
    private String regexpPhone2 = "(096)-656-83-17";
    private String regexpPass1 = ";dkfjgei4^^";
    private String regexpPass2 = "Brutto22";


    @Test
    public void testValidateLogin() {
        //
        boolean test1 = new Validator().validateRegistration(regexpLog1, regexpPhone1, regexpPass1);
        boolean test2 = new Validator().validateRegistration(regexpLog2, regexpPhone2, regexpPass2);
        boolean test3 = new Validator().validateRegistration(regexpLog1, regexpPhone2, regexpPass2);
        boolean test4 = new Validator().validateRegistration(regexpLog2, regexpPhone2, regexpPass1);
        Assert.assertTrue(!test1);
        Assert.assertTrue(test2);
        Assert.assertTrue(!test3);
        Assert.assertTrue(!test4);

    }
}
