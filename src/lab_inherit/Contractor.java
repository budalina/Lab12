package lab_inherit;

import java.time.LocalDate;

public class Contractor extends Person implements Payable{
    private double hourCost;
    private int hoursWorked;

    public Contractor(String name, LocalDate birthDay, String gender, int hourCost, int hoursWorked) {
        super(name, birthDay, gender);
        this.hourCost = hourCost;
        this.hoursWorked = hoursWorked;
    }

    public Contractor(int hourCost, int hoursWorked) {
        this.hourCost = hourCost;
        this.hoursWorked = hoursWorked;
    }

    public double getHourCost() {
        return hourCost;
    }

    public void setHourCost(double hourCost) {
        this.hourCost = hourCost;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "Contractor -> "+super.toString()+ String.format("\t Отработанные чвсы - %d \t Зарплата - %.2f \n",hoursWorked, getSalary() );
    }

    public double getSalary(){
        return this.hourCost*hoursWorked;
    }

    @Override
    public double bonus() {
        return this.hoursWorked/200.0*5;
    }

    @Override
    public boolean increasePay(double pecent) {
        if (pecent <= Payable.INCREASE_CAP){
            this.setHourCost(this.getHourCost()*(100+pecent)/100);
            return true;
        }
        return false;
    }

    @Override
    public void printSalaryInfo() {
        System.out.println(this.toShortString() + "\tЗарплата = "+this.getSalary());
    }
}
