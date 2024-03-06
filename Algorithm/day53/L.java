package Algorithm.day53;

public class L {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder number1 = new StringBuilder();
        while(l1.next != null){
            number1.append(l1.val);
            l1 = l1.next;
        }

        StringBuilder number2 = new StringBuilder();
        while(l2.next != null){
            number2.append(l2.val);
            l2 = l2.next;
        }

        number1.reverse();
        number2.reverse();


        int val = Integer.parseInt(number1.toString()) + Integer.parseInt(number2.toString());
        StringBuilder valToCharArray = new StringBuilder(String.valueOf(val)).reverse();

        ListNode[] ret = new ListNode[valToCharArray.length()];
        ret[0] = new ListNode(valToCharArray.charAt(0) - '0');
        for(int i=1; i<valToCharArray.length() - 1; i++){
            ret[i] = new ListNode(valToCharArray.charAt(i) - '0');
            ret[i - 1].next = ret[i];
        }
        return ret[0];
    }

    public static void main(String[] args) {

    }
}
