#include <bits/stdc++.h>
using namespace std;

int board[23][23];
int dx[4] = { -1, 0, 0, 1 }; //위, 왼, 오, 아
int dy[4] = { 0, -1, 1, 0 };
int n;
int shark_size = 2;
int cnt = 0;
int ans = 0;
//찾으면 물고기 위치 반환, 못 찾으면 -1, -1 반환
pair<int, int> find_fish(int x, int y) {
	queue<pair<int, int>> q;
	vector<tuple<int, int, int>> candi;
	int vis[25][25];
	for (int i = 0; i < n; i++) fill(vis[i], vis[i] + n, -1);
	vis[x][y] = 0;
	q.push({ x, y });
	int tmp = 0;
	while (!q.empty()) {
		auto cur = q.front(); q.pop();
		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.first + dx[dir];
			int ny = cur.second + dy[dir];
			//cout << nx << ' ' << ny<<'\n';
			if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			if (board[nx][ny] > shark_size || vis[nx][ny] != -1) continue;
			q.push({ nx, ny });
			vis[nx][ny] = vis[cur.first][cur.second] + 1;
			if (board[nx][ny] != 0 && board[nx][ny] < shark_size) {
				/*ans += vis[cur.first][cur.second] + 1;
				return { nx, ny };*/
				candi.push_back({ vis[nx][ny], nx, ny });
			}
		}
	}
	if (!candi.empty()) {
		sort(candi.begin(), candi.end());
		int dist, i, j;
		tie(dist, i, j) = candi[0];
		ans += dist;
		return { i, j };
	}
	return { -1, -1 };
}
int main() {
	int x, y;
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> board[i][j];
			if (board[i][j] == 9) {
				x = i;
				y = j;
				board[i][j] = 0;
			}
		}
	}
	pair<int, int> p;
	while ((p = find_fish(x, y)) != make_pair(-1, -1)) {
		board[p.first][p.second] = 0;
		x = p.first;
		y = p.second;
		cnt++;
		//cout << "x: " << x << " y: " << y <<'\n';
		//cout << "shark_size: " << shark_size << " cnt: " << cnt <<" ans: " << ans << '\n';
		if (cnt == shark_size) {
			cnt = 0;
			shark_size++;
		}
	}
	cout << ans;
}