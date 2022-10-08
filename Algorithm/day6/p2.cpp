#include <bits/stdc++.h>
using namespace std;

int board[100001];
int rev[100001];
int n, k;
int main(){
    fill(board, board+100001, -1);
    cin>>n>>k;
    board[n] = 0;
    rev[n] = n;
    queue<int> q;
    q.push(n);
    while(!q.empty()){
        int cur = q.front();
        q.pop();

        for(int nx: {cur-1, cur+1, cur*2}){
            if(nx<0 || nx >=100001) continue;
            if(board[nx] != -1) continue;
            q.push(nx);
            board[nx] = board[cur] + 1;
            rev[nx] = cur;
        }
    }
    cout<<board[k]<<'\n';;
    deque<int> track = {k};
    while(track.front() != n){
        track.push_front(rev[track.front()]);
    }
    for(int p: track) cout<< p<<' ';
}