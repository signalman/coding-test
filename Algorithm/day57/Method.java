package Algorithm.day57;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class Method {

    static class Rectangle {
        int x;
        int y;

        Rectangle(){}
        Rectangle(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int area(int width, int height){
            return width * height;
        }
    }
    static class Node{
        int val;
        Node(int val){
            this.val = val;
        }
    }

    static class Person{
        private List<String> email;
        private String name;

        public Person(String name, List<String> email) {
            this.email = email;
            this.name = name;
        }
        public List<String> getEmail(){
            return email;
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Rectangle rectangle = new Rectangle();
        IntBinaryOperator operator = rectangle::area;
        int area = operator.applyAsInt(1, 2);
        Class n = Class.forName("Algorithm.day57.Method$Rectangle");
        Class[] interfaces = n.getInterfaces();

        List<Person> persons = List.of(new Person("allice", List.of("awef@naver.com")),
            new Person("Park", List.of("www.google.com")),
                new Person("Kim", List.of("efefe.ewfaw", "ekfjeifn.com")));
        List<String> collect = persons.stream()
                                      .flatMap(
                                          person -> person.getEmail().stream()
                                      ).sorted(Comparator.reverseOrder())
                                      .collect(Collectors.toList());
        System.out.println(collect);

    }
}
