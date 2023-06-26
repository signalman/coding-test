#include <bits/stdc++.h>
using namespace std;
#define MX 33000
int n, m;
vector<int> adj[MX];
int indeg[MX];
bool vis[MX];
vector<int> ret;

int main(){
    cin>>n>>m;
    for(int i=0; i<m; i++){
        int a, b;
        cin>>a>>b;
        adj[a].push_back(b);
        indeg[b] += 1;
    }
    queue<int> q;
    for(int i=1; i<=n; i++){
        if(indeg[i] == 0) {
            q.push(i);
            vis[i] = true;
            ret.push_back(i);
        }
    }

    while(!q.empty()){
        auto cur = q.front();
        q.pop();
        for(auto nxt: adj[cur]){
            indeg[nxt] -= 1;
            if(indeg[nxt] == 0 && !vis[nxt]){
                vis[nxt] = true;
                q.push(nxt);
                ret.push_back(nxt);
            }
        }
    }
    for(auto i: ret){
        cout<< i<< ' ';
    }

}