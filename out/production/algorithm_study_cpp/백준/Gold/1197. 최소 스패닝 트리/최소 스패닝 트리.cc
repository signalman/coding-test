#include <bits/stdc++.h>
using namespace std;

vector<tuple<int, int, int>> edge; // 비용, 노드1, 노드2
vector<int> p(10005, -1);

int find(int x) {
	if (p[x] < 0) return x;
	return p[x] = find(p[x]);
}

bool is_diff_group(int u, int v) {
	u = find(u); v = find(v);
	if (u == v) return false;
	if (p[u] > p[v]) swap(u, v);
	p[u] += p[v];
	p[v] = u;
	return true;
}

int main() {
	int v, e;
	cin >> v >> e;

	while (e--) {
		int a, b, cost;
		cin >> a >> b >> cost;
		edge.push_back({ cost, a, b });
	}
	sort(edge.begin(), edge.end());

	int cnt = 0; //연결된 간선 개수
	int ans = 0;
	for (auto ed : edge) {
		int cost, a, b;
		tie(cost, a, b) = ed;

		if (!is_diff_group(a, b)) continue;
		ans += cost;
		cnt++;
		if (cnt == e - 1) break;
	}
	cout << ans;
}