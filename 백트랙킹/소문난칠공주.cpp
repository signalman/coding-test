#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
string board[5];
bool mask[25];
int ans;
queue<pair<int, int>> Q;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  for(int i=0; i<5; i++){
    cin>>board[i];
  }
  fill(mask+7, mask+25, true);

  do{
    int dasom = 0 ;
    int adj = 0;
    bool isp7[5][5] = {0, };
    bool vis[5][5] = {0, };
    for(int i=0; i<25; i++){
      if(!mask[i]){
        int x = i/5, y = i%5;
        isp7[x][y] = true;
        if(Q.empty()){
          Q.push({x, y});
          vis[x][y] = true;
        }
      }
    }
    while(!Q.empty()){
      int x, y;
      tie(x, y) = Q.front();
      Q.pop();
      adj++;
      if(board[x][y] == 'S')dasom++;
      for(int i=0; i<4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx<0||ny<0||nx>=5||ny>=5)continue;
        if(!isp7[nx][ny]||vis[nx][ny])continue;
        Q.push({nx, ny});
        vis[nx][ny] = true;
      }
      if(adj>=7&&dasom>=4){ans++; break;}
    }

  }
  while(next_permutation(mask, mask+25));
  cout<<ans;
}