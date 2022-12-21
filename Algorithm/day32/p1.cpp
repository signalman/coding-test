#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    int a[100002];

    cin>>n;
    for(int i=0; i<n; i++){
        cin>>a[i];
    }
    sort(a, a+n);
    cin>>m;
    for(int i=0; i<m; i++){
        int num;
        cin>>num;
        if(binary_search(a, a+n, num)) cout<<1<<'\n';
        else cout<<0<<'\n';
    }
}