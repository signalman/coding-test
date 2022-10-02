#include <iostream>
#include <cstring>
using namespace std;

int main()
{
  int n;
  cin >> n;
  char arr[80]={0};
  for (int i = 0; i < n; i++)
  {
    int score = 0;
    int sum = 0;
    cin >> arr;
    for (int j = 0; j < strlen(arr); j++)
    {
      if (arr[j] == 'X'){score = 0;}
      else if (arr[j] == 'O'){score++;}
      sum += score;
    }

    cout << sum << "\n";
  }
  return 0;
}