#include <bits/stdc++.h>
using namespace std;

int n, r, q;
vector<int> adj[100005];
int sub[100005]; // sub[i]: 노드 i의 서브트리 노드개수
bool vis[100005];
int dfs(int root) { //root를 루트로 하는 서브트리 노드개수
	int ret = 1;
	vis[root] = true;
	for (int nxt : adj[root]) {
		if (vis[nxt]) continue;
		ret += dfs(nxt);
	}
	sub[root] = ret;
	return ret;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> r >> q;
	
	while (--n) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	int s = dfs(r);
	while (q--) {
		int t;
		cin >> t;
		cout << sub[t] << '\n';
	}
}