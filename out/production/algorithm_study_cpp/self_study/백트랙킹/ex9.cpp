#include <bits/stdc++.h>
#include <iostream>

using namespace std;

int main(){
  int a[4] = {0, 0, 1, 1};
  do{
    for(int i=0; i<4; i++){
      if(a[i] == 0) cout<<i+1;
    }
    cout<<'\n';
  }while(next_permutation(a, a+4));
}