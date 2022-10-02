#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
#define MAX 25
#define NVALUE -2

int N, M;
int board[MAX][MAX];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, 1, -1};
bool Visit[MAX][MAX];
bool R_Visit[MAX][MAX];
int answer;
struct BLOCK{
    int Size;
    int x, y;
    int Rainbow_Cnt;
    vector<pair<int, int>> Block_Group;
};

bool cmp(pair<int, int> A, pair<int, int> B){
    if(A.first <= B.first){
        if(A.first == B.first){
            if(A.second < B.second){
                return true;
            }
            return false;
        }
        return true;
    }
    return false;
}
bool Comp_Block(BLOCK A, BLOCK B){
    if(A.Size >= B.Size){
        if(A.Size == B.Size){
            if(A.Rainbow_Cnt >= B.Rainbow_Cnt){
                if(A.Rainbow_Cnt == B.Rainbow_Cnt){
                    if(A.x >= B.x){
                        if(A.x == B.x){
                            if(A.y > B.y){
                                return true;
                            }
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }
    return false;
}


BLOCK BFS(int a, int b, int Color){
    memset(R_Visit, false, sizeof(R_Visit));
    queue<pair<int, int>> Q;
    vector<pair<int, int>> Block;
    vector<pair<int, int>> Except_Rainbow_Block;

    Q.push({a, b});
    Block.push_back({a, b});
    Except_Rainbow_Block.push_back({a, b});
    Visit[a][b] = true;
    int Rainbow = 0;

    while(!Q.empty()){
        auto cur = Q.front();
        int x = cur.X;
        int y = cur.Y;
        Q.pop();
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N)
            {
                if (board[nx][ny] == 0)
                {
                    if (R_Visit[nx][ny] == false)
                    {
                        R_Visit[nx][ny] = true;
                        Rainbow++;
                        Block.push_back(make_pair(nx, ny));
                        Q.push(make_pair(nx, ny));
                    }
                }
                else if(board[nx][ny] == Color)
                {
                    if (Visit[nx][ny] == false)
                    {
                        Visit[nx][ny] = true;
                        Q.push(make_pair(nx, ny));
                        Block.push_back(make_pair(nx, ny));
                        Except_Rainbow_Block.push_back(make_pair(nx, ny));
                    }
                }
            }
        }
    }

    sort(Except_Rainbow_Block.begin(), Except_Rainbow_Block.end(), cmp);
    BLOCK R_Block;
    R_Block.Size = Block.size();
    R_Block.Rainbow_Cnt = Rainbow;
    R_Block.x = Except_Rainbow_Block[0].X;
    R_Block.y = Except_Rainbow_Block[0].Y;
    R_Block.Block_Group = Block;
    return R_Block;
}

BLOCK Find_Largest_Block(){
    memset(Visit, false, sizeof(Visit));
    BLOCK Result;
    Result.Size = -1;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(Visit[i][j]) continue;
            if(board[i][j] == -1 || board[i][j] == 0 || board[i][j] == NVALUE) continue;
            BLOCK Temp_Block = BFS(i, j, board[i][j]);
            if(Result.Size == -1){
                Result = Temp_Block;
            }
            else{
                if(Comp_Block(Temp_Block, Result)){
                    Result = Temp_Block;
                }
            }
        }
    }
    return Result;
}

void Delete_Block(BLOCK A){
    vector<pair<int, int>> v = A.Block_Group;
    for(int i=0; i<v.size(); i++){
        int x = v[i].X;
        int y = v[i].Y;
        board[x][y] = NVALUE;
    }
    answer += (v.size() * v.size());
}

void Gravity(){
	for (int i = N - 2; i >= 0; i--)
	{
		for (int j = 0; j < N; j++)
		{
			if (board[i][j] == -2) continue;
			if (board[i][j] == -1) continue;

			int Color = board[i][j];
			int nx = i + 1;
			while (1)
			{
				if (board[nx][j] != -2) break;
				if (nx == N) break;
				nx++;
			}
			nx--;
			board[i][j] = -2;
			board[nx][j] = Color;
		}
	}
}
void Rotate(){
    for (int i = 0; i < N / 2; i++)
        {
            int Sx = i;
            int Sy = i;
            int Ex = N - i - 1;
            int Ey = N - i - 1;
    
            int x_Idx = Ex;
            int y_Idx = Sy;
            int Idx = 0;
            vector<int> Temp;
            for (int x = Ex; x > Sx; x--) Temp.push_back(board[x][Sy]);
            for (int y = Sy; y < Ey; y++) board[x_Idx--][Sy] = board[Sx][y];
            for (int x = Sx; x < Ex; x++) board[Sx][y_Idx++] = board[x][Ey];
            for (int y = Ey; y > Sy; y--) board[x_Idx++][Ey] = board[Ex][y];
            for (int y = Ey; y > Sy; y--) board[Ex][y] = Temp[Idx++];
        }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin>>board[i][j];
        }
    }
    while(1){
        BLOCK target = Find_Largest_Block();
        if(target.Size < 2) break;
        Delete_Block(target);
        Gravity();
        Rotate();
        Gravity();
    }
    cout<<answer;
    return 0;
}