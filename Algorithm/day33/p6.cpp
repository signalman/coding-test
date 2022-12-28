#include <bits/stdc++.h>
using namespace std;

#define INF 100000
int n, m, r; //지역개수, 범위, 길개수
int items[105];
int d[105][105];

int main(){
    cin>>n>>m>>r;
    for(int i=1; i<=n; i++) fill(d[i], d[i]+n+1, INF);
    for(int i=1; i<=n; i++) d[i][i] = 0;
    for(int i=1; i<=n; i++){
        int it;
        cin>>it;
        items[i] = it;
    }

    for(int i=0; i<r; i++){
        int a, b, l;
        cin>>a>>b>>l;
        d[a][b] = l;
        d[b][a] = l;
    }

    for(int k=1; k<=n; k++){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
            }
        }
    }

    int mx = 0;
    for(int i=1; i<=n; i++){
        int tmp = 0;
        for(int j=1; j<=n; j++){
            if(d[i][j] <= m) tmp += items[j];
        }
        mx = max(mx, tmp);
    }
    cout<<mx;
}