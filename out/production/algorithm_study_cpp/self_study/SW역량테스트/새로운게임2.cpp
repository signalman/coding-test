#include <bits/stdc++.h>
using namespace std;

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

int n, k;
int color[13][13]; //체스판의 색깔 저장
struct POS {
  int x, y;
  int d;
};
int MAP[12][12][5]; //체스판의 상태 저장
POS pos[10];  //체스 말들의 상태 저장하는 배열
int pos_size; //체스 말의 번호

int turn(int index){
  POS cur = pos[index];
  POS next;
  next.x = cur.x + dx[cur.d];
  next.y = cur.y + dy[cur.d];
  next.d = cur.d;
  //파란색 판이거나 벽에 만났을 때
  if(next.x<0 || next.y<0 || next.x >=n || next.y>=n || color[next.x][next.y] == 2){
    next.d = (cur.d==0 || cur.d==2) ? cur.d + 1 : cur.d - 1;
    next.x = cur.x + dx[next.d];
    next.y = cur.y + dy[next.d];
    pos[index].d = next.d;
    //다시한번 파란색 판이거나 벽에 만났을 때
    if(next.x<0 || next.y<0 || next.x >=n || next.y>=n || color[next.x][next.y] == 2){
      return MAP[cur.x][cur.y][0];
    }
  }

  //이동시켜야 할 체스 말들 파악
  int bottom = -1;
  int& cur_size = MAP[cur.x][cur.y][0];
  for(int i=1; i<=cur_size; i++){
    if(MAP[cur.x][cur.y][i] == index){
      bottom = i;
      break;
    }
  }
  //이동시켜야 할 체스 말들 저장
  int move[5] = {0, };
  int& move_size = move[0]; //움직여야 하는 말의 개수
  for(int i=bottom; i<=cur_size; i++){
    move[++move_size] = MAP[cur.x][cur.y][i];
  }
  cur_size = bottom - 1;

  //빨간색 판을 만났을 때 -> move 배열의 순서 뒤집어야 함
  if(color[next.x][next.y] == 1){
    for(int i=1; i<=move_size/2; i++){
      swap(move[i], move[move_size - i + 1]);
    }
  }

  //이동시켜야 할 체스말 이동
  int& next_size = MAP[next.x][next.y][0];
  for(int i=1; i<=move_size; i++){
    MAP[next.x][next.y][++next_size] = move[i];
    pos[move[i]].x = next.x;
    pos[move[i]].y = next.y;
    if(next_size >= 4){
      return next_size;
    }
  }
  return next_size;
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
    int x, y, d;
    cin>>x>>y>>d;
    x--, y--, d--;
    pos[pos_size].x = x;
    pos[pos_size].y = y;
    pos[pos_size].d = d;
    int& size = MAP[x][y][0];
    MAP[x][y][++size] = pos_size;
    ++pos_size;
  }
  int loop = 0;
  int ret = -1;
  while(loop<=1000 && ret == -1){
    loop++;
    for(int i=0; i<k; i++){
      int h = turn(i);
      if(h>=4){
        ret = loop;
        break;
      }
    }
  }
  cout<<ret;

  return 0;
}