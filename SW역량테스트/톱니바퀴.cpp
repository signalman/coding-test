#include <bits/stdc++.h>
using namespace std;

char t[4][8];
void rot(int row, int dir){
  if(dir==1){
    int temp = t[row][8];
    for(int i=7; i>=1; i--){
      t[row][i+1] = t[row][i];
    }
    t[row][1] = temp;
  }
  else{
    int temp = t[row][1];
    for(int i=2; i<=8; i++){
      t[row][i-1] = t[row][i];
    }
    t[row][8] = temp;
  }
}
bool ischeck(int idx_1, int idx_2){
  if(idx_1 > idx_2){
    if(t[idx_1][7] != t[idx_2][3]) return true;
  }
  else{
    if(t[idx_2][7] != t[idx_1][3]) return true;
  }
  return false;
}
void func(int row, int dir){
  switch (row)
  {
  case 1:
    if(ischeck(row, row+1)){
      if(ischeck(row+1, row+2)){
        if(ischeck(row+2, row+3)){
          rot(row+3, -dir);
        }
        rot(row+2, dir);
      }
      rot(row+1, -dir);
    }
    rot(row, dir);
    break;
  case 2:
    if(ischeck(row, row-1)){
      rot(row-1, -dir);
    } 
    if(ischeck(row, row+1)){
      if(ischeck(row+1, row+2)){
        rot(row+2, dir);
      }
      rot(row+1, -dir);
    }
    rot(row, dir);
    break;
  case 3:
    if(ischeck(row, row-1)){
      if(ischeck(row-1, row-2)){
        rot(row-2, dir);
      }
      rot(row-1, -dir);
    } 
    if(ischeck(row, row+1)){
      rot(row+1, -dir);
    }
    rot(row, dir);
    break;
  case 4:
    if(ischeck(row, row-1)){
      if(ischeck(row-1, row-2)){
        if(ischeck(row-2, row-3)){
          rot(row-3, -dir);
        }
        rot(row-2, dir);
      }
      rot(row-1, -dir);
    }
    rot(row, dir);
    break;
  }
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  for(int i=1; i<=4; i++){
    for(int j=1; j<=8; j++){
      cin>>t[i][j];
    }
  }
  int k;
  cin>>k;
  while(k--){
    int a, b;
    cin>>a>>b;
    func(a, b);
  }

  int ans = t[1][1]-'0'+(t[2][1]-'0')*2+(t[3][1]-'0')*4+(t[4][1]-'0')*8;
  cout<<ans;

}