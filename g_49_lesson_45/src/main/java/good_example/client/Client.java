package good_example.client;

import good_example.app.repository.TimesheetRepositoryList;
import good_example.app.repository.TimesheetRepositoryMap;
import good_example.app.service.SalaryService;
import good_example.app.service.SalaryServiceImpl;

public class Client {

    public static void main(String[] args) {

        TimesheetRepositoryList repositoryList = new TimesheetRepositoryList();
        TimesheetRepositoryMap repositoryMap = new TimesheetRepositoryMap();
        SalaryService service = new SalaryServiceImpl(repositoryMap);

        System.out.println("Заработная плата компании в целом:");
        System.out.println(service.calculateTotalSalary());

        System.out.println("Заработная плата по подразделениям:");
        System.out.println("Отдел продаж - " + service.calculateSalaryByDepartment("Sales"));
        System.out.println("Производство - " + service.calculateSalaryByDepartment("Production"));
    }
}