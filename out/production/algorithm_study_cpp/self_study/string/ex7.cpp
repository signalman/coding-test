#include <iostream>
#include <string>

using namespace std;

int main(){
  string a,b;
  string c,d;
  cin>>a>>b;
  for(int i=0; i<3; i++ ){
    c[i]=a[2-i];
  }
  for(int i=0; i<3; i++){
    d[i]=b[2-i];
  }
  int x = stoi(c);
  int y = stoi(d);
  if(x>y){
    cout<<x<<'\n';
  }
  else if(x<y){
    cout<<y<<'\n';
  }

  return 0;
}