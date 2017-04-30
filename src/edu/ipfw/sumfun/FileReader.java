package edu.ipfw.sumfun;
/* The FileReader class just help read the input/output file when the project is put into a jar and no longer has the same file paths */
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileReader {//start FileReader class
	private InputStream in;//the input stream to read the file
	private OutputStream out;//the output stream to write to the file
	private String actualPath;//the String to keep track fo the path
	
	/**
	 * The constructor for the FileReader class
	 * Takes the basic file path and creates the InputStream object and makes a String 
	 * out the actual file path for later use
	 * @param path - the basic file path
	 */
	public FileReader(String path){//start FileReader constructor
		in = this.getClass().getResourceAsStream(path+".SOURCE");
		URL url = this.getClass().getResource(path);
		actualPath = url.getPath();
	}//end FileReader constructor
	
	/**
	 * Returns the InputStream variable
	 * @return in - the input stream to read the file
	 */
	public InputStream returnStream(){//start returnStream method
		return in;
	}//end returnStream method
	
	/**
	 * Returns the actualPath 
	 * @return actualpath - the String to keep track fo the path
	 */
	public String returnPath(){//start returnPath method
		return actualPath;
	}//end returnPath method

}//end FileReader class
