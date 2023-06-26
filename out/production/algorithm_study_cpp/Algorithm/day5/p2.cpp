#include <bits/stdc++.h>
using namespace std;

int k;
int h, w;
int board[201][201];
int dist[201][201];

int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};

int sx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
int sy[] = {1, 2, 2, 1, -1, -2, -2, -1};
int ans = 0x7f7f7f7f;

void bfs(int i, int j, int skill){
    queue<tuple<int, int, int>> q;
    for(int i=0; i<w; i++) fill(dist[i], dist[i]+h, -1);
    q.push({i, j, skill});
    dist[i][j] = 0;
    if(i == w-1 && j == h-1) {ans = 0; return;}

    while(!q.empty()){
        auto cur = q.front(); q.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = get<0>(cur) + dx[dir];
            int ny = get<1>(cur) + dy[dir];

            if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
            if(board[nx][ny] == 1 || dist[nx][ny] >= 0) continue;
            if(nx == w-1 && ny == h-1) {
                ans = min(ans, dist[get<0>(cur)][get<1>(cur)]+1) ;
            }
            q.push({nx, ny, skill});
            dist[nx][ny] = dist[get<0>(cur)][get<1>(cur)] + 1;
        }

        if(skill > 0){
            for(int dir = 0; dir < 8; dir++){
                int nx = get<0>(cur) + sx[dir];
                int ny = get<1>(cur) + sy[dir];

                if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
                if(board[nx][ny] == 1 || dist[nx][ny] >= 0) continue;
                if(nx == w-1 && ny == h-1) {
                    ans = min(ans, dist[get<0>(cur)][get<1>(cur)]+1);
                }
                q.push({nx, ny, skill-1});
                dist[nx][ny] = dist[get<0>(cur)][get<1>(cur)] + 1;
            }
        }
    }
}

int main(){
    cin>>k;
    cin>>w>>h;
    for(int i=0; i<w; i++){
        for(int j=0; j<h; j++){
            cin>>board[i][j];
        }
    }
    bfs(0, 0, k);
    if(ans == 0x7f7f7f7f) cout<< -1;
    else cout<<ans;
}