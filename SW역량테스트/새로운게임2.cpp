#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};
int n, k;
int color[13][13];//맵의 색깔을 저장하는 2차원 배열 (흰->빨->파)
int states[13][13][5]; //맵의 상태를 저장하는 3차원 배열
//마지막 5개의 idx에는 0번째 idx = 쌓인 구슬의 크기, 1번째 idx부터는 쌓인 구슬의 idx
struct pieces{
  int x, y;
  int dir;
};
vector<pieces> v; //구슬의 정보를 저장하는 벡터(구슬의 위치, 방향, 구슬의 IDX)

//idx번 구슬을 움직이는 함수
int turn(int idx){
  int curX = v[idx].x;
  int curY = v[idx].y;
  int curDir = v[idx].dir;
  int nx = curX + dx[curDir];
  int ny = curY + dy[curDir];

  //이동하려는 칸이 파란색이거나 벗어나는 경우
  if(nx<0||ny<0||nx>=n||ny>=n || color[nx][ny] == 2){
    if(curDir == 0 || curDir ==2){curDir++;}
    else{curDir--;}
    nx = curX + dx[curDir];
    ny = curY + dy[curDir];
    
  }


}




int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>k;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>color[i][j];
    }
  }
  for(int i=0; i<k; i++){
    int row, col, dir;
    cin>>row>>col>>dir;
    row--;
    col--;
    dir--;
    v[i].x = row;
    v[i].y = col;
    v[i].dir = dir;
  }
  for(int i=0; i<v.size(); i++){
    int x = v[i].x;
    int y = v[i].y;
    int& size = states[x][y][0];
    states[x][y][++size] = i;
  }

  int val = 0;
  bool flag = false;
  while(val<=1000 && flag==false){
    val++;
    for(int i=0; i<v.size(); i++){
      if(turn(i)>=4){
        flag = true;
        break;
      }
    }
    if(flag) break;
  }
  int ans = (val >= 1000) ? -1: val;
  cout<<ans;
}