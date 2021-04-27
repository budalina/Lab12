package lab_inherit;

import java.time.LocalDate;

import static lab_inherit.Constants.DEFAULT_DEPT_NAME;

/**Класс Employee  предназначен для работы с объектами- сотрудниками*/

public abstract class Employee extends Person implements Payable{
    /**Поле taxpayerID определяет ИНН сотрудника*/
    private String taxpayerID;
    /**Поле dept определяет название отдела сотрудника*/
    private String dept;
    /**Поле empNo определяет табельный номер сотрудника*/
    private String empNo;
    /**Поле salary определяет базовую ставку зарплаты сотрудника*/
    private double baseSalary;
    /**Поле empDate - дата приема на работу*/
    private LocalDate empDate;

    public Employee(String name, LocalDate birthDay, String gender, String dept, String empNo, double baseSalary, LocalDate empDate, String taxpayerID) {
        super(name, birthDay, gender);
        this.dept = dept;
        this.empNo = empNo;
        this.baseSalary = baseSalary;
        this.empDate = empDate;
        this.taxpayerID = taxpayerID;
    }
    public Employee(String name, LocalDate birthDay, String gender) {
        super(name, birthDay, gender);
        this.dept = DEFAULT_DEPT_NAME;
        this.empNo = Constants.DEFAULT_EMP_NO;
        this.baseSalary = Constants.DEFAULT_SALARY;
        this.empDate = LocalDate.now();
        this.taxpayerID =Constants.DEFAULT_TAXPAYER_ID;
    }
    public Employee(String dept, String empNo, double baseSalary, LocalDate empDate, String taxpayerID){
        super();
        this.dept = dept;
        this.empNo = empNo;
        this.baseSalary = baseSalary;
        this.empDate = empDate;
        this.taxpayerID = taxpayerID;

    }
    public Employee(){
        super();
        this.dept = DEFAULT_DEPT_NAME;
        this.empNo = Constants.DEFAULT_EMP_NO;
        this.baseSalary = Constants.DEFAULT_SALARY;
        this.empDate = LocalDate.now();
        this.taxpayerID =Constants.DEFAULT_TAXPAYER_ID;
    }

    public String getTaxpayerID() {
        return taxpayerID;
    }

    public void setTaxpayerID(String taxpayerID) {
        this.taxpayerID = taxpayerID;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }


    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    @Override
    public String toString() {
        String f = "\tDepartment - %s\tNumber=%s\t TaxPayerID - %s \n";
        return super.toString() + String.format(f,this.getDept(), this.getEmpNo(), this.getTaxpayerID());
    }


    /**Метод интерфейса @see Payable
     * увеличивает базовую ставку зарплаты на указанное число процентов
     * при условии, что не превышена максимальная граница для повышения
     * @param pecent число процентов, на которые повышается зарплата
     *
     * @return true - если базовая ставка зарплаты была увеличена и false - в противном случае*/
    @Override
    public boolean increasePay(double pecent) {
        if (pecent <= Payable.INCREASE_CAP){
            this.setBaseSalary(this.getBaseSalary()*(100+pecent)/100);
            return true;
        }
        return false;
    }

    @Override
    public void printSalaryInfo() {
        System.out.println(this.toShortString() + "\tЗарплата = "+this.getSalary());
    }

}
