#include <bits/stdc++.h>
using namespace std;

int n;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n;
    vector<int> arr(n);
    for(int i=0; i<n; i++){
        arr[i] = i+1;
    }

    int step = 0;
    int curIdx = 0;

    while(arr.size() > 1){
        step++;
        int nxtIdx = (curIdx + step * step * step - 1) % arr.size();

    }

}