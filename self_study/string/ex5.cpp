#include <iostream>
#include <string>
using namespace std;

int main(){
  string word;
  cin>>word;
  int ary1[26]={0};
  int ary2[26]={0};
  int ary[26]={0};
  for(char i='a'; i<='z'; i++){
    for(int j=0; j<word.length(); j++){
      if(i==word.at(j)){
        ary1[i-97]++;
      }
    }
  }
  for(char i='A'; i<='Z'; i++){
    for(int j=0; j<word.length(); j++){
      if(i==word.at(j)){
        ary2[i-65]++;
      }
    }
  }
  int max=0;
  int index=0;
  for(int i=0; i<26; i++){
    ary[i]=ary1[i]+ary2[i];
    if(max<ary[i]){
      max=ary[i];
      index=i;
    }
    else if(max==ary[i]){
      index=-2;
    }
  }
  cout<<char(index+65)<<endl;
  
}