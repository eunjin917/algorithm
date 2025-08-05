#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>

using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
priority_queue<pii> pq;
vector<pii> vec;
int arr[20005][3]; // st/ed, y1, y2
int arrY[30001];
int n;
ll ret = 0;
struct Node
{
    int cnt = 0;
    int sum = 0;
};
vector<Node> tree; // count, 1이상 갯수

void build(int node, int st, int ed)
{
    if (st == ed)
    {
        // tree[node] = 0;
        return;
    }
    int mid = (st + ed) / 2;
    build(node * 2, st, mid);
    build(node * 2 + 1, mid + 1, ed);
    // tree[node] = tree[node * 2] + tree[node * 2 + 1];
    // tree[node] = 0;
}

void updateRange(int node, int st, int ed, int l, int r, int diff)
{
    if (r < st || ed < l)
        return;
    if (l <= st && ed <= r)
        tree[node].cnt += diff;
    else
    {
        int mid = (st + ed) / 2;
        updateRange(node * 2, st, mid, l, r, diff);
        updateRange(node * 2 + 1, mid + 1, ed, l, r, diff);
    }

    // 1이상 개수 갱신
    if (tree[node].cnt > 0)
        tree[node].sum = ed - st + 1;
    else
    {
        if (st == ed)
            tree[node].sum = 0;
        else
            tree[node].sum = tree[node * 2].sum + tree[node * 2 + 1].sum;
    }
}

int query(int node, int st, int ed, int l, int r)
{
    if (r < st || ed < l)
    {
        return 0;
    }
    if (l <= st && ed <= r)
    {
        return tree[node].sum;
    }
    int mid = (st + ed) / 2;
    int left = query(node * 2, st, mid, l, r);
    int right = query(node * 2 + 1, mid + 1, ed, l, r);
    return left + right;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    int h = (int)ceil(log2(30000));
    int treeSize = (1 << (h + 1));
    tree.assign(treeSize, Node{0, 0});

    int x1, x2, y1, y2;
    for (int i = 1; i <= n * 2; i += 2)
    {
        cin >> x1 >> y1 >> x2 >> y2;
        // pq.push(make_pair(x1, i));       // st, index
        vec.push_back(make_pair(x1, i)); // st, index
        arr[i][0] = 1;
        arr[i][1] = y1 + 1;
        arr[i][2] = y2;
        // pq.push(make_pair(x2, i + 1));       // ed, index
        vec.push_back(make_pair(x2, i + 1)); // st, index
        arr[i + 1][0] = -1;
        arr[i + 1][1] = y1 + 1;
        arr[i + 1][2] = y2;
    }

    sort(vec.begin(), vec.end());
    int sted, idx, x, cnt;
    int prevx = -1;
    y1 = 0;
    y2 = 0;
    for (pii elem : vec)
    {
        x = elem.first;
        idx = elem.second;
        cnt = 0;
        if (prevx == -1)
            prevx = x;

        y2 = arr[idx][2];
        y1 = arr[idx][1];
        sted = arr[idx][0];

        cnt = query(1, 1, 30000, 1, 30000);
        ret += (x - prevx) * cnt;

        updateRange(1, 1, 30000, y1, y2, sted);

        prevx = x;
    }
    cout << ret;
    return 0;
}