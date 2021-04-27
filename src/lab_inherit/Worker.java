package lab_inherit;

import java.time.LocalDate;

public class Worker extends Employee {
    private String[] projects;

    public Worker(String name, LocalDate birthDay, String gender, String dept, String empNo, int salary, LocalDate empDate, String taxpayerID, String[] projects) {
        super(name, birthDay, gender, dept, empNo, salary, empDate, taxpayerID);
        this.projects = projects;
    }

    public Worker(String name, LocalDate birthDay, String gender, String[] projects) {
        super(name, birthDay, gender);
        this.projects = projects;
    }

    public Worker(String dept, String empNo, int salary, LocalDate empDate, String taxpayerID, String[] projects) {
        super(dept, empNo, salary, empDate, taxpayerID);
        this.projects = projects;
    }

    public Worker(String[] projects) {
        this.projects = projects;
    }

    public Worker(){
        this.projects = null;
    }

    public String[] getProjects() {
        return projects;
    }

    public void setProjects(String[] projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (projects!=null) {
            sb.append("Список проектов сотрудника:\n");
            for (String proj : this.projects) {
                sb.append("\t").append(proj).append("\n");
            }
        }
        return "Worker -> "+super.toString()+sb.toString();
    }

    public String toShortString() {
        return "Worker -> "+super.toString();
    }
    @Override
    public double getSalary() {
        return getBaseSalary()*1.8;
    }

    @Override
    public double bonus() {
        return this.projects.length * 5;
    }
}
