package data;

import java.util.HashMap;
import java.util.Map;

public class DataSource {


    public static Map getDictionary(){
        return new HashMap<String, String>(10) {
            {
                this.put("leo","лев");
                this.put("king", "король");
                this.put("of","из");
                this.put("animals", "зверей");
                this.put("forest","лес");
                this.put("river", "речка");
                this.put("sun","солнце");
                this.put("sky", "небо");
                this.put("cloud","туча");
                this.put("rain", "дождь");
            }
        };
    }
}
