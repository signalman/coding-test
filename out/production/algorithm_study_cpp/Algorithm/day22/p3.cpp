#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[10][10];
vector<pair<int, int>> virus;
vector<int> canBuild;
int ret = -1;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

int main(){
    cin>>n>>m;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin>>board[i][j];
            if(board[i][j] == 2){
                virus.push_back({i, j});
            }
            else if(board[i][j] == 0){
                canBuild.push_back(i * m + j);
            }
        }
    }

    // canBuild에서 3개 뽑는다.
    vector<bool> tmp(canBuild.size(), false);
    for(int i=0; i<3; i++){
        tmp.at(i) = true;
    }

    do
    {
        /* code */
        int cpyboard[10][10]; 
        // copy(&board[0][0], &board[0][0]+n*m, &cpyboard[0][0]);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cpyboard[i][j] = board[i][j];
            }
        }

        for(int i=0; i<canBuild.size(); i++){
            if(tmp[i]){
                int row = canBuild[i] / m;
                int col = canBuild[i] % m;
                cpyboard[row][col] = 1;
            }
        }

        queue<pair<int, int>> q;
        bool vis[10][10] = {false, };
        for(auto c: virus){
            q.push(c);
            vis[c.first][c.second] = true;
        }

        while(!q.empty()){
            auto cur = q.front();
            q.pop();

            for(int dir = 0; dir < 4; dir++){
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(cpyboard[nx][ny] != 0 || vis[nx][ny] == true) continue;
                cpyboard[nx][ny] = 2;
                vis[nx][ny] = true;
                q.push({nx, ny});
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(cpyboard[i][j] == 0) cnt++;
            }
        }
        ret = max(ret, cnt);

    } while (prev_permutation(tmp.begin(), tmp.end()));

    std::cout<<ret;

}

