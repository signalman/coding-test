#include <iostream>
using namespace std;

int main()
{
  ios_base::sync_with_stdio(0);
  int n;
  cin >> n;
  int min = 1000000;
  int max(-1000000);
  for (int i = 0; i < n; i++)
  {
    int a;
    cin >> a;
    if (min > a)
    {
      min = a;
    }
    if (max < a)
    {
      max = a;
    }
  }
  cout << min << " " << max << '\n';
  return 0;
}