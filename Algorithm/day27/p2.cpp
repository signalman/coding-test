#include <bits/stdc++.h>
using namespace std;

int main(){
    int d[10][10]={0,};
    // memset(d, 3, sizeof(d));
    fill(d[0], d[9] + 10, -1);
    for(int i=0; i<10; i++){
        for(int j=0; j<10; j++){
            cout<<d[i][j]<< ' ';
        }
        cout<<'\n';
    }
}