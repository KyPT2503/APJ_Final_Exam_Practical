package controller.services;

import model.Directory;
import model.Gender;
import view.UserInterface;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class DirectoryCreator {
    private static Pattern phoneNumberPattern = Pattern.compile("^[0-9]{9,11}");
    private static Pattern emailPattern = Pattern.compile("^[a-zA-z][a-zA-z0-9_]+@[a-zA-z]+(\\.[a-zA-z]+)$");
    UserInterface userInterface;

    public DirectoryCreator() {
        this.userInterface = UserInterface.getInstance();
    }

    public Directory createDirectory() {
        userInterface.displayMessage("__Directory Information__");
        String phoneNumber = this.getPhoneNumber();
        userInterface.displayMessage("Group: ");
        String group = userInterface.getOption();
        userInterface.displayMessage("Name: ");
        String name = userInterface.getOption();
        Gender gender = this.getGender();
        userInterface.displayMessage("Address: ");
        String address = userInterface.getOption();
        LocalDate birthday = this.getBirthDay();
        String email = this.getEmail();
        return new Directory().withAddress(address).withGender(gender).withBirthday(birthday).withEmail(email).withName(name).withPhoneNumber(phoneNumber).withGroup(group).build();
    }

    private LocalDate getBirthDay() {
        userInterface.displayMessage("_Birthday_");
        userInterface.displayMessage("Day: ");
        String day = userInterface.getOption();
        userInterface.displayMessage("Month: ");
        String month = userInterface.getOption();
        userInterface.displayMessage("Year: ");
        String year = userInterface.getOption();
        try {
            return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } catch (Exception e) {
            userInterface.displayMessage("Invalid birthday, please try again.");
            return this.getBirthDay();
        }
    }

    private Gender getGender() {
        userInterface.displayMessage("_Gender_");
        userInterface.displayMessage("1. Male");
        userInterface.displayMessage("2. Female");
        userInterface.displayMessage("3. Another");
        String option = userInterface.getOption();
        if (option.equals("1")) {
            return Gender.MALE;
        } else if (option.equals("2")) {
            return Gender.FEMALE;
        } else if (option.equals("3")) {
            return Gender.ANOTHER;
        } else {
            userInterface.displayMessage("Please choose the right option.");
            return this.getGender();
        }
    }

    private String getPhoneNumber() {
        userInterface.displayMessage("Phone Number: ");
        String phoneNumber = userInterface.getOption();
        while (!phoneNumberPattern.matcher(phoneNumber).matches()) {
            userInterface.displayMessage("Phone Number have 9-11 digits: ");
            phoneNumber = userInterface.getOption();
        }
        return phoneNumber;
    }

    private String getEmail() {
        userInterface.displayMessage("Email: ");
        String email = userInterface.getOption();
        while (!emailPattern.matcher(email).matches()) {
            userInterface.displayMessage("Please enter valid email: ( ex. james@gmail.com)");
            email = userInterface.getOption();
        }
        return email;
    }
}
