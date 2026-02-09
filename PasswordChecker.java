
public class PasswordChecker {

    public static boolean strongPasswordChecker(String password) {
        //8 char len check
        if (password.length() < 8) {
            return false;
        }

        String specialChar = "!@#$%^&*()-+";

        boolean isLower = false, isUpper = false, isDigit = false, isSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                isLower = true;
            } else if (Character.isUpperCase(ch)) {
                isUpper = true;
            } else if (Character.isDigit(ch)) {
                isDigit = true;
            } else if (specialChar.indexOf(ch) != -1) {
                isSpecialChar = true;
            }
            if (i > 0 && ch == password.charAt(i - 1)) {
                return false;
            }

        }

        return isLower && isUpper && isDigit && isSpecialChar;
    }

    public static void main(String[] args) {
        String password = "ehGg45y$sgrj";
        System.out.println(strongPasswordChecker(password) ? "Password is strong" : "Please select strong password");
     
    }
}
