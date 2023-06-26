#include <bits/stdc++.h>
using namespace std;


int stair(int a, int b){
    if(a == 0){
        return b;
    }
    else{
        int sum = 0;
        for(int i=1; i<=b; i++){
            sum += stair(a-1, i);
        }
        return sum;
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin>>t;
    for(int i=0; i<t; i++){
        int k, n;
        cin>>k>>n;
        cout<<stair(k, n)<<'\n';
    }
    return 0;
}