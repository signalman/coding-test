package Algorithm.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P6 {

    static int N, M;
    static BufferedWriter bw;
    static class Node{
        int id;
        Node next;
        Node prev;

        Node(){
            id = -1;
            next = null;
            prev = null;
        }
        Node(int id){
            this.id = id;
            next = null;
            prev = null;
        }
    }

    static class Subway{
        Node head;
        Node tail;
    }
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Subway subway = new Subway();
        Node node = new Node();
        subway.head = node;
        subway.tail = node;
        nodes = new Node[1000002];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            if(i == 0){
                subway.head = new Node(Integer.parseInt(st.nextToken()));
//                subway.head.next.prev = subway.head;
                subway.tail = subway.head;
                nodes[subway.head.id] = subway.head;
            }
            else if(i == N-1){
                subway.tail.next = new Node(Integer.parseInt(st.nextToken()));
                subway.tail.next.prev = subway.tail;
                subway.tail = subway.tail.next;
                nodes[subway.tail.id] = subway.tail;
                subway.tail.next = subway.head;
                subway.head.prev = subway.tail;
            }
            else{
                subway.tail.next = new Node(Integer.parseInt(st.nextToken()));
                subway.tail.next.prev = subway.tail;
                subway.tail = subway.tail.next;
                nodes[subway.tail.id] = subway.tail;
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int[] ij = new int[2];
            ij[0] = Integer.parseInt(st.nextToken());
            if (st.hasMoreTokens()) {
                ij[1] = Integer.parseInt(st.nextToken());
            }
            solve(s, ij);
//            for(int abc=1; abc<=11; abc++){
//                if(nodes[abc] == null || nodes[abc].next == null) continue;
//                System.out.println(abc+ "번째 노드가 " + nodes[abc].next.id + "를 가리킴//" + nodes[abc].prev.id);
//            }
//            System.out.println("++++++++++++++");
        }
        bw.flush();
        bw.close();
    }
    private static void solve(String name, int[] ij) throws IOException {
        switch (name){
            case "BN":
                bw.write(nodes[ij[0]].next.id+ "\n");
                Node newNode = new Node(ij[1]);
                newNode.next = nodes[ij[0]].next;
                nodes[ij[0]].next.prev = newNode;
                newNode.prev = nodes[ij[0]];
                nodes[ij[0]].next = newNode;
                nodes[newNode.id] = newNode;
                break;
            case "BP":
                bw.write(nodes[ij[0]].prev.id+ "\n");
                newNode = new Node(ij[1]);
                newNode.next = nodes[ij[0]];
                nodes[ij[0]].prev.next = newNode;
                newNode.prev = nodes[ij[0]].prev;
                nodes[ij[0]].prev = newNode;
                nodes[newNode.id] = newNode;
                break;
            case "CN":
                bw.write(nodes[ij[0]].next.id+ "\n");
                nodes[ij[0]].next.next.prev = nodes[ij[0]];
                nodes[ij[0]].next = nodes[ij[0]].next.next;
                break;
            case "CP":
                bw.write(nodes[ij[0]].prev.id+ "\n");
                nodes[ij[0]].prev.prev.next = nodes[ij[0]];
                nodes[ij[0]].prev = nodes[ij[0]].prev.prev;
                break;
        }
    }
}
