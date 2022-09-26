import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "131sdf";
        String pass = "qwe_123";
        String confirmPass = "qwe_123";
        System.out.println(acceptThreeParameters(login,pass,confirmPass));
    }

    public static boolean acceptThreeParameters(String login, String password, String confirmPassword) {
        boolean checkLogin;
        boolean checkPassword;
        boolean checkLengthPass;
        boolean checkLengthLogin;
        boolean checkPasswordMatching;
        try {
            checkLogin = checkValidationCharacter(login);
            checkPassword = checkValidationCharacter(password);
            checkLengthLogin = checkLengthLogin(login);
            checkLengthPass = checkLengthPassword(password);
            checkPasswordMatching = checkPasswordMatching(password, confirmPassword);

        } catch (WrongLoginException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return checkLogin && checkPassword && checkLengthPass && checkLengthLogin && checkPasswordMatching;

    }
    public static boolean checkValidationCharacter(String checkWord) {
        if(checkWord==null){
            throw new NullPointerException("Проеряемое слово не введено");
        }
        if (checkWord.matches("\\w+")) {
            return true;
        }
        System.out.printf("Недостимые символы в слове! - %s\n", checkWord);
        return false;
    }

    public static boolean checkLengthLogin (String login) throws WrongLoginException{

        if (login.length()>20){
            throw new WrongLoginException("Слишком длинный логин");

        }
        return true;
    }
    public static boolean checkLengthPassword (String pass){
        if (pass.length()>19){
            System.out.println("Слишком длинный пароль");
            return false;
        }
        return true;
    }
    public static boolean checkPasswordMatching(String password, String confirmPassword) throws  WrongPasswordException{
        if (password.equals(confirmPassword)) return true;
        throw new WrongPasswordException("Пароли не совпадают");

    }


}
