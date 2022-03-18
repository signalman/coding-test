#include <bits/stdc++.h>
using namespace std;

int n,m,t;
vector<deque<int>> disk;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m>>t;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=m; j++){
      int num;
      cin>>num;
      disk[i].push_back(num);
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
    //인접한 수를 모두 찾기
    for(int i=1; i<=n; i++){
      for(int j=1; j<=m; j++){
        cout<<disk[i].front();
        disk[i].pop_front();
      }
      cout<<'\n';
    }
  }
}