package exceptions;

/**
 * ====================================================================
 * ÖZEL HATA SINIFI (Custom Exception): InvalidAgeException
 * ====================================================================
 * Java'da hazır gelen istisnalar (NullPointerException, ArithmeticException vs.)
 * iş mantığımızı karşılamadığında kendi özel hata sınıflarımızı türetebiliriz.
 *
 * 'Exception' sınıfından miras (extends) alırsak bu bir CHECKED (derleme zamanında
 * kontrol edilen) hata olur ve metotta 'throws' ile belirtilmesi ya da try-catch
 * ile ele alınması zorunludur.
 */
public class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}
