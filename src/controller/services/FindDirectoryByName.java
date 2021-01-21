package controller.services;

import model.Directory;

import java.util.LinkedList;
import java.util.List;

public class FindDirectoryByName implements CanFindDirectory {
    @Override
    public List<Directory> find(String name, List<Directory> directories) {
        List<Directory> result = new LinkedList<>();
        for (Directory directory : directories) {
            if (directory.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(directory);
            }
        }
        return result;
    }
}
