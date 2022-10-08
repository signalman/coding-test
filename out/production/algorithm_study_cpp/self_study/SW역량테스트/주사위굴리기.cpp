#include <bits/stdc++.h>
using namespace std;

int n, m, x, y, k;
int board[21][21];
int dice[6];
//동, 서, 북, 남
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};

void move_dice(int dir){
  int ndice[6];
  switch (dir)
  {
  case 0:
    ndice[0] = dice[2];
    ndice[1] = dice[1];
    ndice[2] = dice[5];
    ndice[3] = dice[0];
    ndice[4] = dice[4];
    ndice[5] = dice[3];
    break;
  case 1:
    ndice[0] = dice[3];
    ndice[1] = dice[1];
    ndice[2] = dice[0];
    ndice[3] = dice[5];
    ndice[4] = dice[4];
    ndice[5] = dice[2];
    break;
  case 2:
    ndice[0] = dice[1];
    ndice[1] = dice[5];
    ndice[2] = dice[2];
    ndice[3] = dice[3];
    ndice[4] = dice[0];
    ndice[5] = dice[4];
    break;
  case 3:
    ndice[0] = dice[4];
    ndice[1] = dice[0];
    ndice[2] = dice[2];
    ndice[3] = dice[3];
    ndice[4] = dice[5];
    ndice[5] = dice[1];
    break;
  }
  for(int i=0; i<6; i++){
    dice[i] = ndice[i];
  }
}

int main()
{
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  cin >> n >> m >> x >> y >> k;
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < m; j++)
    {
      cin >> board[i][j];
    }
  }
  int dir;
  for (int i = 0; i < k; i++)
  {
    cin >> dir;
    dir--;
    int nx = x + dx[dir];
    int ny = y + dy[dir];
    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
      continue;
    move_dice(dir);
    if (board[nx][ny] == 0)
      board[nx][ny] = dice[5];
    else
    {
      dice[5] = board[nx][ny];
      board[nx][ny] = 0;
    }
    cout<<dice[0]<<'\n';
    x = nx, y = ny;
  }
}