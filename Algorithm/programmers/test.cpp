#include <bits/stdc++.h>
using namespace std;

void func(int a[][5][5]){
    for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            a[0][i][j] = 0;
        }
    }
}
int main(){
    int board[5][5][5];
    int cnt = 0;

    for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            for(int k=0; k<5; k++){
                board[i][j][k] = cnt;
                cnt++;
            }
        }
    }

    func(board);
    
    for(int i=0; i<5; i++){

        for(int j=0; j<5; j++){

            for(int k=0; k<5; k++){
                cout<<board[i][j][k]<<' ';
            }
            cout<<'\n';
        }
        cout<<'\n';
    }
        cout<<'\n';


}
