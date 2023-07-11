#include <bits/stdc++.h>
using namespace std;

int n, d, k, c;
int a[34000];
bool check[34000];
int ans;
int main(){
    cin>>n>>d>>k>>c;
    for(int i=0; i<n; i++){
        cin>>a[i];
    }
    for(int i=n; i<n+k-1; i++){
        a[i] = a[i-n];
    }

    for(int i=0; i<n; i++){
        fill(check, check+34000, false);
        bool flag = false;
        int cnt = 0;
        for(int j=i; j<k+i; j++){
            if(!check[a[j]]) {check[a[j]] = true; cnt++;}
            if(a[j] == c) flag = true;
        }
        if(!flag) cnt++;

        ans = max(ans, cnt);
    }
    cout<<ans;
    

}