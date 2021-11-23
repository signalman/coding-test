#include <iostream>
using namespace std;

void print_no_space(const char str[]){
  for(int i =0; str[i]!='\0'; i++ ){
    if(str[i] != ' '){
      cout<<str[i];
    }
  }
  return;
}

int main(){
  print_no_space("Hello, World!\n");
  print_no_space("My name is Hoin\n");
  string a="hi my name";


  return 0;
}