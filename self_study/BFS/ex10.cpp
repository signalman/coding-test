#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[8] = {-1, -2, -2, -1, 1, 2, 2, 1};
int dy[8] = {-2, -1, 1, 2, 2, 1, -1, -2};
queue<pair<int, int>> Q;
int dist[302][302];

int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
  int testCase; 
  cin>>testCase;
  for(int s=0; s<testCase; s++){
    int MAX;
    int n1, m1;
    int n2, m2;
    cin>>MAX;
    cin>>n1>>m1;
    cin>>n2>>m2;
    for(int i=0; i<MAX; i++){
      for(int j=0; j<MAX; j++){
        dist[i][j]=-1;
      }
    }
    dist[n1][m1]=0;
    Q.push({n1,m1});
    while(!Q.empty()||dist[n2][m2]==-1){
      auto cur = Q.front(); Q.pop();
      for(int dir=0; dir< 8; dir++){
        int nx = cur.X + dx[dir];
        int ny = cur.Y + dy[dir];
        if(nx<0 || ny<0 || nx>=MAX || ny>=MAX)continue;
        if(dist[nx][ny]!=-1)continue;
        Q.push({nx, ny});
        dist[nx][ny] = dist[cur.X][cur.Y]+1;
      }
    }
    cout<<dist[n2][m2]<<'\n';
  }
}