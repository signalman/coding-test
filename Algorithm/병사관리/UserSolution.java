package Algorithm.병사관리;

import java.util.*;
class UserSolution {

    static Map<Integer, Soldier> soldierMap;
    static Map<Integer, Map<Integer, Soldier>> teamMap;
    static Map<Integer, TreeMap<Integer, TreeSet<Integer>>> teamTreeMaps;

    static class Soldier {
        int mID;
        int mTeam;
        int mScore;

        public Soldier(int mID, int mTeam, int mScore) {
            this.mID = mID;
            this.mTeam = mTeam;
            this.mScore = mScore;
        }
    }

    public void init() {
        soldierMap = new HashMap<>();
        teamMap = new HashMap<>();
        teamTreeMaps = new HashMap<>();
    }

    public void hire(int mID, int mTeam, int mScore) {
        Soldier hireSoldier = new Soldier(mID, mTeam, mScore);
        soldierMap.put(mID, hireSoldier);

        teamMap.computeIfAbsent(mTeam, k -> new HashMap<>()).put(mID, hireSoldier);
        teamTreeMaps.computeIfAbsent(mTeam, k -> new TreeMap<>())
                    .computeIfAbsent(mScore, k -> new TreeSet<>())
                    .add(mID);
    }

    public void fire(int mID) {
        Soldier removeSoldier = soldierMap.remove(mID);
        teamMap.get(removeSoldier.mTeam).remove(removeSoldier.mID);
        TreeSet<Integer> soldiersWithSameScore = teamTreeMaps.get(removeSoldier.mTeam).get(removeSoldier.mScore);
        soldiersWithSameScore.remove(removeSoldier.mID);
        if (soldiersWithSameScore.isEmpty()) {
            teamTreeMaps.get(removeSoldier.mTeam).remove(removeSoldier.mScore);
        }
    }

    public void updateSoldier(int mID, int mScore) {
        Soldier soldier = soldierMap.get(mID);
        fire(mID); // Remove the soldier from the current score set
        soldier.mScore = mScore;
        hire(mID, soldier.mTeam, mScore); // Re-add the soldier with the new score
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        Map<Integer, Soldier> findSoldierMap = new HashMap<>(teamMap.get(mTeam));
        for (Soldier soldier : findSoldierMap.values()) {
            fire(soldier.mID); // Remove the soldier from the current score set
            soldier.mScore = Math.max(1, Math.min(5, soldier.mScore + mChangeScore));
            hire(soldier.mID, soldier.mTeam, soldier.mScore); // Re-add the soldier with the new score
        }
    }

    public int bestSoldier(int mTeam) {
        TreeMap<Integer, TreeSet<Integer>> scoreMap = teamTreeMaps.get(mTeam);
        if (scoreMap == null || scoreMap.isEmpty()) return -1;

        Map.Entry<Integer, TreeSet<Integer>> lastEntry = scoreMap.lastEntry();
        return lastEntry.getValue().first(); // Return the ID of the soldier with the highest score
    }
}
