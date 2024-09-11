package bad_example.client;

import bad_example.app.repository.TimesheetRepositoryList;
import bad_example.app.repository.TimesheetRepositoryMap;
import bad_example.app.service.SalaryService;

// Клиентское приложение, которое отправляет запросы
// на серверное приложение (которое в пакете app)
public class Client {

    public static void main(String[] args) {

        TimesheetRepositoryList repository = new TimesheetRepositoryList();
        TimesheetRepositoryMap repositoryMap = new TimesheetRepositoryMap();
        SalaryService service = new SalaryService(repositoryMap);

        System.out.println("Заработная плата всей компании:");
        double totalSalary = service.calculateTotalSalary();
        System.out.println(totalSalary);

        System.out.println("Заработная плата по подразделениям:");
        double salesSalary = service.calculateSalaryByDepartment("Sales");
        double productionSalary = service.calculateSalaryByDepartment("Production");
        System.out.println("Отдел продаж - " + salesSalary);
        System.out.println("Производство - " + productionSalary);
    }
}