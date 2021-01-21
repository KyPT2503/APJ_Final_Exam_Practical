package controller.services;

import model.Directory;

import java.util.List;

public interface CanFindDirectory {
    List<Directory> find(String input,List<Directory> directories);
}
