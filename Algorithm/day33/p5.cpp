#include <bits/stdc++.h>
using namespace std;

int n, m;
int d[102][102];
int nxt[102][102];
int main(){
    cin>>n>>m;
    for(int i=1; i<=n; i++) fill(d[i], d[i]+n+1, 200000);
    for(int i=1; i<=n; i++) d[i][i] = 0;

    for(int i=1; i<=m; i++){
        int s, t, c;
        cin>>s>>t>>c;
        d[s][t] = min(d[s][t], c);
        nxt[s][t] = t;
    }

    for(int k=1; k<=n; k++){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(d[i][j] > d[i][k] + d[k][j]){
                    d[i][j] = d[i][k] + d[k][j];
                    nxt[i][j] = nxt[i][k];
                }
            }
        }
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            if(d[i][j] == 200000) d[i][j] = 0;
            cout<<d[i][j]<<' ';
        }cout<<'\n';
    }
    
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            if(d[i][j] == 0 || d[i][j] == 200000) {cout<<"0\n"; continue;}
            vector<int> path;
            int st = i;
            while(st != j){
                path.push_back(st);
                st = nxt[st][j];
            }
            path.push_back(j);
            cout<<path.size() <<' ';
            for(auto& c: path) cout<< c <<' ';
            cout<<'\n';
        }
    }

}