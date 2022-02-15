#include <bits/stdc++.h>
using namespace std;

int n, l;
int board[105][105];

bool check(vector<int>& line){
  int cnt = 1;
  int idx = 0;
  while(idx<n-1){
    if(abs(line[idx]-line[idx+1]) >1) return false;
    if(line[idx] == line[idx+1]) {cnt++; idx++;}
    else if(line[idx] < line[idx+1]){
      if(cnt<l) return false;
      cnt = 1;
      idx++;
    }
    else{
      if(idx+l>n) return false;
      for(int i=idx+1; i<idx+l; i++){
        if(line[i] != line[i+1]) return false;
      }
      idx = idx + l;
      cnt = 0;
    }
  }
  return true;
}


int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>l;

  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
    }
  }
  int ans=0;
  for(int i=0; i<n; i++){
    vector<int> line;
    for(int j=0; j<n; j++){
      line.push_back(board[i][j]);
    }
    ans += check(line);
  }
  for(int i=0; i<n; i++){
    vector<int> line;
    for(int j=0; j<n; j++){
      line.push_back(board[j][i]);
    }
    ans += check(line);
  }

  cout<<ans;
}