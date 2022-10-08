#include <bits/stdc++.h>
using namespace std;

int m, n, k;
int board[101][101];
bool vis[101][101];

int dx[] ={1, -1, 0, 0};
int dy[] ={0, 0, 1, -1};

int main(){
    cin>>m>>n>>k;
    int x1, x2, y1, y2;
    for(int i=0; i<k; i++){
        cin>>x1>>y1>>x2>>y2;

        //색칠하기
        for(int a=y1; a<y2; a++){
            for(int b=x1; b<x2; b++){
                board[a][b] = 1;
            }
        }
    }

    vector<int> area;
    int cnt=0;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(vis[i][j]==1 || board[i][j] == 1)continue;
            queue<pair<int, int>> q;
            vis[i][j] = 1;
            q.push({i, j});
            int tmp = 1;
            cnt++;
            while(!q.empty()){
                auto cur = q.front();
                q.pop();

                for(int dir=0; dir<4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];
                    if(nx < 0 || nx>=m|| ny<0 || ny >=n) continue;
                    if(board[nx][ny] == 1 || vis[nx][ny] == 1) continue;
                    q.push({nx, ny});
                    vis[nx][ny] = 1;
                    tmp++;
                }
            }
            area.push_back(tmp);
        }
    }
    sort(area.begin(), area.end());

    cout<<cnt<<'\n';
    for(auto i: area){
        cout<<i<<' ';
    }
}