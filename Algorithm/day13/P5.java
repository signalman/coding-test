package Algorithm.day13;

public class P5 {

//    static class Soldier{
//        int id;
//        Soldier next;
//    }
//
//    static class Team{
//        Soldier[] tail;
//        Soldier[] head;
//    }

    static Team[] team;

    public static void main(String[] args) {
        team = new Team[6];
        for(int i=1; i<=5; i++){
            team[i] = new Team();
            for(int s=1; s<=5; s++){
                team[i].head[s] = team[i].tail[s] = new Soldier();
            }
        }
        team[1].tail[1].next = new Soldier(1, 1, new Soldier(2, 3));
        System.out.println(team[1].head[1].next);
        System.out.println(team[1].tail[1].next);

    }
}
