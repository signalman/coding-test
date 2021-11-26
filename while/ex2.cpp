#include <iostream>
using namespace std;

int main()
{
  int a;
  int cnt = 0;
  cin >> a;
  int b = a;
  if (b < 10)
  {
    b = 11 * b;
    cnt += 1;
  }
  else
  {
    b = (b % 10) * 10 + ((b % 10) + (b / 10)) % 10;
    cnt += 1;
  }
  while (true)
  {
    if (b == a)
    {
      cout<<cnt;
      break;
    }
    else
    {
      if (b < 10)
      {
        b = 11 * b;
        cnt += 1;
      }
      else
      {
        b = (b % 10) * 10 + ((b % 10) + (b / 10)) % 10;
        cnt += 1;
      }
    }
  }
  return 0;
}