#include <iostream>
#include <vector>
using namespace std;

int gcd(int a, int b){
  if(a>=b){
    if(a%b==0){
      return b;
    }
    else{
      return gcd(b,a%b);
    }
  }
  else{return gcd(b,a);}
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int case_num;
  int num;

  int test_case;
  cin>>test_case;

  for(int i=0; i<test_case; i++){ //100
    long long sum=0;
    cin>>case_num;
    vector<int> v(case_num);
    if(case_num>1){
      for(int j=0; j<case_num; j++){ //100
        cin>>v[j];
        if(j>=1){
          for(int k=0; k<j; k++){
            sum+=gcd(v[j],v[k]);
          }
        }
      }
      cout<<sum<<'\n';
    }
    else{
      cin>>v[0];
      cout<<v[0]<<'\n';
    }
  }
}