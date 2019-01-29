package utils.managers;

import utils.Language;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
    private ResourceBundle resourceBundle;
    private String property;
    private static MessageManager instance;

    public static MessageManager getInstance() {
        if(instance == null){
            instance = new MessageManager();
            instance.resourceBundle = ResourceBundle.getBundle("properties.messages", Locale.getDefault());
        }
        return instance;
    }

    public MessageManager(){
        resourceBundle = ResourceBundle.getBundle("properties.messages");
    }

    public String getProperty(String key){
        property = resourceBundle.getString(key);
        return property;
    }

    public void setString(String property){
        this.property = property;
    }

    public void changeLocale(String str){
        Locale locale = Locale.getDefault();
        for (Language lang:Language.values()) {
            if(lang.toString().equalsIgnoreCase(str)) {
                locale = lang.getLocale();
            }
        }
        resourceBundle = ResourceBundle.getBundle("properties.messages", locale);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }
}
