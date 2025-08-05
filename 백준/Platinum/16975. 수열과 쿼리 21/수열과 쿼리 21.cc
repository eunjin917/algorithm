#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
int n, m, k;
ll arr[100005];
vector<ll> tree;
vector<ll> lazy;

void build(int node, int st, int ed)
{
    if (st == ed)
    {
        tree[node] = arr[st];
        return;
    }
    int mid = (st + ed) / 2;
    build(node * 2, st, mid);
    build(node * 2 + 1, mid + 1, ed);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

void updateLazy(int node, int st, int ed)
{
    if (lazy[node] != 0)
    {
        tree[node] += (ed - st + 1) * lazy[node];
        if (st != ed)
        {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }
}

ll query(int node, int st, int ed, int l, int r)
{
    updateLazy(node, st, ed);
    if (r < st || ed < l)
        return 0;
    if (l <= st && ed <= r)
        return tree[node];
    int mid = (st + ed) / 2;
    ll left = query(node * 2, st, mid, l, r);
    ll right = query(node * 2 + 1, mid + 1, ed, l, r);
    return left + right;
}

void updateRange(int node, int st, int ed, int l, int r, ll diff)
{
    updateLazy(node, st, ed);
    if (r < st || ed < l)
        return;
    if (l <= st && ed <= r)
    {
        lazy[node] += diff;
        updateLazy(node, st, ed);
        return;
    }
    int mid = (st + ed) / 2;
    updateRange(node * 2, st, mid, l, r, diff);
    updateRange(node * 2 + 1, mid + 1, ed, l, r, diff);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int h = (int)ceil(log2(n));
    int treeSize = (1 << (h + 1));
    tree.assign(treeSize, 0);
    lazy.assign(treeSize, 0);
    build(1, 0, n - 1);

    int a, b, c;
    ll d;
    cin >> m;
    for (int i = 0; i < m; i++)
    {
        cin >> a;
        if (a == 1)
        {
            cin >> b >> c >> d;
            updateRange(1, 0, n - 1, b - 1, c - 1, d);
        }
        else
        {
            cin >> b;
            cout << query(1, 0, n - 1, b - 1, b - 1) << '\n';
        }
    }

    return 0;
}