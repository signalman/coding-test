#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[] = {-1, 0, 0, 1};
int dy[] = {0, -1, 1, 0};
int n, m;
long long fuel;
bool vis[21];
vector<vector<int>> info;
int board[21][21];

int dist(int from_x, int from_y, int to_x, int to_y){
  if(from_x == to_x && from_y == to_y) return 0;
  queue<pair<int, int>> q;
  int d[21][21] = {0,};
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      d[i][j] = -1;
    }
  }
  d[from_x][from_y] = 0;
  q.push({from_x, from_y});
  while(!q.empty()){
    auto cur = q.front();
    q.pop();
    for(int dir = 0; dir < 4; dir++){
      int nx = cur.X + dx[dir];
      int ny = cur.Y + dy[dir];
      if(nx<0 || ny<0 || nx>=n || ny>=n)continue;
      if(board[nx][ny] == 1 || d[nx][ny]>=0) continue;
      q.push({nx, ny});
      d[nx][ny] = d[cur.X][cur.Y] + 1;
      if(nx == to_x && ny==to_y) return d[nx][ny];
    }
  }
  return -1;
}


bool solution(vector<vector<int>> info, int taxi_x, int taxi_y, int cnt){
  if(cnt == m){
    return true;
  }
  
  //방문하지 않은 승객 중, 가장 가까운 승객 찾기
  int mndist = 0x7f7f7f7f;
  pair<int, int> passenger;
  pair<int, int> destination;
  int vis_idx;
  for(int i=0; i<m; i++){
    if(vis[i]) continue;
    int d = dist(info[i][0], info[i][1], taxi_x, taxi_y);
    if(d == -1) return false;
    if(mndist>d){
      mndist = d;
      passenger = {info[i][0], info[i][1]};
      destination = {info[i][2], info[i][3]};
      vis_idx = i;
    }
    
  }
  //연료가 부족하면 false
  if(mndist > fuel){
    return false;
  }

  taxi_x = passenger.X;
  taxi_y = passenger.Y;
  fuel -= mndist;

  int d = dist(taxi_x, taxi_y, destination.X, destination.Y);
  if(d == -1 || d > fuel){
    return false;
  }
  
  taxi_x = destination.X;
  taxi_y = destination.Y;
  fuel += d;
  vis[vis_idx] = true;
  cnt++;
  return solution(info, taxi_x, taxi_y, cnt);
}


int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m>>fuel;

  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
    }
  }
  int taxi_x, taxi_y;
  cin>>taxi_x>>taxi_y;
  taxi_x--, taxi_y--;
  for(int i=0; i<m; i++){
    vector<int> v;
    for(int j=0; j<4; j++){
      int s;
      cin>>s;
      s--;
      v.push_back(s);
    }
    info.push_back(v);
  }
  sort(info.begin(), info.end());
  bool pos = solution(info, taxi_x, taxi_y, 0);
  int ans = pos ? fuel : -1;
  cout<<ans;

}