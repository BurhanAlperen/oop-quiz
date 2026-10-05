package exercises.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * ====================================================================
 * ALIŞTIRMA 7 [ZOR] - Kurumsal Şirket, Departman ve Personel Yönetim Sistemi
 * ====================================================================
 * Odaklanılan Konular:
 * - Nesne Yönelimli Programlama (OOP): Aggregation & Composition
 * - Çok Katmanlı Nesne Modelleri (Company -> Department -> Employee)
 * - Constructor Chaining ve Kapsülleme (Encapsulation)
 * - Koleksiyonlar (List / ArrayList) üzerinde filtreleme, zam yapma ve istatistiki raporlama
 *
 * PROBLEM TANIMI:
 * Bir kurumsal şirket için personel ve departman yönetim yazılımı tasarlayınız:
 * 1. Employee: id, ad, unvan, maaş ve performans skoru (1-5 arası) barındırmalı.
 * 2. Department: departman adı, departman kodu ve çalışanlar listesini yönetmeli.
 *    - Departmana personel ekleme
 *    - Departman toplam ve ortalama maaşını hesaplama
 *    - Departmandaki en yüksek performanslı personeli (Top Performer) bulma
 *    - Departmana özel yüzdesel zam yapma yeteneklerine sahip olmalıdır.
 * 3. Company: Birden fazla departmanı barındırmalı ve şirket geneli mali rapor üretmelidir.
 * ====================================================================
 */
public class Hard01_CompanyDepartmentSystem {

    // -------------------------------------------------------------
    // 1. ÇALIŞAN (EMPLOYEE) SINIFI
    // -------------------------------------------------------------
    public static class Employee {
        private final int id;
        private final String fullName;
        private final String title;
        private double salary;
        private final int performanceScore; // 1 ile 5 arası

        public Employee(int id, String fullName, String title, double salary, int performanceScore) {
            this.id = id;
            this.fullName = fullName;
            this.title = title;
            this.salary = Math.max(0, salary);
            this.performanceScore = Math.max(1, Math.min(5, performanceScore));
        }

        public int getId() { return id; }
        public String getFullName() { return fullName; }
        public String getTitle() { return title; }
        public double getSalary() { return salary; }
        public int getPerformanceScore() { return performanceScore; }

        public void applyRaise(double percentage) {
            if (percentage > 0) {
                this.salary += this.salary * (percentage / 100.0);
            }
        }

        public void printInfo() {
            System.out.printf("    [ID: %-3d] %-16s | Unvan: %-14s | Skor: %d/5 | Maaş: %10.2f TL\n",
                    id, fullName, title, performanceScore, salary);
        }
    }

    // -------------------------------------------------------------
    // 2. DEPARTMAN (DEPARTMENT) SINIFI
    // -------------------------------------------------------------
    public static class Department {
        private final String name;
        private final String code;
        private final List<Employee> employeeList;

        public Department(String name, String code) {
            this.name = name;
            this.code = code;
            this.employeeList = new ArrayList<>();
        }

        public void addEmployee(Employee emp) {
            this.employeeList.add(emp);
        }

        public double calculateTotalSalary() {
            double total = 0;
            for (Employee emp : employeeList) {
                total += emp.getSalary();
            }
            return total;
        }

        public double calculateAverageSalary() {
            if (employeeList.isEmpty()) return 0;
            return calculateTotalSalary() / employeeList.size();
        }

        public Employee getTopPerformer() {
            if (employeeList.isEmpty()) return null;
            Employee top = employeeList.get(0);
            for (Employee emp : employeeList) {
                if (emp.getPerformanceScore() > top.getPerformanceScore()) {
                    top = emp;
                }
            }
            return top;
        }

        public void applyDepartmentRaise(double percentage) {
            for (Employee emp : employeeList) {
                emp.applyRaise(percentage);
            }
        }

        public void printDepartmentReport() {
            System.out.println("  ============================================================");
            System.out.printf("  Departman: %s (%s) | Çalışan Sayısı: %d\n", name, code, employeeList.size());
            System.out.printf("  Toplam Maaş Gideri: %.2f TL | Ortalama Maaş: %.2f TL\n",
                    calculateTotalSalary(), calculateAverageSalary());
            Employee top = getTopPerformer();
            if (top != null) {
                System.out.printf("  Ayın Yıldızı: %s (Skor: %d/5)\n", top.getFullName(), top.getPerformanceScore());
            }
            System.out.println("  Çalışanlar:");
            for (Employee emp : employeeList) {
                emp.printInfo();
            }
            System.out.println("  ============================================================");
        }
    }

    // -------------------------------------------------------------
    // 3. ŞİRKET (COMPANY) SINIFI
    // -------------------------------------------------------------
    public static class Company {
        private final String companyName;
        private final List<Department> departments;

        public Company(String companyName) {
            this.companyName = companyName;
            this.departments = new ArrayList<>();
        }

        public void addDepartment(Department department) {
            this.departments.add(department);
        }

        public void generateGeneralReport() {
            System.out.println("\n************************************************************");
            System.out.println("             " + companyName.toUpperCase() + " KURUMSAL RAPORU");
            System.out.println("************************************************************");
            double totalCompanySalary = 0;
            int totalEmployees = 0;

            for (Department dep : departments) {
                dep.printDepartmentReport();
                totalCompanySalary += dep.calculateTotalSalary();
                totalEmployees += dep.employeeList.size();
                System.out.println();
            }

            System.out.println("----------------- GENEL ŞİRKET ÖZETİ -----------------");
            System.out.println("Toplam Departman Sayısı : " + departments.size());
            System.out.println("Toplam Personel Sayısı  : " + totalEmployees);
            System.out.printf("Aylık Toplam Maaş Yükü  : %.2f TL\n", totalCompanySalary);
            System.out.println("------------------------------------------------------\n");
        }
    }

    // -------------------------------------------------------------
    // TEST SENARYOSU
    // -------------------------------------------------------------
    public static void main(String[] args) {
        Company holding = new Company("TechNexus Teknoloji A.Ş.");

        // 1. Yazılım Departmanı Oluşturma
        Department software = new Department("Yazılım Mühendisliği", "DEV");
        software.addEmployee(new Employee(101, "Ali Yılmaz", "Kıdemli Yazılımcı", 75000, 5));
        software.addEmployee(new Employee(102, "Ayşe Kaya", "Frontend Dev", 50000, 4));
        software.addEmployee(new Employee(103, "Caner Erkin", "Junior Dev", 35000, 3));

        // 2. Siber Güvenlik Departmanı Oluşturma
        Department security = new Department("Siber Güvenlik & Operasyon", "SEC");
        security.addEmployee(new Employee(201, "Deniz Demir", "Güvenlik Uzmanı", 70000, 5));
        security.addEmployee(new Employee(202, "Berk Aslan", "Sistem Yöneticisi", 48000, 4));

        holding.addDepartment(software);
        holding.addDepartment(security);

        System.out.println("=== 1. ZAM ÖNCESİ DURUM ===");
        holding.generateGeneralReport();

        System.out.println(">>> YAZILIM DEPARTMANINA %10 ENFLASYON ZAMMI UYGULANIYOR...\n");
        software.applyDepartmentRaise(10.0);

        System.out.println("=== 2. ZAM SONRASI GÜNCEL DURUM ===");
        holding.generateGeneralReport();
    }
}
