// #include <bits/stdc++.h>
// using namespace std;

// int board1[32][32];
// int board2[32][32];
// int n, m, h;

// bool ladder(){
//   for(int y=1; y<=n; y++){
//     int i = 1;
//     int j= y;
//     while(i <= m){
//       if(board2[i][j]){
//         j++;
//       }
//       if(board2[i][j-1]){
//         j--;
//       }
//       i++;
//     }
//     if(y != j) return false;
//   }
//   return true;
// }


// int main(){
//   ios_base::sync_with_stdio(0);
//   cin.tie(0);
//   cin>>n>>m>>h;
//   while(m--){
//     int a, b;
//     cin>>a>>b;
//     board1[a][b] = true;
//   }
//   for(int i=0; i<n; i++){
//     for(int j=0; j<m; j++){
//       board2[i][j] = board1[i][j];
//     }
//   }
//   if(ladder()){
//     cout<<"good";
//   }
//   else{
//     cout<<"bad";
//   }
// }
#include<iostream>
#include<algorithm>
using namespace std;
 
int N, M, H;
int map[32][12];
int ans;
 
bool go() {
    for (int X = 1; X <= N; X++) {
        int ch = X;
        for (int Y = 1; Y <= H; Y++) {
            if (map[Y][ch] == 1) {
                ch++;
            }
            else if (map[Y][ch - 1] == 1) {
                ch--;
            }
        }
        if (ch != X) {
            return false;
        }
    }
    return true;
}
 
void dfs(int dep,int x,int y) {
    if (ans <= dep) return;
    if (go()) {
        ans = dep;
        return;
    }
    for (int Y = y; Y <= H; Y++) {
        for (int X = x; X <= N; X++) {
            if (map[Y][X] == 0 && map[Y][X - 1] == 0 && map[Y][X + 1] == 0) {
                map[Y][X] = 1;
                dfs(dep + 1, X, Y);
                map[Y][X]=0;
            }
        }
        x = 1;
    }
}
 
int main() {
    ans = 10000000;
    cin >> N >> M >> H;
    for (int m = 0; m < M; m++) {
        int a, b;
        cin >> a >> b;
        map[a][b] = 1;
    }
    ans = 4;
    dfs(0,1,1);
    if (ans == 4)
        cout << "-1";
    else
        cout << ans;
}
