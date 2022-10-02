#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
// int n;
// int red[4][4];
// int blue[4][6];
// int green[6][4];
// int scores;
// void play(int t, int x, int y){
//   int score = 0;
//   //초록과 파랑으로 이동
//   queue<pair<int, int>> bQ;
//   queue<pair<int, int>> gQ;
//   if(t==1){
//     bQ.push({x, 0});
//     gQ.push({0, y});
//     while(!bQ.empty()){
//       auto cur = bQ.front();
//       bQ.pop();
//       int nx = cur.X;
//       int ny = cur.Y + 1;
//       if(ny >= 6 || blue[nx][ny] == 1) {blue[cur.X][cur.Y] = 1; break;}
//       bQ.push({nx, ny});
//     }
//     while(!gQ.empty()){
//       auto cur = gQ.front();
//       gQ.pop();
//       int nx = cur.X + 1;
//       int ny = cur.Y;
//       if(ny >= 6 || green[nx][ny] == 1) {green[cur.X][cur.Y] = 1; break;}
//       gQ.push({nx, ny});
//     }
//   }
//   else if(t==2){
//     bQ.push({x, 1});
//     gQ.push({0, y});
//     while(!bQ.empty()){
//       auto cur = bQ.front();
//       bQ.pop();
//       int nx = cur.X;
//       int ny = cur.Y + 1;
//       if(ny >= 6 || blue[nx][ny] == 1) {blue[cur.X][cur.Y] = 1; blue[cur.X][cur.Y-1] = 1; break;}
//       bQ.push({nx, ny});
//     }
//     while(!gQ.empty()){
//       auto cur = gQ.front();
//       gQ.pop();
//       int nx = cur.X + 1;
//       int ny = cur.Y;
//       if(ny >= 6 || green[nx][ny] == 1 || green[nx][ny+1]==1) {green[cur.X][cur.Y] = 1; green[cur.X][cur.Y+1]=1; break;}
//       gQ.push({nx, ny});
//     }
//   }
//   else if(t==3){
//     bQ.push({x, 0});
//     gQ.push({0, y});
//     while(!bQ.empty()){
//       auto cur = bQ.front();
//       bQ.pop();
//       int nx = cur.X;
//       int ny = cur.Y + 1;
//       if(ny >= 6 || blue[nx][ny] == 1 || blue[nx+1][ny]==1) {blue[cur.X][cur.Y] = 1; blue[cur.X+1][cur.Y] = 1; break;}
//       bQ.push({nx, ny});
//     }
//     while(!gQ.empty()){
//       auto cur = gQ.front();
//       gQ.pop();
//       int nx = cur.X + 1;
//       int ny = cur.Y;
//       if(ny >= 6 || green[nx][ny] == 1) {green[cur.X][cur.Y] = 1; green[cur.X-1][cur.Y]=1; break;}
//       gQ.push({nx, ny});
//     }
//   }
//   //파란색 판의 한줄 검사
//   for(int j=0; j<6; j++){
//     bool flag = true;
//     int right = j;
//     for(int i=0; i<4; i++){
//       if(blue[i][j] != 1) flag = false;
//     }
//     if(flag){
//       for(int i=0; i<4; i++){
//         blue[i][right] = 0;
//       }
//       for(int j=right-1; j>=0; j--){
//         for(int i=0; i<4; i++){
//           swap(blue[i][j], blue[i][j+1]);
//         }
//       }
//       score++;
//     }
//   }
//   //초록색 판의 한줄 검사
//   for(int i=0; i<6; i++){
//     bool flag = true;
//     int top = i;
//     for(int j=0; j<4; j++){
//       if(green[i][j] != 1) flag = false;
//     }
//     if(flag){
//       for(int j=0; j<4; j++){
//         green[top][j] = 0;
//       }
//       for(int i = top -1; i>=0; i--){
//         for(int j=0; j<4; j++){
//           swap(green[i][j], green[i+1][j]);
//         }
//       }
//       score++;
//     }
//   }

//   //special칸에 있는지 검사(파랑)
//   int cnt = 0;
//   for(int j=0; j<2; j++){
//     bool flag = true;
//     for(int i=0; i<4; i++){
//       if(blue[i][j] != 0) flag = false;
//     }
//     if(flag)  cnt++;
//   }
//   while(cnt--){
//     for(int i=0; i<4; i++){
//       blue[i][5] = 0;
//     }
//     for(int j=4; j>=0; j--){
//       for(int i=0; i<4; i++){
//         swap(blue[i][j], blue[i][j+1]);
//       }
//     }
//   }
//   //special칸에 있는지 검사(초록)
//   cnt = 0;
//   for(int i=0; i<2; i++){
//     bool flag = true;
//     for(int j=0; j<4; j++){
//       if(green[i][j] != 0) flag = false;
//     }
//     if(flag) cnt++;
//   }
//   while(cnt--){
//     for(int j=0; j<4; j++){
//       green[5][j] = 0;
//     }
//     for(int i=4; i>=0; i--){
//       for(int j=0; j<4; j++){
//         swap(green[i][j], green[i+1][j]);
//       }
//     }
//   }
// }
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  // cin>>n;
  // for(int i=0; i<n; i++){
  //   int x, y, t;
  //   for(int a=0; a<4; a++){
  //     fill(red[a], red[a]+4, 0);
  //   }
  //   cin>>t>>x>>y;
  //   play(t, x, y);
  // }

  // //타일의 개수
  // int ans = 0;
  // for(int i=0; i<6; i++){
  //   for(int j=0; j<4; j++){
  //     if(green[i][j] == 1) ans++;
  //   }
  // }
  // for(int i=0; i<4; i++){
  //   for(int j=0; j<6; j++){
  //     if(blue[i][j] == 1) ans++;
  //   }
  // }
  // cout<<scores<<'\n'<<ans;
  int board[12][12];
  for(int j=0; j<4; j++){
    for(int i=0; i<6; i++){
      cin>>board[i][j];
    }
  }
  for(int i=0; i<6; i++){
    for(int j=0; j<4; j++){
      cout<< board[i][j]<< ' ';
    }
    cout<<'\n';
  }
}