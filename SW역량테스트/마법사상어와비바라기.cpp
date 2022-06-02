#include <bits/stdc++.h>
using namespace std;
#define MAX 55
#define X first
#define Y second
int dx[8] = {0, -1, -1, -1, 0, 1, 1, 1};
int dy[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int N, M;
int A[MAX][MAX];
vector<pair<int, int>> Move_Info;
vector<pair<int, int>> Cloud_Pos;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin>>A[i][j];
        }
    }
    for(int i=0; i<M; i++){
        int d, s;
        cin>>d>>s;
        d--;
        Move_Info.push_back({d, s});
    }

    for(int i=0; i<M; i++){
        int d = Move_Info[i].X;
        int s = Move_Info[i].Y;
        s = s % N;
        if(i == 0){
            Cloud_Pos.push_back({N-2, 0});
            Cloud_Pos.push_back({N-2, 1});
            Cloud_Pos.push_back({N-1, 0});
            Cloud_Pos.push_back({N-1, 1});
        }

        //구름 이동 후 물 1 증가
        for(int c = 0; c < Cloud_Pos.size(); c++){
            int x = Cloud_Pos[c].X;
            int y = Cloud_Pos[c].Y;
            int nx = (x + dx[d] * s + N) % N;
            int ny = (y + dy[d] * s + N) % N;
            Cloud_Pos[c].X = nx;
            Cloud_Pos[c].Y = ny;
            A[nx][ny] += 1;
        }

        //물복사버그
        for(int c=0; c< Cloud_Pos.size(); c++){
            int x = Cloud_Pos[c].X;
            int y = Cloud_Pos[c].Y;
            int cnt = 0;
            for(int dir = 0; dir < 4; dir++){
                int nd = dir * 2 + 1;
                int nx = x + dx[nd];
                int ny = y + dy[nd];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
                if(A[nx][ny] > 0) cnt++;
            }
            A[x][y] += cnt;
        }

        // 구름 생성
        vector<pair<int, int>> New_Cloud;
        for(int a=0; a<N; a++){
            for(int b=0; b<N; b++){
                if(find(Cloud_Pos.begin(), Cloud_Pos.end(), make_pair(a, b)) == Cloud_Pos.end()){ 
                    if(A[a][b] >= 2){
                        New_Cloud.push_back({a, b});
                        A[a][b] -= 2;
                    }
                }
            }
        }
        Cloud_Pos = New_Cloud;
    }

    int answer = 0;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            answer += A[i][j];
        }
    }
    cout<<answer;
    return 0;
}