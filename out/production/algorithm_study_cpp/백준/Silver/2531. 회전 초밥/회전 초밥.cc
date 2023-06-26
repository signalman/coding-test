#include <bits/stdc++.h>
using namespace std;

int n, d, k, c;
int a[34000];
bool vis[34000];
int main() {
	cin >> n >> d >> k >> c;

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	for (int i = n; i < n + k - 1; i++) {
		a[i] = a[i - n];
	}

	int ans = 0;

	//////7 9 7 30 2 7 9 5 25
	for (int i = 0; i < n; i++) { //n
		int dup = 0;
		for (int j = i; j < i + k; j++) {
			if (!vis[a[j]]) vis[a[j]] = true;
			else dup++;
		}
		if (vis[c]) {
			ans = max(ans, k - dup);
		}
		else {
			ans = max(ans, k - dup + 1);
		}
		fill(vis, vis + 34000, false);
	}
	cout << ans;
}

