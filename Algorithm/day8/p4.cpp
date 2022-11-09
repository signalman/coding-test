#include <bits/stdc++.h>
using namespace std;

int n;
int arr[1001];
int vis[1001];
int main(){

    cin>>n;
    for(int i=0; i<n; i++){
        int t;
        cin>>t;
        arr[i] = t;
    }
    sort(arr, arr+n);
    dfs(arr);

    
    
}
void dfs(int arr[]){

}