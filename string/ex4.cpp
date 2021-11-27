#include <iostream>
#include <string>

using namespace std;

int main()
{
  int T;
  int R;
  cin >> T;
  string S;
  for (int i = 0; i < T; i++)
  {
    cin >> R;
    cin >> S;
    for (int j = 0; j < S.length(); j++)
    {
      for (int i = 0; i < R; i++)
      {
        cout << S[j];
      }
    }
    cout<<'\n';
  }
  return 0;
}