#include <bits/stdc++.h>
using namespace std;
//봄: 자신의 나이만큼 양분을 먹는다
// 하나의 칸에 여러개의 나무 -> 나이가 어린 나무부터 먹는다
// 먹을수 없으면 죽는다
// 여름: 봄에 죽은 나무가 양분으로 변함, 나이/2 = 양분
// 가을: 나이가 5의 배수인 나무는 번식함. 인접한 8개의 칸에 나이 1인 나무 생성
// 겨울: 양분 추가

int n, m, k;
int a[15][15];

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m>>k;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>a[i][j];
    }
  }
  while(m--){
    int x, y, z;
    cin>>x>>y>>z;
  }
}