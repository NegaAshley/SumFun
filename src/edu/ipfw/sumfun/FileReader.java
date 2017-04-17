package edu.ipfw.sumfun;
/* The FileReader class just help read the input/output file when the project is put into a jar and no longer has the same file paths */
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileReader {
	private InputStream in;
	private OutputStream out;
	private String actualPath;
	
	/**
	 * takes the basic file path and creates the InputStream object and makes a String out the actual file path for later use
	 * @param path the basic file path
	 */
	public FileReader(String path){
		in = this.getClass().getResourceAsStream(path+".SOURCE");
		URL url = this.getClass().getResource(path);
		actualPath = url.getPath();
	}
	
	/**
	 * returns the InputStream variable
	 * @return in
	 */
	public InputStream returnStream(){
		return in;
	}
	
	/**
	 * returns the actualPath 
	 * @return actualpath
	 */
	public String returnPath(){
		return actualPath;
	}

}
