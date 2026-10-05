import arrays.ArraysBasics;
import constructors.ConstructorsBasics;
import encapsulation.EncapsulationBasics;
import exceptions.ExceptionsBasics;
import exercises.easy.Easy01_BMICalculator;
import exercises.easy.Easy02_PalindromeChecker;
import exercises.easy.Easy03_ArrayMinMaxAvg;
import exercises.medium.Medium01_FrequencyCounter;
import exercises.medium.Medium02_GradeManager;
import exercises.medium.Medium03_BankAccountApp;
import exercises.hard.Hard01_CompanyDepartmentSystem;
import exercises.hard.Hard02_UserAuthSystem;
import loops.LoopsBasics;
import loops.LoopsWithIfElse;
import methods.MethodsBasics;

import java.util.Scanner;

/**
 * ====================================================================
 * JAVA OOP & TEMEL KAVRAMLAR - REHBER VE TEST MERKEZİ (MAIN GİRİŞİ)
 * ====================================================================
 * Bu proje, Java programlama diline yeni başlayanların temel kavramlardan
 * Nesne Yönelimli Programlamaya (OOP) ve İleri Hata Yönetimine kadar
 * tüm konuları basitten zora doğru öğrenmeleri ve pratik yapmaları
 * amacıyla hazırlanmıştır.
 *
 * Konsol menüsünü kullanarak istediğiniz konunun anlatımını veya
 * alıştırmasını (Kolay - Orta - Zor) tek tıkla çalıştırabilirsiniz.
 * ====================================================================
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========================================================");
            System.out.println("   JAVA ÖĞRENME REHBERİ & ALIŞTIRMA MERKEZİ");
            System.out.println("========================================================");
            System.out.println("--- [TEMEL KONU ANLATIMLARI] ---");
            System.out.println(" 1 - Loops Basics (Döngüler: for, while, do-while, for-each, arama)");
            System.out.println(" 2 - Loops + If-Else (Döngü & Karar Yapıları: Tek/Çift, Not Baremi, Kalan Hak, Sepet)");
            System.out.println(" 3 - Arrays (Diziler, 2D Matrisler ve Arrays Sınıfı)");
            System.out.println(" 4 - Methods (Metotlar, Overloading ve Varargs)");
            System.out.println(" 5 - Constructors (Yapıcılar, 'this', Nesne İlişkileri)");
            System.out.println(" 6 - Encapsulation (Kapsülleme, Data Hiding, Validation)");
            System.out.println(" 7 - Exceptions (Hata Yakalama, Custom Exceptions)");
            System.out.println("\n--- [KOLAY SEVİYE ALIŞTIRMALAR] ---");
            System.out.println(" 8 - [Kolay 1] Vücut Kitle İndeksi (VKİ) Hesaplayıcı");
            System.out.println(" 9 - [Kolay 2] Palindrom Kelime/Sayı Denetleyici");
            System.out.println("10 - [Kolay 3] Dizide Min, Max ve Ortalama Bulucu");
            System.out.println("\n--- [ORTA SEVİYE ALIŞTIRMALAR] ---");
            System.out.println("11 - [Orta 1] Dizide Eleman Frekansı / Tekrar Sayısı");
            System.out.println("12 - [Orta 2] Öğrenci Not & Başarı Sistemi (Overloading)");
            System.out.println("13 - [Orta 3] Banka Hesabı & Günlük Limit Simülasyonu");
            System.out.println("\n--- [ZOR SEVİYE ALIŞTIRMALAR] ---");
            System.out.println("14 - [Zor 1] Kurumsal Şirket, Departman & Personel Sistemi");
            System.out.println("15 - [Zor 2] Güvenli Kullanıcı Kayıt & Custom Exception Sistemi");
            System.out.println("\n 0 - Çıkış");
            System.out.println("========================================================");
            System.out.print("Çalıştırmak istediğiniz modülü seçin (0-15): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Lütfen geçerli bir sayı giriniz!");
                scanner.nextLine();
                continue;
            }

            int secim = scanner.nextInt();
            scanner.nextLine(); // buffer temizliği

            if (secim == 0) {
                System.out.println("İyi çalışmalar, Java öğrenme yolculuğunuzda başarılar!");
                break;
            }

            System.out.println("\n>>> MODÜL ÇALIŞTIRILIYOR... <<<\n");

            switch (secim) {
                case 1:
                    LoopsBasics.main(new String[]{});
                    break;
                case 2:
                    LoopsWithIfElse.main(new String[]{});
                    break;
                case 3:
                    ArraysBasics.main(new String[]{});
                    break;
                case 4:
                    MethodsBasics.main(new String[]{});
                    break;
                case 5:
                    ConstructorsBasics.main(new String[]{});
                    break;
                case 6:
                    EncapsulationBasics.main(new String[]{});
                    break;
                case 7:
                    ExceptionsBasics.main(new String[]{});
                    break;
                case 8:
                    Easy01_BMICalculator.hesaplaVeYazdir(75.0, 1.78);
                    break;
                case 9:
                    Easy02_PalindromeChecker.main(new String[]{});
                    break;
                case 10:
                    Easy03_ArrayMinMaxAvg.main(new String[]{});
                    break;
                case 11:
                    Medium01_FrequencyCounter.main(new String[]{});
                    break;
                case 12:
                    Medium02_GradeManager.main(new String[]{});
                    break;
                case 13:
                    Medium03_BankAccountApp.main(new String[]{});
                    break;
                case 14:
                    Hard01_CompanyDepartmentSystem.main(new String[]{});
                    break;
                case 15:
                    Hard02_UserAuthSystem.main(new String[]{});
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen menüdeki numaralardan birini giriniz.");
            }

            System.out.println("\n(Menüye dönmek için Enter'a basınız...)");
            scanner.nextLine();
        }

        scanner.close();
    }
}
