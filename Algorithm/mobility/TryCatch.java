package Algorithm.mobility;

public class TryCatch {

    public static void main(String[] args) {
        int ans = test();
        System.out.println(ans);
    }

    static int test(){
        int n = 5;
        try {
            System.out.println("---------try 블록--------");
            return n;
        } finally {
            System.out.println("---------finally 블룩 ---------");
            n = 10;
        }
    }
}


