package good_example.app.service;

import good_example.app.domain.Timesheet;
import good_example.app.repository.TimesheetRepository;

public class SalaryServiceImpl implements SalaryService {

    // Принцип слабой связанности говорит о том, что класс должен
    // зависеть не от конкретной реализации, а от абстракции.
    // Другими словами - класс должен зависеть не от другого конкретного
    // класса, а от интерфейса.

    // Задача: научить сервис работать со второй версией репозитория
    // Алгоритм действий, которые для этого необходимы:
    // 1. Ничего...

    // Потому что вот это поле - интерфейсного типа.
    // То есть это поле позволяет передать нам в него объект любого класса,
    // который реализует интерфейс TimesheetRepository.
    private TimesheetRepository repository;
    private double salaryHourRate = 100;

    // И в этот конструктор мы можем передать объект любого репозитория,
    // главное - чтобы он реализовывал интерфейс TimesheetRepository
    public SalaryServiceImpl(TimesheetRepository repository) {
        this.repository = repository;
    }

    // И методы нам переписывать не надо.
    // Потому что все варианты репозиториев реализуют один и тот же интерфейс.
    // А это значит, что у всех репозиториев одна и та же сигнатура методов.
    @Override
    public double calculateTotalSalary() {
        return repository.findAll()
                .stream()
                .mapToInt(x -> x.getHours())
                .sum() * salaryHourRate;
    }

    @Override
    public double calculateSalaryByDepartment(String department) {
        return repository.findAllByDepartment(department)
                .stream()
                .mapToInt(Timesheet::getHours)
                .sum() * salaryHourRate;
    }
}