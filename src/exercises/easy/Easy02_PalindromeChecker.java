package exercises.easy;

/**
 * ====================================================================
 * ALIŞTIRMA 2 [KOLAY] - Palindrom Kontrol Edici (Palindrome Checker)
 * ====================================================================
 * Odaklanılan Konular:
 * - Döngüler (for döngüsü)
 * - String ve Karakter işlemleri (charAt, length, toLowerCase)
 * - Boolean mantığı ve algoritmik düşünme
 *
 * PROBLEM TANIMI:
 * Düzden okunuşu ile tersten okunuşu aynı olan kelimelere veya ifadelere
 * 'Palindrom' denir (Örn: "kayak", "radar", "madam", "12321").
 * Verilen bir kelimenin palindrom olup olmadığını döngü kullanarak kontrol
 * eden ve sonucu ekrana yazdıran metodu yazınız.
 * (Büyük/küçük harf duyarsız olmalıdır).
 * ====================================================================
 */
public class Easy02_PalindromeChecker {

    public static void main(String[] args) {
        System.out.println("=== PALİNDROM KONTROLÜ TESTLERİ ===");

        String[] testKelimeleri = {"kayak", "Radar", "Java", "madam", "Programlama", "12321"};

        for (String kelime : testKelimeleri) {
            boolean sonuc = isPalindrome(kelime);
            System.out.printf("Kelime: %-12s -> Palindrom mu? %s\n",
                    ("'" + kelime + "'"), (sonuc ? "EVET, Palindromdur." : "HAYIR, Palindrom değildir."));
        }
    }

    /**
     * ÇÖZÜM METODU:
     * İki işaretçi (two pointers) tekniği ile baştan ve sondan karşılaştırarak
     * kelimenin palindrom olup olmadığını test eder.
     */
    public static boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }

        // Büyük/küçük harf farkını ortadan kaldırmak için küçük harfe dönüştürüyoruz
        String cleanText = text.toLowerCase().trim();

        int left = 0;
        int right = cleanText.length() - 1;

        // Baştaki ve sondaki karakterleri adım adım merkeze doğru kontrol ediyoruz
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false; // Karakterler uyuşmadığı anda palindrom olamaz
            }
            left++;
            right--;
        }

        return true; // Tüm karakterler simetrik eşleştiyse palindromdur
    }
}
