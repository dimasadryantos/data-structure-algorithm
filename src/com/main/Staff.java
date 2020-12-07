package com.main;

public class Staff extends Employee{
    public Staff(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    private String newStaff;
    private String oldStaff;

    public void mailCheck(){
        System.out.println("staff class");
    }



    public String getNewStaff() {
        return newStaff;
    }

    public void setNewStaff(String newStaff) {
        this.newStaff = newStaff;
    }

    public String getOldStaff() {
        return oldStaff;
    }

    public void setOldStaff(String oldStaff) {
        this.oldStaff = oldStaff;
    }
}
