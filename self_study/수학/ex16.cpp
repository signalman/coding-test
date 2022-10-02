#include <bits/stdc++.h>
using namespace std;


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int t, h, w, n;
    cin>>t;
    for(int i=0; i<t; i++){
        cin>>h>>w>>n;
        int floor = (n-1)  % h + 1;
        int room = (n-1) / h + 1;
        if(room < 10 ) cout<< floor << 0 << room <<'\n';
        else cout << floor << room << '\n';
    }
    return 0;
}