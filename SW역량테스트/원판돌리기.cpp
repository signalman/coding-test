#include <bits/stdc++.h>
using namespace std;

int n, m, t;
int disk[51][51];
void solve(int x, int d, int k){
  int select = x - 1;
  if(d==1)  k = -k;
  
  while(select < n){
    int temp[51] = {0, };
    for(int i=0; i<m; i++){
      temp[(i + k + m) % m] = disk[select][i];
    }
    for(int i=0; i<m; i++){
      disk[select][i] = temp[i];
    }
    select += x;
  }
  bool check[51][51] = {false, };
  bool flag = false;
  int dx[4] = {-1, 1, 0, 0};
  int dy[4] = {0, 0, -1, 1};
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      for(int d=0; d<4; d++){
        int nx = i + dx[d];
        int ny = (j + dy[d] + m) % m;
        if(nx < 0 || nx >= n)continue;
        if(disk[i][j] != -1 && disk[nx][ny] != -1 && disk[i][j] == disk[nx][ny]){
          flag = true;
          check[i][j] = true;
          check[nx][ny] = true;
        }
      }
    }
  }
  if(flag){
    //인접한 수 지우기
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(check[i][j]){
          disk[i][j] = -1;
        }
      }
    }
  }
  else{
    //원판에 적힌 수의 평균 구하고 -1, +1
    int sum, cnt = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(disk[i][j] == -1)continue;
        sum += disk[i][j];
        cnt ++;
      }
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(disk[i][j] != -1){
          if(disk[i][j]*cnt > sum){
            disk[i][j]--;
          }
          else if(disk[i][j]*cnt < sum){
            disk[i][j]++;
          }
        }
      }
    }
  }

}
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m>>t;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>disk[i][j];
    }
  }
  while(t--){
    int x, d, k;
    cin>>x>>d>>k;
    solve(x, d, k);
  }
  int ans = 0;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(disk[i][j]==-1) continue;
      ans += disk[i][j];
    }
  }
  cout<<ans;
}