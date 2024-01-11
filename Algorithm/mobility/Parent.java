package Algorithm.mobility;

public class Parent {
    String name;
    boolean gender;

    Parent(){
        this.name = "기본";
        this.gender = true;
    }
    Parent(String name, boolean gender){
        this.name = name;
        this.gender = gender;
    }

    public String info(){
        return "이름은 " + name + ", 성별은 " + gender;
    }
}
