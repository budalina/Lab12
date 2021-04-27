package lab_inherit;

import java.time.LocalDate;

/**Класс Person предназначен для работы с объектами - персонами
 * является базовым для классов Employee, Client*/
abstract public class Person implements Stimulable {
    /**Поле name -  имя (фамилия) персоны*/
    private String name;
    /**Поле birthday - Дата рождения персоны*/
    private LocalDate birthDay;
    /**Поле gender - пол , заполняется посредством выбора константы из интерфейса
     * @see Constants#GENDER_FEMALE
     * @see Constants#GENDER_MALE
     * */
    private String gender;

    public Person(String name, LocalDate birthDay, String gender) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public Person() {
        this("unknown", LocalDate.now(), Constants.GENDER_MALE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        String f = "%s\t%s\t%s";
        return String.format(f,this.name, this.birthDay, this.gender);
    }

    public String toShortString() {
        return this.toString();
    }

    @Override
    public void printBonus() {
        System.out.println(this.toShortString() +
             String.format("\t Число накопленных бонусов - %.2f\n", this.bonus()));
    }
}


/*
@startuml
class Person {
    - title
    + getTitle()
}
User "1" -- "*" Article
@enduml
 */