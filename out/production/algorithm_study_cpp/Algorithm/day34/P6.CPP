#include <bits/stdc++.h>
using namespace std;

bool isPrime[4000001];
int n;
int main(){
    cin>>n;
    fill(isPrime, isPrime+n+1, true);

    for(int i=2; i<=n; i++){
        if(!isPrime[i]) continue;
        for(int j=i*2; j<=n; j += i){
            isPrime[j] = false;
        }
    }

    vector<int> nums;
    for(int i=2; i<=n; i++){
        if(isPrime[i]) nums.push_back(i);
    }

    vector<long long> sums;
    long long sum = 0;
    for(auto i: nums){
        sums.push_back(sum+=i);
    }
    int ans = 0;
    sort(sums.begin(), sums.end());
    if(binary_search(sums.begin(), sums.end(), n)) ans++;
    for(int i=0; i<sums.size(); i++){
        if(binary_search(sums.begin() + i, sums.end(), n+sums[i])) ans++;
    }
    cout<<ans;
}