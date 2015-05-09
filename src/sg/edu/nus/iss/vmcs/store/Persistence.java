package sg.edu.nus.iss.vmcs.store;

import java.io.IOException;

public interface Persistence {
	public void saveProperty() throws IOException;
	public void initialize() throws IOException;
	public int getNumOfItems();
	public void setNumOfItems(int vl);
	public String getValue(String key);
	public void setValue(String key, String value);
}