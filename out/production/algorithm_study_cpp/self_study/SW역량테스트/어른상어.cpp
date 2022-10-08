#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
//위 아래 왼쪽 오른쪽
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
struct SHARK
{
  int x, y;
  int dir;
  int priority[4][4];
};
SHARK shark[401];

//상어 num 1~M, 1이 가장강함
//냄새 k번 이동하면 사라짐
int n, m, k;
int board[20][20][2]; // 상어의 NUM, 남은 유효시간

int main()
{
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < n; j++)
    {
      cin >> board[i][j][0];
      if (board[i][j][0] != 0)
      {
        board[i][j][1] = k;
        shark[board[i][j][0]].x = i;
        shark[board[i][j][0]].y = j;
      }
    }
  }
  // m개의 상어, 방향 입력
  for (int i = 1; i <= m; i++)
  {
    int d;
    cin >> d;
    d--;
    shark[i].dir = d;
  }
  //각 상어의 방향에 대한 우선순위 방향 입력
  for (int s = 1; s <= m; s++)
  {
    for (int i = 0; i < 4; i++)
    {
      for (int j = 0; j < 4; j++)
      {
        int dir;
        cin >> dir;
        dir--;
        shark[s].priority[i][j] = dir;
      }
    }
  }
  int test = 15;
  int time = 0;
  int flag = false;
  while (time <= 1000 && !flag)
  {
    time++;
    for (int s = 1; s <= m; s++)
    {
      //상어의 현재위치, 방향
      if (shark[s].x == -1)
        continue;
      int cx = shark[s].x;
      int cy = shark[s].y;
      int cd = shark[s].dir;
      bool empty = false;
      //상어의 다음위치, 방향
      for (int i = 0; i < 4; i++)
      {
        int nd = shark[s].priority[cd][i];
        int nx = cx + dx[nd];
        int ny = cy + dy[nd];
        if (nx < 0 || ny < 0 || nx >= n || ny >= n)
          continue;
        if (board[nx][ny][0] == 0)
        {
          //상어의 이동 처리
          empty = true;
          shark[s].x = nx;
          shark[s].y = ny;
          shark[s].dir = nd;
          break;
        }
      }
      // 냄새가 있는 칸으로 이동
      if (!empty)
      {
        for (int i = 0; i < 4; i++)
        {
          int nd = shark[s].priority[cd][i];
          int nx = cx + dx[nd];
          int ny = cy + dy[nd];
          if (nx < 0 || ny < 0 || nx >= n || ny >= n)
            continue;
          if (board[nx][ny][0] == s && board[nx][ny][1]>0)
          {
            shark[s].x = nx;
            shark[s].y = ny;
            shark[s].dir = nd;
            break;
          }
        }
      }
    }
    //같은 칸에 있는 상어 처리
    for (int s = 1; s <= m; s++)
    {
      if(shark[s].x == -1) continue;
      int x = shark[s].x;
      int y = shark[s].y;
      for (int t = s + 1; t <= m; t++)
      {
        if (x == shark[t].x && y == shark[t].y)
        {
          shark[t].x = -1;
          shark[t].y = -1;
        }
      }
      board[shark[s].x][shark[s].y][0] = s;
      board[shark[s].x][shark[s].y][1] = k;
    }

    int cnt = 0;
    for(int s = 1; s<=m; s++){
      if(shark[s].x != -1) cnt++;
    }
    if (cnt == 1)
    {
      flag = true;
      break;
    }

     //냄새 유효시간 처리
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {
        if (board[i][j][1] == 0)
          {board[i][j][0] = 0;
          continue;}
        board[i][j][1]--;
        if(board[i][j][1] == 0){
          board[i][j][0] = 0;
        }
      }
    }
    //유효시간 전체를 1 뺐으므로 현재 상어가 있는칸은 1을 다시 더해줘야한다.
    for(int s = 1; s<=m; s++){
      board[shark[s].x][shark[s].y][1]++;
    }
  }
  int ans = 0;
  ans = (time>1000) ? -1 : time;
  cout << ans;
  return 0;
}
