import java.io.*;
import java.util.*;

class Node {
    boolean toggle = false;
    int idx = 0;
    int childCnt = 0;
    List<Integer> childs = new ArrayList<>();
}

public class Main {
    static int n, q;
    static int curNode, curIdx, prevIdx, mvCnt;
    static int[] parent = new int[2003];
    static Node[] nodes = new Node[2003];

    static boolean validUp() {
        if (parent[curNode] == 1 && curIdx == 0) {
            return false;
        }
        return true;
    }

    static boolean validDown() {
        int tempNode = curNode;
        int tempIdx = curIdx;
        while (tempIdx == (nodes[parent[tempNode]].childCnt - 1)) {
            if (parent[tempNode] == 1)
                return false;
            tempNode = parent[tempNode];
            tempIdx = nodes[tempNode].idx;
        }
        return true;
    }

    static void move() {
        if (mvCnt > 0) {
            if (nodes[curNode].toggle) {
                if (nodes[curNode].childCnt > 0) { // has child
                    curIdx = 0;
                    curNode = nodes[curNode].childs.get(curIdx);
                    mvCnt--;
                    return;
                } else {
                    if (nodes[parent[curNode]].childCnt - 1 > curIdx) { // parent's next child
                        curIdx++;
                        curNode = nodes[parent[curNode]].childs.get(curIdx);
                        mvCnt--;
                        return;
                    } else { // parent's last child
                        if (!validDown()) {
                            mvCnt--;
                            return;
                        }
                        curNode = parent[curNode];
                        curIdx = nodes[curNode].idx;
                        prevIdx = curIdx;
                        while (true) {
                            curNode = parent[curNode];
                            curIdx = nodes[curNode].idx;
                            if (nodes[curNode].childCnt - 1 > prevIdx) {
                                curNode = nodes[curNode].childs.get(prevIdx + 1);
                                curIdx = nodes[curNode].idx;
                                mvCnt--;
                                break;
                            }
                            prevIdx = curIdx;
                        }

                    }
                }
            } else {
                if (!validDown()) {
                    mvCnt--;
                    return;
                }
                prevIdx = curIdx;
                while (true) {
                    curNode = parent[curNode];
                    curIdx = nodes[curNode].idx;
                    if (nodes[curNode].childCnt - 1 > prevIdx) {
                        curNode = nodes[curNode].childs.get(prevIdx + 1);
                        curIdx = nodes[curNode].idx;
                        mvCnt--;
                        break;
                    }
                    prevIdx = curIdx;
                }
            }
        } else {
            if (curIdx > 0) { // has up sibling
                curNode = nodes[parent[curNode]].childs.get(--curIdx);

                while (nodes[curNode].toggle && (nodes[curNode].childCnt > 0)) {
                    curNode = nodes[curNode].childs.get(nodes[curNode].childCnt - 1);
                    curIdx = nodes[curNode].idx;
                }

                mvCnt++;
                return;
            } else {
                if (!validUp()) {
                    mvCnt++;
                    return;
                }
                // while (curIdx == 0) {
                // if (!validUp()) {
                // mvCnt++;
                // return;
                // }
                // curNode = parent[curNode];
                // curIdx = nodes[curNode].idx;
                // }
                // curNode = nodes[parent[curNode]].childs.get(--curIdx);
                // while (nodes[curNode].toggle && (nodes[curNode].childCnt > 0)) {
                // curNode = nodes[curNode].childs.get(nodes[curNode].childCnt - 1);
                // curIdx = nodes[curNode].idx;
                // }
                curNode = parent[curNode];
                curIdx = nodes[curNode].idx;
                mvCnt++;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int child = Integer.parseInt(st.nextToken());
                nodes[i].childs.add(child);
                nodes[i].childCnt++;
                nodes[child].idx = j;
                parent[child] = i;
            }
        }
        curNode = nodes[1].childs.get(0);
        curIdx = 0;
        for (int query = 0; query < q; query++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("toggle")) {
                nodes[curNode].toggle = !nodes[curNode].toggle;
            }
            if (command.equals("move")) {
                mvCnt = Integer.parseInt(st.nextToken());
                while (mvCnt != 0)
                    move();
                bw.write(curNode + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
