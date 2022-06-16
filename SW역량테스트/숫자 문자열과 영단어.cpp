#include <bits/stdc++.h>
using namespace std;

char func(string s){
    char n;
    if(s=="zero" || s =="0"){n='0';}
    else if(s=="one" || s== "1"){n = '1';}
    else if(s=="two" || s == "2"){n = '2';}
    else if(s=="three" || s== "3"){n = '3';}
    else if(s=="four" || s== "4"){n = '4';}
    else if(s=="five" || s== "5"){n = '5';}
    else if(s=="six" || s== "6"){n = '6';}
    else if(s=="seven" || s=="7"){n = '7';}
    else if(s=="eight" || s == "8"){n = '8';}
    else if(s=="nine" || s== "9"){n = '9';}
    else{n = 'a';}
    return n;
}

int solution(string s) {
    int answer = 0;
    string temp = "";
    string ans = "";
    for(int i=0; i<s.size(); i++){
        char c = s[i];
        temp += c;
        if(func(temp) == 'a') continue;
        ans += func(temp);
        temp = "";
    }
    answer = stoi(ans);
    return answer;
}