package com.main;



import java.util.HashMap;
import java.util.Map;

public class TheBoss extends MoneyCounter implements EmployeeForm {

    @Override
    void employeeAbsent() {
        System.out.println("ABSENT BROOOOOOOO");
    }

    @Override
    public Map<String, String> employeeData(String data) {
        Map<String, String> map = new HashMap<>();
        map.put("dimas", "adr");
        System.out.println("FROM INTERFACE");
        return map;
    }

    @Override
    public String EmployeeOutsourcing() {
        String outsource = "lol";
        System.out.println(outsource+"OUT SOURCEEEEEEEEEEEEEE");
        return outsource;
    }
}
