package lab_inherit;

import java.time.LocalDate;

public class Manager extends Employee {

    private Worker[] workers;

    public Manager(String name, LocalDate birthDay, String gender, String dept, String empNo, int baseSalary, LocalDate empDate, String taxpayerID, Worker[] workers) {
        super(name, birthDay, gender, dept, empNo, baseSalary, empDate, taxpayerID);
        this.workers = workers;
    }

    public Manager(String name, LocalDate birthDay, String gender, Worker[] workers) {
        super(name, birthDay, gender);
        this.workers = workers;
    }

    public Manager(String dept, String empNo, int baseSalary, LocalDate empDate, String taxpayerID, Worker[] workers) {
        super(dept, empNo, baseSalary, empDate, taxpayerID);
        this.workers = workers;
    }

    public Manager(Worker[] workers) {
        this.workers = workers;
    }

    /**Метод интерфейса @see Payable для вычисления реальной зарплаты сотрудника
     * @return реальную зарплату сотрудника (вычисляется на основе базовой ставки
     * */
    @Override
    public double getSalary() {
        return this.getBaseSalary()*2.5;
    }

    @Override
    public double bonus() {
        int projCount =0;
        for (Worker worker:workers ) {
            projCount += worker.getProjects()!=null?worker.getProjects().length:0;
        }
        return projCount * 10;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (workers!=null) {
            sb.append("Список сотрудников отдела:\n");
            for (Worker worker : this.workers) {
                sb.append("\t").append(worker.toShortString());
            }
        }
        return "Manager -> "+super.toString()+sb.toString();
    }

    public String toShortString() {
        return "Manager -> "+super.toString();
    }
}
