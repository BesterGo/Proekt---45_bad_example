package good_example.app.repository;

import good_example.app.domain.Timesheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimesheetRepositoryMap implements TimesheetRepository {

    // Это поле тоже является имитацией базы данных.
    // В этой мапе ключ - это подразделение компании,
    // а значение - это список табелей, которые относятся к этому подразделению.
    private Map<String, List<Timesheet>> database = new HashMap<>();

    public TimesheetRepositoryMap() {
        List<Timesheet> salesList = new ArrayList<>();
        List<Timesheet> productionList = new ArrayList<>();

        productionList.add(new Timesheet(40, "Jack", "Production"));
        salesList.add(new Timesheet(42, "John", "Sales"));
        productionList.add(new Timesheet(39, "Jenna", "Production"));
        salesList.add(new Timesheet(37, "Samantha", "Sales"));
        salesList.add(new Timesheet(40, "Bill", "Sales"));
        productionList.add(new Timesheet(41, "Mary", "Production"));

        database.put("Sales", salesList);
        database.put("Production", productionList);
    }

    @Override
    public List<Timesheet> findAll() {
        return database.values()
                .stream()
                .flatMap(x -> x.stream())
                .toList();
    }

    @Override
    public List<Timesheet> findAllByDepartment(String department) {
        return database.get(department);
    }
}