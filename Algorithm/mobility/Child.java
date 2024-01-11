package Algorithm.mobility;

public class Child extends Parent{

    int age;
    private int pr;

    public Child(){
        this.age = 10;
        this.pr = 2;
    }

    public Child(String name, boolean gender, int age){
        super(name, gender);
        this.age = age;
    }

    @Override
    public String info() {
        return super.info() + ", 나이는: " + this.age + "private" + pr;
    }
}
