#include <bits/stdc++.h>
using namespace std;
#define MAX 64

int n, q;
int board[MAX][MAX];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
void rotate(int r, int c, int L){
  for(int i=0; i<L; i++){
    for(int j=0; j<L; j++){
      swap(board[r+i][c+j], board[r+L-1-j][c+i]);
    }
  }
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>q;

}