package lab_inherit;

import java.time.LocalDate;

public class SalesPerson extends Worker{
    private int quota;
    private int salesCount;
    private int discount;

    public SalesPerson(String name, LocalDate birthDay, String gender, String dept, String empNo, int salary, LocalDate empDate, String taxpayerID, String[] projects, int quota, int salesCount, int discount) {
        super(name, birthDay, gender, dept, empNo, salary, empDate, taxpayerID, projects);
        this.setDept("Sales");
        this.quota = quota;
        this.salesCount = salesCount;
        this.discount = discount;
    }

    public SalesPerson(String name, LocalDate birthDay, String gender, String[] projects, int quota, int salesCount, int discount) {
        super(name, birthDay, gender, projects);
        this.setDept("Sales");
        this.quota = quota;
        this.salesCount = salesCount;
        this.discount = discount;
    }

    public SalesPerson(String empNo, int salary, LocalDate empDate, String taxpayerID, String[] projects, int quota, int salesCount, int discount) {
        super("Sales", empNo, salary, empDate, taxpayerID, projects);
        this.quota = quota;
        this.salesCount = salesCount;
        this.discount = discount;
    }

    public SalesPerson(String[] projects, int quota, int salesCount, int discount) {
        super(projects);
        this.setDept("Sales");
        this.quota = quota;
        this.salesCount = salesCount;
        this.discount = discount;
    }

    public SalesPerson(){
        super();
        this.quota=100;
        this.salesCount = 0;
        this.discount = 0;
        this.setDept("Sales");
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        String f = "Квота - %d, Число продаж - %d, Скидка - %d %%\n";
        return "SalesPerson -> "+super.toString()+String.format(f, quota, salesCount, discount);
    }

    @Override
    public double getSalary() {
        return this.getBaseSalary()*1.3;
    }

    @Override
    public double bonus() {
        return Math.max(this.salesCount-this.quota,0)*3;
    }
}
