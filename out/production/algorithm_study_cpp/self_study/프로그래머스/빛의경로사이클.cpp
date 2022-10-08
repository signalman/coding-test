#include <bits/stdc++.h>
using namespace std;

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
vector<string> MAP;
int N, M;
bool vis[501][501][4] = {false, };

int change_dir(char c, int dir){
    if(c == 'L'){
        if(dir == 0) return 3;
        else if(dir == 1) return 2;
        else if (dir == 2) return 0;
        else return 1;
    }
    if(dir == 0) return 2;
    else if(dir == 1) return 3;
    else if (dir == 2) return 1;
    else return 0;
}

int find_cycle(int i, int j, int dir, int len){
    if(vis[i][j][dir]) return len;
    vis[i][j][dir] = 1;
    int nx = (i + dx[dir] + N) % N;
    int ny = (j + dy[dir] + M) % M;
    int nd = dir;
    if(MAP[nx][ny] != 'S') nd = change_dir(MAP[nx][ny], dir);
    return find_cycle(nx, ny, nd, len+1);
}

vector<int> solution(vector<string> grid) {
    vector<int> answer;
    N = grid.size();
    M = grid[0].size();
    MAP = grid;

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            for(int dir = 0; dir < 4; dir++){
                int length = find_cycle(i, j, dir, 0);
                if(length != 0) answer.push_back(length);
            }
        }
    }
    sort(answer.begin(), answer.end());
    return answer;
}