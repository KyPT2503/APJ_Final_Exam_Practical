package controller.services;

import model.Directory;
import model.WriteToFile;
import view.UserInterface;

import java.util.List;

public class UpdateDirectory {
    public void updateDirectory(List<Directory> directories, DirectoryCreator directoryCreator) {
        UserInterface.getInstance().displayMessage("Enter phone number to update: ");
        String phoneNumber = UserInterface.getInstance().getOption();
        while (true) {
            for (Directory directory : directories) {
                if (directory.getPhoneNumber().equals(phoneNumber)) {
                    directories.remove(directory);
                    directories.add(directoryCreator.createDirectory());
                    return;
                }
            }
            UserInterface.getInstance().displayMessage("Phone Number not found, please try again, press Enter to exit: ");
            phoneNumber = UserInterface.getInstance().getOption();
            if (phoneNumber.equals("")) return;
        }
    }

    public void removeDirectory(List<Directory> directories, WriteToFile writeToFile) {
        UserInterface.getInstance().displayMessage("Enter phone number to delete: ");
        String phoneNumber = UserInterface.getInstance().getOption();
        while (true) {
            for (Directory directory : directories) {
                if (directory.getPhoneNumber().equals(phoneNumber)) {
                    directories.remove(directory);
                    UserInterface.getInstance().displayMessage("Confirm remove this directory? Press Y to confirm: ");
                    String option = UserInterface.getInstance().getOption();
                    if (option.equalsIgnoreCase("y")) {
                        writeToFile.writeToFile(directories);
                    }
                    return;
                }
            }
            UserInterface.getInstance().displayMessage("Phone Number not found, please try again, press Enter to exit: ");
            phoneNumber = UserInterface.getInstance().getOption();
            if (phoneNumber.equals("")) return;
        }
    }
}
