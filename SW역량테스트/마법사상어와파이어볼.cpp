#include <bits/stdc++.h>
using namespace std;

int dx[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int n, m, k;
struct fireball{
  int r, c, m, s, d;
};
vector<fireball> v;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m>>k;
  for(int i=0; i<m; i++){
    int r, c, m, s, d;
    cin>>r>>c>>m>>s>>d;
    fireball f;
    f.r = r;
    f.c = c;
    f.m = m;
    f.s = s;
    f.d = d;
    v.push_back(f);
  }
  while(k--){
    //파이어 볼의 방향으로 속력만큼 이동
    for(int i =0; i<v.size(); i++){
      v[i].r = (v[i].r + v[i].s + dx[v[i].d]) % m;
      v[i].c = (v[i].c + v[i].s + dy[v[i].d]) % m;
    }
    sort(v.begin(), v.end());
    vector<fireball> rep;
    vector<fireball> clone;
    rep.push_back(v[0]);
    for(int i=1; i<v.size(); i++){
      if(rep[i-1].r == v[i].r && rep[i-1].c == v[i].c){
        rep.push_back(v[i]);
      }
      else{
        if(rep.size()){
          //중복 파이어볼 처리
        }
        else{
          clone.push_back(v[i-1]);
        }
      }
    }


  }
  int ans = 0;
  for(int i=0; i<v.size(); i++){
    ans += v[i].m;
  }
  cout<<ans;
}