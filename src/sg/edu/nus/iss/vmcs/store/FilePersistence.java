package sg.edu.nus.iss.vmcs.store;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FilePersistence implements Persistence {
	
	private static final String PROP_NUM_ITEMS = "NumOfItems";
	private Properties prop;
	private String fileName;

	public FilePersistence(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}

	/*
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	*/

	@Override
	public void saveProperty() throws IOException {
		FileOutputStream stream = new FileOutputStream(fileName);
		prop.store(stream, "");
		stream.close();

	}

	@Override
	public void initialize() throws IOException {
		prop = new Properties(System.getProperties());
		FileInputStream stream = new FileInputStream(fileName);
		prop.load(stream);
		stream.close();

	}
	
	public int getNumOfItems() {
		String nm = prop.getProperty(PROP_NUM_ITEMS);
		int nmi;
		nmi = Integer.parseInt(nm);
		return nmi;
	}
	
	public void setNumOfItems(int vl) {
		prop.setProperty(PROP_NUM_ITEMS, String.valueOf(vl));
	}
	
	@Override
	public String getValue(String key) {
		return prop.getProperty(key);
	}

	@Override
	public void setValue(String key, String value) {
		prop.setProperty(key, value);		
	}
}