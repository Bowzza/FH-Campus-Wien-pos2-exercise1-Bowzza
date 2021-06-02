package at.ac.fhcampuswien;

public class PasswordValidator {

    private char[] pwd;

    public boolean checkPassword(String password) {
        if(password == null) return false;
        if(!checkMinLength(password)) return false;
        if(!checkMaxLength(password)) return false;
        if(!checkCapital(password)) return false;
        if(!checkNumber(password)) return false;
        if(!checkSpecialChar(password)) return false;
        if(!checkContinueNumbers(password)) return false;
        if(!checkSameNumberInARow(password)) return false;

        return true;
    }

    public boolean checkMinLength(String password) {
        if(password.length() < 8) return false;
        return true;
    }

    public boolean checkMaxLength(String password) {
        if(password.length() > 25) return false;
        return true;
    }

    public boolean checkCapital(String password) {
        pwd = password.toCharArray();
        int capital = 0;
        for (char value : pwd) {
            for (char c = 'A'; c <= 'Z'; c++) {
                if (value == c) capital++;
            }
        }
        if(capital == 0) return false;
        return true;
    }

    public boolean checkNumber(String password) {
        pwd = password.toCharArray();
        int number = 0;
        for (char value : pwd) {
            for (char c = 'A'; c <= 'Z'; c++) {
                if(Character.isDigit(value)) number++;
            }
        }
        if(number == 0) return false;
        return true;
    }

    public boolean checkSpecialChar(String password) {
        pwd = password.toCharArray();
        char[] specialChars = {'(', ')', '#', '$', '?', '!', '%', '/', '@'};
        int specialChar = 0;
        for (char value : pwd) {
            for (char c : specialChars) {
                if (value == c) specialChar++;
            }
        }
        if(specialChar == 0) return false;
        return true;
    }

    public boolean checkContinueNumbers(String password) {
        pwd = password.toCharArray();
        for(int i = 0; i < pwd.length; i++) {
            if (Character.isDigit(pwd[i])) {
                char check = pwd[i];
                if (check + 1 == pwd[i + 1] && check + 2 == pwd[i + 2]) return false;
            }
        }
        return true;
    }

    public boolean checkSameNumberInARow(String password) {
        pwd = password.toCharArray();
        for(int i = 0; i < pwd.length; i++) {
            if(Character.isDigit(pwd[i])) {
                char check = pwd[i];
                if(check == pwd[i+1] && check == pwd[i+2] && check == pwd[i+3]) return false;
            }
        }
        return true;
    }

}
