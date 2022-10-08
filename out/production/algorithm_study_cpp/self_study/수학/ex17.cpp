#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int cur_h, cur_m;
    int cook;
    cin>>cur_h>>cur_m;
    cin>>cook;

    int a = cook / 60;
    int b = cook % 60;

    cur_h += a;
    cur_m += b;

    if(cur_m >= 60){
        cur_h = cur_h + cur_m/60;
        cur_m = cur_m % 60;
    }
    cur_h = cur_h % 24;
    cur_m = cur_m % 60;
    cout<< cur_h << ' ' << cur_m;
    return 0;
}