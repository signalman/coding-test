#include <bits/stdc++.h>
using namespace std;

int n;
int board[25][25];
vector<int> members;
vector<int> mask;

int comp(vector<int> t1, vector<int> t2){
  int sum1 = 0;
  int sum2 = 0;
  for(int i=0; i<t1.size(); i++){
    for(int j=0; j<t1.size(); j++){
      sum1+=board[t1[i]][t1[j]];
    }
  }
  for(int i=0; i<t2.size(); i++){
    for(int j=0; j<t2.size(); j++){
      sum2+=board[t2[i]][t2[j]];
    }
  }
  return abs(sum1-sum2);
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
      members.push_back(i);
    }
  }
  mask.resize(n);
  fill(mask.begin(), mask.end(), true);
  for(int i=0; i<n/2; i++){
    mask[i] = false;
  }

  int mn = 0x7f7f7f7f;

  //팀가르기
  do{
    vector<int> team1;
    vector<int> team2;
    for(int i=0; i<n; i++){
      if(!mask[i]) team1.push_back(i);
      else team2.push_back(i);
    }
    comp(team1, team2);
    mn = min(mn, comp(team1, team2));

  }while(next_permutation(mask.begin(), mask.end()));
  cout<<mn;
}