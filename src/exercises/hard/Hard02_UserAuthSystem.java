package exercises.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * ====================================================================
 * ALIŞTIRMA 8 [ZOR] - Güvenli Kullanıcı Kayıt & Kimlik Doğrulama Sistemi
 * ====================================================================
 * Odaklanılan Konular:
 * - Özel Hata Sınıfları (Custom Checked Exceptions) Hiyerarşisi
 * - throw, throws ve try-catch-finally mimarisi
 * - String Analizi (Büyük harf, küçük harf, rakam, format kontrolü)
 * - OOP Prensipleri, Kapsülleme ve Koleksiyonlar
 *
 * PROBLEM TANIMI:
 * Kurumsal bir kullanıcı kimlik doğrulama (Auth) motoru yazınız:
 * 1. Özel İstisnalar (Custom Exceptions):
 *    - WeakPasswordException: Şifre en az 8 karakter olmalı, en az bir büyük harf,
 *      bir küçük harf ve bir rakam içermelidir.
 *    - InvalidEmailException: E-posta geçerli formatta (@ ve .) olmalıdır.
 *    - UserAlreadyExistsException: Aynı e-posta veya kullanıcı adıyla ikinci kayıt yapılamaz.
 *    - AuthenticationFailedException: Hatalı kullanıcı adı veya parola girildiğinde fırlatılır.
 * 2. AuthManager sınıfı ile kayıt ve giriş senaryolarını test ediniz.
 * ====================================================================
 */
public class Hard02_UserAuthSystem {

    // -------------------------------------------------------------
    // ÖZEL HATA SINIFLARI (CUSTOM EXCEPTIONS)
    // -------------------------------------------------------------
    public static class WeakPasswordException extends Exception {
        public WeakPasswordException(String message) { super(message); }
    }

    public static class InvalidEmailException extends Exception {
        public InvalidEmailException(String message) { super(message); }
    }

    public static class UserAlreadyExistsException extends Exception {
        public UserAlreadyExistsException(String message) { super(message); }
    }

    public static class AuthenticationFailedException extends Exception {
        public AuthenticationFailedException(String message) { super(message); }
    }

    // -------------------------------------------------------------
    // KULLANICI MODELİ (USER ENTITY)
    // -------------------------------------------------------------
    public static class UserAccount {
        private final String username;
        private final String email;
        private final String password; // Gerçek sistemlerde hashlenir, burada eğitim amaçlı sade tutuldu

        public UserAccount(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }

        public String getUsername() { return username; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }
    }

    // -------------------------------------------------------------
    // KİMLİK DOĞRULAMA YÖNETİCİSİ (AUTH MANAGER)
    // -------------------------------------------------------------
    public static class AuthManager {
        private final List<UserAccount> users = new ArrayList<>();

        /**
         * Yeni kullanıcı kaydı. Tüm kuralları sırayla denetler.
         */
        public void register(String username, String email, String password)
                throws InvalidEmailException, WeakPasswordException, UserAlreadyExistsException {

            // 1. E-posta Format Kontrolü
            if (email == null || !email.contains("@") || !email.contains(".")) {
                throw new InvalidEmailException("Geçersiz e-posta adresi: '" + email + "'. Format 'kullanici@domain.com' olmalıdır.");
            }

            // 2. Parola Güçlülük Kontrolü
            validatePasswordStrength(password);

            // 3. Mükerrer Kullanıcı Kontrolü
            for (UserAccount u : users) {
                if (u.getUsername().equalsIgnoreCase(username)) {
                    throw new UserAlreadyExistsException("Bu kullanıcı adı zaten kullanımda: " + username);
                }
                if (u.getEmail().equalsIgnoreCase(email)) {
                    throw new UserAlreadyExistsException("Bu e-posta ile kayıtlı bir hesap zaten var: " + email);
                }
            }

            // Tüm kontrollerden geçerse kullanıcı listeye eklenir
            UserAccount newUser = new UserAccount(username, email, password);
            users.add(newUser);
            System.out.println("[KAYIT BAŞARILI] Hoş geldiniz, " + username + "! (" + email + ")");
        }

