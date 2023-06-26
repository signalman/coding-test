#include <bits/stdc++.h>
using namespace std;

int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};

int testCase;
char board[1001][1001];
int n, m;
int distFire[1001][1001];
int distUser[1001][1001];

void fire(){
    queue<pair<int, int>> q;
    for(int i=0; i<n; i++) fill(distFire[i], distFire[i]+m, -1);

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(board[i][j] == '*'){
                q.push({i, j});
                distFire[i][j] = 0;
            }
        }
    }

    while(!q.empty()){
        auto cur = q.front();
        q.pop();

        for(int dir =0; dir < 4; dir++){
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];

            if(nx < 0 || ny < 0 || nx>= n || ny >= m) continue;
            if(board[nx][ny] == '#' || distFire[nx][ny] >= 0) continue;
            q.push({nx, ny});
            distFire[nx][ny] = distFire[cur.first][cur.second] + 1;
        }
    }
}

int user(){
    queue<pair<int, int>> q;
    for(int i=0; i<n; i++) fill(distUser[i], distUser[i]+m, -1);

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(board[i][j] == '@') {
                q.push({i, j});
                distUser[i][j] = 0;
            }
        }
    }

    while(!q.empty()){
        auto cur = q.front(); q.pop();
        
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) return distUser[cur.first][cur.second]+1;
            if(board[nx][ny] == '#' || distUser[nx][ny]>=0) continue;
            if(distFire[nx][ny]!= -1 && distFire[nx][ny] <= distUser[cur.first][cur.second] + 1)continue;
            q.push({nx, ny});
            distUser[nx][ny] = distUser[cur.first][cur.second] + 1;
        }  
    }
    //탈출 못했을 때
    return -1;
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>testCase;
    while(testCase--){
        cin>>m>>n;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cin>>board[i][j];
            }
        }

        fire();

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         cout<<distFire[i][j]<<' ';
        //     }
        //     cout<<'\n';
        // }
        int dist = user();
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         cout<<distUser[i][j]<<' ';
        //     }
        //     cout<<'\n';
        // }
        if(dist == -1) cout<< "IMPOSSIBLE"<<'\n';
        else{ cout<< dist<< '\n';}
    }
}