package utils.managers;

import java.util.ResourceBundle;

public enum QueriesManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    QueriesManager(){
        resourceBundle = ResourceBundle.getBundle("queries");
    }
    public String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
