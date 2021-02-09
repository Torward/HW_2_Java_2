import java.util.Arrays;

public class Main {
    static int sum = 0;
    static int size = 4;

    public static void main(String[] args) {
        try {
            myArray();
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.err.println("Превышен размер массива!");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.err.println(e.getString() + " " + e.getColumn());
        }
    }

    public static void myArray() throws MyArraySizeException, MyArrayDataException {
        String[][] mass = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},//"Открылась бездна звёзд полна, звездам числа нет, бездне дна..."
                {"13", "14", "15", "16"}//,"17"

        };
        /*String[][] mass = new String[4][4];

        mass[0][0] = "1";
        mass[0][1] = "2";
        mass[0][2] = "3";
        mass[0][3] = "4";
        mass[1][0] = "5";
        mass[1][1] = "6";
        mass[1][2] = "7";
        mass[1][3] = "8";
        mass[2][0] = "9";
        mass[2][1] = "10";
        mass[2][2] = "11";
        mass[2][3] = "12";//Раскрылась бездна звёзд полна, Звездам числа нет, Бездне дна...
        mass[3][0] = "13";
        mass[3][1] = "14";
        mass[3][2] = "15";
        mass[3][3] = "16";
        //mass[3][4] = "17";*///При подобной инициализации массива превышая размер получаем в любом
                              //случае ArrayIndexOutOfBoundsException вместо ожидаемого MyArraySizeException
                              //меняю на вашу инициализацию
        if (mass.length != size) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < mass.length; i++) {
            try {
                if (mass[i].length != size) {
                    throw new MyArraySizeException();
                }
            } catch (ArrayIndexOutOfBoundsException e) {//попытался заставить выдать MyArraySizeException при
                                                        // моём способе инициализации массива
                throw new MyArraySizeException();
            }
        }

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                try {
                    sum += Integer.parseInt(mass[i][j]);
                    System.out.println(sum);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("format " + i + " " + j, i, j);
                }
            }
        }

        System.out.println("End");
    }

}
