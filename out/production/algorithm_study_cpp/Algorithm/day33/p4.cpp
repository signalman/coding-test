#include <bits/stdc++.h>
using namespace std;

int n, m;
int d[102][102];
int main(){
    cin>>n >>m;
    for(int i=1; i<=n; i++) fill(d[i], d[i] + n + 1, 120000);
    for(int i=1; i<=n; i++) d[i][i] = 0;
    for(int i=1; i<=m; i++){
        int a, b, c;
        cin>>a>>b>>c;
        d[a][b] = min(d[a][b], c);
    }
    for(int k=1; k<=n; k++){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
            }
        }
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cout<<d[i][j]<<' ';
        }cout<<'\n';
    }

}