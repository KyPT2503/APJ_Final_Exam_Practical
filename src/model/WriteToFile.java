package model;

import java.util.List;

public class WriteToFile extends FileController {
    public boolean execute(List<Directory> directories) {
        return super.writeToFile(directories);
    }
}
