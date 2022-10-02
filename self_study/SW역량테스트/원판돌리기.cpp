#include <bits/stdc++.h>
using namespace std;

int n, m, t;
int disk[51][51];

void solve(int x, int d, int k){
  int select = x - 1;
  if(d==1) k = -k;
  while(select<n){
    //회전 시키기
    int temp[51] = {0,};
    //temp에 회전시킨 disk 복사
    for(int i=0; i<m; i++){
      temp[(i+k+m)%m] = disk[select][i];
    }
    //disk에 temp배열 대로 값 집어넣기
    for(int i=0; i<m; i++){
      disk[select][i] = temp[i];
    }
    select += x;
  }
  //disk에 인접한 수 찾기
  bool flag = false;
  bool check[51][51] = {0,};
  int dx[4] = {0, 0, -1, 1};
  int dy[4] = {1, -1, 0, 0};
  for(int x=0; x<n; x++){
    for(int y=0; y<m; y++){
      if(disk[x][y] == -1) continue;
      for(int d=0; d<4; d++){
        int nx = x + dx[d];
        int ny = (y + dy[d] + m) % m; // 같은 원판 위에서 인접한 수를 체크하기 위한 모듈러연산
        if(nx<0 || nx>=n)continue;
        if(disk[x][y] != -1 && disk[nx][ny] != -1 && disk[x][y] == disk[nx][ny]){
          check[x][y] = true;
          check[nx][ny] = true;
          flag = true;
        }
      }
    }
  }

  if(flag){
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        // if(disk[i][j] == -1) continue;
        if(check[i][j]) disk[i][j] = -1;
      }
    }
  }
  else{
    int sum = 0;
    int cnt = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(disk[i][j] == -1) continue;
        sum += disk[i][j];
        cnt++;
      }
    }
    float avg = sum/float(cnt);
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(disk[i][j] == -1) continue;
        if(disk[i][j] > avg) disk[i][j]--;
        else if(disk[i][j] < avg) disk[i][j]++;
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
      if(disk[i][j]==-1)continue;
      ans+=disk[i][j];
    }
  }
  cout<<ans;
  return 0;
}