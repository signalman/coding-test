#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> adj[504];
bool vis[504];
int dist[504];
int ans;

void bfs(int cur){
    queue<int> q;
    dist[cur] = 0;
    q.push(cur);
    vis[cur] = true;

    while(!q.empty()){
        int now = q.front();
        q.pop();

        for(auto nxt: adj[now]){
            if(vis[nxt]) continue;
            vis[nxt] = true;
            dist[nxt] = dist[now] + 1;
            q.push(nxt);
        }
    }
}

int main(){
    cin>>n>>m;
    while(m--){
        int u, v;
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    bfs(1);

    for(int i=2; i<=n; i++){
        if(dist[i] == 1 || dist[i] == 2) ans++;
    }

    cout<<ans;
}