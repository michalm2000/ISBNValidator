import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISBNValidatorTest {

    @Test
    void checkAValidISBN(){
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("1784753602");
        assertTrue(result);
        result = validator.checkISBN("1472116968");
        assertTrue(result);
    }

    @Test
    void checkAnInvalidISBN(){
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("1784753603");
        assertFalse(result);
    }

    @Test
    public void nineDigitISBNsAreNotAllowed() {
        ISBNValidator validator = new ISBNValidator();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("123456789"));
    }

    @Test
    public void ISBNHasToConsistOnlyOfNumbers(){
        ISBNValidator validator = new ISBNValidator();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("helloworld"));
    }

    @Test
    public void ISBNNumbersEndingWithAnXAreValid() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    void ISBNNumbersWith13CharactersAreValid() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("9781784753603");
        assertTrue(result);
        validator.checkISBN("9781472116963");
        assertTrue(result);
    }


    @Test
    void ISBNNumbersWith13CharactersAreInvalid() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("9781472116960");
        assertFalse(result);
    }

}
