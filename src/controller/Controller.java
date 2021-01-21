package controller;

import controller.services.*;
import model.Directory;
import model.ReadFromFile;
import model.WriteToFile;
import view.UserInterface;

import java.util.List;

public class Controller {
    public static final String NOT_AN_OPTION = "Not an option";
    public static final String OPTION_ = "_Option_";
    public static final String FIND_BY_PHONE_NUMBER = "1. Find by phone number";
    public static final String FIND_BY_NAME = "2. Find by name";
    public static final String ALREADY_WRITE = "Already write.";
    public static final String CAN_T_WRITE = "Can't write.";
    public static final String DIRECTORY_ADDED = "Directory Added.";

    private static Controller instance;

    private AnalysisOption analysisOption;
    private DirectoryCreator directoryCreator;
    private WriteToFile writeToFile;
    private List<Directory> directories;
    private ReadFromFile readFromFile;
    private UpdateDirectory updateDirectory;
    private CanFindDirectory findDirectoryByPhoneNumber;
    private CanFindDirectory findDirectoryByName;

    private Controller() {
        analysisOption = new OptionAnalysis();
        directoryCreator = new DirectoryCreator();
        writeToFile = new WriteToFile();
        readFromFile = new ReadFromFile();
        this.directories = this.readFromFile.readFromFile();
        this.updateDirectory = new UpdateDirectory();
        this.findDirectoryByPhoneNumber = new FindDirectoryByPhoneNumber();
        this.findDirectoryByName = new FindDirectoryByName();
    }

    public static Controller getInstance() {
        if (instance == null) {
            synchronized (UserInterface.class) {
                if (instance == null) {
                    instance = new Controller();
                }
            }
        }
        return instance;
    }

    public void execute(String stringOption) {
        int option = analysisOption.analysis(stringOption);
        switch (option) {
            case 1:
                UserInterface.getInstance().displayMessage(this.directories.toString());
                break;
            case 2:
                Directory newDirectory = directoryCreator.createDirectory();
                this.directories.add(newDirectory);
                UserInterface.getInstance().displayMessage(DIRECTORY_ADDED);
                break;
            case 3:
                this.updateDirectory.updateDirectory(this.directories, this.directoryCreator);
                break;
            case 4:
                this.updateDirectory.removeDirectory(this.directories, writeToFile);
                break;
            case 5:
                int findOption = this.getFindOption();
                if (findOption == 1) {
                    UserInterface.getInstance().displayMessage("Enter Phone number: ");
                    System.out.println(this.findDirectoryByPhoneNumber.find(UserInterface.getInstance().getOption(), this.directories));
                } else if (findOption == 2) {
                    UserInterface.getInstance().displayMessage("Enter Name: ");
                    System.out.println(this.findDirectoryByName.find(UserInterface.getInstance().getOption(), this.directories));
                }
                break;
            case 6:
                UserInterface.getInstance().displayMessage("!!! Read from file will update all of information in buffer, you should write to file then read. Enter Y to confirm read from file ANYWAY: ");
                String readFromFileOption = UserInterface.getInstance().getOption();
                if (readFromFileOption.equalsIgnoreCase("y"))
                    this.directories = this.readFromFile.readFromFile();
                break;
            case 7:
                UserInterface.getInstance().displayMessage("Are you sure? Press Y to confirm Write to file. ");
                String isSure = UserInterface.getInstance().getOption();
                if (!isSure.equalsIgnoreCase("y")) break;
                boolean executed = writeToFile.execute(this.directories);
                if (executed) {
                    UserInterface.getInstance().displayMessage(ALREADY_WRITE);
                } else {
                    UserInterface.getInstance().displayMessage(CAN_T_WRITE);
                }
                break;
            case 8:
                System.exit(0);
            default:
                UserInterface.getInstance().displayMessage(NOT_AN_OPTION);
                break;
        }
    }

    private int getFindOption() {
        UserInterface.getInstance().displayMessage(OPTION_);
        UserInterface.getInstance().displayMessage(FIND_BY_PHONE_NUMBER);
        UserInterface.getInstance().displayMessage(FIND_BY_NAME);
        String optionString = UserInterface.getInstance().getOption();
        try {
            int intOption = Integer.parseInt(optionString);
            if (intOption == 1 || intOption == 2) return intOption;
            throw new Exception();
        } catch (Exception e) {
            UserInterface.getInstance().displayMessage(NOT_AN_OPTION);
            return this.getFindOption();
        }
    }
}
