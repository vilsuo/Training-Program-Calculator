package com.mycompany.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    
    private final String configFileName = "config.properties";
    
    public PropertyManager() throws FileNotFoundException, IOException {
        File configFile = new File(this.configFileName);
        if (configFile.createNewFile()) {
            System.out.println("File " + configFile.getName() + " created");
            
            writeProperty("weightAccuracy", "2.5", "selected weight accuracy");
                
        } else {
            System.out.println("File " + this.configFileName + " already exists");
        }
    }
    
    public Properties loadProperties() throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(this.configFileName);
        Properties props = new Properties();
        props.load(reader);
        return props;
    }
    
    public void writeProperty(String property, String value, String message) throws IOException {
        Properties props = loadProperties();
        props.setProperty(property, value);
        FileWriter writer = new FileWriter(this.configFileName);
        props.store(writer, message);
        writer.close();
    }
}
