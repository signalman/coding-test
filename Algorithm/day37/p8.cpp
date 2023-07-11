#include <bits/stdc++.h>
using namespace std;

int n, m;
char board[105][105];
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, -1, 1};
bool vis[105][105];

struct Memo{
    int x, y, count; //행 열 벽부신횟수
    
    Memo(int x, int y, int count){
        this -> x = x;
        this -> y = y;
        this -> count = count;
    }

    bool operator<(const Memo m) const{
        return count > m.count;
    }
};

int main(){
    cin>>m>>n;
    for(int i=0; i<n; i++){
        string line;
        cin>>line;
        for(int j=0; j<m; j++){
            board[i][j] = line[j];
        }
    }

    priority_queue<Memo> pq;
    pq.push(Memo(0, 0, 0));
    vis[0][0] = true;

    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();

        if(cur.x == n-1 && cur.y == m-1) {
            cout<<cur.count;
            return 0;
        }

        for(int dir = 0; dir < 4; dir++){
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m || vis[nx][ny]) continue;
            //벽이라면
            if(board[nx][ny] == '1'){
                pq.push(Memo(nx, ny, cur.count + 1));
            }
            else{
                pq.push(Memo(nx, ny, cur.count));
            }
            board[nx][ny] = '0';
            vis[nx][ny] = 1;
        }
    }

}