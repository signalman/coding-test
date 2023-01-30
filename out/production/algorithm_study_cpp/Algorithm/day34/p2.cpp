#include <bits/stdc++.h>
using namespace std;

int T;
int sdoku[10][10];
int check[10];

bool is_valid(){
    for(int i=1; i<=9; i++){
        if(check[i] != 1) return false;
    }
    return true;
}

int main(){
    cin>>T;
    for(int t=1; t<=T; t++){
        bool status = true;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                cin>>sdoku[i][j];
            }
        }
        //검증하기 위한 1~9까지 배열
        fill(check, check+10, 0);

        //9개의 작은 네모 검증
        for(int row = 0; row < 9; row += 3){
            for(int col = 0; col < 9; col += 3){
                fill(check, check+10, 0);
                for(int i=row; i<row+3; i++){
                    for(int j=col; j<col+3; j++){
                        check[sdoku[i][j]]++;
                    }
                }
                if(!is_valid()) status = false;
            }
        }

        //행 검증
        for(int i=0; i<9; i++){
            fill(check, check+10, 0);
            for(int j=0; j<9; j++){
                check[sdoku[i][j]]++;
            }
            if(!is_valid()) status = false;
        }

        //열 검증
        for(int i=0; i<9; i++){
            fill(check, check+10, 0);
            for(int j=0; j<9; j++){
                check[sdoku[j][i]]++;
            }
            if(!is_valid()) status = false;
        }

        cout<< "#" << t << " " << status << '\n';
    }
}