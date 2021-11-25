#include <iostream>
using namespace std;

class MyClass
{
public:
  MyClass() : num(cnt++), ch('\0') {}
  void Check(MyClass *ptr)
  {
    if (ptr + num = this)
    {
      cout << num << endl;
    }
  }
  static int cnt;

private:
  int num;
  char ch;
};
int MyClass::cnt = 0;

int main(){

  MyClass obj[5];
  cout<<"Test #1 : " <<endl;
  

  return 0;
}
