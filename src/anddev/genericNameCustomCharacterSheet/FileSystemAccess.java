package anddev.genericNameCustomCharacterSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;

public class FileSystemAccess {
	static public final String templatePath = "/anddev/templates/";
	static public final String characterPath = "/anddev/"; 
	
	/**
	 * Get names of template files
	 * @return
	 * @throws IOException
	 */
	public List<FileReader> getTemplateFiles() throws IOException {
		File directory = Environment.getExternalStorageDirectory();
		return getFilesInDir(new File(directory + templatePath));
	}
	
	/**
	 * Get paths to character files for given template
	 * @param templateType string without '/'
	 * @return
	 * @throws IOException
	 */
	public List<FileReader> getCharacterFiles(String templateType)
			throws IOException {
		if(templateType.contains("/"))
			throw new IOException("bad template name (no / allowed)");
		File directory = Environment.getExternalStorageDirectory();
		return getFilesInDir(new File(directory + characterPath + "/" + templateType));
	}

	List<FileReader> getFilesInDir(File path) throws IOException {
		path.mkdirs();
		if(!path.isDirectory())
			throw new IOException("Can't access templates folder!");

		List<FileReader> files = new ArrayList<FileReader>();
		for(String file : path.list())
			files.add(new FileReader(path + "/" + file));
		return files;
	}
}
