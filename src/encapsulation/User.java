package encapsulation;

/**
 * ====================================================================
 * MODEL: User (Kullanıcı) Sınıfı - Encapsulation (Kapsülleme) İlkesi
 * ====================================================================
 * Kapsülleme Kuralları:
 * 1. Sınıf değişkenleri (fields) doğrudan dışarıdan erişilemesin diye 'private' yapılır.
 * 2. Bu değişkenlere kontrollü erişim sağlamak için 'getter' ve 'setter' metotları yazılır.
 * 3. 'Setter' metotları içerisinde veri doğrulama (validation) yapılarak nesnenin
 *    tutarsız ya da geçersiz duruma düşmesi engellenir.
 */
public class User {

    // 1. Private alanlar (Data Hiding - Veri Gizleme)
    private int id;
    private String name;
    private int age;
    private double income;
    private String email;

    /**
     * Parametreli Constructor:
     * Doğrudan alanlara atama yapmak yerine 'setter' metotlarını çağırarak
     * constructor üzerinden nesne oluşturulurken de kuralların denetlenmesini sağlarız.
     */
    public User(int id, String name, int age, double income, String email) {
        setId(id);
        setName(name);
        setAge(age);
        setIncome(income);
        setEmail(email);
    }

    // --- GETTER & SETTER METOTLARI (KONTROLLÜ ERİŞİM) ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            System.out.println("[HATA] ID değeri 0 veya negatif olamaz! (Girilen: " + id + ")");
            this.id = 1; // Varsayılan güvenli değer
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("[HATA] İsim boş bırakılamaz!");
            this.name = "Anonim";
        } else {
            this.name = name.trim();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // Doğrulama (Validation) Kuralı: Yaş 0 ile 120 arasında olmalıdır.
        if (age < 0 || age > 120) {
            System.out.println("[HATA] Geçersiz yaş: " + age + "! Yaş 0 ile 120 arasında olmalıdır.");
            this.age = 18; // Varsayılan değer
        } else {
            this.age = age;
        }
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        // Doğrulama Kuralı: Gelir negatif olamaz.
        if (income < 0) {
            System.out.println("[HATA] Gelir negatif olamaz! (Girilen: " + income + ")");
            this.income = 0.0;
        } else {
            this.income = income;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("[HATA] Geçersiz e-posta formatı: " + email);
            this.email = "belirtilmedi@mail.com";
        }
    }

    public void printUser() {
        System.out.printf("ID: %-3d | İsim: %-10s | Yaş: %-3d | Gelir: %10.2f TL | E-posta: %s\n",
                id, name, age, income, email);
    }
}
