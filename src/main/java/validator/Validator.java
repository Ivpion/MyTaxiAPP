package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ivan on 23.08.17.
 */
public class Validator implements IValidator {
    @Override
    public boolean validateRegistration(String login, String phone, String pass) {
        // length login 4-12 char
        // use only numbers, a-z, _,
        String regPhone = "^\\(\\d{3}\\)-\\d{3}-\\d{2}-\\d{2}$";
        Pattern pLogin = Pattern.compile("^[a-zA-Z0-9]{3,12}$");
        Matcher mLogin = pLogin.matcher(login);
        Pattern pPhone = Pattern.compile(regPhone);
        Matcher mPhone = pPhone.matcher(phone);
        Matcher mPass = pLogin.matcher(pass);
        boolean res = mLogin.matches() && mPass.matches() && mPhone.matches();
        return res;
    }

    @Override
    public boolean validateCar(String numbers, String model) {
        Pattern pNumbers = Pattern.compile("");
        Pattern pModel = Pattern.compile("");
        Matcher mNumbers = pNumbers.matcher(numbers);
        Matcher mModel = pModel.matcher(model);
        return mModel.matches() && mNumbers.matches();
    }

    @Override
    public boolean validateAddress(String city, String street, String number) {
        return false;
    }
}
