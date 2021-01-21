package model;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class FileController implements CanReadFromFile, CanWriteToFile {

    public static final String FILE_PATH = "data/contacts.csv";
    private File file;


    public FileController() {
        this.file = new File(FILE_PATH);
    }

    @Override
    public List<Directory> readFromFile() {
        List<Directory> result = new LinkedList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] directoryInfo = line.split(",");
                for (int i = 0; i < directoryInfo.length; i++) {
                    directoryInfo[i] = directoryInfo[i].replaceAll("__", ",");
                }
                String phoneNumber = directoryInfo[0];
                String name = directoryInfo[1];
                String group = directoryInfo[2];
                Gender gender = directoryInfo[3].equalsIgnoreCase("male") ? Gender.MALE : (directoryInfo[4].equalsIgnoreCase("female") ? Gender.FEMALE : Gender.ANOTHER);
                String address = directoryInfo[4];
                String[] yearMonthDay = directoryInfo[5].split("-");
                LocalDate birthday = LocalDate.of(Integer.parseInt(yearMonthDay[0]), Integer.parseInt(yearMonthDay[1]), Integer.parseInt(yearMonthDay[2]));
                String email = directoryInfo[6];
                result.add(new Directory().withAddress(address).withGender(gender).withBirthday(birthday).withEmail(email).withName(name).withPhoneNumber(phoneNumber).withGroup(group).build());
            }

            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean writeToFile(List<Directory> directories) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (Directory directory : directories) {
                String name = directory.getName().replaceAll(",", "__");
                String phoneNumber = directory.getPhoneNumber().replaceAll(",", "__");
                String group = directory.getGroup().replaceAll(",", "__");
                String gender = directory.getGender().toString().replaceAll(",", "__");
                String address = directory.getAddress().replaceAll(",", "__");
                String birthday = directory.getBirthday().toString().replaceAll(",", "__");
                String email = directory.getEmail().replaceAll(",", "__");
                String line = phoneNumber + "," + name + "," + group + "," + gender + "," + address + "," + birthday + "," + email;
                bufferedWriter.write(line + "\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
