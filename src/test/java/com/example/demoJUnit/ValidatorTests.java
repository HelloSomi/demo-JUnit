package com.example.demoJUnit;

import org.junit.jupiter.api.Test;

import static com.example.demoJUnit.Validator.isPhoneNumberValid;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTests {

    @Test
        //testar ett korrekt telefonnummer
    void testValidPhoneNumber() {
        boolean result = isPhoneNumberValid("0746598230");

        assertTrue(result);

    }

    @Test
        //testar ett telefon nummer som börjar på 0
    void checkIfNumberStartsWithZero() {
        boolean result = isPhoneNumberValid("0746598230");

        assertTrue(result);

    }
    @Test
    //testar skicka ett telefon nummer som inte börjar på 0
    public void phoneNumberDoNotStartsWithZero() {

        boolean result = isPhoneNumberValid("1284648596");

        assertFalse(result);

    }

    @Test

    public void testInvalidPhoneNumberWithTooFewDigits() {
        //testar skriva in ett kort telefon nummer
        boolean result = isPhoneNumberValid("012");

        assertFalse(result);
    }

    @Test
    public void testIsPhoneNumberContainsInvalidCharacters() {
        //testar skriva in ogiltiga tecken i telefon numret
        assertFalse(isPhoneNumberValid("01234A6789"));
    }

    @Test
    //Testa om meton retunerar True när man har space i telefonnumret
    public void testPhoneNumberWithExtraSpaces() {

        boolean result = Validator.isPhoneNumberWithExtraSpaces("047 012345");

        assertTrue(result);

    }

    @Test
    //Testa om meton retunerar ett felmeddelande när man har snedstreck i telefonnumret
    public void testIfPhoneNumberIsValidWithSlashCharacters() {

        boolean result = isPhoneNumberValid("074//46587089");

        assertFalse(result);

    }
    @Test
    //testar skicka in ett värde med bara mellanslag som argument
    public void testPhoneNumber_with_emptyInput() {

        boolean result = isPhoneNumberValid("  ");

        assertFalse(result);

    }
    @Test
    //testar skicka in ett långt telefon nummer
    public void testPhoneNumber_with_LoongNumber() {

        boolean result = isPhoneNumberValid("0756839768564736282");

        assertFalse(result);

    }






    //Testa om meton retunerar True vid en giltig Mail-adress
    @Test
    public void testValidEmail() {
        boolean result = Validator.isEmailValid("hello@mail.com");
        assertTrue(result);
    }

    @Test
    public void testInvalidEmail() {
        boolean result = Validator.isEmailValid("mail.com");

        assertFalse(result);

    }


    @Test
    public void testExtractEmailPartsWithInvalidIndexSign() {
        String email = "hello@hotmail.com";
        //indexOf är en metod som man använder för att söka efter en viss teckensträng i en annan teckensträng
        int positionSign = email.indexOf("@");
        //lastIndexOf metoden hittar positionen för det sista
        int domainPositionStart = email.lastIndexOf(".");
        String topDomainName = email.substring(domainPositionStart + 1);
        String emailDomaine = email.substring(positionSign + 1, domainPositionStart);
        String emailName = email.substring(0, positionSign);
        String[] expected = {"hello", "hotmail", "com"};
        String[] actual = {emailName, emailDomaine, topDomainName};
        assertArrayEquals(expected, actual);
    }

    //kontrollerar att det förväntade resultatet är falskt, för att eport adressen är ogiltig
    @Test
    public void testIsEmailValidWithInvalidSign() {
        String email = " hello!hotmail.com";
        boolean result = Validator.isEmailValid(email);
        assertFalse(result);
    }

    // kontrollerar att det testfallet returnerar false falskt, för att epostadressen saknar . i formatet

    //vill få ut ett felmeddelande isåfall
    @Test
    public void testIsEmailValidWithNoDot() {
        String email = " hello@hotmailcom";
        boolean result = Validator.isEmailValid(email);
        assertFalse(result);
    }


    @Test
    public void testNameLength() {

        assertFalse(Validator.isNameValid("Alexanderalexanaaa"));// invalid name
        // assertTrue(Validator.isNameValid("Alexander")); // valid name

    }

    @Test
    public void testEmailInputWithExtraSpaces() {
        //with space
        String email = "Alexander @.mail.com";
        assertTrue(Validator.isEmailContentIndexSign(email));

    }

    @Test
    public void testIfEmailNameToLong() {

        // retunera false om emailadress är orimligt lång
        String email = "Alexanderaxelssonhejsanssonnnn@.com";

        assertFalse(Validator.isEmailValid(email));


    }

    @Test
    public void testIfEmailValidWithEmptyEmail() {
        // retunera false om emailadress fältet är tomt, ett felmeddelande bör visas i terminalen
        String email = "";

        assertFalse(Validator.isEmailValid(email));


    }

    @Test
    public void testIfIsEmailValidWithNumbers(){
        String str = "142336374757585884";
        String result = Validator.ShouldContainsOnlyLetters(str);
        assertEquals("Error", result);
    }


}
