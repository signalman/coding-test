#include <bits/stdc++.h>
using namespace std;

int n, m, k;
int d[201][201];
int f[201];
int main() {
	cin >> n >> m;
	for (int i = 1; i <= n; i++) fill(d[i], d[i] + n + 1, 0x3f3f3f3f);
	for (int i = 1; i <= n; i++) d[i][i] = 0;
	for (int i = 1; i <= m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		d[a][b] = min(d[a][b], c);
	}
	cin >> k;
	for (int i = 1; i <= k; i++) {
		cin >> f[i];
	}

	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				d[i][j] = min(d[i][k] + d[k][j], d[i][j]);
			}
		}
	}

	vector<pair<int, int>> mx_vec; //val, idx
	vector<int> ans;
	for (int i = 1; i <= n; i++) { 
		int mx = 0;
		for (int j = 1; j <= k; j++) {
			mx = max(mx, d[i][f[j]] + d[f[j]][i]);
		}
		mx_vec.push_back(make_pair(mx, i));
		/*auto iter = max_element(d[i] + 1, d[i] + n + 1);
		mx_vec.push_back(make_pair(*iter, iter - d[i])); */
	}
	sort(mx_vec.begin(), mx_vec.end());
	int felem = mx_vec[0].first;
	
	for (auto p : mx_vec) {
		if (p.first == felem) ans.push_back(p.second);
	}
	for (auto i : ans) {
		cout << i << ' ';
	}

}