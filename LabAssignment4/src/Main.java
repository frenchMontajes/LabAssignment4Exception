import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String validPass = "password";
        String pass = null;
        int maxAttempt = 3;
        int attempt = 0;

        Scanner scan = new Scanner(System.in);
        while (attempt < maxAttempt) {
            try {
                System.out.print("Enter Password: ");
                pass = scan.nextLine();

                if (!pass.equals(validPass)) {
                    attempt++;
                    throw new PasswordValidationException("Invalid Password");
                }
                System.out.println("Login Successful!!!!");
                break;

            } catch (PasswordValidationException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            if (attempt == maxAttempt){
                throw new LoginAttemptsException("Maximum Attempts Reached");
            }
        } catch (LoginAttemptsException e){
            System.out.println(e.getMessage());
        }

    }
}

