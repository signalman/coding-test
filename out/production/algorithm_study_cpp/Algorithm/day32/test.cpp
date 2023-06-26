#include <bits/stdc++.h>
using namespace std;

int main(){
    vector<int> v(6);

    for(int i=0; i<6; i++) v[i] = i+3;
    for(auto i: v){
        cout<<i << ' ';
    }cout<<'\n';

    cout<<upper_bound(v.begin(), v.end(), 7) - v.begin();
}