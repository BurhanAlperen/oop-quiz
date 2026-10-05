package exercises.medium;

import java.util.Arrays;

/**
 * ====================================================================
 * ALIŞTIRMA 4 [ORTA] - Dizide Eleman Frekansı (Tekrar Sayısı) Bulma
 * ====================================================================
 * Odaklanılan Konular:
 * - Diziler ve çoklu geçiş (Nested Loops)
 * - Boolean bayrak dizisi (visited/ziyaret edildi dizisi) ile mükerrer kontrolü
 * - Algoritmik veri işleme
 *
 * PROBLEM TANIMI:
 * Verilen bir tam sayı dizisinde her bir elemanın kaç kez tekrar ettiğini
 * (frekansını) bulan ve ekrana her elemanı yalnızca 1 kez listeleyerek yazdıran
 * algoritmayı yazınız.
 *
 * Örnek Girdi : {10, 20, 20, 10, 10, 20, 5, 20}
 * Beklenen Çıktı:
 *   - 10 sayısı 3 kez tekrar etti.
 *   - 20 sayısı 4 kez tekrar etti.
 *   - 5 sayısı 1 kez tekrar etti.
 * ====================================================================
 */
public class Medium01_FrequencyCounter {

    public static void main(String[] args) {
        System.out.println("\n=== DİZİ ELEMAN FREKANSI (TEKRAR SAYISI) HESAPLAMA ===");

        int[] dizi = {10, 20, 20, 10, 10, 20, 5, 20, 7, 7, 10};

        System.out.println("Girdi Dizisi: " + Arrays.toString(dizi) + "\n");
        hesaplaFrekans(dizi);
    }

    /**
     * ÇÖZÜM METODU:
     * Boolean tabanlı 'ziyaret edildi' (visited) dizisi kullanarak daha önce
     * sayılmış elemanların tekrar sayılmasını önler.
     */
    public static void hesaplaFrekans(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Dizi boş!");
            return;
        }

        int n = arr.length;
        // Hangi elemanların daha önce işlendiğini tutan boolean dizi
        boolean[] ziyaretEdildi = new boolean[n];

        System.out.println("Eleman Tekrar Dağılımı:");
        for (int i = 0; i < n; i++) {
            // Eğer bu indisteki eleman daha önce bir tekrar olarak sayıldıysa atla
            if (ziyaretEdildi[i]) {
                continue;
            }

            int sayac = 1;
            // Kendisinden sonraki elemanları tara
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    ziyaretEdildi[j] = true; // Tekrar eden elemanı işaretle
                    sayac++;
                }
            }

            System.out.printf("  * Sayı: %-4d -> %d kez tekrar etti.\n", arr[i], sayac);
        }
    }
}
