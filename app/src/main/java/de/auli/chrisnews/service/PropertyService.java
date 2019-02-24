package de.auli.chrisnews.service;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyService {
    private static final String TAG = PropertyService.class.getSimpleName();
    private static PropertyService service;
    Properties props;
    static String file = "";

    public static PropertyService getInstance(){
        if(service== null){
            service = new PropertyService();
        }
        return service;
    }

    private PropertyService(){
        this.props = new Properties();
        try {
            URI uri = PropertyService.class.getResource("/").toURI();
            File file = new File(String.format("%s/properties.xml", uri));
            FileInputStream fis = new FileInputStream(file);
            props.loadFromXML(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String store(){
        return file;
    }

    public String get(String key){
        return props.getProperty(key);
    }
}
