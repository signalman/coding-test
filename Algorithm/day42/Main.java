package Algorithm.day42;

class Parent {

    int x = 100;

    Parent() {
        this(500);
    }

    Parent(int val) {
        this.x = val;
    }

    int getX() {
        return x;
    }
}

class Child extends Parent {

    int x = 4000;

    Child() {
        this(5000);
    }

    Child(int val) {
        this.x = val;
    }
}

public class Main {

    public static void main(String[] args) {
        Child obj = new Child();
        System.out.println(obj.getX());
    }
}