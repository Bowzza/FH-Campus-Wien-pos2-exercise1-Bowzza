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
    @DisplayName("Password not null")
    public void testPasswordNotNull() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "Ppa12s(ss";
        assertTrue(passwordValidator.checkPassword(password));
    }




   @Test
    @DisplayName("Password length < 8")
    public void testPasswordLengthShort() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "fdfsd";
        assertFalse(passwordValidator.checkMinLength(password));
    }

    @Test
    @DisplayName("Password length > 8")
    public void testPasswordLengthNotShort() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "fdfsdkukrt";
        assertTrue(passwordValidator.checkMinLength(password));
    }




    @Test
    @DisplayName("Password length > 25")
    public void testPasswordLengthLong() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "dfdsopksdpkagüaskdfdgdfgvfdvf";
        assertFalse(passwordValidator.checkMaxLength(password));
    }

    @Test
    @DisplayName("Password length < 25")
    public void testPasswordLengthNotLong() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "dfdsopksdpkagüa";
        assertTrue(passwordValidator.checkMaxLength(password));
    }




    @Test
    @DisplayName("Password contains no capital")
    public void testPasswordNoCapital() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "ab8/cdefghjkl";
        assertFalse(passwordValidator.checkCapital(password));
    }

    @Test
    @DisplayName("Password contains capital")
    public void testPasswordCapital() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "ab8/cdEfghjkl";
        assertTrue(passwordValidator.checkCapital(password));
    }




    @Test
    @DisplayName("Password contains no number")
    public void testPasswordNoNumber() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "Aa/bcdefghjkl";
        assertFalse(passwordValidator.checkNumber(password));
    }

    @Test
    @DisplayName("Password contains number")
    public void testPasswordNumber() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "Aa/bcdefgh4jkl";
        assertTrue(passwordValidator.checkNumber(password));
    }




    @Test
    @DisplayName("Password contains no special char")
    public void testPasswordNoSpecialChar() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "A6bcdefghjkl";
        assertFalse(passwordValidator.checkSpecialChar(password));
    }

    @Test
    @DisplayName("Password contains special char")
    public void testPasswordSpecialChar() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "A6bcdefgh/jkl";
        assertTrue(passwordValidator.checkSpecialChar(password));
    }




    @Test
    @DisplayName("Password doesn't contain ongoing numbers")
    public void testPasswordNoTwoNumbersInRow() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "A/234abcdefghjkl";
        assertFalse(passwordValidator.checkContinueNumbers(password));
    }

    @Test
    @DisplayName("Password contains ongoing numbers")
    public void testPasswordTwoNumbersInRow() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "A/22abcdefghjkl";
        assertTrue(passwordValidator.checkContinueNumbers(password));
    }




    @Test
    @DisplayName("Password contains the same number four times in a row")
    public void testPasswordFourNumbersInRow() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "A/2222abcdefghjkl";
        assertFalse(passwordValidator.checkSameNumberInARow(password));
    }

    @Test
    @DisplayName("Password doesn't contain the same number four times in a row")
    public void testPasswordNoFourNumbersInRow() {
        PasswordValidator passwordValidator = new PasswordValidator();
        String password = "A/222abcdefghjkl";
        assertTrue(passwordValidator.checkSameNumberInARow(password));
    }
}
