#include <bits/stdc++.h>
using namespace std;

int n;
int arr[1002];
int d[1002];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n;
    for(int i=0; i<n; i++){
        cin>>arr[i];
        d[i] = arr[i];
    }


    d[0] = arr[0];
    for(int i=1; i<n; i++){
        int mx = 0;
        for(int j=i-1; j>=0; j--){
            if(arr[i] > arr[j]) {mx = max(d[j], mx);}
        }
        d[i] = arr[i] + mx;
    }
    cout<<*max_element(d, d+n);

}