        /**
         * Sisteme Giriş Kontrolü
         */
        public UserAccount login(String usernameOrEmail, String password) throws AuthenticationFailedException {
            for (UserAccount u : users) {
                boolean matchesIdentifier = u.getUsername().equalsIgnoreCase(usernameOrEmail) ||
                                            u.getEmail().equalsIgnoreCase(usernameOrEmail);
                if (matchesIdentifier && u.getPassword().equals(password)) {
                    System.out.println("[GİRİŞ BAŞARILI] Oturum açıldı: " + u.getUsername());
                    return u;
                }
            }
            throw new AuthenticationFailedException("Kullanıcı adı veya şifre hatalı!");
        }

        /**
         * Şifre Güvenlik Denetleyicisi:
         * - En az 8 karakter
         * - En az 1 büyük harf
         * - En az 1 küçük harf
         * - En az 1 rakam
         */
        private void validatePasswordStrength(String password) throws WeakPasswordException {
            if (password == null || password.length() < 8) {
                throw new WeakPasswordException("Şifre en az 8 karakter uzunluğunda olmalıdır!");
            }

            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpper = true;
                else if (Character.isLowerCase(c)) hasLower = true;
                else if (Character.isDigit(c)) hasDigit = true;
            }

            if (!hasUpper) {
                throw new WeakPasswordException("Şifre en az bir BÜYÜK harf içermelidir!");
            }
            if (!hasLower) {
                throw new WeakPasswordException("Şifre en az bir KÜÇÜK harf içermelidir!");
            }
            if (!hasDigit) {
                throw new WeakPasswordException("Şifre en az bir RAKAM içermelidir!");
            }
        }
    }

    // -------------------------------------------------------------
    // TEST VE ÇALIŞTIRMA SENARYOLARI
    // -------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=== GÜVENLİ KİMLİK DOĞRULAMA VE HATA YÖNETİMİ TESTİ ===");
        AuthManager auth = new AuthManager();

        // Senaryo 1: Hatalı E-posta Denemesi
        try {
            System.out.println("\n[Test 1] Hatalı e-posta ile kayıt deneniyor...");
            auth.register("ahmet123", "gecersiz-posta", "GucluSifre123");
        } catch (Exception e) {
            System.out.println("-> Yakalanan Hata: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Senaryo 2: Zayıf Parola Denemesi
        try {
            System.out.println("\n[Test 2] Zayıf parola ile kayıt deneniyor...");
            auth.register("mehmet_dev", "mehmet@kod.com", "kucuk12"); // 8 karakterden az, büyük harf yok
        } catch (Exception e) {
            System.out.println("-> Yakalanan Hata: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Senaryo 3: Başarılı Kayıt
        try {
            System.out.println("\n[Test 3] Geçerli bilgilerle kayıt yapılıyor...");
            auth.register("zeynep_tech", "zeynep@tech.org", "Zeynep2026!");
        } catch (Exception e) {
            System.out.println("-> Beklenmeyen Hata: " + e.getMessage());
        }

        // Senaryo 4: Mükerrer Kullanıcı Adı ile Kayıt Denemesi
        try {
            System.out.println("\n[Test 4] Aynı kullanıcı adı ile tekrar kayıt deneniyor...");
            auth.register("zeynep_tech", "baska_eposta@tech.org", "BaskaSifre99");
        } catch (Exception e) {
            System.out.println("-> Yakalanan Hata: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Senaryo 5: Giriş (Login) Testleri
        System.out.println("\n[Test 5] Giriş senaryoları test ediliyor...");
        try {
            // Hatalı şifre
            auth.login("zeynep_tech", "YanlisSifre1");
        } catch (AuthenticationFailedException e) {
            System.out.println("-> Giriş Engellendi: " + e.getMessage());
        }

        try {
            // Doğru giriş
            auth.login("zeynep@tech.org", "Zeynep2026!");
        } catch (AuthenticationFailedException e) {
            System.out.println("-> Hata: " + e.getMessage());
        }
    }
}
