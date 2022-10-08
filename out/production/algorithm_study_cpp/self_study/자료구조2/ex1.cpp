#include <bits/stdc++.h>
using namespace std;

array<array<char, 21>, 21> arr;
int n, ret = 401;

//행 뒤집기
void Flip(int idx)
{
	for (int i = 0;i < n;i++)
	{
		if (arr[idx][i] == 'T')
			arr[idx][i] = 'H';
		else
			arr[idx][i] = 'T';
	}
}

void Check(int idx)
{
	if (idx == n)
	{
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			int cnt = 0;
			for (int j = 0; j < n; j++)
			{
				if (arr[j][i] == 'T')
					cnt++;
			}
			sum += min(cnt, n - cnt);
		}
		ret = min(ret, sum);
		return;
	}

	Flip(idx);
	Check(idx + 1);
	Flip(idx);
	Check(idx + 1);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0;i < n;i++)
	{
		for (int j = 0;j < n;j++)
		{
			cin >> arr[i][j];
		}
	}

	Check(0);

	cout << ret;

	return 0;
}