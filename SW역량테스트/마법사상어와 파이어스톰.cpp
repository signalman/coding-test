#include <iostream>
#include <cstring>
#define MAX 64
using namespace std;

int N,Q;
int board[MAX][MAX], temp[MAX][MAX];
bool checkMelt[MAX][MAX], visited[MAX][MAX];
const int dy[]={-1,1,0,0};
const int dx[]={0,0,-1,1};

bool inRange(int y,int x){
    return y>=0 && x>=0 && y<N && x<N;
}

int dfs(int y, int x){
    visited[y][x]=true;
    int ret=1;
    for(int i=0;i<4;i++){
        int ny=y+dy[i];
        int nx=x+dx[i];
        if(inRange(ny,nx) && !visited[ny][nx] && board[ny][nx]>0)
            ret+=dfs(ny,nx);
    }
    return ret;
}

// 가장 큰 덩어리 찾기 - DFS
int getBiggest(){
    int ret=0;
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
            if(board[i][j]>0 && !visited[i][j])
                ret=max(ret,dfs(i,j));
    return ret;
}
 
 
// 얼음 합 반환
int getSum(){
    int ret=0;
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
            ret+=board[i][j];
    return ret;
}

// 격자 시계방향 회전
void rotate(int y, int x, int L){
    for(int i=0;i<L;i++)
        for(int j=0;j<L;j++)
            temp[i][j]=board[y+L-1-j][x+i];
    for(int i=0;i<L;i++)
        for(int j=0;j<L;j++)
            board[y+i][x+j]=temp[i][j];
}

void solve(int L){
    L=(1<<L);

    // 모든 격자에 대한 회전
    for(int i=0;i<N;i+=L)
        for(int j=0;j<N;j+=L)
            rotate(i,j,L);

    // 얼음 융해
    memset(checkMelt,false,sizeof(checkMelt));
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(board[i][j]==0) continue;
            int cnt=0;
            for(int k=0;k<4;k++){
                int ny=i+dy[k];
                int nx=j+dx[k];
                if(!inRange(ny,nx)) continue;
                if(board[ny][nx]>0) cnt++;
            }
            if(cnt<3) checkMelt[i][j]=true;
        }
    }
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
            if(checkMelt[i][j])
                board[i][j]--;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>N>>Q;
    N=(1<<N);
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
            cin>>board[i][j];

    while(Q--){
        int L; cin>>L;
        solve(L);
    }

    cout<<getSum()<<'\n';
    cout<<getBiggest()<<'\n';

    return 0;
}