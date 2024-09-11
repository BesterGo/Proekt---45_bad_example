package good_example.app.repository;

import good_example.app.domain.Timesheet;

import java.util.List;

// Задача данного интерфейса - определить поведение
// для всех вариантов репозиториев, сколько бы их ни было
public interface TimesheetRepository {

    List<Timesheet> findAll();
    List<Timesheet> findAllByDepartment(String department);
}