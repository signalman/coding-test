#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
deque<pair<int, int>> dq;
int n, k;
//right, down, left, up
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

bool apple[101][101];
bool snake[101][101];
char head[10001];
int dir = 0;

void func(){
  int t = 0;
  dq.push_front({0,0});
  snake[0][0] = true;
  while(true){
    int x, y;  tie(x, y) = dq.front();
    int bx, by; tie(bx, by) = dq.back();
    t++;
    int nx = x + dx[dir];
    int ny = y + dy[dir];
    if(nx<0 || ny<0|| nx>=n||ny>=n) {cout<<t; return;}
    if(snake[nx][ny]){cout<<t; return;}
    if(apple[nx][ny]){
      snake[nx][ny] = true;
      dq.push_front({nx, ny});
      apple[nx][ny] = false;
    }
    else{
      snake[nx][ny] = true;
      dq.push_front({nx, ny});
      dq.pop_back();
      snake[bx][by] = false;
    }
    if(head[t]=='D') {dir += 1;}
    else if(head[t] == 'L') {dir += 3;}
    dir %= 4;
  }
}


int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>k;
  while(k--){
    int i, j;
    cin>>i>>j;
    apple[i-1][j-1] = 1;
  }
  int l;
  cin>>l;
  while(l--){
    int time; char c;
    cin>>time>>c;
    head[time] = c;
  }
  func();
}

