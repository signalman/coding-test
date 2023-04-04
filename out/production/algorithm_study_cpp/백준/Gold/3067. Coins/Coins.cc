#include <bits/stdc++.h>
using namespace std;

int T, N;
int coin[21], arr[10001];

int main(void){
    cin >> T;
    for (int test_case = 0; test_case < T; test_case++){
        cin >> N;
        fill(coin, coin+21, 0);
        fill(arr, arr+10001, 0);
        
        for (int i = 0; i < N; i++) cin >> coin[i];
        int target;
        cin >> target;
        
        arr[0] = 1;
        for (int i = 0; i < N; i++){
            for (int j = coin[i]; j <= target; j++){
                arr[j] += arr[j-coin[i]];
            }
        }
        cout << arr[target] << "\n";
    }
    return 0;
}