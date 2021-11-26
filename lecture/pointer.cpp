#include <iostream>
using namespace std;

int main()
{
  int arr[15][15];
  int a, b;
  cin >> a >> b;
  int arr1[15];
  for (int i = 0; i < a; i++)
  {
    int cnt = 0;

    for (int j = 0; j < b; j++)
    {
      int num;
      cin >> num;
      cnt += num;
    }
    arr1[i] = cnt;
  }
  for (int i = 0; i < a; i++)
  {
    cout << arr1[i] << endl;
  }
  return 0;
}