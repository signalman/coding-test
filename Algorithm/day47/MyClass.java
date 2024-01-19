package Algorithm.day47;

import java.util.HashMap;

public class MyClass {

    private final String name;
    private final int age;
    private HashMap<Integer, Integer> map;

    public MyClass(){
        name = "";
        age = 0;
    }

    private MyClass(String name, int age){
        this.name = name;
        this.age = age;
    }

    private void print(){
        System.out.println(name + ": " + age);
    }


}
