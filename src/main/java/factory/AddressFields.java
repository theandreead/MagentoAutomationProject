package factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Random;

@Getter
@Data
@AllArgsConstructor

public class AddressFields {

    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public AddressFields() {
        generateRandomAddress();
    }

    private void generateRandomAddress() {
        phoneNumber = generateRandomPhoneNumber();
        streetAddress = generateRandomString(10) + " Street";
        city = generateRandomString(8) + " City";
        state = "Bacău";
        zipCode = generateRandomNumericString(5);
        country = "RO";
    }

    private String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("+");
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    private String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        return randomString.toString();
    }

    private String generateRandomNumericString(int length) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        String characters = "0123456789";
        for (int i = 0; i < length; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        return randomString.toString();
    }

}