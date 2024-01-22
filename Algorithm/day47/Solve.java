package Algorithm.day47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solve {

    /*
    shop : 4, 물건: 5
    물건은 최대 16
    shop은 최대 20
    가장 적은 수의 shop을 이용해서 물건을 다 샀을 때
    shop의 번호를 사전순 가장 작은것 return
    * 1 0 0 0 1
    * 0 1 0 0 0
    * 0 0 1 1 1
    * 1 0 0 1 0
    *
    * */
    static int s = Integer.MAX_VALUE;
    static int[] ans;

    int[] solution(int[][] shops){

        int n = shops.length; //shop의 수
        int m = shops[0].length; //물건의 수

        dfs(0, n, m, new int[m], new ArrayList<>(), shops);
        return ans;
    }

    void dfs(int cur, int n, int m, int[] cart, List<Integer> select, int[][] shops){

        if(cur == n){
            //갱신 코드
            for(int i=0; i<cart.length; i++){
                if(cart[i] == 0) return;
            }
            Collections.sort(select);
            if(select.size() < s){
                s = select.size();
                ans = select.stream()
                            .mapToInt(i -> i)
                            .toArray();
            }
            else if(select.size() == s){
                for(int i=0; i<select.size(); i++){
                    if(select.get(i) > ans[i]) return;
                }
                ans = select.stream()
                            .mapToInt(i -> i)
                            .toArray();
            }
            return;
        }

        //cur 선택 안함
        dfs(cur + 1, n, m, cart, select, shops);

        //cur 선택 함
        int[] curShop = shops[cur];
        for(int i=0; i<curShop.length; i++){
            if(curShop[i] == 0) continue;
            cart[i] += 1;
        }
        select.add(cur);
        dfs(cur + 1, n, m, cart, select, shops);

        for(int i=0; i<curShop.length; i++){
            if(curShop[i] == 0) continue;
            cart[i] -= 1;
        }
        select.remove(select.size() - 1);
    }


    public static void main(String[] args) {
        Solve solve = new Solve();
        int[] solution = solve.solution(new int[][]{
            {0, 0, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 1, 0},
            {1, 0, 0, 1, 1},
        });

        List<String> list = new ArrayList<>();
        list.add("ekfekf");
        Collections.sort(list);
        list.sort(null);



        String str1 = "Abcde";
        String str2 = "abcde";
        System.out.println(str2.compareTo(str1));
        System.out.println();

        Integer a = 2;
        Integer b = 3;
        System.out.println(b.compareTo(a));



        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(2, 3, 4));
        list1.add(Arrays.asList(1, 2, 3));
        list1.sort((l1, l2) -> {
            if (l1.size() == l2.size()) {
                return l1.toString()
                         .compareTo(l2.toString());
            } else {
                return Integer.compare(l1.size(), l2.size());
            }
        });

        for (List<Integer> integers : list1) {
            for (Integer integer : integers) {
                System.out.print("integer = " + integer);
            }
            System.out.println();
        }



    }
}
