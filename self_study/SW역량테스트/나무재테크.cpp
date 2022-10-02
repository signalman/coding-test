#include <bits/stdc++.h>
using namespace std;
//봄: 자신의 나이만큼 양분을 먹는다
// 하나의 칸에 여러개의 나무 -> 나이가 어린 나무부터 먹는다
// 먹을수 없으면 죽는다
// 여름: 봄에 죽은 나무가 양분으로 변함, 나이/2 = 양분
// 가을: 나이가 5의 배수인 나무는 번식함. 인접한 8개의 칸에 나이 1인 나무 생성
// 겨울: 양분 추가

//n: 땅의 크기, m: 나무의 개수, k: 구해야하는 년수
int n, m, k;
int a[15][15];
int upd[15][15];
vector<tuple<int, int, int>> v;
int dx[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[8] = {-1, 0, 1, -1, 1, -1, 0, 1};

bool compare(tuple<int, int, int> a, tuple<int, int, int> b){
  return (get<2>(a) < get<2>(b));
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m>>k;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=n; j++){
      cin>>upd[i][j];
      a[i][j] = 5;
    }
  }
  
  while(m--){
    int x, y, z;
    cin>>x>>y>>z;
    v.push_back({x, y, z});
  }

  while(k--){
    vector<tuple<int, int, int>> v1;
    vector<tuple<int, int, int>> v2;
    //봄
    sort(v.begin(),v.end(),compare);
    for(int i=0; i<v.size(); i++){
      int row = get<0>(v[i]);
      int col = get<1>(v[i]);
      int age = get<2>(v[i]);
      if(a[row][col]<age) {v1.push_back({row, col, age}); continue;}
      a[row][col] -= age;
      age++;
      v2.push_back({row, col, age});
    }
    //여름
    for(int i=0; i<v1.size(); i++){
      int row = get<0>(v1[i]);
      int col = get<1>(v1[i]);
      int age = get<2>(v1[i]);
      a[row][col] += age/2;
    }

    //가을
    for(int i=0; i<v2.size(); i++){
      int row = get<0>(v2[i]);
      int col = get<1>(v2[i]);
      int age = get<2>(v2[i]);
      if(age%5) continue;
      for(int dir = 0; dir <8; dir++){
        int nrow = row + dx[dir];
        int ncol = col + dy[dir];
        if(nrow<1||ncol<1||nrow>n||ncol>n)continue;
        v2.push_back({nrow, ncol, 1});
      }
    }

    //겨울
    for(int i=1; i<=n; i++){
      for(int j=1; j<=n; j++){
        a[i][j] += upd[i][j];
      }
    }
    v.clear();
    v.assign(v2.begin(), v2.end());
    // copy(v2.begin(), v2.end(), v.begin());
  }

  cout<<v.size();
  
}