package exercises.medium;

/**
 * ====================================================================
 * ALIŞTIRMA 6 [ORTA] - Güvenli Banka Hesabı ve Günlük Limit Simülasyonu
 * ====================================================================
 * Odaklanılan Konular:
 * - Kapsülleme (Encapsulation) & Data Hiding
 * - Yapıcı Metotlar (Constructors)
 * - Durum Yönetimi (State Management: Günlük çekilen tutar takibi)
 * - İş Mantığı Doğrulamaları (Business Validation)
 *
 * PROBLEM TANIMI:
 * Bir banka hesabı sınıfı tasarlayınız.
 * - Hesap numarası, hesap sahibi, bakiye, günlük çekim limiti ve
 *   o gün çekilen toplam tutar private tutulmalıdır.
 * - Kullanıcı para çekerken:
 *     1. Çekilmek istenen tutar pozitif olmalı,
 *     2. Bakiye yetersiz olmamalı,
 *     3. Günlük çekim limiti (örn: 5.000 TL) aşılmamalıdır.
 * Bu kuralları uygulayan ve hesap ekstresini yazdıran sistemi kodlayınız.
 * ====================================================================
 */
public class Medium03_BankAccountApp {

    // Kapsüllenmiş (Private) Alanlar
    private final String accountNumber;
    private final String ownerName;
    private double balance;
    private final double dailyWithdrawLimit;
    private double withdrawnToday;

    // Parametreli Constructor
    public Medium03_BankAccountApp(String accountNumber, String ownerName, double initialBalance, double dailyWithdrawLimit) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = Math.max(0, initialBalance);
        this.dailyWithdrawLimit = Math.max(0, dailyWithdrawLimit);
        this.withdrawnToday = 0.0;
    }

    // Para Yatırma
    public boolean paraYatir(double tutar) {
        if (tutar <= 0) {
            System.out.println("[REDDEDİLDİ] Yatırılacak tutar pozitif olmalıdır: " + tutar + " TL");
            return false;
        }
        this.balance += tutar;
        System.out.printf("[BAŞARILI] %.2f TL yatırıldı. Güncel bakiye: %.2f TL\n", tutar, this.balance);
        return true;
    }

    // Para Çekme (Limit ve Bakiye Kontrollü)
    public boolean paraCek(double tutar) {
        if (tutar <= 0) {
            System.out.println("[REDDEDİLDİ] Çekilecek tutar 0'dan büyük olmalıdır.");
            return false;
        }
        if (tutar > this.balance) {
            System.out.printf("[REDDEDİLDİ] Yetersiz bakiye! Mevcut: %.2f TL, İstenen: %.2f TL\n", this.balance, tutar);
            return false;
        }
        if (this.withdrawnToday + tutar > this.dailyWithdrawLimit) {
            double kalanLimit = this.dailyWithdrawLimit - this.withdrawnToday;
            System.out.printf("[REDDEDİLDİ] Günlük çekim limiti aşıldı! Bugün kalan çekim hakkınız: %.2f TL\n", kalanLimit);
            return false;
        }

        this.balance -= tutar;
        this.withdrawnToday += tutar;
        System.out.printf("[BAŞARILI] %.2f TL çekildi. Kalan bakiye: %.2f TL (Bugün çekilen toplam: %.2f TL)\n",
                tutar, this.balance, this.withdrawnToday);
        return true;
    }

    // Hesap Ekstresi
    public void ekstreYazdir() {
        System.out.println("\n----------- HESAP EKSTRESİ -----------");
        System.out.println("Hesap No       : " + accountNumber);
        System.out.println("Hesap Sahibi   : " + ownerName);
        System.out.printf("Güncel Bakiye  : %.2f TL\n", balance);
        System.out.printf("Günlük Limit   : %.2f TL\n", dailyWithdrawLimit);
        System.out.printf("Bugün Çekilen  : %.2f TL\n", withdrawnToday);
        System.out.println("--------------------------------------\n");
    }

    public static void main(String[] args) {
        System.out.println("\n=== BANKACILIK KAPSÜLLEME TESTİ ===");

        Medium03_BankAccountApp hesap = new Medium03_BankAccountApp(
                "TR99887766", "Ali Can", 10000.0, 5000.0
        );

        hesap.ekstreYazdir();

        // 1. Başarılı para yatırma
        hesap.paraYatir(2000.0);

        // 2. Başarılı para çekme
        hesap.paraCek(3000.0);

        // 3. Günlük limiti aşan para çekme denemesi (Kalan limit 2000, 2500 isteniyor)
        hesap.paraCek(2500.0);

        // 4. Limite uygun para çekme
        hesap.paraCek(1500.0);

        // 5. Son durum ekstresi
        hesap.ekstreYazdir();
    }
}
