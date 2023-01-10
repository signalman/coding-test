#include <bits/stdc++.h>
using namespace std;

int arr[101][101];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    for(int test=0; test<10; test++){
        for(int i=0; i<100; i++) fill(arr[i], arr[i]+100, 0);
        int t;
        int mx = -0x7f7f7f7f;
        int ret = 0;
        cin>>t;

        for(int i=0; i<100; i++){
            ret = 0;
            for(int j=0; j<100; j++){
                cin>>arr[i][j];
                ret += arr[i][j];
            }
            mx = max(mx, ret);
        }

        for(int i=0; i<100; i++){
            ret = 0;
            for(int j=0; j<100; j++){
                ret += arr[j][i];
            }
            mx = max(mx, ret);
        }

        ret = 0;
        for(int i=0; i<100; i++){
            ret += arr[i][i];
        }
        mx = max(mx, ret);

        ret = 0;
        for(int i=0; i<100; i++){
            ret += arr[i][99-i];
        }
        mx = max(mx, ret);
        cout<<"#"<<t << " " << mx <<'\n';
    }

}