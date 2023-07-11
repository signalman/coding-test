#include <bits/stdc++.h>
using namespace std;

int m, n; //m 俺狼 快林, n俺狼 青己
int arr[101][10001];

void compress(int arr[]){
    vector<int> v(arr, arr+n);

    sort(v.begin(), v.end());
    v.erase(unique(v.begin(), v.end()), v.end());
    for(int i=0; i<n; i++){
        arr[i] = lower_bound(v.begin(), v.end(), arr[i]) - v.end();
    }
}

bool compare(int a[], int b[]){
    for(int i=0; i<n; i++){
        if(a[i] != b[i]) return false;
    }
    return true;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>m>>n;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            cin>>arr[i][j];
        }
    }

    for(int i=0; i<m; i++){
        compress(arr[i]);
    }
    int ans = 0;

    for(int i=0; i<m-1; i++){
        for(int j=i+1; j<m; j++){
            ans += compare(arr[i], arr[j]);
        }
    }
    cout<<ans;
}