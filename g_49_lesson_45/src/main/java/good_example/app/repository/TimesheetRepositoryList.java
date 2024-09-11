package good_example.app.repository;

import good_example.app.domain.Timesheet;

import java.util.ArrayList;
import java.util.List;

public class TimesheetRepositoryList implements TimesheetRepository {

    // Этот лист является имитацией базы данных, он будет содержать
    // объекты табелей, которые хранятся в базе данных программы.
    private List<Timesheet> database = new ArrayList<>();

    // В конструкторе мы наполняем базу данных шестью объектами,
    // чтобы на старте программы у нас была уже наполненная база данных.
    public TimesheetRepositoryList() {
        database.add(new Timesheet(40, "Jack", "Production"));
        database.add(new Timesheet(42, "John", "Sales"));
        database.add(new Timesheet(39, "Jenna", "Production"));
        database.add(new Timesheet(37, "Samantha", "Sales"));
        database.add(new Timesheet(40, "Bill", "Sales"));
        database.add(new Timesheet(41, "Mary", "Production"));
    }

    @Override
    public List<Timesheet> findAll() {
        return database;
    }

    @Override
    public List<Timesheet> findAllByDepartment(String department) {
        return database
                .stream()
                .filter(x -> x.getDepartment().equals(department))
                .toList();
    }
}