#include <bits/stdc++.h>
using namespace std;

int n;
int x, y, d, g;
bool vis[104][104];

int dx[] = { 0, -1, 0, 1 };
int dy[] = { 1, 0, -1, 0 };

pair<int, int> move(int x, int y, int rx, int ry) {
    //x - rx , y - ry 평행이동
    //y - ry, -x + rx 90도 회전          
	return make_pair(y - ry + rx, -x + rx + ry);
}

void dragon(int x, int y, int d, int g) { //x, y, 방향, 세대
	vector<pair<int, int>> v;
    //시작점 삽입
	v.push_back({ x, y });
	vis[x][y] = true;

    //pivot 삽입
	int nx = x + dx[d];
	int ny = y + dy[d];
	v.push_back({ nx, ny });
	vis[nx][ny] = true;
	
	while (g--) {
		int vSize = v.size();
		int rx = v.back().first;
		int ry = v.back().second;

		for (int i = vSize - 2; i >= 0; i--) {
			int curx = v[i].first;
			int cury = v[i].second;

			pair<int,int> nxt = move(curx, cury, rx, ry);
			v.push_back({nxt.first, nxt.second});
            
			vis[nxt.first][nxt.second] = true;
		}
	}
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> y >> x >> d >> g;
		dragon(x, y, d, g);
	}
	int answer = 0;

	for (int i = 0; i < 103; i++) {
		for (int j = 0; j < 103; j++) {
			if (!vis[i][j]) continue;
			if (vis[i][j + 1] && vis[i + 1][j] && vis[i + 1][j + 1]) answer++;
		}
	}

    // for(int i=0; i<30; i++){
    //     for(int j=0; j<30; j++){
    //         cout<<vis[i][j]<<' ';
    //     }
    //     cout<<'\n';
    // }

	cout << answer;


}