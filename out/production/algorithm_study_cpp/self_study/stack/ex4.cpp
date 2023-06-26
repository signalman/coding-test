#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main()
{
  int n;
  stack<int> stack;
  cin >> n;
  int x;
  int max = 0;
  string a;
  for (int i = 1; i <= n; i++)
  {
    cin >> x;
    if (a == "NO")
    {
    }
    else
    {
      if (stack.empty())
      {
        for (int j = i; j <= x; j++)
        {
          stack.push(j);
          a += '+';
        }
        stack.pop();
        a += '-';
        max = x;
      }
      else
      {
        if (stack.top() > x)
        {
          a.clear();
          a = "NO";
        }
        else if (stack.top() == x)
        {
          stack.pop();
          a += '-';
        }
        else if (stack.top() < x)
        {
          for (int j = max + 1; j <= x; j++)
          {
            stack.push(j);
            a += '+';
          }
          stack.pop();
          a += '-';
          max = x;
        }
      }
    }
  }
  if (a == "NO")
  {
    cout << a << '\n';
  }
  else
  {
    for (int i = 0; i < a.length(); i++)
    {
      cout << a.at(i) << '\n';
    }
  }
  return 0;
}