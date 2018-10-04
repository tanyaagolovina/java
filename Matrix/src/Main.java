public class Main {
    public static void main(String[] args){
        Matrix matrix = new Matrix();
        matrix.setSize();
        matrix.createMatrix();
        matrix.showMatrix(matrix.createMatrix());
        System.out.println();
        matrix.showMatrix(matrix.revertMatrix());
    }
}

