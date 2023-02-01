#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;

int k, l;
unordered_map<string, int> m;
bool cmp(pair<string, int>& a, pair<string, int>& b) {
	return a.second < b.second;
}

int main() {
	cin >> k >> l;
	for (int i = 1; i <= l; i++) {
		string str;
		cin >> str;
		m[str] = i;
	}


	vector<pair<string, int>> v(m.begin(), m.end());
	//sort(v.begin(), v.end(), [](auto& a, auto& b) {return a.second < b.second; });
	sort(v.begin(), v.end(), cmp);
	k = min(k, (int)v.size());
	for (int i = 0; i < k; i++) {
		cout << v[i].first << '\n';
	}


}