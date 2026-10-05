package constructors;

/**
 * ====================================================================
 * MODEL: Person (Kişi) Sınıfı - Constructor Mantığı
 * ====================================================================
 * Bu sınıf; parametresiz constructor, parametreli constructor ve
 * 'this(...)' ile constructor chaining (zincirleme çağrı) kavramlarını gösterir.
 */
public class Person {
    public String name;
    public String surname;
    public String city;
    public int age;
    public double salary;

    /**
     * 1. Parametresiz (Default / No-Args) Yapıcı Metot:
     * Nesne hiçbir bilgi verilmeden 'new Person()' şeklinde üretilirse varsayılan değerleri atar.
     */
    public Person() {
        // Constructor Chaining: Diğer 5 parametreli yapıcıyı varsayılan değerlerle çağırıyoruz.
        this("Bilinmiyor", "Bilinmiyor", "Belirtilmedi", 18, 0.0);
        System.out.println("[Person] Parametresiz yapıcı metot çalıştı.");
    }

    /**
     * 2. Temel Bilgileri Alan Yapıcı Metot (Overloading):
     */
    public Person(String name, String surname, int age) {
        this(name, surname, "Belirtilmedi", age, 0.0);
    }

    /**
     * 3. Tüm Alanları Dolduran Parametreli Yapıcı Metot:
     * 'this.name = name;' ifadesinde soldaki 'this.name' nesnenin alanını (field),
     * sağdaki 'name' ise metoda gelen parametreyi temsil eder.
     */
    public Person(String name, String surname, String city, int age, double salary) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.age = age;
        this.salary = salary;
    }

    /**
     * Kişi bilgilerini formatlı olarak konsola yazdıran metot.
     */
    public void printInfo() {
        System.out.printf("Kişi: %s %s | Şehir: %s | Yaş: %d | Maaş: %.2f TL\n",
                name, surname, city, age, salary);
    }
}
