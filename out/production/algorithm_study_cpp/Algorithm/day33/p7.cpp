#include <bits/stdc++.h>
using namespace std;


int T;
int n, m;
int a[23];
int b[23];

void func(){
    int tmp[23];
    if(n > m){
        int temp = n;
        for(int i=0; i<n; i++){
            tmp[i] = a[i];
        }
        for(int i=0; i<m; i++){
            a[i] = b[i];
        }
        for(int i=0; i<n; i++){
            b[i] = tmp[i];
        }
        n = m;
        m = temp;
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>T;
    for(int test = 1; test <= T; test++){
        cin>>n>>m;
        int mx = -0x7f7f7f7f;
        for(int i=0; i<n; i++){
            cin>>a[i];
        }
        for(int i=0; i<m; i++){
            cin>>b[i];
        }
        func();
        //무조건 a < b
        int p = 0;
        while(p <= m-n){
            int ret = 0;

            for(int i=0; i<n; i++){
                ret += (a[i] * b[i+p]);
            }
            mx = max(mx, ret);
            p++;
        }
        cout<< "#"<< test << " " << mx <<'\n';
    }
    return 0;
}