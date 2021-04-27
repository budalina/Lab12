package lab_inherit;

public interface Payable {
    /**Константа INCREASE_CAP - определяет максимальное увеличение зарплаты*/
    int INCREASE_CAP=20;
    /**Метод для получения заработной платы (с начислениями)*/
    double getSalary();
    /**Метод для увеличения заработной платы
     * @param pecent - количество процентов, на которые будет повышена зарплата, если это значение допустимо*/
    boolean increasePay(double pecent);
    /**Метод для вывода информации о зарплате сотрудников*/
    default void printSalaryInfo(){
        System.out.println(this+ "\tЗарплата = "+this.getSalary());
    }
}
