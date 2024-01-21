package Algorithm.day47;

public class My{


    //화살표가 주어졌을 때, 연속한 것은 증가 몇번째 버튼을 눌렀을때 벌의 값이 최소가되는지 최소의 index 구하라
    //0: 위 // 1:아래
    int solve1(int[] array){
        int losePoint = Integer.MAX_VALUE;
        int ans = -1;
        int press = -1;
        int myArrow = 0;

        while(press < array.length){
            int count = 1;
            int losePointTmp = 0;

            //검사하기
            for(int i=0; i<array.length; i++){
                //한번도 누를지 않을때
                if(press == -1){
                    if(array[i] == 1){
                        losePointTmp += count;
                        if(i + 1 < array.length && array[i + 1] == array[i]) count++;
                        else count = 1;
                    }
                }
                //누를때
                else{
                    //1찾기
                    if(i < press){
                        if(array[i] == 1){
                            losePointTmp += count;
                            if(i + 1 < array.length && array[i + 1] == array[i]) count++;
                            else count = 1;
                        }
                    }
                    //0찾기
                    else{
                        if(array[i] == 0){
                            losePointTmp += count;
                            if(i + 1 < array.length && array[i + 1] == array[i]) count++;
                            else count = 1;
                        }
                    }
                    if(press == 6){
                        System.out.println(losePointTmp);
                    }
                }
            }
            if(losePointTmp < losePoint){
                losePoint = losePointTmp;
                ans = press;
            }

            System.out.println("press가" + press + " 벌점은: " + losePointTmp);
            press++;

        }
        return ans;
    }

    int solve(int[] array){

        int ret = -1;
        int retValue = Integer.MAX_VALUE;
        int press = -1;

        while (press < array.length) {

            int MY_ARROW = 0;
            int tmpValue = 0;
            int count = 0;

            for(int i=0; i<array.length; i++){
                if(i == press) MY_ARROW ^= 1;
                //내 화살표와 다를 때
                if(array[i] != MY_ARROW){
                    count++;
                    tmpValue += count;
                }
                //내 화살표와 같을 때
                else {
                    count = 0;
                }
                if(press == 0){
                    System.out.println(count);
                }
            }
            System.out.println("press가" + press + " 벌점은: " + tmpValue);
            if(retValue > tmpValue){
                retValue = tmpValue;
                ret = press;
            }
            press++;
        }
        return ret;
    }


    public static void main(String[] args) {
        My my = new My();
        int solve = my.solve(new int[]{0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1});
        System.out.println(solve);
    }

}
