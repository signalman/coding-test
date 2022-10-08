#include <bits/stdc++.h>
using namespace std;

int a,b,c;
int arr[10];

int main(){
  cin>>a>>b>>c;
  int sum= a*b*c;
  string a = to_string(sum);
  for(char c: a){
    arr[c-'0']++;
  }
  for(int i=0; i<=9; i++){
    cout<<arr[i]<<'\n';
  }
}