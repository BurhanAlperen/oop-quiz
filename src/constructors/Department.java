package constructors;

import java.util.ArrayList;
import java.util.List;

/**
 * ====================================================================
 * MODEL: Department (Departman / Atölye) Sınıfı
 * ====================================================================
 * Bir departmanın adı, departman ID'si ve içinde çalışan Person listesini
 * yöneten nesne modellemesi.
 */
public class Department {
    public String departmentName;
    public int departmentId;
    public List<Person> employees;

    public Department(String departmentName, int departmentId) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
        // Listeyi başlatıyoruz ki NullPointerException hatası almayalım
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Person person) {
        this.employees.add(person);
    }

    public void printDepartmentDetails() {
        System.out.println("\n-------------------------------------------");
        System.out.println("Departman: " + departmentName + " (ID: " + departmentId + ")");
        System.out.println("Toplam Çalışan Sayısı: " + employees.size());
        System.out.println("Çalışan Listesi:");
        for (Person p : employees) {
            System.out.print("  * ");
            p.printInfo();
        }
        System.out.println("-------------------------------------------");
    }
}
