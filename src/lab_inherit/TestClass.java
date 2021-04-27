package lab_inherit;

import java.time.LocalDate;
import java.util.Scanner;

public class TestClass {
    static String[] proj = {"проект1", "проект2"};
    static Client ivanov = new Client("Иванов", LocalDate.of(1990, 6, 12), Constants.GENDER_MALE, proj, 150, 0);
    static Worker sidorov = new Worker("Сидоров", LocalDate.of(1990, 4, 1), Constants.GENDER_MALE, "Закупки", "001131", 40000, LocalDate.of(2014, 5, 21), "151-66-43-22-23", proj);
    static SalesPerson guskov = new SalesPerson("Гуськов", LocalDate.of(1992, 2, 23), Constants.GENDER_MALE, "Закупки", "001258", 30000, LocalDate.of(2016, 7, 13), "152-86-84-82-23", proj, 100, 123, 2);
    static Contractor sinitzin = new Contractor("Синицын", LocalDate.of(1986, 6, 19), Constants.GENDER_MALE, 200, 60);
    static Worker pushkina = new Worker("Пушкина", LocalDate.of(1995, 5, 15), Constants.GENDER_FEMALE, "Кадры", "002131", 43000, LocalDate.of(2016, 9, 1), "151-69-43-65-23", null);
    static SalesPerson durova = new SalesPerson("Дурова", LocalDate.of(1998, 10, 16), Constants.GENDER_FEMALE, "Закупки", "003258", 32000, LocalDate.of(2019, 9, 19), "152-96-94-89-99", proj, 90, 140, 5);
    static Worker plaksina = new Worker("Плаксина", LocalDate.of(1985, 11, 3), Constants.GENDER_FEMALE, "Кадры", "009119", 46000, LocalDate.of(2005, 12, 1), "152-65-53-55-53", null);
    static SalesPerson fomina = new SalesPerson("Фомина", LocalDate.of(1998, 9, 15), Constants.GENDER_FEMALE, "Закупки", "008858", 32000, LocalDate.of(2018, 4, 1), "153-36-34-32-33", proj, 100, 180, 10);

    static Worker[] workersZakupki = {sidorov, guskov, durova, fomina};
    static Worker[] workersKadri = {pushkina, plaksina};

    static Manager petrovZakupki = new Manager("Петров", LocalDate.of(1998, 3, 16), Constants.GENDER_MALE, "Закупки", "001231", 70000, LocalDate.of(2019, 1, 1), "151-02-23-12-13", workersZakupki);
    static Manager ziminaKadri = new Manager("Зимина", LocalDate.of(1986, 2, 11), Constants.GENDER_FEMALE, "Кадры", "003331", 65000, LocalDate.of(2010, 5, 4), "158-82-73-77-73", workersKadri);

    public static void main(String[] args) {
        System.out.println("Меню:");
        System.out.println("1. тест_1 _ Person\n2. тест_2 _ Stimulable\n3. тест_3 _ Payable\n4. Выход");
        System.out.print("Выберите пункт (1..4): ");
        int n = (new Scanner(System.in)).nextInt();
        switch (n){
            case 1 : firstTest();break;
            case 2 : secondTest();break;
            case 3 : thirdTest();break;
            default: System.exit(0);
        }
    }

    public static void firstTest() {
        Person[] persons = new Person[5];
        persons[0] = ivanov;
        persons[1] = petrovZakupki;
        persons[2] = sidorov;
        persons[3] = ziminaKadri;
        persons[4] = sinitzin;
        System.out.println("1. Подробная информация \t 2. Короткая информация?");
        int n = (new Scanner(System.in)).nextInt();
        for (Person person : persons) {

            System.out.println((n==1)?person.toString():person.toShortString());
        }
    }


    public static void secondTest() {
        Stimulable[] persons = new Stimulable[5];
        persons[0] = ivanov;
        persons[1] = petrovZakupki;
        persons[2] = sidorov;
        persons[3] = ziminaKadri;
        persons[4] = sinitzin;
        for (Stimulable person : persons) {
            person.printBonus();
        }
    }

    public static void thirdTest() {
        Payable[] persons = new Payable[5];
        persons[0] = durova;
        persons[1] = petrovZakupki;
        persons[2] = sidorov;
        persons[3] = ziminaKadri;
        persons[4] = sinitzin;
        for (Payable person : persons) {
            person.printSalaryInfo();
        }

        System.out.println("=======================================================");
        //Увеличить всем сотрудникам зарплату на n%
        System.out.println("Введите число %, на которые нужно повысить зарплату сотрудников \n n = ");
        int n = (new Scanner(System.in)).nextInt();
        for (Payable person : persons) {
            if (person.increasePay(n)) person.printSalaryInfo();
            else {
                System.out.println("Недопустимое повышение, отказано!");
                break;
            }
        }
    }
}
