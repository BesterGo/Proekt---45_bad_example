package bad_example.app.repository;

import bad_example.app.domain.Timesheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimesheetRepositoryMap {

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

    // Метод возвращает список табелей по компании в целом
    public List<Timesheet> findAll() {
        return database.values() // [[datasheet, datasheet, datasheet], [datasheet, datasheet, datasheet]]
                .stream() // последовательность листов, состоящая из [datasheet, datasheet, datasheet] и [datasheet, datasheet, datasheet]
                .flatMap(x -> x.stream()) // два стрима из двух листов объединяются в один общий стрим, состоящий из 6 табелей
                .toList(); // list, состоящий из 6 табелей, которые получены из двух листов по 3 табеля в каждом
    }

    // Метод возвращает список табелей конкретного подразделения
    public List<Timesheet> findAllByDepartment(String department) {
        return database.get(department);
    }
}