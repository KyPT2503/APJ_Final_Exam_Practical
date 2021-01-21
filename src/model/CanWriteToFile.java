package model;

import java.io.File;
import java.util.List;

public interface CanWriteToFile {
    boolean writeToFile(List<Directory> directories);
}
