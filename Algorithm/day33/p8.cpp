#include <bits/stdc++.h>
using namespace std;

int T;
int arr[1002];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>T;
    for(int t=1; t<=T; t++){
        int test;
        cin>>test;
        fill(arr, arr+101, 0);
        for(int i=0; i<1000; i++){
            int score;
            cin>>score;
            arr[score]++;
        }
        int mx = 0;
        int ret = 100;
        for(int i=100; i>=0; i--){
            if(mx < arr[i]) {mx = arr[i]; ret = i;}
        }

        cout<<"#"<< t<<" "<< ret<<'\n';
    }
}