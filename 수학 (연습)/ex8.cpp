#include <bits/stdc++.h>
using namespace std;

long long a, b, c;
long long sum;

void multi(long long x, long long y){
    if(y==b) return;
    sum = (sum * x) % c;
    multi(x, y+1);
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>a>>b>>c;
    sum = a;
    multi(a, 0);
    cout<<sum<<'\n';

}