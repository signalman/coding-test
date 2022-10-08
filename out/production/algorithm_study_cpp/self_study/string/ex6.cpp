#include <iostream>
#include <string>

#define MAX 1000001

using namespace std;

int main(){
	string str;
	int cnt = 1;

	getline(cin, str);
	
	for(int i=0; i<str.length(); i++){
		if(str[i] == ' '){ // 공백인 경우
			cnt++;
		}
	}
	
	if(str[0] == ' ' || str[0] == '\0'){ // 처음 공백이 오는 경우 
		cnt--;
	}
	
	if(str[str.length()-1] == ' '){ // 맨 뒤가 공백일 겨우 
		cnt--;
	}
		
	cout << cnt;

	return 0;
}