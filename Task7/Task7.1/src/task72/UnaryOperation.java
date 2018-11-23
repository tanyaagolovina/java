package task72;

public class UnaryOperation {

    private double value;

    public UnaryOperation(){
       this(100.0);
    }

    public UnaryOperation(double value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "UnaryOperation: " +
                "value = " + value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void increment(){
        value++;
    }

    public void decrement(){
        value--;
    }

    public void unsigned(){
        value = -value;
    }
}
