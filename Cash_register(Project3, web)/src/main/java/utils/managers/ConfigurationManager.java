package utils.managers;

import java.util.ResourceBundle;

public enum ConfigurationManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    ConfigurationManager(){
        resourceBundle = ResourceBundle.getBundle("config");
    }
    public String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
