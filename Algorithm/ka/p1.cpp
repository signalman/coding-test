#include <bits/stdc++.h>
using namespace std;

string solution(string &line) {
    string answer ="";

    if(line.length() == 1) return line;
    answer += line[0];
    int cnt = 1;
    for(int i=1; i<line.length(); i++){
        if(i == line.length()-1){
            if(line[i] == line[i-1]){
                answer += '*';
            }
            else{
                answer += line[i];
            }
            continue;
        }
        if(line[i] == line[i-1]) { 
            cnt++; 
            continue;
        }
        if(cnt > 1){
            answer += '*';
            answer += line[i];
            cnt = 1;
        }
        else{
            answer += line[i];
        }

    }


    return answer;
}

int main(){
    string str = "aabbbbadccccccccc";
    

    string s = solution(str);
    cout<<s;

}