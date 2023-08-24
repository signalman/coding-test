package Algorithm.day13;

class Soldier{
    int mID, version;
    Soldier next;

    Soldier(){
        mID = 0;
        version = 0;
        next = null;
    }
    Soldier(int mID, int version){
        this.mID = mID;
        this.version= version;
        this.next = null;
    }

    Soldier(int mID, int version, Soldier soldier){
        this.mID = mID;
        this.version =version;
        this.next = soldier;
    }
}
class Team{
    Soldier[] tail;
    Soldier[] head;
    Team(){
        head = new Soldier[6];
        tail = new Soldier[6];
    }
}
class UserSolution
{

    int[] soldierVersion;
    int[] soldierTeam;
    Team[] team;

    public void init()
    {
        soldierVersion = new int[100002];
        soldierTeam = new int[100002];
        team = new Team[6];
        for(int i=1; i<=5; i++){
            team[i] = new Team();
            for(int s=1; s<=5; s++){
                team[i].head[s] = team[i].tail[s] = new Soldier();
            }
        }
    }

    public void hire(int mID, int mTeam, int mScore)
    {
        Soldier soldier = new Soldier(mID, ++soldierVersion[mID]);
        team[mTeam].tail[mScore].next = soldier;
        team[mTeam].tail[mScore] = soldier;
        soldierTeam[mID] = mTeam;

    }

    public void fire(int mID)
    {
        soldierVersion[mID] = -1;
    }

    public void updateSoldier(int mID, int mScore)
    {
        hire(mID, soldierTeam[mID], mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore)
    {

        if(mChangeScore < 0){
            for(int prev = 1; prev <= 5; prev++){
                int afterScore = Integer.max(prev + mChangeScore, 1);
                if(prev == afterScore || team[mTeam].head[prev].next == null){
                    continue;
                }
                team[mTeam].tail[afterScore].next = team[mTeam].head[prev].next;
                team[mTeam].tail[afterScore] = team[mTeam].head[prev];
                team[mTeam].head[prev].next = null;
                team[mTeam].tail[prev] = team[mTeam].head[prev];
            }
        }
        else if(mChangeScore > 0){
            for(int prev = 5; prev >= 1; prev--){
                int afterScore = Integer.min(prev + mChangeScore, 5);

                if(prev == afterScore || team[mTeam].head[prev].next == null){
                    continue;
                }
                team[mTeam].tail[afterScore].next = team[mTeam].head[prev].next;
                team[mTeam].tail[afterScore] = team[mTeam].head[prev];
                team[mTeam].head[prev].next = null;
                team[mTeam].tail[prev] = team[mTeam].head[prev];
            }
        }
    }

    public int bestSoldier(int mTeam)
    {

        int best = 0;
        for(int s = 5; s >= 1 && best == 0; s--){
            Soldier soldier = team[mTeam].head[s].next;

            while(soldier != null){
                if (soldierVersion[soldier.mID] == soldier.mID) {
                    best = Integer.max(best, soldier.mID);
                }
                soldier = soldier.next;
            }
        }
        return best;
    }
}