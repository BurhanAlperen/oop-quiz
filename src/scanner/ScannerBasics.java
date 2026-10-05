package scanner;

import java.util.Scanner;

/**
 * ====================================================================
 * KONU: Scanner Sınıfı ile Kullanıcıdan Veri Alma (User Input)
 * ====================================================================
 * Bu sınıf, Java'da kullanıcıdan konsol üzerinden farklı veri tiplerinde
 * girdi alma işlemlerini ve en sık karşılaşılan tuzakları öğretir.
 *
 * Önemli Noktalar:
 * 1. nextInt(), nextDouble() gibi metotlar sayıyı okur ancak klavyeden
 *    basılan 'Enter' (yeni satır / \n) karakterini okumaz ve tamponda (buffer) bırakır.
 * 2. Ardından nextLine() çağrılırsa bu tamponda kalan boşluğu okur ve kullanıcıdan
 *    yeni girdi almadan geçer.
 * 3. Çözüm: Sayısal okumadan hemen sonra boş bir scanner.nextLine() çağırmaktır.
 */
public class ScannerBasics {

    public static void main(String[] args) {
        // Scanner nesnesi oluşturulurken System.in (Standart Giriş Akışı - Klavye) kullanılır.
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 1. TEMEL VERİ TİPLERİ İLE GİRDİ ALMA ===");

        // 1. Tam sayı (int) alma
        System.out.print("Lütfen yaşınızı giriniz: ");
        int age = scanner.nextInt();

        // 2. Ondalıklı sayı (double) alma
        System.out.print("Not ortalamanızı giriniz (örn: 3.45): ");
        double gpa = scanner.nextDouble();

        // 3. Mantıksal değer (boolean) alma
        System.out.print("Öğrenci misiniz? (true / false): ");
        boolean isStudent = scanner.nextBoolean();

        /*
         * KRİTİK NOKTA (Scanner Buffer Temizliği):
         * nextInt/nextDouble/nextBoolean klavyeden girilen son 'Enter' karakterini
         * okumadığı için, alttaki nextLine() fonksiyonunun atlanmasını önlemek
         * amacıyla tampon belleği temizliyoruz.
         */
        scanner.nextLine();

        // 4. Metin (String) satırı alma
        System.out.print("Adınızı ve soyadınızı giriniz: ");
        String fullName = scanner.nextLine();

        // Alınan verileri ekrana yazdırma
        System.out.println("\n--- GİRİLEN BİLGİLER ---");
        System.out.println("Ad Soyad : " + fullName);
        System.out.println("Yaş      : " + age);
        System.out.println("Ortalama : " + gpa);
        System.out.println("Öğrenci  : " + (isStudent ? "Evet" : "Hayır"));

        System.out.println("\n=== 2. MATEMATİKSEL İŞLEM ÖRNEĞİ (DİKDÖRTGEN ALAN/ÇEVRE) ===");
        System.out.print("Dikdörtgenin genişliğini giriniz (cm): ");
        double width = scanner.nextDouble();

        System.out.print("Dikdörtgenin yüksekliğini giriniz (cm): ");
        double height = scanner.nextDouble();

        double area = width * height;
        double perimeter = 2 * (width + height);

        System.out.printf("Alan: %.2f cm² | Çevre: %.2f cm\n", area, perimeter);

        // Kaynak sızıntısını önlemek için scanner kapatılır.
        scanner.close();
        System.out.println("\nScanner başarıyla kapatıldı.");
    }
}
