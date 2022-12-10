#include <bits/stdc++.h>
using namespace std;
#define MX 510


/**
 *   |    ㅡㅡㅡ     |_
 *   |_     |         |   은 2x3안에 포함되므로  2x3 or 3x2 를 결정한후 -> 각각 8가지 경우의 수가 있음.
*/
int board[MX][MX];
int row, col;
int sumMax;

int main(){

    cin>>row>>col;

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            cin>> board[i][j];
        }
    }

    //1. ㅡ   |
    sumMax = max(func1(), sumMax);

    //2. 네모
    sumMax = max(func2(), sumMax);
    
    //3. 나머지 - 2행 3열 직사각형
    sumMax = max(func3(), sumMax);

    //4. 나머지 - 3행 2열 직사각형
    sumMax = max(func4(), sumMax);


}

int func1(){

    int ret = 0;

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            ret = max(ret, board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j]);
            ret = max (ret, board[i][j] + board[i][j+1]+ board[i][j+2]+ board[i][j+3]);
        }
    }

    return ret;
}

int func2(){
    int ret = 0; 

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            ret = max(ret, board[i][j] + board[i][j+1] + board[i+1][j] + board[i+1][j+1]);
        }
    }

    return ret;
}

int arr[2][3];
void makeShape1(int d){
    int arr[2][3];
    if(d == 0){
        int ret[2][3] = {{0, 1, 1}, {1, 1, 0}};
    }
    else if(d== 1){
        int ret[2][3] = {{1, 0, 0}, {1, 1, 1}};
    }
    else if(d==2){
        int ret[2][3] = {{0, 0, 1}, {1, 1, 1,}};
    }
    else if(d==3){
        int ret[2][3] = {{1, 1, 1}, {0, 1, 0}};
    }
    else if(d==4){
        int ret[2][3] = {{1, 1, 0}, {0,1, 1}};
    }
    else if(d==5){
        int ret[2][3]  = {{1, 1, 1}, {1, 0, 0}};
    }
    else if(d==6){
        int ret[2][3] = {{1, 1, 1}, {0, 0, 1}};
    }
    else {
        int ret[2][3] = {{0, 1, 0}, {1, 1, 1}};
    }
}

//3. 2행 3열 직사각형
int func3(){
    int ret = 0;

    for(int d=0; d<8; d++){
        makeShape1(d);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){

            }
        }
    }
}

int func4(){

}
