#include <bits/stdc++.h>
using namespace std;

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};
string keyboard[10][10] = {
    {"��", "��", "��", "��", "ī", "Ÿ", "ȣ", "��", "��", "��"},
    {"��", "��", "��", "��", "��", "��", "��", "��", "��", "��"},
    {"��", "��", "��", "��", "��", "��", "��", "��", "ö", "��"}, //��
    {"��", "��", "��", "��", "��", "��", "��", "��", "��", "��"},
    {"��", "��", "��", "��", "��", "��", "��", "��", "��", "ķ"},   //�� //ķ
    {"ȭ", "��", "õ", "��", "ȭ", "��", "��", "��", "��", "��"},
    {"Ʈ", "��", "��", "��", "��", "��", "ȭ", "��", "õ", "��"}, //Ʈ
    {"ȭ", "��", "��", "��", "��", "��", "��", "��", "��", "��"},
    {"��", "��", "��", "��", "��", "��", "��", "��", "��", "ȣ"},
    {"��", "��", "��", "��", "", "��", "��", "��", "��", "��"} //��
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
    string word = "�ν�Ʈķ��";
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