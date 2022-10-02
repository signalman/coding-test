#include <iostream>
#include <cmath>

using namespace std;

int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  int n;
  int ret=1;
  cin>>n;
  if(n==0){cout<<1<<'\n';}
  else{
    for(int i=1; i<=n; i++){
      ret*=i;
    }
    cout<<ret<<'\n';  
  }

}