#include <bits/stdc++.h>
using namespace std;

int N, M;
int board[51][51];
int dx[4] = {-1, 0, 1, 0};
int dy[4] ={0, 1, 0, -1};

vector<pair<int, int>> canVirus;
int minTime = 0x7f7f7f7f;
int distBoard[51][51];

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin>>N>>M;

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin>>board[i][j];
            if(board[i][j] == 2){
                canVirus.push_back({i, j});
            }
            distBoard[i][j] = -1;
            if(board[i][j] == 1) {
                distBoard[i][j] = -7; // 벽 -7로 표시
            }
        }
    }

    int tmp[canVirus.size()] = {0, };
    for(int i=0; i<M; i++){
        tmp[i] = 1;
    }


    do{
        int cpyBoard[51][51];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cpyBoard[i][j] = distBoard[i][j];
                // cout<<cpyBoard[i][j]<<' ';
            }
            // cout<<'\n';
        }

        queue<pair<int, int>> q;
        for(int i=0; i<canVirus.size(); i++){
            if(tmp[i]){
                q.push(canVirus[i]);
                cpyBoard[canVirus[i].first][canVirus[i].second] = 0;
            }
        }
        while(!q.empty()){
            auto cur = q.front();
            q.pop();

            for(int dir = 0; dir < 4; dir++){
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(cpyBoard[nx][ny] != -1) continue;
                cpyBoard[nx][ny] = cpyBoard[cur.first][cur.second] + 1;
                q.push({nx, ny});
            }
        }

        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         cout<<cpyBoard[i][j]<<' ';
        //     }
        //     cout<<'\n';
        // }


        bool flag = true;
        int ret = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cpyBoard[i][j] == -7) continue;
                if(cpyBoard[i][j] == -1) {flag = false; break;}
                ret = max(ret, cpyBoard[i][j]);
            }
        }
        
        if(flag) minTime = min(minTime, ret);
        

    }while(prev_permutation(tmp, tmp + canVirus.size()));


    if(minTime == 0x7f7f7f7f) cout<<-1<<'\n';
    else cout<<minTime<<'\n';

}