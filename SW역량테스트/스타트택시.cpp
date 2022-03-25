#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int n, m, fuel;
int board[21][21];
int cnt;
vector<vector<pair<int, int>>> info;

bool solve(vector<vector<pair<int, int>>> info, int car_x, int car_y, int fuel){
  if(info.empty()){
    return true;
  }
  //가장 가까운 승객 찾기
  //info 행, 열 순으로 정렬해놓기
  //dist()함수를 만들어 승객과 택시사이의 거리를 반환하는 함수생성
  //가장 작은것을 고름

  //dist와 연료를 비교하여 가능한지 판단

  //불가능 -> return;
  //가능하다면 택시가 승객 위치로 이동, 남아있는 fuel 수정

  //택시와 목적지거리, 연료 비교하여 가능한지 판단
  //불가능 -> return;
  //가능하다면 택시가 목적지 위치로 이동 후 fuel 조정 후 erase

  
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

  solve(info, car_x, car_y, fuel);
}