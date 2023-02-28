package tek.sdet.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlfiles {
	  private static ReadYamlfiles readYamlFiles;
	    private HashMap propertyMap;
	    
	    private ReadYamlfiles(String filepath) throws FileNotFoundException {
	        FileInputStream fileInputStream = FileUtility.getFileInputStream(filepath);
	        Yaml yaml = new Yaml();
	        this.propertyMap = yaml.load(fileInputStream);
	    }
	    public static ReadYamlfiles getInstance(String filePath) throws FileNotFoundException {
	        if(readYamlFiles == null)
	            return new ReadYamlfiles(filePath);
	        return readYamlFiles;
	    }
	    
	    public HashMap getYamlProperty(String key) {
	        return (HashMap) this.propertyMap.get(key);
	    
	    }	    
	    
}

