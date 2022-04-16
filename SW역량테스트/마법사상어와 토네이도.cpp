#include <iostream>
using namespace std;

int N;
int A[499][499];
const int dy[]={0,1,0,-1};
const int dx[]={-1,0,1,0};
const int ratio[9]={1,1,2,7,7,2,10,10,5};
const int blowY[4][10]={
    {-1,1,-2,-1,1,2,-1,1,0,0},
    {-1,-1,0,0,0,0,1,1,2,1},
    {-1,1,-2,-1,1,2,-1,1,0,0},
    {1,1,0,0,0,0,-1,-1,-2,-1}
};
const int blowX[4][10]={
    {1,1,0,0,0,0,-1,-1,-2,-1},
    {-1,1,-2,-1,1,2,-1,1,0,0},
    {-1,-1,0,0,0,0,1,1,2,1},
    {-1,1,-2,-1,1,2,-1,1,0,0}
};

bool inRange(int y, int x){
    return y>=0 && x>=0 && y<N && x<N;
}

// 모래의 흩날림 처리와 격자 밖 모래 반환
int blowSand(int y, int x, int dir){
    int ret=0, init=A[y][x];

    for(int i=0;i<10;i++){
        int sand;
        if(i!=9){
            sand=init*ratio[i]/100;
            A[y][x]-=sand;
        }
        else sand=A[y][x];

        int by=y+blowY[dir%4][i];
        int bx=x+blowX[dir%4][i];

        if(!inRange(by,bx)){
            ret+=sand;
            continue;
        }

        A[by][bx]+=sand;
    }

    A[y][x]=0;

    return ret;
}

int solve(){
    int ret=0, y=N/2, x=N/2, dir=0;

    // 토네이도 이동
    for(double i=1.0;i<=N;i+=0.5){
        for(int j=0;j<(int)i;j++){
            y+=dy[dir%4];
            x+=dx[dir%4];

            ret+=blowSand(y,x,dir);
        }
        dir++;
    }

    return ret;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>N;
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
            cin>>A[i][j];

    cout<<solve();

    return 0;
}