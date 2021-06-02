package at.ac.fhcampuswien;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPasswordValidator {

    @Test
    @DisplayName("Password null")
    public void testPasswordNull() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = null;
        assertFalse(passwordValidator.checkPassword(password));
    }

    @Test
    @DisplayName("Password length < 8")
    public void testPasswordLengthShort() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "fdfsd";
        assertFalse(passwordValidator.checkMinLength(password));
    }

    @Test
    @DisplayName("Password length > 25")
    public void testPasswordLengthLong() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "dfdsopksdpkagüaskdfdgdfgvfdvf";
        assertFalse(passwordValidator.checkMaxLength(password));
    }

    @Test
    @DisplayName("Password contains capital")
    public void testPasswordCapital() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "ab8/cdefghjkl";
        assertFalse(passwordValidator.checkCapital(password));
    }

    @Test
    @DisplayName("Password contains number")
    public void testPasswordNumber() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "Aa/bcdefghjkl";
        assertFalse(passwordValidator.checkNumber(password));
    }

    @Test
    @DisplayName("Password contains special char")
    public void testPasswordSpecialChar() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "A6bcdefghjkl";
        assertFalse(passwordValidator.checkSpecialChar(password));
    }

    @Test
    @DisplayName("Password contains ongoing numbers")
    public void testPasswordTwoNumbersInRow() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "A/234abcdefghjkl";
        assertFalse(passwordValidator.checkContinueNumbers(password));
    }

    @Test
    @DisplayName("Password contains the same number four times in a row")
    public void testPasswordFourNumbersInRow() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "A/2222abcdefghjkl";
        assertFalse(passwordValidator.checkSameNumberInARow(password));
    }
}
