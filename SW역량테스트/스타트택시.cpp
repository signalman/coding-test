#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int n, m, fuel;
int board[21][21];
int cnt;
vector<vector<pair<int, int>>> info(200);
bool check[401] = {false, };

// int dist(int from_x, int from_y,int to_x, int to_y){
//   queue<pair<int, int>> q;
//   bool vis[21][21] = {0,};
//   q.push({from_x, from_y});
//   vis[from_x][from_y]=true;
//   bool flag = false;
//   int length = 0;
//   while(!q.empty()){
//     auto cur = q.front();
//     for(int dir=0; dir<4; dir++){
//       int nx = cur.X + dx[dir];
//       int ny = cur.Y + dy[dir];

//       if(nx<0 || ny<0 || nx>=n ||ny>=n) continue;
//       if(board[nx][ny] == 1 || vis[nx][ny] == 1) continue;

//       q.push({nx, ny});
//       length++;
//       vis[nx][ny] = 1;
//       if(nx==to_x && ny==to_y) {flag = true; break;}
//     }
//     if(flag) break;
//   }
//   return length;
// }

bool solve(vector<vector<pair<int, int>>> info, int car_x, int car_y, int fuel, int cnt){
  if(cnt==m){
    return true;
  }

  //가장 가까운 승객 찾기
  //info 행, 열 순으로 정렬해놓기
  //dist()함수를 만들어 승객과 택시사이의 거리를 반환하는 함수생성
  //가장 작은것을 고름
  int mndist = 0x7f7f7f7f;
  pair<int, int> find_passenger;
  pair<int, int> destination;
  int idx;
  for(int i=0; i<m; i++){
    if(check[i])continue;
    if(mndist > dist(car_x, car_y, info[i][0].X, info[i][0].Y)){
      mndist = dist(car_x, car_y, info[i][0].X, info[i][0].Y);
      find_passenger = info[i][0];
      destination = info[i][1];
      check[i] = true;
    }
  }

  //dist와 연료를 비교하여 가능한지 판단
  //불가능 -> return;
  if(mndist > fuel){
    return false;
  }
  //가능하다면 택시가 승객 위치로 이동, 남아있는 fuel 수정
  car_x = find_passenger.X;
  car_y = find_passenger.Y;
  fuel -= mndist;

  //택시와 목적지거리, 연료 비교하여 가능한지 판단
  int des_dist = dist(car_x, car_y, destination.X, destination.Y);
  
  //불가능 -> return;
  if(des_dist > fuel){
    return false;
  }

  //가능하다면 택시가 목적지 위치로 이동 후 fuel 조정 후 erase
  car_x = destination.X;
  car_y = destination.Y;
  fuel += des_dist;
  cnt++;
  solve(info, car_x, car_y, fuel, cnt);
  return false;
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
  int car_x, car_y;
  cin>>car_x>>car_y;
  for(int i=0; i<m; i++){
    int st_row, st_col, end_row, end_col;
    cin >> st_row >> st_col >> end_row >> end_col;
    st_row--;
    st_col--;
    end_row--;
    end_col--;
    info[i].push_back({st_row, st_col});
    info[i].push_back({end_row, end_col});
  }
  
  sort(info.begin(), info.end());
  
  bool pos = solve(info, car_x, car_y, fuel, 0);
  int ans = pos ? fuel : -1;
  cout<<ans;
  return 0;
}