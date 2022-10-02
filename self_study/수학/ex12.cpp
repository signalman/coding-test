#include <iostream>
#include <cstdio>
#include <string>
#include <cmath>
#include <vector>
 
using namespace std;
 
int main() {
    string s = "";
    // string으로 입력
    getline(cin, s);
    // 자릿수를 3으로 나누어 떨어지게 만들기
    while (s.size() % 3 != 0) {
        s = '0' + s;
    }
    string ans = "";
    for (int i = 0; i < s.size(); i+=3) {
        int tmp = 0;
        // 3자리씩 8진수로 변환하기
        for (int j = i; j < i+3; j++) {
            tmp += (s[j]-'0')*pow(2,2-(j%3));
        }
        ans += to_string(tmp);
    }
    for (int i = 0; i < ans.size(); i++) {
        printf("%c", ans[i]);
    }
}
 


