#include <bits/stdc++.h>
using  namespace std;

typedef long long ll;
queue<int> Q;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ll n;
  cin>>n;
  while(n--){
    string s;
    cin>>s;
    if(s=="push"){
      int n;
      cin>>n;
      Q.push(n);
    }
    else if(s=="pop"){
      if(!Q.empty()){cout<<Q.front()<<'\n'; Q.pop();}
      else cout<<-1<<'\n';
    }
    else if(s=="size"){
      cout<<Q.size()<<'\n';
    }
    else if(s=="empty"){
      cout<<Q.empty()<<'\n';
    }
    else if(s=="front"){
      if(!Q.empty()){cout<<Q.front()<<'\n';}
      else cout<<-1<<'\n';
    }
    else if(s=="back"){
      if(!Q.empty()){cout<<Q.back()<<'\n';}
      else cout<<-1<<'\n';
    }
  }
}