#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[102][102];
int main(){
    cin>>n>>m;
    for(int i=1; i<=n; i++) fill(board[i], board[i]+1+n, 0x3f3f3f3f);
    for(int i=0; i<m; i++){
        int start, end, cost;
        cin>>start>>end>>cost;
        board[start][end] = min(board[start][end], cost);
    }
    for(int i=1; i<=n; i++) board[i][i] = 0;

    for(int v=1; v<=n; v++){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                board[i][j] = min(board[i][j], board[i][v] + board[v][j]);
            }
        }
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            if(board[i][j] == 0x3f3f3f3f) board[i][j] = 0;
            cout<<board[i][j]<<' ';
        }
        cout<<'\n';
    }
}