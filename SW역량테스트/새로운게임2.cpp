#include <bits/stdc++.h>
using namespace std;

const int dx[] = {0, 0, -1, 1};
const int dy[] = {1, -1, 0, 0};
int n, k;
int color[12][12];
int board[12][12][5];

struct POS {
  int x, y, d;
};
int pos_size;
POS pos[10];

int turn(int index){
  POS cur = pos[index];
  POS next;
  next.x = cur.x + dx[cur.d];
  next.y = cur.y + dy[cur.d];
  next.d = cur.d;

  if(next.y < 0 || next.y>=n || next.x>=n || next.x<0 || color[next.x][next.y] == 2){
    next.d = (cur.d==0 || cur.d ==2) ? (cur.d + 1) : (cur.d - 1);
    next.x = cur.x + dx[next.d];
    next.y = cur.y + dy[next.d];
    pos[index].d = next.d;
    if(next.y < 0 || next.y>=n || next.x>=n || next.x<0 || color[next.x][next.y] == 2){
      return board[cur.x][cur.y][0];
    }
  }
  int bottom = -1;
  int& cur_size = board[cur.x][cur.y][0];
  for(int i=1; i<=cur_size; i++){
    if(board[cur.x][cur.y][i] == index){
      bottom = i;
      break;
    }
  }
  int move[5] = {0, };
  int& move_size = move[0];
  for(int i=bottom; i<=cur_size; i++){
    move[++move_size] = board[cur.x][cur.y][i];
  }
  cur_size = bottom - 1;
  if(color[next.x][next.y] == 1){
    for(int i=1; i<=move_size/2; i++){
      swap(move[i], move[move_size-i+1]);
    }
  }

  int& next_size = board[next.x][next.y][0];
  for(int i =1; i<=move_size; i++){
    board[next.x][next.y][++next_size] = move[i];
    pos[move[i]].x = next.x;
    pos[move[i]].y = next.y;
    if(next_size>=4) return next_size;
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
    --x, --y, --d;
    pos[pos_size].x = x;
    pos[pos_size].y = y;
    pos[pos_size].d = d;
    int& size = board[x][y][0];
    board[x][y][++size] = pos_size;
    pos_size++;
  }

  int loop = 0, ret = -1;
  while(loop <= 1000 && ret ==-1){
    ++loop;
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

