package Algorithm.병사관리;

class Soldier{
    int id; // 병사의 고유번호
    int version; // 병사의 버전
    Soldier next; // 연결 리스트의 다음 병사

    Soldier() {
        id = 0;
        version = 0;
        next = null;
    }
    Soldier(int id, int version) {
        this.id = id;
        this.version = version;
        this.next = null;
    }
    Soldier(int id, int version, Soldier next){
        this.id = id;
        this.version = version;
        this.next = next;
    }
}

class Team{
    Soldier[] head; // 점수별 헤드
    Soldier[] tail; // 점수별 테일

    Team() {
        head = new Soldier[6];
        tail = new Soldier[6];
    }
}

class UserSolution
{
    // 소속 팀 별로 병사 관리. 1~5
    Team[] team;
    // 고유번호의 버전. -1: 해고
    int[] soldierVersion;
    // 고유번호의 소속 팀
    int[] soldierTeam;

    /**
     * 각 테스트 케이스의 처음에 호출된다.
     * 테스트 케이스의 시작 시 고용된 병사는 없다.
     */
    public void init()
    {
        team = new Team[6];
        for(int t = 1; t <= 5; t++) {
            team[t] = new Team();
            for(int s = 1; s <= 5; s++) {
                // 더미 헤드
                team[t].head[s] = team[t].tail[s] = new Soldier();
            }
        }

        soldierVersion = new int[100001];
        soldierTeam = new int[100001];
    }

    /**
     * 고유번호가 mID, 소속팀이 mTeam, 평판 점수가 mScore인 병사를 고용한다.
     * 한 테스트 케이스 내에서 동일한 mID를 가진 병사가 여러 번 고용되는 경우는 없음이 보장된다.
     *
     * @param mID : 고유번호 (1 ≤ mID ≤ 100,000)
     * @param mTeam : 소속팀 (1 ≤ mTeam ≤ 5)
     * @param mScore : 평판 점수 (1 ≤ mScore ≤ 5)
     */
    public void hire(int mID, int mTeam, int mScore)
    {
        Soldier soldier = new Soldier(mID, ++soldierVersion[mID]);
        team[mTeam].tail[mScore].next = soldier;
        team[mTeam].tail[mScore] = soldier;
        soldierTeam[mID] = mTeam;
    }

    /**
     * 고유번호가 mID인 병사를 해고한다.
     * fire() 함수 호출 시, 고유번호가 mID인 병사가 고용되어 있음이 보장된다.
     *
     * @param mID : 고유번호 (1 ≤ mID ≤ 100,000)
     */
    public void fire(int mID)
    {
        soldierVersion[mID] = -1;
    }

    /**
     * 고유번호가 mID인 병사의 평판 점수를 mScore로 변경한다.
     * 고유번호가 mID인 병사가 고용되어 있음이 보장된다.
     *
     * @param mID : 고유번호 (1 ≤ mID ≤ 100,000)
     * @param mScore : 평판 점수 (1 ≤ mScore ≤ 5)
     */
    public void updateSoldier(int mID, int mScore)
    {
        hire(mID, soldierTeam[mID], mScore);
    }

    /**
     * 소속팀이 mTeam인 병사들의 평판 점수를 모두 변경한다.
     * 소속팀이 mTeam인 병사가 한 명 이상 고용되어 있음이 보장된다.
     *
     * updateTeam() 함수에서의 평판 점수 변경은 아래의 규칙에 따른다.
     * ‘변경 전 평판 점수 + mChangeScore’가 5보다 클 경우, 평판 점수를 5로 변경한다.
     * ‘변경 전 평판 점수 + mChangeScore’가 1보다 작을 경우, 평판 점수를 1로 변경한다.
     * 그 외의 경우, 평판 점수를 ‘변경 전 평판 점수 + mChangeScore’로 변경한다.
     *
     * @param mTeam : 소속팀 (1 ≤ mTeam ≤ 5)
     * @param mChangeScore : 평판 점수의 변화량 (-4 ≤ mChangeScore ≤ 4)
     */
    public void updateTeam(int mTeam, int mChangeScore)
    {
        if(mChangeScore < 0) { // 1점부터 확인
            for(int prev = 1; prev <= 5; prev++) {
                // 바뀐 점수
                int next = Integer.max(prev + mChangeScore, 1);

                // 이동할 병사가 없을 때
                if(prev == next || team[mTeam].head[prev].next == null) {
                    continue;
                }

                team[mTeam].tail[next].next = team[mTeam].head[prev].next;
                team[mTeam].tail[next] = team[mTeam].tail[prev];
                team[mTeam].head[prev].next = null;
                team[mTeam].tail[prev] = team[mTeam].head[prev];
            }
        }
        else if(mChangeScore > 0) { // 5점부터 확인
            for(int prev = 5; prev >= 1; prev--) {
                // 바뀐 점수
                int next = Integer.min(prev + mChangeScore, 5);

                // 이동할 병사가 없을 때
                if(prev == next || team[mTeam].head[prev].next == null) {
                    continue;
                }

                team[mTeam].tail[next].next = team[mTeam].head[prev].next;
                team[mTeam].tail[next] = team[mTeam].tail[prev];
                team[mTeam].head[prev].next = null;
                team[mTeam].tail[prev] = team[mTeam].head[prev];
            }
        }
    }

    /**
     * 소속팀이 mTeam인 병사들 중 평판 점수가 가장 높은 병사의 고유번호를 반환한다.
     * 평판 점수가 가장 높은 병사가 여러 명일 경우, 고유번호가 가장 큰 병사의 고유번호를 반환한다.
     * 소속팀이 mTeam인 병사가 한 명 이상 고용되어 있음이 보장된다.
     *
     * @param mTeam : 소속팀 (1 ≤ mTeam ≤ 5)
     * @return : 평판 점수가 가장 높은 병사의 고유번호
     */
    public int bestSoldier(int mTeam)
    {
        // 평판 점수가 가장 높은 병사
        int best = 0;
        for(int s = 5; s >= 1 && best == 0; s--) {
            Soldier soldier = team[mTeam].head[s].next;

            while(soldier != null) {
                // 현재 버전의 병사만 확인
                if(soldier.version == soldierVersion[soldier.id]) {
                    best = Integer.max(best, soldier.id);
                }
                soldier = soldier.next;
            }
        }

        return best;
    }
}