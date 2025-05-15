package com.selenium_testng.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;





public class PropertyReader {
    String path=System.getProperty("user.dir");
    String filepath=path+"\\src\\main\\java\\com\\selenium_testng\\utils\\objectRepo.properties";
    private FileInputStream fis;
    private Properties prop;
    
    
    public PropertyReader() throws IOException{        
    fis =  new FileInputStream(filepath);
    prop = new Properties();    
    prop.load(fis);
    if (fis != null) {
        fis.close();
    }
    }  

     public String get(String key){
        return prop.getProperty(key);
    }
   
    
}
