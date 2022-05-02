#include <bits/stdc++.h>
using namespace std;
#define MAX 20
//비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
// 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
// 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.

int n;
int board[MAX][MAX];
int like_cnt[MAX][MAX];
int empty_cnt[MAX][MAX];
vector<vector<int>> v;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  int p = pow(n, 2);
  for(int i=0; i<p; i++){
    vector<int> v1;
    for(int j=0; j<5; j++){
      int a;
      cin>>a;
      v1.push_back(a);
    }
    v.push_back(v1);
  }
  for(int i=0; i<v.size(); i++){
    //인접한 칸에 좋아하는 학생의 수 CNT


    //인접한 칸 중 비어있는 칸이 가장 많은 칸 선택


    //행번호, 열번호 MIN 선택
  }


}