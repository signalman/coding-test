#include <bits/stdc++.h>
using namespace std;
//왼쪽, 아래, 오른쪽, 위
int dx[] = {0, 1, 0, -1};
int dy[] = {-1, 0, 1, 0};
int n; 
int MAP[500][500];
int sandX[4][10] = {
  {0, -1, 1, -2, -1, 1, 2, -1, 1, 0},
  {2, 1, 1, 0, 0, 0, 0, -1, -1, 1},
  {0, -1, 1, -2, -1, 1, 2, -1, 1, 0},
  {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1}
};
int sandY[4][10] = {
  {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1},
  {0, -1, 1, -2, -1, 1, 2, -1, 1, 0},
  {2, 1, 1, 0, 0, 0, 0, -1, -1, 1},
  {0, -1, 1, -2, -1, 1, 2, -1, 1, 0}
};
int rate[9] = {5, 10, 10, 2, 7, 7, 2, 1, 1};
int ans;
bool OOB(int x, int y){
  return !(x<0||y<0||x>=n||y>=n);
}

int wind(int dir, int x, int y){
  int ret = 0;
  int sand = MAP[x][y];
  for(int i=0; i<10; i++){
    int nx = x + sandX[dir][i];
    int ny = y + sandY[dir][i];
    if(i != 9){
      MAP[nx][ny] += sand * rate[i] / 100;
      MAP[x][y] -= sand * rate[i] / 100;
    }
    else{
      MAP[x + sandX[dir][i]][y + sandY[dir][i]] = MAP[x][y];
      MAP[x][y] = 0;
    }
  }
  return ret;


}

int ret;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>MAP[i][j];
    }
  }
  
  return 0;
}