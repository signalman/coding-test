#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
string board[27];
vector<int> v;
int vis[27][27];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};
queue<pair<int, int>> Q;
int n;
int h;
int main(){
  int mx;
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>board[i];
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      if(board[i][j]=='0'||vis[i][j]!=0)continue;
      vis[i][j]=1;
      int cnt =1;
      Q.push({i, j});
      while(!Q.empty()){
        pair<int,int> cur = Q.front(); Q.pop();
        for(int i=0; i<4; i++){
          int nx = cur.X + dx[i];
          int ny = cur.Y + dy[i];
          if(nx<0 || ny<0 || nx>=n || ny>=n)continue;
          if(board[nx][ny]=='0'||vis[nx][ny]!=0)continue;
          Q.push({nx,ny});
          vis[nx][ny]=1;
          cnt++;
        }
      }
      v.push_back(cnt);
      h++;
    }
  }
  
  cout<<h<<'\n';
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size(); i++) {
		cout << v[i] << '\n';
	}
  
}