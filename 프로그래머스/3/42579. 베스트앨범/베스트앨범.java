import java.util.*;

class Music {
    String genre;
    int genrePlay;
    int play;
    int no;
    
    public Music(String genre, int genrePlay, int play, int no) {
        this.genre = genre;
        this.genrePlay = genrePlay;
        this.play = play;
        this.no = no;
    }
    
    public String toString() {
        return genre + no;
    }
}

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        int n = genres.length;

        // 10,000 : 장르별 합계 구하기
        Map<String, Integer> genrePlayMap = new HashMap<>();
        for (int i=0; i<n; i++) {
            String genre = genres[i];
            if (genrePlayMap.containsKey(genre)) {
                genrePlayMap.put(genre, genrePlayMap.get(genre)+plays[i]);
            } else {
                genrePlayMap.put(genre, plays[i]);
            }
        }
        
        // 10,000 : 객체 만들기
        Music[] musics = new Music[n];
        for (int i=0; i<n; i++) {
            musics[i] = new Music(genres[i], genrePlayMap.get(genres[i]), plays[i], i);
        }
        
        // 10,000log10,000 : 우선순위 기준 정렬
        Arrays.sort(musics, (a, b)->{
            if (a.genrePlay != b.genrePlay) return b.genrePlay - a.genrePlay;
            if (a.play != b.play) return b.play - a.play;
            return a.no - b.no;
        });
        // System.out.println(Arrays.toString(musics));
        
        // 10,000 : 장르별 2개
        Map<String, Integer> pickedCount = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (Music m : musics) {
            int cnt = pickedCount.getOrDefault(m.genre, 0);
            if (cnt < 2) {
                answer.add(m.no);
                pickedCount.put(m.genre, cnt + 1);
            }
        }
        
        return answer;
    }
}