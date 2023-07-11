#include <bits/stdc++.h>
using namespace std;

int n;
long long a[5001];
long long x = 0x7f7f7f7f, y= 0x7f7f7f7f, z= 0x7f7f7f7f;
int main(){
    cin>>n;
    for(int i=0; i<n; i++){
        cin>>a[i];
    }

    sort(a, a+n);
    for(int i=0; i<n-1; i++){
        for(int j=i+1; j<n; j++){

            int idx = lower_bound(a, a+n, -a[i]-a[j]) - a;

            for(int k=-2; k<=2; k++){
                if(idx + k < 0 || idx + k >= n) continue;
                if(idx + k == i || idx + k == j) continue;

                if(abs(x+y+z) > abs(a[idx + k] + a[i] + a[j])){
                    x = a[i];
                    y = a[j];
                    z = a[idx + k];
                }
            }
        }
    }
    long long arr[3] = {x, y, z};
    sort(arr, arr+3);
    cout<<arr[0] << " " << arr[1] << " " << arr[2];
}