package pro.sky.HW_27.service;

import org.springframework.stereotype.Service;
import pro.sky.HW_27.entity.Employee;
import pro.sky.HW_27.exception.EmployeeAlreadyAddedException;
import pro.sky.HW_27.exception.EmployeeNotFoundExection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImp  implements EmployeeService{
    private static final int MAX_SIZE = 100;
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Бобров", "Ефим"),
            new Employee("Гуляев", "Тихон"),
            new Employee("Шашков", "Савели"),
            new Employee("Николаев", "Остап"),
            new Employee("Шаров", "Алексей"),
            new Employee("Вишнякова", "Дарья"),
            new Employee("Калашникова", "Астра"),
            new Employee("Беспалова", "Роксана"),
            new Employee("Лазарева", "Хильда"),
            new Employee("Уварова", "Дана")
    ));

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundExection();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundExection();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }

}


