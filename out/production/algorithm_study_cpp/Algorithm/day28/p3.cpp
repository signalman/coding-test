#include <bits/stdc++.h>
using namespace std;

#define INF 20000000
int n, m;
int dist[102][102];
int nxt[102][102];

void load(int i, int j){
    if(dist[i][j] == 0 || dist[i][j]==INF) {cout<< "0\n"; return;}
    vector<int> path;
    int st = i;
    while(st != j){
        path.push_back(st);
        st = nxt[st][j];
    }
    path.push_back(j);
    cout<<path.size()<< ' ';
    for(auto i: path){
        cout<<i << ' ';
    }cout<<'\n';
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>n>>m;
    for(int i=1; i<=n; i++) {
        fill(dist[i], dist[i] + n+1, INF);
        dist[i][i] = 0;
    }

    while(m--){
        int i, j, d;
        cin>>i>>j;
        cin>>d;
        if(dist[i][j] > d){
            dist[i][j] = d;
            nxt[i][j] = j;
        }
    }

    for(int k=1; k<=n; k++){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(dist[i][j] > dist[i][k] + dist[k][j]){
                    dist[i][j] = dist[i][k] + dist[k][j];
                    nxt[i][j] = nxt[i][k];
                }
            }
        }
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            if(dist[i][j] == INF) cout<< "0 ";
            else cout<<dist[i][j]<< ' ';
        }
        cout<<'\n';
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            load(i, j);
        }
    }

}