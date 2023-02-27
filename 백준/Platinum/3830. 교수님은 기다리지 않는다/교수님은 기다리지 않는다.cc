#include <iostream>
#include <cstring>
#define MAX 100005
#define ll long long

using namespace std;

int N, M;
int p[MAX];
ll dist[MAX];

int find(int node){
    if(p[node] == -1) return node;
    int parent = find(p[node]);
    dist[node] += dist[p[node]];
    return p[node] = parent;
}

void merge(int a, int b, int w){
    int roota = find(a);
    int rootb = find(b);

    if(roota == rootb) return;
    dist[rootb] = dist[a] - dist[b] + w;
    p[rootb] = roota;
    return;
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    while(1){
        memset(p, -1, sizeof(p));
        memset(dist, 0, sizeof(dist));

        cin>>N>>M;
        if(N == 0 && M == 0) break;
        char op;
        int a, b, w;
        for(int i=0; i<M; i++){
            cin>>op;
            if(op == '!'){
                cin>>a>>b>>w;
                merge(a, b, w);
            }
            else{
                cin>>a>>b;
                if(find(a) != find(b)){
                    cout<<"UNKNOWN\n";
                }
                else cout<<dist[b] - dist[a] <<'\n';
            }
        
        }
    }
}