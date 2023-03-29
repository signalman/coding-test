#include <bits/stdc++.h>
using namespace std;

int n, e, v1, v2;
vector<pair<int, int>> adj[805];
int d[805];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>e;
    for(int i=0; i<e; i++){
        int a, b, c;
        cin>>a>>b>>c;
        adj[a].push_back(make_pair(c, b));
        adj[b].push_back(make_pair(c, a));
    }
    cin>>v1>>v2;

    //1 - v1 - v2 - N
    int ans1[3];
    int ans2[3];
    fill(d, d+805, 0x7f7f7f7f);
    d[1] = 0;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push(make_pair(d[1], 1));
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(cur.first != d[cur.second]) continue;
        for(auto nxt: adj[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push(make_pair(d[nxt.second], nxt.second));
        }
    }
    ans1[0] = d[v1];
    ans2[0] = d[v2];

    fill(d, d+805, 0x7f7f7f7f);
    d[v1] = 0;
    pq.push(make_pair(d[v1], v1));
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(cur.first != d[cur.second]) continue;
        for(auto nxt: adj[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push(make_pair(d[nxt.second], nxt.second));
        }
    }
    ans1[1] = d[v2];
    ans2[1] = d[n];

    fill(d, d+805, 0x7f7f7f7f);
    d[v2] = 0;
    pq.push(make_pair(d[v2], v2));
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(cur.first != d[cur.second]) continue;
        for(auto nxt: adj[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push(make_pair(d[nxt.second], nxt.second));
        }
    }
    ans1[2] = d[n];
    ans2[2] = d[v1];
    bool flag = true;
    if((ans1[0] == 0x7f7f7f7f || ans1[1] == 0x7f7f7f7f || ans1[2] == 0x7f7f7f7f) && (ans2[0] == 0x7f7f7f7f || ans2[1] == 0x7f7f7f7f || ans2[2] == 0x7f7f7f7f)) flag = false;

    if(flag) cout<<min(ans1[0] + ans1[1] + ans1[2], ans2[0] + ans2[1] + ans2[2]);
    else cout<<-1;


}