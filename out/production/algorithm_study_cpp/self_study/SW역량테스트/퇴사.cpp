#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int n,m;
int board1[10][10];
int board2[10][10];
int arr[70];
vector<bool> temp;
queue<pair<int, int>> q;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int mx;
void bfs(){
  int cnt = 0;
  while(!q.empty()){
    auto cur = q.front();
    q.pop();
    for(int i=0; i<4; i++){
      int nx = cur.X + dx[i];
      int ny = cur.Y + dy[i];
      if(nx<0||ny<0||nx>=n||ny>=m)continue;
      if(board2[nx][ny]!=0)continue;
      board2[nx][ny] = 2;
      q.push({nx, ny});
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(board2[i][j]==0) cnt++;
    }
  }
  mx = max(cnt, mx);
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>board1[i][j];
      board2[i][j] = board1[i][j];
    }
  }
  int s = n*m;
  for(int i=0; i<s; i++){
    arr[i] = i;
  }
  vector<bool> temp(s, true);
  temp[0] = false;
  temp[1] = false;
  temp[2] = false;
  do{
    int cnt = 0;
    bool flag = true;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        board2[i][j] = board1[i][j];
        if(board2[i][j] == 2) q.push({i, j});
      }
    }
    vector<int> v;
    for(int i=0; i<s; i++){
      if(!temp[i]){
        v.push_back(i);
      }
    }
    for(int i=0; i<v.size(); i++){
      if(board2[v[i]/m][v[i]%m] != 0) flag = false;
    }
    if(!flag)continue;
    for(int i=0; i<v.size(); i++){
      board2[v[i]/m][v[i]%m] = 1;
    }
    bfs();
  }while(next_permutation(temp.begin(), temp.end()));

  cout<<mx;
}