package com.company;

import java.util.*;
import java.lang.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        var worker = new Worker("Иван", "Иванов", 10, 31);

        System.out.println(worker.getName()); //выведет 'Иван'
        System.out.println(worker.getSurname()); //выведет 'Иванов'
        System.out.println(worker.getRate()); //выведет 10
        System.out.println(worker.getDays()); //выведет 31
        System.out.println(worker.getSalary()); //выведет 310 - то есть 10*31
        worker.setRate(20); //увеличим ставку
        worker.setDays(10); //уменьшим дни
        System.out.println(worker.getSalary()); //200

        var str = new MyString();

        System.out.println(str.reverse("abcde")); //выведет 'edcba'
        System.out.println(str.ucFirst("abcde")); //выведет 'Abcde'
        System.out.println(str.ucWords("abcde abcde abcde")); //выведет 'Abcde Abcde Abcde'

        var validator = new Validator();

        System.out.println(validator.isEmail("phphtml@mail.ru"));
        System.out.println(validator.isDomain("phphtml.net"));
        System.out.println(validator.isDate("12.05.2020"));
        System.out.println(validator.isPhone("+373 (29) 817-68-92"));
    }
}

//
class Worker{
    private final String name;
    private final String surname;
    private int rate;
    private int days;
    public Worker(String name, String surname, int rate, int days) {
        this.name = name;
        this.surname = surname;
        this.rate = rate;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getRate() {
        return rate;
    }

    public int getDays() {
        return days;
    }

    public int getSalary() {
        return rate*days;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setDays(int days) {
        this.days = days;
    }
}

class MyString {

    public String reverse(String string) {
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < string.length(); i++ ) {
            reversed.insert(0, string.charAt(i));
        }
        return reversed.toString();
    }

    public String ucFirst(String string) {
        return  Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    public String ucWords(String string) {
        return Arrays.stream(string.split(" "))
                .map(this::ucFirst).reduce("", (a, b) -> a + " " + b).substring(1);
    }
}

class Validator {

    public Boolean isEmail(String string) {
        return Pattern.matches("[A-Z,a-z.]+[@][a-z]+[.][a-z]+", string);
    }

    public Boolean isDomain(String string) {
        return Pattern.matches("[a-z]+[.][a-z]+", string);
    }

    public Boolean isDate(String string) {
        return Pattern.matches("([1-9]|[1-2][0-9]|3[0-1])[.](0[1-9]|1[0-2])[.][1-9][0-9]*", string);
        //не проверяет связь числа, месяца и высокосного года
    }

    public Boolean isPhone(String string) {
        return Pattern.matches("(\\+373) ?\\([1-9][0-9]\\).?[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]", string);
    }
}