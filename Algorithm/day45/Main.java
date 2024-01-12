package Algorithm.day45;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        User1 user1 = new User1();
        user1.setCalculator(calculator);
        user1.start();

        char c = 2;

        User2 user2 = new User2();
        user2.setCalculator(calculator);
        user2.start();
    }



}
