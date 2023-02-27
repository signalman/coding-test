#include <bits/stdc++.h>
using namespace std;

int main(){
    string board;
    string ans;
    cin>>board;

    int cnt = 0;
    board += " ";
    for(int i=0; i<board.size()-1; i++){

        if(board[i] == '.'){
            if(cnt % 2 != 0) break;
            ans += ".";
            cnt = 0;
        }

        if(board[i] == 'X'){
            cnt++;
        }
        //X가 4개일때
        if(cnt == 4){
            ans += "AAAA";
            cnt = 0;
        }
        //X가 2개이고 다음번이 X가 아닐 때
        if(cnt == 2 && board[i+1] != 'X'){
            ans += "BB";
            cnt = 0;
        }
    }
    if(cnt % 2 != 0) cout<< -1;
    else cout<<ans;


}