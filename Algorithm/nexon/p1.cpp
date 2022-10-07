#include <bits/stdc++.h>
using namespace std;
vector<int> getWays(vector<int> nvalues) {
    vector<int> ret;
    int SIZE = 1000001;
    int mod = 1e9;
    long long dp[1000001]={0,};
    dp[1] = 2;
    dp[2] = 9;
    dp[3] = 32;
    for(int i=4; i<1000001; i++){
        dp[i] = (4 * dp[i-1]) % mod - dp[i-2] + 2 * pow(-1, i);
        dp[i] = dp[i] % mod;
    }
    for(int n: nvalues){
        ret.push_back(dp[n]);
        cout<<dp[n];
    }
    return ret;
}

int main()
{    
    vector<int> nvalues = {1, 2, 3, 4, 5};
    vector<int> ways;
    ways = getWays(nvalues);

    for(auto i: ways){
        cout<< i <<" ";
    }

}