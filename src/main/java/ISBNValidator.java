public class ISBNValidator {

    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_LENGTH = 10;

    public boolean checkISBN(String code) {
        if (code.length() == LONG_ISBN_LENGTH) return checkLongISBN(code);
        if (code.length() == SHORT_ISBN_LENGTH)return checkShortISBN(code);
        throw new NumberFormatException("ISBN numbers must be 10 digits long");
    }

    private boolean checkShortISBN(String code) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++){
            char digit = code.charAt(i);
            if (!Character.isDigit(digit)){
                if (i != 9 || digit != 'X')  throw new NumberFormatException("ISBN numbers must consist only of digits");
                else total += 10;
            }
            else total += Character.getNumericValue(digit) * (10 - i);
        }
        return total % 11 == 0;
    }

    private boolean checkLongISBN(String code){
        int total = 0;
        int[] powerArray = new int[]{1, 3};
        for (int i = 0; i < LONG_ISBN_LENGTH; i++){
            char c = code.charAt(i);
            if(Character.isDigit(c)){
                total += Character.getNumericValue(c) * powerArray[i % 2];
            }
            else throw new NumberFormatException("ISBN numbers must consist only of digits");
        }
        return total % 10 == 0;
    }
}
