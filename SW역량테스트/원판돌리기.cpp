#include <bits/stdc++.h>
using namespace std;

int n,m,t;
vector<deque<int>> disk(n);
vector<vector<int>> clone_disk;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m>>t;
  int num;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=m; j++){
      cin>>num;
      // disk[i].push_back(num);
    }
  }

  while(t--){
    int x, d, k;
    //x의 배수인 원판을 회전시킨다.
    cin>>x>>d>>k;
    for(int i=x; i<=n; i+=x){
      if(d==0){//시계방향
        int back = disk[i].back();
        disk[i].push_front(back);
        disk[i].pop_back();
      }
      else{//반시계 방향
        int front = disk[i].front();
        disk[i].push_back(front);
        disk[i].pop_front();
      }
    }
    memcpy(&clone_disk, &disk, sizeof(disk));
    //인접한 수를 모두 찾기
    bool flag = false;

    //같은 원판에서의 인접 확인
    for(int i=1; i<=n; i++){
      for(int j=1; j<m; j++){
        if(disk[i][j]==disk[i][j+1]){
          clone_disk[i][j] = -1;
          clone_disk[i][j+1] = -1;
          flag = true;
        }
      }
      if(disk[i][1] == disk[i][m]){
        clone_disk[i][1] = -1;
        clone_disk[i][m] = -1;
        flag = true;
      }
    }

    //인접한 원판에서의 인접 확인
    for(int i=1; i<n; i++){
      for(int j=1; j<=m; j++){
        if(disk[i][j] == disk[i+1][j]){
          clone_disk[i][j] = -1;
          clone_disk[i+1][j] = -1;
          flag = true;
        }
      }
    }
    //인접한 수가 없는 경우
    if(!flag){
      int sum = 0;
      int cnt = 0;
      for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
          if(disk[i][j]==-1)continue;
          sum += disk[i][j];
          cnt++;
        }
      }
      int avg = sum/cnt;
      for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
          if(disk[i][j] == -1) continue;
          if(disk[i][j] > avg) {
            disk[i][j]++;
          }
          else{
            disk[i][j]--;
          }
        }
      }
    }
    else{
      memcpy(&disk,&clone_disk, sizeof(clone_disk));
    }
  }
  int ans = 0;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=m; j++){
      if(disk[i][j]==-1)continue;
      ans+=disk[i][j];
    }
  }
  cout<<ans;

}