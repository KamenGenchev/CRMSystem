package com.sirma.fileio;

import java.io.File;
import java.util.List;

public interface DataFileWriter {
    void writeDataFile(List<String[]> list, File file);
}
