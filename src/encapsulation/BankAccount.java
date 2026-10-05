package encapsulation;

/**
 * ====================================================================
 * MODEL: BankAccount (Banka Hesabı) - Veri Güvenliği ve Kapsülleme
 * ====================================================================
 * Bu sınıf, kapsülleme ilkesinin gerçek dünyadaki en yaygın kullanımını gösterir.
 * Bakiye (balance) doğrudan dışarıdan 'hesap.balance = 1000000' şeklinde değiştirilemez.
 * Sadece para yatırma (deposit) ve para çekme (withdraw) kuralları üzerinden değişebilir.
 */
public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("[UYARI] Başlangıç bakiyesi negatif olamaz! Bakiye 0 yapıldı.");
            this.balance = 0.0;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Para Yatırma Metodu: Tutar pozitif olmalıdır.
     */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("[HATA] Yatırılacak tutar pozitif bir değer olmalıdır: " + amount + " TL");
            return false;
        }
        this.balance += amount;
        System.out.println("[BAŞARILI] " + amount + " TL yatırıldı. Güncel bakiye: " + this.balance + " TL");
        return true;
    }

    /**
     * Para Çekme Metodu: Tutar pozitif olmalı ve bakiyeyi aşmamalıdır.
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("[HATA] Çekilecek tutar 0'dan büyük olmalıdır.");
            return false;
        }
        if (amount > this.balance) {
            System.out.println("[HATA] Yetersiz bakiye! Mevcut bakiye: " + this.balance + " TL, İstenen: " + amount + " TL");
            return false;
        }
        this.balance -= amount;
        System.out.println("[BAŞARILI] " + amount + " TL çekildi. Kalan bakiye: " + this.balance + " TL");
        return true;
    }
}
