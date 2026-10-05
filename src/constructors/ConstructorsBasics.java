package constructors;

/**
 * ====================================================================
 * KONU: Java'da Yapıcı Metotlar (Constructors) ve Nesne Başlatma
 * ====================================================================
 * Bu sınıf; nesnelerin nasıl belleğe yüklendiğini, constructor türlerini,
 * nesneler arası ilişkileri (Association / Composition) uygulamalı olarak öğretir.
 *
 * Temel Kurallar:
 * 1. Constructor ismi Sınıf ismi ile birebir aynı olmalıdır.
 * 2. Constructor'ların 'return' tipi (void dahil) olamaz.
 * 3. Eğer sınıfa hiç constructor yazmazsanız, Java arka planda parametresiz
 *    boş bir 'default constructor' sağlar.
 * 4. Parametreli herhangi bir constructor yazarsanız, Java'nın sağladığı
 *    default constructor kaybolur; parametresiz gerekiyorsa elle yazılmalıdır.
 */
public class ConstructorsBasics {

    public static void main(String[] args) {
        System.out.println("\n=== 1. FARKLI CONSTRUCTOR'LAR İLE NESNE ÜRETİMİ ===\n");

        // 1. Parametresiz constructor ile nesne üretme
        Person p1 = new Person();
        p1.printInfo();

        // 2. Kısmi parametreli constructor ile nesne üretme
        Person p2 = new Person("Ahmet", "Yılmaz", 28);
        p2.salary = 42000.0;
        p2.printInfo();

        // 3. Tam parametreli constructor ile nesne üretme
        Person p3 = new Person("Elif", "Kaya", "İzmir", 31, 55000.0);
        Person p4 = new Person("Burak", "Demir", "Ankara", 24, 38000.0);
        p3.printInfo();
        p4.printInfo();

        System.out.println("\n=== 2. NESNELER ARASI İLİŞKİ: DEPARTMAN VE ÇALIŞANLAR ===");
        // Departman nesneleri oluşturuyoruz
        Department yazilimDep = new Department("Yazılım Geliştirme", 101);
        yazilimDep.addEmployee(p2);
        yazilimDep.addEmployee(p3);

        Department argeDep = new Department("Ar-Ge ve İnovasyon", 102);
        argeDep.addEmployee(p4);

        // Departman detaylarını yazdıralım
        yazilimDep.printDepartmentDetails();
        argeDep.printDepartmentDetails();
    }
}
