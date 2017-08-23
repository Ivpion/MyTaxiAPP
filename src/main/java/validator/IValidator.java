package validator;

/**
 * Created by ivan on 23.08.17.
 */
public interface IValidator {

    boolean validateRegistration(String login,String phone, String pass);
    boolean validateCar(String numbers, String model);
    boolean validateAddress(String city, String street, String number);

}
