#include <bits/stdc++.h>
using namespace std;

int n,m;
vector<int> adj[1002];
bool vis[1002];
int main(){
    cin>>n>>m;
    while(m--){
        int u, v;
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int ret = 0;
    queue<int> q;
    for(int i=1; i<=n; i++){
        if(vis[i]) continue;
        vis[i] = true;
        q.push(i);
        ret++;
        while(!q.empty()){
            int cur = q.front();
            q.pop();
            for(auto nxt: adj[cur]){
                if(vis[nxt]) continue;
                vis[nxt] = true;
                q.push(nxt);
            }
        }
    }
    cout<<ret;
}