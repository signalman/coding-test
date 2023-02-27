#include <bits/stdc++.h>
using namespace std;

vector<int> p(100003, -1);
vector<long long> weight(100003, 0);

int find(int x){
    if(p[x] < 0) return x;
    int parent = find(p[x]);
    weight[x] += weight[p[x]];
    return p[x] = parent;
}

bool uni(int u, int v, int w){
    int rootu = find(u); int rootv = find(v);
    if(rootu == rootv) return 0;
    weight[rootv] = weight[u] - weight[v] + w;
    p[rootv] = rootu;
    return 1;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    while(1){
        int n, m;
        cin >> n >> m;
        if(n == 0 && m == 0) break;
        //초기화
        fill(p.begin(), p.begin() + n + 1, -1);
        fill(weight.begin(), weight.begin() + n + 1, 0);

        for(int i=0; i<m; i++){
            char oper;
            int a, b, w;
            cin>>oper;
            if(oper == '!'){
                cin >> a >> b >> w;
                uni(a, b, w);
            }
            else if(oper == '?'){
                cin >> a >> b;
                //다른 그룹
                if(find(a) != find(b)) cout<<"UNKNOWN\n";
                //같은 그룹
                else cout<<weight[b] - weight[a] <<'\n';
            }
        }
    }
}