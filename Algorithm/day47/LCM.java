package Algorithm.day47;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LCM {
    static int solve(int[] array){
        int answer = 0;
        for(int i=0; i<array.length; i++){
            if(i == 0) answer = array[i];
            else answer = lcm(answer, array[i]);
        }
        return answer;
    }
    static int gcd(int a, int b){
        if(a < b) return gcd(b, a);
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
    static int lcm(int a, int b){
        int gcd = gcd(a, b);
        return gcd * a / gcd * b / gcd;
    }

    static class User{
        private String name;
        private int age;
        User(String name, int age){
            this.name = name;
            this.age = age;
        }
        @Override
        public boolean equals(Object obj) {
            User u = (User) obj;
            return this.name == u.name && this.age == u.age;
        }

        @Override
        public String toString(){
            return this.name + " " + this.age;
        }
    }

    static class UserDetail extends User{

        UserDetail(String name, int age) {
            super(name, age);
        }
    }
    public static void main(String[] args) {

        UserDetail userDetail = new UserDetail("H", 22);

        List<User> list = new ArrayList<>();
        list.add(new User("bbb", 28));
        list.add(new User("aaa", 31));
        list.add(new User("ccc", 28));
        list.add(new User("ddd", 22));
        list.add(new User("bbb", 28));


        int 빈도수 = Collections.frequency(list, new User("호인", 28));
        User 최댓값 = Collections.max(list, Comparator.comparingInt(o -> o.age));
        User 최소값 = Collections.min(list, Comparator.comparing(o -> o.name));
        Collections.reverse(list);

        for (User user : list) {
            System.out.println(user.name + " " + user.age);
        }
    }

}
