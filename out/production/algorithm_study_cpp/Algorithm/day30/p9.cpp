#include <bits/stdc++.h>
using namespace std;

int m, n; //조카의 수, 과자의 수
// vector<int> snacks(1000002);
int snacks[1000002];

bool solve(int x){
    if(x == 0) return true;
    long long cnt = 0;
    for(int i=0; i<n; i++){
        cnt += snacks[i] / x;
    }
    return cnt >= m;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>m>>n;
    for(int i=0; i<n; i++){
        cin>>snacks[i];
    }
    
    int st = 0;
    int en = *max_element(snacks, snacks + n);

    while(st < en){
        int mid = (st + en + 1) / 2;

        if(solve(mid)){
            st = mid;
        }
        else{
            en = mid - 1;
        }
    }
    cout<<st<<'\n';
}