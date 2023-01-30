#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[1001][1001];
int ans = 0x7f7f7f7f;
bool cmp(tuple<int,int,int> a, tuple<int, int, int> b){
    return get<0>(a) < get<0>(b);
}
int main(){
    cin>>n>>m;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin>>a[i][j];
        }
        sort(a[i], a[i]+m);
    }

    vector<tuple<int, int, int>> v(n); //한 열에 대해 n개의 행이 있기 때문에  //값 , 행 , 열
    //초기값 세팅
    for(int i=0; i<n; i++){
        v[i] = make_tuple(a[i][0], i, 0);
    }
    
    int nx_col = 1;
    while(nx_col < m){

        int mx_idx = max_element(v.begin(), v.end()) - v.begin();
        int mn_idx = min_element(v.begin(), v.end()) - v.begin();

        ans = min(ans, get<0>(v[mx_idx]) - get<0>(v[mn_idx]));

        int row = get<1>(v[mn_idx]);
        nx_col = get<2>(v[mn_idx]) + 1;
        v[row] = make_tuple(a[row][nx_col], row, nx_col);
    }
    cout<<ans;

}