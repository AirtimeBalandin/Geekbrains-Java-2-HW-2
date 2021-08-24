public class MyArrayDataException extends ArrayIndexOutOfBoundsException {
    public MyArrayDataException(String message){
        super("Wrong data" + message);
    }
}
