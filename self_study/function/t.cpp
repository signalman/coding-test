#include <bits/stdc++.h>
using namespace std;

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};
string keyboard[10][10] = {
    {"가", "동", "하", "굴", "카", "타", "호", "인", "조", "연"},
    {"동", "해", "물", "과", "백", "두", "산", "이", "구", "다"},
    {"남", "산", "위", "에", "저", "소", "스", "무", "철", "갑"}, //스
    {"을", "두", "른", "듯", "하", "느", "님", "이", "보", "우"},
    {"하", "사", "우", "리", "부", "라", "만", "세", "무", "캠"},   //부 //캠
    {"화", "삼", "천", "리", "화", "려", "강", "산", "대", "한"},
    {"트", "람", "만", "세", "무", "궁", "화", "삼", "천", "리"}, //트
    {"화", "려", "강", "산", "대", "한", "사", "람", "대", "한"},
    {"으", "로", "길", "이", "보", "전", "하", "세", "신", "호"},
    {"인", "신", "의", "식", "", "가", "수", "왕", "대", "프"} //프
};

int T_row, T_col;
int T_dist;

bool findWord(char s){
    for(int i=0; i<10; i++){
        for(int j=0; j<10; j++){
            if(keyboard[i][j][0] == s){
                return true;
            }
        }
    }
    return false;
}

void bfs(int r, int c, char s){
    queue<pair<int, int>> q;
    bool vis[10][10] = {false, };
    int dist[10][10] = {-1, };

    q.push({r, c});
    vis[r][c] = true;
    dist[r][c] = 0;

    while(!q.empty()){
        auto cur = q.front();
        q.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || ny < 0 || nx >= 10 || ny >= 10) continue;
            if(vis[nx][ny]) continue;
            if(keyboard[nx][ny][0] == s) {
                T_row = nx;
                ny = T_col;
                T_dist = dist[cur.first][cur.second] + 1;
                return;
            }
            q.push({nx, ny});
            vis[nx][ny] = true;
            dist[nx][ny] = dist[cur.first][cur.second] + 1;
        }
    }
}


int main(){
    string word = "부스트캠프";
    int Row=0;
    int Col=0;
    int Dist=0;
    vector<pair<int, int>> idxInfo(word.size());

    for(int i=0; i<word.length(); i++){

        if(findWord(word[i])){
            bfs(Row,Col, word[i]);
            Row = T_row;
            Col = T_col;
            Dist += T_dist;
            idxInfo.push_back({Row, Col});
            cout<<"if"<<'\n';
        }
        else{
            Row = 0;
            Col = 0;
            Dist += 20;
            cout<<"else"<<'\n';
        }
        cout<< keyboard[Row][Col] <<'\n';
    }
    // for(auto i: idxInfo) {cout<< '{' <<i.first << ", " << i.second <<'}'; cout<<'\n';}
    // cout<<'\n';
    // cout<<Dist;

}