package encapsulation;

import java.util.ArrayList;
import java.util.List;

/**
 * ====================================================================
 * KONU: Kapsülleme (Encapsulation) Nedir ve Neden Kullanılır?
 * ====================================================================
 * Kapsülleme, bir sınıfın verilerini (alanlarını) dış müdahalelerden ve
 * doğrudan hatalı erişimlerden koruma sanatıdır.
 *
 * Bu sınıfta:
 * 1. Hatalı veri girişlerinin setter kontrolleriyle nasıl engellendiğini,
 * 2. Banka hesabı gibi kritik varlıklarda bakiye tutarlılığının nasıl sağlandığını,
 * 3. Kapsüllenmiş nesnelerin listeler halinde nasıl güvenle yönetildiğini görüyoruz.
 */
public class EncapsulationBasics {

    public static void main(String[] args) {
        System.out.println("=== 1. VERİ DOĞRULAMA (VALIDATION) TESTİ ===");

        // Bilerek geçersiz değerler (negatif yaş, hatalı email, negatif gelir) verelim
        User user1 = new User(1, "Ahmet", -5, -2000, "gecersizemail");
        user1.printUser();

        System.out.println("\nBilgileri geçerli değerlerle güncelliyoruz:");
        user1.setAge(24);
        user1.setIncome(45000);
        user1.setEmail("ahmet@ornek.com");
        user1.printUser();

        System.out.println("\n=== 2. BANKA HESABI KAPSÜLLEME TESTİ ===");
        BankAccount account = new BankAccount("TR1234567890", "Zeynep Kaya", 1000.0);

        // Doğrudan 'account.balance = 5000000;' yapamayız, private'tır ve derlenmez!
        // Yalnızca izin verilen metotları çağırabiliriz:
        account.deposit(500.0);
        account.withdraw(2000.0); // Yetersiz bakiye hatası verir
        account.withdraw(300.0);  // Başarıyla çeker

        System.out.println("\n=== 3. KAPSÜLLENMİŞ LİSTE YÖNETİMİ ===");
        List<User> userList = new ArrayList<>();
        userList.add(new User(10, "Mert", 29, 32000, "mert@mail.com"));
        userList.add(new User(11, "Selin", 27, 41000, "selin@mail.com"));
        userList.add(new User(12, "Efe", 35, 52000, "efe@mail.com"));

        double toplamGelir = 0;
        for (User u : userList) {
            toplamGelir += u.getIncome();
            u.printUser();
        }
        System.out.printf("\nToplam Kullanıcı Geliri: %.2f TL | Ortalama Gelir: %.2f TL\n",
                toplamGelir, (toplamGelir / userList.size()));
    }
}
