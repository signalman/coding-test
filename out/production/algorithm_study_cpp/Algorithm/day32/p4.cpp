#include <bits/stdc++.h>
using namespace std;

int arr[10004];
int k, n;

bool solve(long long x){
    long long cnt = 0;
    for(int i=0; i<k; i++){
        cnt += (arr[i]/x);
    }
    return cnt >= n;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>k>>n;
    for(int i=0; i<k; i++)cin>>arr[i];
    sort(arr, arr+k);
    long long st = 1;
    long long en = 0x7fffffff;
    while(st < en){
        long long mid = (st + en + 1) / 2; //한번더 보기

        if(solve(mid)) st = mid;
        else en = mid - 1;
    }
    cout<<st;
}