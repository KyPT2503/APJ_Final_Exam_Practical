package model;

import java.io.File;
import java.util.List;

public class ReadFromFile extends FileController {
    List<Directory> execute(File file) {
        return super.readFromFile();
    }
}
