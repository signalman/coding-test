#include <bits/stdc++.h>
using namespace std;

void func(int board[4]){
    board[2] = 123;
}
void func(vector<int>& v){
    v[2] = 123;
}
void func(int& a){
    a = 123;
}
int main(){

    int board[] = {0, 2, 3, 5,};
    vector<int> v = {1, 2, 3, 4};
    int t = 3;

    func(board);
    for(auto c: board){
        cout<<c<<' '; 
    }
    cout<<'\n';

    func(v);
    for(auto c: v){
        cout<<c<<' '; 
    }
    cout<<'\n';

    func(t);
    cout<<t;
}
