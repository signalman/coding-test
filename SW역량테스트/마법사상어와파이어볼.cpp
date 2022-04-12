#include <bits/stdc++.h>
using namespace std;

int dx[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int n, m, k;
struct fireball{
  int r, c, m, s, d;
};
vector<fireball> v;
vector<fireball> MAP[51][51];
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m>>k;
  for(int i=0; i<m; i++){
    int r, c, m, s, d;
    cin>>r>>c>>m>>s>>d;
    r--,c--;
    fireball f;
    f.r = r;
    f.c = c;
    f.m = m;
    f.s = s;
    f.d = d;
    v.push_back(f);
  }
  while(k--){
    //MAP초기화
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        MAP[i][j].clear();
      }
    }
    //파이어 볼의 방향으로 속력만큼 이동
    for(int i =0; i<v.size(); i++){
      v[i].r = (v[i].r + (((v[i].s)%n)*(dx[v[i].d]))+n ) % n;
      v[i].c = (v[i].c + (((v[i].s)%n)*(dy[v[i].d]))+n ) % n;
    }
    for(int i=0; i<v.size(); i++){
      MAP[v[i].r][v[i].c].push_back(v[i]);
    }
    vector<fireball> tmp;
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(MAP[i][j].size()==0)continue;
        else if(MAP[i][j].size()==1) tmp.push_back(MAP[i][j][0]);
        else {
          int mess=0, speed=0, dir;
          bool flag = MAP[i][j][0].d % 2;
          bool checker = true;
          for(int k=0; k<MAP[i][j].size(); k++){
            mess += MAP[i][j][k].m;
            speed += MAP[i][j][k].s;
            if(flag != MAP[i][j][k].d % 2) checker = false;
          }

          mess /= 5;
          speed /= MAP[i][j].size();
          if(mess == 0) continue;
          int plus = checker ? 0 : 1;
          for(int n =0; n<4; n++){
            fireball newfireball;
            newfireball.r = i;
            newfireball.c = j;
            newfireball.m = mess;
            newfireball.s = speed;
            newfireball.d = n*2 + plus;
            tmp.push_back(newfireball);
          }
        }
      }
    }
    v = tmp;
  }
  int ans = 0;
  for(int i=0; i<v.size(); i++){
    ans += v[i].m;
  }
  cout<<ans;
}