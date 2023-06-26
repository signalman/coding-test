#include <bits/stdc++.h>
using namespace std;
#define INF 20000000

int n, m;
int board[102][102];
int main(){
    cin>>n>>m;
    for(int i=0; i<n; i++) fill(board[i], board[i]+n, INF);
    while(m--){
        int i, j;
        cin>>i>>j;
        int t;
        cin>>t;
        i--, j--;
        board[i][j] = min(board[i][j], t);
    }
    
    for(int k=0; k<n; k++){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                board[i][j] = min(board[i][j], board[i][k] + board[k][j]);
            }
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j] >= INF) board[i][j] = 0;
            cout<<board[i][j]<<' ';
        }
        cout<<'\n';
    }
}