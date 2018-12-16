package DoAnOop;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface File {

    void docFile(String tenFile) throws FileNotFoundException, IOException;

    void ghiThem(String tenFile) throws FileNotFoundException, IOException;

    void ghiDe(String tenFile) throws FileNotFoundException, IOException;

    void ghiFile(String tenFile, Boolean ghiDe) throws FileNotFoundException, IOException;
}
