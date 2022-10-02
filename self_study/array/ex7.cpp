#include <iostream>
using namespace std;

int main(){
  int C;
  cin>>C;

  for(int i=0; i<C;i++){
    int students;
    int sum=0;
    int cnt=0;
    cin>> students;
    int scores[1000]={0};
    for(int i=0; i<students; i++){
      cin>>scores[i];
      sum+=scores[i];
    }
    int avg=sum/float(students);
    for(int i=0; i<students; i++){
      if(avg<scores[i]){
        cnt++;
      }
    }
    cout<<fixed;
    cout.precision(3);
    cout<<cnt/float(students)*100<<"%"<<'\n';
  }
  return 0;
}