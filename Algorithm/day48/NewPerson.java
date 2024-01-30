package Algorithm.day48;

public class NewPerson extends Person{

    @Override
    public void getName() {
        System.out.println("자식 호출!");
    }
}
