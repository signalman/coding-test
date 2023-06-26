#include <bits/stdc++.h>
using namespace std;

int arr[10];
int main(){
  string n;
  cin>>n;
  for(auto c: n){
    arr[c-'0']++;
  }
  int m=0;
  for(int i=0; i<6; i++)
    m=max(m, arr[i]);
  for(int i=7; i<9; i++)
    m=max(m, arr[i]);
  int s = arr[6] + arr[9];
  if(s%2==0){cout<< max(m, s/2);}
  else{ cout<< max(m, (s+1)/2);}
}