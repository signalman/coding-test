#include <bits/stdc++.h>
using namespace std;

int dx[9] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
int dy[9] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
int n, m;
int board[51][51];
struct INFO{
    int d;
    int s;
};
struct CLOUD{
    int row;
    int col;
};
CLOUD cloud[4];
INFO info[100];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>m;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin>>board[i][j];
        }
    }
    for(int i=0; i<m; i++){
        cin>>info[i].d>>info[i].s;
    }
    cloud[0].row = n-1;
    cloud[0].col = 0;
    cloud[1].row = n-1;
    cloud[1].col = 1;
    cloud[2].row = n-2;
    cloud[2].col = 0;
    cloud[3].row = n-2;
    cloud[3].col = 1;

    for(int i=0; i<m; i++){
        // moveCloud(info[i]);
        // addWater();
        // clearCloud();
        
    }
}