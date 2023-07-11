#include <bits/stdc++.h>
using namespace std;

vector<int> a(1000002);
int c[1000002];
int n;
int main(){
    cin>>n;
    for(int i=0; i<n; i++){
        cin>>a[i];
        c[i] = a[i];
    }
    sort(a.begin(), a.begin()+n);
    vector<int> b;
    a.erase(unique(a.begin(), a.end()), a.end());
    
    for(int i=0; i<n; i++){
        cout<< lower_bound(b.begin(), b.end(), c[i]) - b.begin() << ' ';
    }

}