public class MyArrayDataException extends RuntimeException{
   private int column;
   private int string;

    public MyArrayDataException(String message, int column, int string) {
        super(message);
        this.column = column;
        this.string = string;
    }

    public int getColumn() {
        return column;
    }

    public int getString() {
        return string;
    }
}
