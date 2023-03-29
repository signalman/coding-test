#include <bits/stdc++.h>
using namespace std;

int board[15][15];
int add[15][15];
int n, m, k;
struct Tree
{
    int x, y, z;
    bool alive;

    bool const operator<(Tree &t) const
    {
        return this->z < t.z;
    }
};
vector<Tree> trees;
int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

void show()
{
    cout << "=======sand=======\n";
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << board[i][j] << ' ';
        }
        cout << '\n';
    }
    cout << "========tree=======\n";
    for (auto t : trees)
    {
        cout << "radi: (" << t.x << ", " << t.y << ") "
             << "size: " << t.z << " alive: " << t.alive << '\n';
    }
    cout << '\n';
}

int main()
{
    cin >> n >> m >> k;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> add[i][j];
            board[i][j] = 5;
        }
    }

    for (int i = 0; i < m; i++)
    {
        int x, y, z;
        cin >> x >> y >> z;
        Tree tree;
        tree.x = x - 1;
        tree.y = y - 1;
        tree.z = z;
        tree.alive = true;
        trees.push_back(tree);
    }
    while (k--) // k년 동안
    {
        sort(trees.begin(), trees.end());
        // 봄
        for (auto &tree : trees)
        {
            if (!tree.alive)
                continue;
            if (board[tree.x][tree.y] >= tree.z)
            {
                board[tree.x][tree.y] -= tree.z;
                tree.z += 1;
            }
            else
            {
                tree.alive = false;
            }
        }
        // cout << "spring end\n";
        // show();

        // 여름
        for (auto &tree : trees)
        {
            if (!tree.alive)
            {
                board[tree.x][tree.y] += (tree.z / 2);
            }
        }
        // cout << "summer end\n";
        // show();

        vector<Tree> _trees(trees);
        // 가을
        for (auto &tree : _trees)
        {
            if (!tree.alive || tree.z % 5 != 0)
                continue;
            for (int dir = 0; dir < 8; dir++)
            {
                int nx = tree.x + dx[dir];
                int ny = tree.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                Tree t;
                t.x = nx;
                t.y = ny;
                t.z = 1;
                t.alive = true;
                trees.push_back(t);
            }
        }
        // cout << "fall end\n";
        // show();

        // 겨울
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                board[i][j] += add[i][j];
            }
        }
        // cout << "winter end\n";
        // show();
    }
    int cnt = 0;
    for (auto &tree : trees)
    {
        // cout << tree.x << ' ' << tree.y << ' ' << tree.z << ' ' << tree.alive << '\n';
        if (tree.alive)
            cnt++;
    }
    cout << cnt;
}