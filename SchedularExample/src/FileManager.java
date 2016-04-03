import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	private static final String PATH_TO_FILE_TO_WRITE = "/tmp/output/result";
	private static final String PATH_TO_FILES_TO_READ = "/tmp/input/";
	private static final String PATTERN = "^.*^.*(vol).*[^0-9]\\d{2}[-]\\d{2}[-]\\d{4}[^0-9].*$.*(?<!~)$";

	public List<String> getFileNames() throws WrongDirException{

		File folder = new File(PATH_TO_FILES_TO_READ);
		File[] listOfFiles = folder.listFiles();
		List<String> fNames = new ArrayList<String>();
        if(listOfFiles == null){
        	throw new WrongDirException("Wrong directory");
        }
		
		for (File file : listOfFiles) {
			if (file.isFile()) {
				fNames.add(file.getName());
			}
		}
		return fNames;
	}

	public String readFiles() throws WrongDirException {
		List<String> fNames = getFileNames();
		StringBuilder str = new StringBuilder();
		BufferedReader br;
		for (String name : fNames) {
			if (name.matches(PATTERN)) {
				System.out.println(name);
				try {
					br = new BufferedReader(new FileReader(PATH_TO_FILES_TO_READ + name));
					try {
						String x;
						while ((x = br.readLine()) != null) {
							str.append(x + "\n");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				str.append("\n");
			}
		}
		return str.toString();
	}

	public void saveResult() {
		String result = null;
		try {
			result = readFiles();
		} catch (WrongDirException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		if(result == null){
			return;
		}
		
		try (BufferedWriter out = new BufferedWriter(new FileWriter(PATH_TO_FILE_TO_WRITE))){
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
