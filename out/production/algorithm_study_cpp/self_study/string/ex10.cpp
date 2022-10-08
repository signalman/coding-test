#include <iostream>
#include <string>
using namespace std;

int main() {
	int n;
	cin>>n;
	string str;

	int cnt = n;
	for (int k = 0; k < n; k++) {
		cin >> str;
		for (int i = 0; i < str.length(); i++) {
			if (str[i] != str[i + 1]) {
				for (int j = i + 1; j < str.length(); j++) {
					if (str[i] == str[j]) {
						cnt--;
						goto STOPCNT;
					}
				}
			}
		}
	STOPCNT:;
	}
	cout<<cnt;
}