#include <bits/stdc++.h>
using namespace std;

int n, m, g, r;
int board[53][53]; //0: 호수, 1: 배양x: 2: 배양o, 3: G, 4: R, 77:꽃
vector<pair<int, int>> able, selected;

int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };
int ans;

void solve(int start, int index) {
	if (index == g + r) {
		//로직 : 현재 g+r개만큼 뽑았음 
		//g, r로 나눠야함

		/* 주석
		*/
		/*for (int i = 0; i < g + r; i++) {
			cout<< select[i].first <<' ' << select[i].second <<'\n';
		}cout << '\n';
		cout << '\n';*/

		vector<int> mask(g + r);
		fill(mask.begin(), mask.end(), 1);
		for (int i = 0; i < g; i++) {
			mask[i] = 0;
		}
		//g개만큼 0, r개만큼 1
		do {
			int cnt = 0;//만들어진 꽃의 개수 저장
			pair<int, int> _board[53][53]; //상태, 거리
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					_board[i][j].first = board[i][j];
					_board[i][j].second = -1;
				}
			}
			
			queue<vector<int>> q; //(좌표), 상태, 거리
			for (int i = 0; i < g + r; i++) {
				if (mask[i] == 0) { 
					_board[selected[i].first][selected[i].second].first = 3;
					_board[selected[i].first][selected[i].second].second = 0;
					q.push({ selected[i].first , selected[i].second, 3, 0 });
				}
				else if (mask[i] == 1) {
					_board[selected[i].first][selected[i].second].first = 4;
					_board[selected[i].first][selected[i].second].second = 0;
					q.push({ selected[i].first , selected[i].second, 4, 0});
				}
			}

			while (!q.empty()) {
				auto cur = q.front(); q.pop(); //  (x, y), (상태, 거리)
				//cout << cur[0] << ' ' << cur[1] << ' ' << cur[2] << ' ' << cur[3] << '\n';
				int curState = cur[2];
				int curDist = cur[3];
				if (_board[cur[0]][cur[1]].first == 77) continue;
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];

					if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					//호수거나 다른 색인데 거리가 차이날경우
					if (_board[nx][ny].first == 0 || (_board[nx][ny].first == 7 - curState && _board[nx][ny].second != curDist + 1)) continue;
					//같은색일 경우
					if (_board[nx][ny].first == curState) continue;
					if (_board[nx][ny].first == 77) continue; //꽃 마주칠 경우
					//꽃만드는 경우
					if ((_board[nx][ny].first == 7 - curState) && (_board[nx][ny].second == curDist + 1)) {
						cnt++;
						_board[nx][ny].first = 77;
						//if (cnt == 6) {
							/*for (int i = 0; i < select.size(); i++) {
								cout << select[i].first << ' ' << select[i].second << '\n';;
							}*/
							/*for (int i = 0; i < select.size(); i++) {
								cout << mask[i] << ' ';
							}*//*
							for (int i = 0; i < n; i++) {
								for (int j = 0; j < m; j++) {
									cout << _board[i][j].first <<' ';
								}cout << '\n';
							}*/
							//cout << "cnt: " << cnt << "   " << nx << ", " << ny<<'\n';
						//}
						continue;
					}
					_board[nx][ny].first = curState;
					_board[nx][ny].second = curDist + 1;
					q.push({ nx, ny, curState, curDist + 1 });
				}

			}
			ans = max(ans, cnt);
		} while (next_permutation(mask.begin(), mask.end()));
		return;
	}

	for (int i = start; i < able.size(); i++) {
		selected[index] = able[i];
		solve(i + 1, index + 1);
	}
}

int main() {
	cin >> n >> m >> g >> r;
	selected.resize(g + r);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
			if (board[i][j] == 2) { 
				able.push_back({ i, j }); 
			}
		}
	}
	//배양액뿌릴수 있는 땅중 g+r개 뽑기
	solve(0, 0); //start, depth
	cout << ans;
}
