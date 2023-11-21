import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите пример: ");
        String num = in.nextLine();
        in.close();
        String[] parts = num.split(" ", 3);
        if(parts.length == 3)
            fin(parts);
        else throw new ArrayIndexOutOfBoundsException();
    }
    static int calculation(int num1, int num2, String sgn){
        int result;
        switch(sgn) {
            case "+" : result = num1 + num2; break;
            case "-" : result = num1 - num2; break;
            case "*" : result = num1 * num2; break;
            case "/" : result = num1 / num2; break;
            default: throw new IllegalArgumentException();
        }
        return result;
    }
    static boolean checkForInt(String part) {
        try {
            Integer.parseInt(part);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return true;
    }
    static boolean isRoman(String part){
        String [] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            for(String element : roman) {
                if(part.equals(element))
                    return true;
            }
            return false;
    }
    static String getNameForValue(int value) {
                int[] answerArab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 24, 25, 27, 28, 30, 32, 35, 36, 40, 42, 45, 48, 49, 50, 54, 56, 60, 63, 64, 70, 72, 80, 81, 90, 100};
                String[] answerRom = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI",
                        "XVII", "XVIII", "XIX", "XX", "XXI", "XXIV", "XXV", "XXVII", "XXVIII", "XXX", "XXXII", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "XLIX", "L", "LIV", "LVI", "LX", "LXIII", "LXIV", "LXX", "LXXII", "LXXX", "LXXXI", "XC", "C"};

                for(int i = 0; i < answerArab.length; i++) {
                    if (value == answerArab[i])
                        return answerRom[i];
                }
            return null;
    }
    static void fin (String[] parts) throws ArrayIndexOutOfBoundsException{
            if (isRoman(parts[0]) && isRoman(parts[2])) {
                Roman rome1 = Roman.valueOf(parts[0]);
                Roman rome2 = Roman.valueOf(parts[2]);
                int result = calculation(rome1.getConvert(), rome2.getConvert(), parts[1]);
                    String value = getNameForValue(result);
                    if (value != null)
                        System.out.println(value);
                    else throw new IllegalArgumentException();
            } else if (checkForInt(parts[0]) && checkForInt(parts[2])) {
                int num1 = Integer.parseInt(parts[0]);
                int num2 = Integer.parseInt(parts[2]);
                if (num1 > 0 && num2 > 0 && num1 < 11 && num2 < 11) {
                    int result = calculation(num1, num2, parts[1]);
                    System.out.println(result);
                }
                else throw new IllegalArgumentException();
            }
        }
    }

