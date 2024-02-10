package factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Random;

@Getter
@Data
public class NewUser {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public NewUser(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public static NewUser createRandomUser() {
        String[] firstNames = {"John", "Jane", "Michael", "Emily", "David", "Sarah"};
        String[] lastNames = {"Doe", "Smith", "Johnson", "Brown", "Wilson", "Taylor"};
        Random rand = new Random();
        String firstName = firstNames[rand.nextInt(firstNames.length)];
        String lastName = lastNames[rand.nextInt(lastNames.length)];
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
        String password = generateRandomPassword();
        return new NewUser(firstName, lastName, email, password);
    }

    private static String generateRandomPassword() {
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String specialChars = "!@#$%^&*()-_=+[{]};:'\",<.>/?";
        String numbers = "0123456789";

        String allChars = upperCaseChars + lowerCaseChars + specialChars + numbers;

        StringBuilder password = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            password.append(allChars.charAt(rand.nextInt(allChars.length())));
        }
        return password.toString();
    }
}