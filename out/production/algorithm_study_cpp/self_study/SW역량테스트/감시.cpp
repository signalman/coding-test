#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int board1[10][10];
int board2[10][10];
int n, m;
int  mn;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
vector<pair<int, int>> cctv;

bool OOB(int x, int y)
{
  return (x < 0 || y < 0 || x >= n || y >= m);
}
void upd(int x, int y, int dir)
{
  dir %= 4;
  while(true){
    x += dx[dir];
    y += dy[dir];
    if(OOB(x, y) || board2[x][y] == 6) return;
    if(board2[x][y] != 0) continue;
    board2[x][y] = -1;
  }
}

int main()
{
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < m; j++)
    {
      cin >> board1[i][j];
      if(board1[i][j]==0) mn++;
      if (board1[i][j] != 0 && board1[i][j] != 6)
        cctv.push_back({i, j});
    }
  }
  for (int brute = 0; brute < (1 << 2 * cctv.size()); brute++)
  {
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        board2[i][j] = board1[i][j];
      }
    }
    int temp = brute;
    for (int i = 0; i < cctv.size(); i++)
    {
      int dir = temp % 4;
      temp /=4;
      int x = cctv[i].X;
      int y = cctv[i].Y;
      if (board1[x][y] == 1)
      {
        upd(x, y, dir);
      }
      else if (board1[x][y] == 2)
      {
        upd(x, y, dir);
        upd(x, y, dir+2);
      }
      else if (board1[x][y] == 3)
      {
        upd(x, y, dir);
        upd(x, y, dir+1);
      }
      else if (board1[x][y] == 4)
      {
        upd(x, y, dir);
        upd(x, y, dir+1);
        upd(x, y, dir+2);
      }
      else if (board1[x][y] == 5)
      {
        upd(x, y, dir);
        upd(x, y, dir+1);
        upd(x, y, dir+2);
        upd(x, y, dir+3);
      }
    }
    int cnt = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(board2[i][j]==0) cnt++;
      }
    }
    mn = min(cnt, mn);
  }

  cout<<mn;
}