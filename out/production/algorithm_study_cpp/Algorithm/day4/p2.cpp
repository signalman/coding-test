#include <bits/stdc++.h>
using namespace std;

const int MX = 100001;
int sis, bro;
int board[MX];
queue<int> q;
    
void teleport(int cur){ //cur:현재 좌표
    int tmp = cur;
    if(tmp == 0) return;
    while(tmp < MX && !board[bro]){
        if(!board[tmp]){
            board[tmp] = board[cur];
            q.push(tmp);
            if(tmp == bro) return;
        }
        tmp *= 2;
    }
}



int main(){
    cin>>sis>>bro;
    board[sis] = 1;
    //수빈이가 움직일때마다 teleport가능한 좌표를 모조리 q에 넣어야함.
    q.push(sis);
    teleport(sis);
    while(!board[bro]){
        int v = q.front(); q.pop();
        vector<int> list = {v-1, v+1};
        for(int i: list){
            if(i < 0 || i >= MX) continue;
            if(board[i]) continue;
            board[i] = board[v] + 1;
            q.push(i);
            teleport(i);
        }
    }
    cout<<board[bro]-1;

}