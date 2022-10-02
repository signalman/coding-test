#include <iostream>
#include <algorithm>
using namespace std;
int gcd(int a, int b) {
    while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}

int lcm(int a, int b) {
    return a * b / gcd(a, b);
}

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);

  int test;
  cin>>test;
  for(int i=0; i<test; i++){
    int n,m,x,y,j;
    cin>>m>>n>>x>>y;
  int limit = lcm(m, n);
        for (j = x; j <= limit; j += m) {
            int temp = (j%n == 0) ? n : j % n;
            if (temp == y) {
                printf("%d\n", j);
                break;
            }
        }
        if (j > limit)
            printf("-1\n");
  }
}
