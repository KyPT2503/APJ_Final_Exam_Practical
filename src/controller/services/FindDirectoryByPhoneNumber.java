package controller.services;

import model.Directory;

import java.util.LinkedList;
import java.util.List;

public class FindDirectoryByPhoneNumber implements CanFindDirectory {
    @Override
    public List<Directory> find(String phoneNumber, List<Directory> directories) {
        List<Directory> result = new LinkedList<>();
        for (Directory directory : directories) {
            if (directory.getPhoneNumber().toLowerCase().contains(phoneNumber.toLowerCase())) {
                result.add(directory);
            }
        }
        return result;
    }
}
