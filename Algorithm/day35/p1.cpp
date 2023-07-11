#include <bits/stdc++.h>
using namespace std;


/*
0: 호수
1: 배양액 x
2: 배양액 o

배양액 뿌릴 수 있는 칸 중 배양액의 개수만큼 뽑기
뽑은 칸을 G, R로 나누기
bfs
*/
int n, m, g, r;
int board[55][55];
int _board[55][55];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
vector<pair<int, int>> accessible; //size: 배양액가능 땅의 수
vector<pair<int, int>> chosen; //size: g+r
const int FLOWER = 777;
const int RED = 300;
const int GREEN = 400;

void solve(int start, int index){
    if(index == g+r){
        //처리로직
        for(int i=0; i<55; i++){
            for(int j=0; j<55; j++){
                _board[i][j] = board[i][j];
                if(board[i][j] != 0) _board[i][j] = 1; //0호수 1else
            }
        }
        //g+r개 뽑은 땅이 chosen에 저장되어있음
        //G와 R로 이 땅을 나눠야함
        vector<bool> divide(g+r, 1);
        for(int i=0; i<g; i++) divide[i] = 0;
        do{ //g와 r을 나눈 경우에 대한 처리
            queue<pair<int, int>> redQ;
            queue<pair<int, int>> greenQ;
            for(int i=0; i<chosen.size(); i++){
                if(divide[i]){ //R
                    _board[chosen[i].first][chosen[i].second] = RED;
                    redQ.push(chosen[i]);
                }else{ //G
                    _board[chosen[i].first][chosen[i].second] = GREEN;
                    greenQ.push(chosen[i]);
                }
            }

            while(!greenQ.empty() || !redQ.empty()){
                //green 먼저 처리
                if(!greenQ.empty()){
                    auto cur = greenQ.front(); greenQ.pop();
                    for(int dir = 0; dir <4 ; dir++){
                        int nx = cur.first + dx[dir];
                        int ny = cur.second + dy[dir];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if(board[nx][ny] == GREEN || board[nx][ny] == 0) continue;
                    }
                }

                if(!redQ.empty()){
                    auto cur = redQ.front(); redQ.pop();
                }

            }





        }while(next_permutation(divide.begin(), divide.end()));

        for(int i=0; i<chosen.size(); i++){
            cout<< chosen[i].first << " " << chosen[i].second<<'\n';
        }
        cout<<'\n';

        return;
    }

    for(int i=start; i<accessible.size(); i++){
        chosen[index] = accessible[i];
        solve(i+1, index+1);
    }
}

int main(){
    cin>>n>>m>>g>>r;
    chosen.resize(g+r);
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin>>board[i][j];
            if(board[i][j] == 2) accessible.push_back(make_pair(i, j));
        }
    }

    //배양액 가능 땅 중 g+r개 뽑기
    solve(0, 0);


}