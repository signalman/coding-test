#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[1000004];

//���ܱ��� ���̸� x�� �������� �� ���� ��� �� �� �ִ� ������ m �̻�����
bool solve(long long x){
    long long cnt = 0;
    for(int i=0; i<n; i++){
        cnt += (arr[i] - x > 0) ? arr[i]-x : 0;
    }
    return cnt >= m;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>m;
    for(int i=0; i<n; i++){
        cin>>arr[i];
    }

    sort(arr, arr+n);
    int st = 0;
    int en = *max_element(arr, arr+n);
    while(st < en){
        long long mid = (st + en + 1) / 2;
        if(solve(mid)) st = mid;
        else en = mid - 1;
    }
    cout<<st;
}