#include <bits/stdc++.h>
using namespace std;

#define MX 100002

int n, r, q;
vector<int> adj[MX];
bool vis[MX];
int subCnt[MX];
vector<int> query;

int dfs(int cur){
    vis[cur] = true;
    int ret = 1;
    for(auto nxt: adj[cur]){
        if(vis[nxt]) continue;
        ret += dfs(nxt);
    }
    subCnt[cur] = ret;
    return ret;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>r>>q;

    //입력받기
    for(int i=0; i<n-1; i++){
        int u, v;
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for(int i=0; i<q; i++){
        int n;
        cin>>n;
        query.push_back(n);
    }


    subCnt[r] = dfs(r);

    //구하기
    for(auto i: query){
        cout<<subCnt[i]<<'\n';
    }
    
}