/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
 и просуммировать. Если в каком-то элементе массива преобразование не удалось
  (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
   исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения
MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 */
public class MainClass {
    public static void main(String[] args) {
        String[][] arr = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String[][] arr_size = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String[][] arr_data = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","a","4"},{"1","2","3","4"}};
        int result = 0;

        try {
            result=0;
            result = check(arr);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат суммирования элементов массива равна "+result);
        }

        try {
            result=0;
            result =check(arr_size);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
           System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат суммирования элементов массива равна "+String.valueOf(result));
        }

        try {
            result = 0;
            result =check(arr_data);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());}
        catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат суммирования элементов массива равна "+result);
        }

    }
    public static int check(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        int sum=0; int row; int cell; int value;
        if(arr.length != 4 || arr[0].length != 4 || arr[1].length != 4 || arr[2].length != 4 || arr[3].length != 4) {
            throw new MyArraySizeException();
        }

        for(int i=0;i<4;i++){
            row = i;
            for(int j=0;j <4; j++){
                cell = j;
                try{
                    value = Integer.parseInt(arr[i][j]);
                    sum += value;
                } catch (IllegalArgumentException e){
                    String message = "в "+ row+" ряду, "+cell+" ячейке";
                    throw new MyArrayDataException(message);
                }
            }
        }
        return sum;
    }
}
