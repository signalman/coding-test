#include <bits/stdc++.h>
using namespace std;

int F, S, G, U, D;
int board[1000000];

int main(){
/**
 * 위 4줄이 중요 inx를 어디서 부터 시작하고 어디서 끝낼지 정하고 시작하는게 제일 중요하다.
*/
    cin>>F>>S>>G>>U>>D;
    fill(board, board+F, -1);
    F--; S--; G--;
    board[S] = 0;
    
    queue<int> q;
    q.push(S);

    while(!q.empty()){
        int cur = q.front(); q.pop();
        if(cur == G) {cout<<board[G]; return 0;}
        for(auto nx: {cur+U, cur-D}){
            if(nx < 0|| nx > F) continue;
            if(board[nx] != -1) continue;
            q.push(nx);
            board[nx] = board[cur] + 1;
        }
    }

    cout<< "use the stairs";
}