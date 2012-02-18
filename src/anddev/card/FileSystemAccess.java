package anddev.card;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
	public List<InputStream> getTemplateFiles() throws IOException {
		File directory = Environment.getExternalStorageDirectory();
		return getFilesInDir(new File(directory + templatePath));
	}
	
	/**
	 * Get paths to character files for given template
	 * @param templateType string without '/'
	 * @return
	 * @throws IOException
	 */
	public List<InputStream> getCharacterFiles(String templateType)
			throws IOException {
		if(templateType.contains("/"))
			throw new IOException("bad template name (no / allowed)");
		File directory = Environment.getExternalStorageDirectory();
		return getFilesInDir(new File(directory + characterPath + "/" + templateType));
	}

	List<InputStream> getFilesInDir(File path) throws IOException {
		path.mkdirs();
		if(!path.isDirectory())
			throw new IOException("Can't access templates folder!");

		List<InputStream> files = new ArrayList<InputStream>();
		for(String file : path.list())
			files.add(new FileInputStream(path + "/" + file));
		return files;
	}
}
