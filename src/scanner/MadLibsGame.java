package scanner;

import java.util.Scanner;

/**
 * ====================================================================
 * UYGULAMA: Mad Libs Kelime Tamamlama Oyunu
 * ====================================================================
 * Bu eğlenceli mini oyun, kullanıcının farklı kelime türleri (sıfat, isim, fiil)
 * girmesini sağlayıp bunları önceden hazırlanmış bir hikaye şablonuna
 * yerleştirerek Scanner sınıfının String okuma yeteneğini pekiştirir.
 */
public class MadLibsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   MAD LIBS HİKAYE OYUNUNA HOŞ GELDİNİZ  ");
        System.out.println("========================================");
        System.out.println("Lütfen sizden istenen kelimeleri sırayla girin:\n");

        System.out.print("1. Bir sıfat girin (örn: komik, uykulu, devasa): ");
        String adjective1 = scanner.nextLine();

        System.out.print("2. Bir isim/hayvan/kişi girin (örn: kaplumbağa, astronot): ");
        String noun1 = scanner.nextLine();

        System.out.print("3. İkinci bir sıfat girin (örn: parıltılı, öfkeli): ");
        String adjective2 = scanner.nextLine();

        System.out.print("4. Bir fiil/eylem girin (şimdiki zaman, örn: dans ediyordu, uçuyordu): ");
        String verb1 = scanner.nextLine();

        System.out.print("5. Son bir duygu/sıfat girin (örn: şaşkın, neşeli): ");
        String adjective3 = scanner.nextLine();

        // Hikaye çıktısı
        System.out.println("\n--- İŞTE OLUŞTURULAN ÇILGIN HİKAYE ---");
        System.out.println("Bugün çok " + adjective1 + " bir müzeye gittim.");
        System.out.println("Salonda aniden bir " + noun1 + " ile karşılaştım.");
        System.out.println(noun1 + " son derece " + adjective2 + " görünüyordu ve sahnede " + verb1 + "!");
        System.out.println("Bu durumu görünce hepimiz tamamen " + adjective3 + " olduk!");
        System.out.println("---------------------------------------");

        scanner.close();
    }
}
