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

    long long step = 0;
    long long curIdx = 0;

    while(arr.size() > 1){
        step++;
        long long nxtIdx = (curIdx + (step * step * step - 1) % arr.size()) % arr.size();
        // cout<<"erased Number: " << arr[nxtIdx]<<'\n';
        vector<int>::iterator nxtStepIter = arr.erase(arr.begin() + nxtIdx);
        curIdx = nxtStepIter - arr.begin();
    }
    cout<<arr.front();
}