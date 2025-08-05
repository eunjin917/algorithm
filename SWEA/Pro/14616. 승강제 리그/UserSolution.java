package swea.swea14616;

import java.util.*;

class Player implements Comparable<Player> {
    int index;
    int ability;

    Player(int index, int ability) {
        this.index = index;
        this.ability = ability;
    }

    @Override
    public int compareTo(Player o) {
        if (this.ability != o.ability) return o.ability - this.ability;
        return this.index - o.index;
    }

    @Override
    public String toString() {
        return "(" + index + ", " + ability + ")";
    }
}

class League {
	TreeSet<Player> leftPlayers;
	Player middlePlayer;
	TreeSet<Player> rightPlayers;
	
	League(TreeSet<Player> leftPlayers, Player middlePlayer, TreeSet<Player> rightPlayers) {
		this.leftPlayers = leftPlayers;
		this.middlePlayer = middlePlayer;
		this.rightPlayers = rightPlayers;
	}
}

class UserSolution {

    int N;
    int L;
    int N_L;
    int middleIndex;
    ArrayList<League> leagues;
    
    void insertIntoLeague(League league, Player p) {	// 1개만 비어있는 리그
    	if (league.leftPlayers.size() < league.rightPlayers.size()) {	//left가 빈 상태
	        if (p.compareTo(league.middlePlayer) < 0) {						// left에 추가
	        	league.leftPlayers.add(p);
	        } else if (p.compareTo(league.rightPlayers.first()) < 0) {		// middle에 추가
	        	league.leftPlayers.add(league.middlePlayer);
	        	league.middlePlayer = p;
	        } else {														// right에 추가
	        	league.leftPlayers.add(league.middlePlayer);
	        	league.middlePlayer = league.rightPlayers.pollFirst();
	        	league.rightPlayers.add(p);
	        }
        } else {														// right가 빈 상태
	        if (p.compareTo(league.leftPlayers.last()) < 0) {				// left에 추가
	        	league.rightPlayers.add(league.middlePlayer);
	        	league.middlePlayer = league.leftPlayers.pollLast();
	        	league.leftPlayers.add(p);
	        } else if (p.compareTo(league.middlePlayer) < 0) {				// middle에 추가
	        	league.rightPlayers.add(league.middlePlayer);
	        	league.middlePlayer = p;
	        } else {														// right에 추가
	        	league.rightPlayers.add(p);
	        }
        }
    }
    
    void insertLeftOrRight(League league, Player p) {	// left-1, right-1인 리그
    	if (p.compareTo(league.middlePlayer) < 0) {			// left에 추가
    		league.leftPlayers.add(p);
        } else {											// right에 추가
        	league.rightPlayers.add(p);
        }
    }

	void init(int N, int L, int[] mAbility) {
	    this.N = N;
	    this.L = L;
	    this.N_L = N/L;
	    this.middleIndex = (N_L+1)/2 - 1;
	    this.leagues = new ArrayList<>();
	    
	    // N_L명씩 정렬 후 -> L개 리그만큼 초기화
	    for (int l=0; l<L; l++) {
	    	TreeSet<Player> allPlayers = new TreeSet<>();
	        for (int i=0; i<N_L; i++) {
	        	int index = l*N_L + i;
	        	allPlayers.add(new Player(index, mAbility[index]));
	        }
	        ArrayList<Player> allPlayersList = new ArrayList<>(allPlayers);	// 리그 내 정렬됨
	        TreeSet<Player> leftPlayers = new TreeSet<>();
	    	Player middlePlayer = null;
	    	TreeSet<Player> rightPlayers = new TreeSet<>();
			for (int i=0; i<N_L; i++) {
				if (i<middleIndex) {
					leftPlayers.add(allPlayersList.get(i));
				} else if (i>middleIndex) {
					rightPlayers.add(allPlayersList.get(i));
				} else {
					middlePlayer = allPlayersList.get(i);
				}
	        }
	        leagues.add(new League(leftPlayers, middlePlayer, rightPlayers));
	    }
	
	}
	
	int move() {
		League thisLeague = leagues.get(0);
	    League nextLeague;
	    Player beforeLowPlayer = null;
	    int sumIndex = 0;
	    
	    for (int l=1; l<L; l++) {
	    	nextLeague = leagues.get(l);
	        
	        // 현재 리그의 최하위, 다음 리그의 최상위 : 찾기 + 제거
	    	Player thisLowPlayer = thisLeague.rightPlayers.pollLast();
	        Player nextHighPlayer = nextLeague.leftPlayers.pollFirst();
	        
	        // index 더하기
	        sumIndex += thisLowPlayer.index + nextHighPlayer.index;
	       
	        // 현재 리그에 -> (이전 리그의 최하위) : 삽입
	        if (beforeLowPlayer != null) {
	        	insertLeftOrRight(thisLeague, beforeLowPlayer);
	        }
	        
	        // 현재 리그에 -> 다음 리그의 최상위 : 삽입
	        insertIntoLeague(thisLeague, nextHighPlayer);
	        
	        // 다음
	        thisLeague = nextLeague;
	        beforeLowPlayer = thisLowPlayer;
	        
	    }
	    // 마지막 리그 : 현재 리그의 최상위 위치에 -> 이전 리그의 최하위 : 삽입
	    insertIntoLeague(thisLeague, beforeLowPlayer);
	    
	    return sumIndex;
	}

	int trade() {
	    League thisLeague = leagues.get(0);
	    League nextLeague;
	    Player beforeMiddlePlayer = null;
	    int sumIndex = 0;
	    
	    for (int l=0; l<L-1; l++) {
	    	nextLeague = leagues.get(l+1);
	        
	        // 현재 리그의 중간, 다음 리그의 최상위 : 찾기 + 제거
	    	Player thisMiddlePlayer = thisLeague.middlePlayer;
	    	thisLeague.middlePlayer = null;
	        Player nextHighPlayer = nextLeague.leftPlayers.pollFirst();
	        
	        thisLeague.middlePlayer = thisLeague.rightPlayers.pollFirst();	// left-1 1 right-1
	        
	        // index 더하기
	        sumIndex += thisMiddlePlayer.index + nextHighPlayer.index;
	        
	        // 현재 리그에 -> (이전 리그의 중간) : 삽입
	        if (beforeMiddlePlayer != null) {
	        	insertLeftOrRight(thisLeague, beforeMiddlePlayer);
	        }
	        
	        // 현재 리그에 -> 다음 리그의 최상위 : 삽입
	        insertIntoLeague(thisLeague, nextHighPlayer);
	        
	        // 다음
	        thisLeague = nextLeague;
	        beforeMiddlePlayer = thisMiddlePlayer;
	    }
	    // 마지막 리그 : 현재 리그의 최상위 위치에 -> 이전 리그의 중간 : 삽입
	    insertIntoLeague(thisLeague, beforeMiddlePlayer);

        return sumIndex;
    }

}
