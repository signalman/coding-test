#include <bits/stdc++.h>
using namespace std;

int n, k;
int color[13][13];
vector<int> board[13][13]; // 번호 (먼저들어온게 0idx)
vector<tuple<int, int, int>> token;

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

void WHITE(int cx, int cy, int cd, int nx, int ny)
{
    board[nx][ny].insert(board[nx][ny].end(), board[cx][cy].begin(), board[cx][cy].end());
    board[cx][cy].clear();
}
void RED(int cx, int cy, int cd, int nx, int ny)
{
    WHITE(cx, cy, cd, nx, ny);
    vector<int> tmp;
    for (int j = board[nx][ny].size() - 1; j >= 0; j--)
    {
        tmp.push_back(board[nx][ny][j]);
    }
    board[nx][ny] = tmp;
}

void BLUE(int cx, int cy, int cd)
{
    int nd;
    if (cd == 0 || cd == 2)
    {
        nd = cd + 1;
    }
    else
    {
        nd = cd - 1;
    }
    int nx = cx + dx[nd];
    int ny = cy + dy[nd];
    if (color[nx][ny] == 0)
    {
        WHITE(cx, cy, cd, nx, cy);
    }
    else if (color[nx][ny] == 1)
    {
        RED(cx, cy, cd, nx, ny);
    }
}

bool check()
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (board[i][j].size() >= 4)
                return true;
        }
    }
    return false;
}

int main()
{
    cin >> n >> k;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> color[i][j];
        }
    }
    for (int i = 0; i < k; i++)
    {
        int r, c, d;
        cin >> r >> c >> d;
        r--, c--, d--;
        token.push_back({r, c, d});
        board[r][c].push_back(i);
    }

    int turn = 1;
    while (turn <= 1000)
    {
        // 검사
        if (check())
            break;

        // 구슬 이동
        for (int i = 0; i < k; i++)
        {
            int cx, cy, cd;
            tie(cx, cy, cd) = token[i];
            int loc = find(board[cx][cy].begin(), board[cx][cy].end(), i) - board[cx][cy].begin();
            // 가장 밑에 있는 구슬이 아니라면 continue;
            if (loc != 0)
                continue;

            int nx = cx + dx[cd];
            int ny = cy + dy[cd];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || color[nx][ny] == 2)
            { // 파랑, 범위

                BLUE(cx, cy, cd);
            }
            else if (color[nx][ny] == 0)
            {
                WHITE(cx, cy, cd, nx, cy);
            }
            else if (color[nx][ny] == 1)
            {
                RED(cx, cy, cd, nx, ny);
            }
        }

        // 턴 증가`````
        turn++;
    }

    turn > 1000 ? cout << -1 << '\n' : cout << turn << '\n';
}
