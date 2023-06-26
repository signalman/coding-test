#include <bits/stdc++.h>
using namespace std;


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int t, h, w, n;
    cin>>t;
    for(int i=0; i<t; i++){
        cin>>h>>w>>n;
        int a = n % h;
        int b = n / h + 1;
        string s;
        
        if(b<10){
            s = to_string(a) + '0' + to_string(b);
        }
        else{
            s = to_string(a) + to_string(b);
        }
        cout<<s<<'\n';
    }
    return 0;
}