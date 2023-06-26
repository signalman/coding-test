#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main(){
  int MAX = 1000005;
  vector<bool> v(MAX);
  v[0]=v[1]=true;
  for(int i=0; i<=sqrt(MAX); i++){
    if(v[i]==false){
      for(int j=2; j<=MAX/i; j++){
        v[i*j]=true;
      }
    }
  }

  int test_case;
  cin>>test_case;
  
  for(int i=0; i<test_case; i++){
    int n;
    int cnt=0;
    cin>>n;
    for(int j=2; j<=n/2; j++){
      if(!v[j]&&!v[n-j]){
        cnt++;
      } 
    }
    cout<<cnt<<'\n';
  }
  return 0;
}