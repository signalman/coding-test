#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
queue<pair<int,int>> Q;
int dx[4]={1, 0, -1, 0};
int dy[4]={0, -1, 0, 1};

int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  int n,m,k;
  cin>>t;
  for(int i=0; i<t; i++){
    int board[52][52]={0, };
    int vis[52][52]={0, };
    int cnt=0;
    cin>>n>>m>>k;
    for(int j=0; j<k; j++){
      int a,b;
      cin>>a>>b;
      board[a][b]=1;
    }
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(board[i][j]==0||vis[i][j]==1)continue;
        Q.push({i,j});
        vis[i][j]=1;
        while(!Q.empty()){
          pair<int,int> cur = Q.front(); Q.pop();
          for(int dir=0; dir<4; dir++){
            int nx= cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx<0 || ny<0 || nx>=n || ny>=m)continue;
            if(board[nx][ny]==0||vis[nx][ny]==1)continue;
            vis[nx][ny]=1;
            Q.push({nx,ny});
          }
        }
        cnt++;
      }
    }
    cout<<cnt<<'\n';
  }
}
