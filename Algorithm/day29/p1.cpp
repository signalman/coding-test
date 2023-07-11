#include <bits/stdc++.h>
using namespace std;

int R, C, M;
//상 하 우 좌
int dx[] = {0, -1, 1, 0, 0};
int dy[] = {0, 0, 0, 1, -1};

/**
 * 위치 속력, 방향, 크기
*/
struct Shark{
    int x = 0, y = 0;
    int s = 0, d = 0, z = 0;
    Shark(){
        this->z=0;
    }
    Shark(int x, int y, int s, int d, int z){
        this->x = x;
        this->y = y;
        this->s = s;
        this->d = d;
        this->z = z;
    }
    bool operator ==(const Shark& s){
        return (this->x == s.x && this->y ==s.y && this->s ==s.s && this->d == s.d && this->z ==s.z);
    }
};
Shark board[102][102];
vector<Shark> sharkList;
void catchShark(int fisher, int& sum){
    for(int row=0; row<R; row++){
        Shark findShark = board[row][fisher];
        if(findShark.z > 0){
            sum += findShark.z;
            // cout<<findShark.z<<'\n';
            sharkList.erase(find(sharkList.begin(), sharkList.end(), findShark));
            board[row][fisher] = Shark();
            return;
        }
    }
}


bool comp(Shark s1, Shark s2){
    if(s1.x != s2.x) return s1.x < s2.x;
    if(s1.y != s2.y) return s1.y < s2.y;
    if(s1.z != s2.z) return s1.z > s2.z;
    return false;
}

void eatSmallShark(){
    sort(sharkList.begin(), sharkList.end(), comp);
    auto i = sharkList.begin();
    while(i != sharkList.end()){
        auto shark = *i;
        if(board[shark.x][shark.y].z == 0){
            board[shark.x][shark.y] = shark;
            ++i;
        }
        else{
            if(board[shark.x][shark.y].z > shark.z){
                i = sharkList.erase(find(sharkList.begin(), sharkList.end(), shark));
                
            }
            else{
                Shark pshark = board[shark.x][shark.y];
                i = sharkList.erase(find(sharkList.begin(), sharkList.end(), pshark));
                board[shark.x][shark.y] = shark;
            }
        }
    }
}
void sharkMove(){
    for(auto& shark: sharkList){
        board[shark.x][shark.y] = Shark();

        int mod;
        //상하로 움직이는 상어
        if(shark.d == 1 || shark.d == 2){
            mod = 2 * (R - 1);
        }
        //좌우로 움직이는 상어
        else{
            mod = 2 * (C -1);
        }

        int s = shark.s % mod;
        if(s == 0){
            continue;
        }
        else if(shark.d == 1 || shark.d == 2){
            while(s--){
                int nx = shark.x + dx[shark.d];
                if(nx <0 || nx>=R){
                    shark.d = 3 - shark.d;
                    nx = shark.x + dx[shark.d];
                }
                shark.x = nx;
            }
        }
        else if(shark.d == 3 || shark.d == 4){
            while(s--){
                int ny = shark.y + dy[shark.d];
                if(ny < 0 || ny>=C){
                    shark.d = 7 - shark.d;
                    ny = shark.y + dy[shark.d];
                }
                shark.y = ny;
            }
        }
    }
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>R>>C>>M;
    while(M--){
        int x, y, s, d, z;
        cin>>x>>y>>s>>d>>z;
        x--,y--;
        board[x][y] = Shark(x,y,s,d,z);
        sharkList.push_back(Shark(x, y, s ,d ,z));
    }
    int fisher = 0;
    int sum = 0;
    while(fisher < C){
        // cout<<"start======\n";

        // 상어 잡기
        catchShark(fisher, sum);


        //상어 이동
        sharkMove();
        
        //큰상어가 잡아먹기
        eatSmallShark();
        
        // //낚시꾼 이동
        fisher++;


        // for(auto v: sharkList){
        //     cout<<v.x<<" "<<v.y<<" "<<v.z<<" \n";
        // }
        // cout<<"end======\n";
    }
    cout<<sum;
}