package FileService;

import java.io.IOException;
import java.io.InputStreamReader;

import lop.Food;

public interface IFileService {
	public InputStreamReader docFile(String file) throws IOException;
	public void ghiFile(String file) throws IOException;
}
