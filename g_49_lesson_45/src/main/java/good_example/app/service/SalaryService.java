package good_example.app.service;

// Этот интерфейс определяет поведение для всех возможных реализаций
// сервиса расчёта заработной платы
public interface SalaryService {

    double calculateTotalSalary();
    double calculateSalaryByDepartment(String department);
}