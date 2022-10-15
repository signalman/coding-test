#include <bits/stdc++.h>
using namespace std;

// int v, e, st;
// vector<pair<int, int>> adj[20005];
// int d[20005];
// const int INF = 5000000;
// int main(){
//     cin>>v>>e>>st;
//     fill(d, d+20005, INF);
//     while(e--){
//         int u, v, w;
//         cin>>u>>v>>w;
//         adj[u].push_back({w, v}); //현재 노드 u와 연결된 (거리, 노드)
//     }

//     priority_queue<pair<int, int>, 
//         vector<pair<int, int>>, 
//         greater<pair<int, int>>> pq;

//     d[st] = 0;
//     pq.push({d[st], st}); //pq에 현재 보고있는 노드와 그 시작점에서 그 노드까지의 거리를 담는다.
//     //현재 노드까지의 거리, 현재노드

//     while(!pq.empty()){
//         auto cur = pq.top(); pq.pop();
//         if(cur.first != d[cur.second]) continue; //업데이트 이전의 요소는 여기서 걸러짐.
//         for(auto nxt: adj[cur.second]){
//             if(d[nxt.second] <= nxt.first + d[cur.second]) continue;
//             d[nxt.second] =  nxt.first + d[cur.second];
//             pq.push({d[nxt.second], nxt.second});
//         }
//     }
//     for(int i=1; i<=v; i++){
//         if(d[i] == INF) cout<<"INF"<<'\n';
//         else cout<<d[i]<<'\n';
//     }
// }

int main(){
    int v, e, st;
    cin>>v>>e>>st;

    vector<pair<int, int>> adj[20005]; //그래프의 정보를 담음 
    int d[20005]; //시작점~ 각 노드까지의 최단거리를 담음
    const int INF = 0x3f3f3f3f;
    fill(d, d+20005, INF);

    while(e--){
        int u, v, w;
        cin>>u>>v>>w;
        adj[u].push_back({w, v}); //부분거리, 노드
    }

    d[st] = 0;
    priority_queue<pair<int,int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({d[st], st}); //총 거리, 현재노드  최소힙.
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(d[cur.second] != cur.first) continue;
        for(auto nxt: adj[cur.second]){
            if(d[nxt.second] <= nxt.first + d[cur.second]) continue;
            d[nxt.second] = nxt.first + d[cur.second];
            pq.push({d[nxt.second], nxt.second});
        }
    }
    
    for(int i=1; i<=v; i++){
        if(d[i] == INF) cout<<"INF"<<'\n';
        else cout<<d[i]<<'\n';
    }



}