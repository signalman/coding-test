#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

vector<string> spl(string s){
    vector<string> ret(3);
    int idx = 0;
    for(int i=0; i<s.size(); i++){
        char c = s[i];
        if(c != ' '){
            ret[idx] += c;
        }
        else{
            idx++;
        }
    }
    return ret;
}
        
vector<string> solution(vector<string> record) {
    vector<vector<string>> v;
    vector<string> answer;
    unordered_map<string, string> m;

    for(int i=0; i<record.size(); i++){
        v.push_back(spl(record[i]));
        if(v[i][0] == "Change" || v[i][0] == "Enter"){
            m[v[i][1]] = v[i][2];
        }
    }

    for(int i=0; i<v.size(); i++){
        string action = v[i][0];
        string id = v[i][1];
        string name = v[i][2];
        string str = "";

        if(v[i][0] == "Enter"){
            str = m[v[i][1]] + "님이 들어왔습니다.";
        }
        else if(v[i][0] == "Leave"){
            str = m[v[i][1]] + "님이 나갔습니다.";
        }
        else continue;
        answer.push_back(str);
    }
    return answer;
}
