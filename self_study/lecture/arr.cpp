#include <iostream>
#include <string>
using namespace std;

int main(){
  cout<< "Enter your name: ";
  string name;
  getline(cin, name);
  cout<< "Enter you age: ";
  string age;
  getline(cin, age);
  cout<< "Your name is " << name << " and your age is " << age;
  
  
  return 0;
}