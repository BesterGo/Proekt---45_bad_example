package bad_example.app.repository;

import bad_example.app.domain.Timesheet;

import java.util.ArrayList;
import java.util.List;

public class TimesheetRepositoryList {

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

    // Метод возвращает все табели из базы данных
    public List<Timesheet> getAll() {
        return database;
    }

    // Метод возвращает все табели указанного подразделения компании
    public List<Timesheet> getAllByDepartment(String department) {
        return database
                .stream()
                .filter(x -> x.getDepartment().equals(department))
                .toList();
    }
}