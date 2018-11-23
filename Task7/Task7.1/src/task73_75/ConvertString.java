package task73_75;

@FunctionalInterface
public interface ConvertString {
    String convert(String string);

    default boolean isNull(String string){
        return string == null || string.trim().equals("");
    }
}
