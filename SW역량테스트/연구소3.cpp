#include <bits/stdc++.h>
using namespace std;

//0 : 빈칸, 1: 벽, 2: 바이러스

int n, m;
int board[51][51];
int board1[51][51];
vector<pair<int, int>> v;

void func(){
  int mask[11];

  do{
    for(int i=0; i<n; i++){
      fill(board1[i], board1[i] + n, 0);}
    

  }while(next_permutation(v.begin(), v.end()));



}


int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
      if(board[i][j] == 2){
        v.push_back({i, j});
      }
    }
  }



}