package bad_example.app.service;

import bad_example.app.domain.Timesheet;
import bad_example.app.repository.TimesheetRepositoryMap;

public class SalaryService {

    // Так как сервису для доступа к базе данных необходимо обращаться
    // к репозиторию, для этого и будет служить данное поле,
    // которое будет содержать объект репозитория, к которому
    // сможет обращаться сервис в своём коде

    // Задача: научить сервис работать со второй версией репозитория
    // Алгоритм действий, которые для этого необходимы:
    // 1. Поле с репозиторием меняем на поле другого типа.
    //    Было - TimesheetRepositoryList, стало - TimesheetRepositoryMap.
    // 2. Поменять входящий параметр конструктора также на новый тип.
    //    Было - TimesheetRepositoryList, стало - TimesheetRepositoryMap.
    // 3. Переписать все методы, которые работают с репозиторием,
    //    т.к. у второго репозитория методы называются по-другому
//    private TimesheetRepositoryList repository;

    // Сильная связанность - это когда класс зависит от другого класса,
    // то есть от его конкретной реализации.
    private TimesheetRepositoryMap repository;

    // Это поле содержит ставку заработной платы (в час)
    private double salaryHourRate = 100;

    public SalaryService(TimesheetRepositoryMap repository) {
        this.repository = repository;
    }

    // Метод рассчитывает заработную плату по всей компании в целом
    public double calculateTotalSalary() {
        return repository.findAll()
                .stream()
                .mapToInt(x -> x.getHours())
                .sum() * salaryHourRate;
    }

    // Метод рассчитывает заработную плату по определённому подразделению
    public double calculateSalaryByDepartment(String department) {
        return repository.findAllByDepartment(department)
                .stream()
                .mapToInt(Timesheet::getHours)
                .sum() * salaryHourRate;
    }
}