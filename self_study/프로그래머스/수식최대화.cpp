#include <bits/stdc++.h>
using namespace std;

string compute(string f, string s, string oper){
    string st = "";
    long long tmp = 0;
    if(oper == "+"){
        tmp = stoll(f) + stoll(s);
    }
    else if(oper == "-"){
        tmp = stoll(f) - stoll(s);
    }
    else if(oper == "*"){
        tmp = stoll(f) * stoll(s);
    }
    st = to_string(tmp);
    return st;
}

long long solution(string expression) {
    long long answer = 0;
    //연산자를 저장하는 벡터 생성
    // vector<char> oper;

    //수식을 보기 용이하게 하는 벡터 생성
    vector<string> fac;
    string s ="";
    for(int i=0; i<expression.length(); i++){
        if(expression[i] == '-' || expression[i] == '+' || expression[i] == '*'){
            // oper.push_back(expression[i]);
            fac.push_back(s);
            string c = "";
            c += expression[i];
            fac.push_back(c);
            s = "";
            continue;
        }
        s += expression[i];
        if(i==expression.length() -1) fac.push_back(s);
    }

    vector<char> oper = {'+', '-', '*'};
    sort(oper.begin(), oper.end());
    vector<string> fac_clone(fac);
    do{
        for(auto c: oper){
            string strc = "";
            strc += c;


            while(find(fac_clone.begin(), fac_clone.end(), strc) != fac_clone.end()){
                auto iter = find(fac_clone.begin(), fac_clone.end(), strc);
                string new_s = compute(fac_clone[iter - fac_clone.begin() -1], fac_clone[iter - fac_clone.begin() + 1], fac_clone[iter - fac_clone.begin()]);
                fac_clone.erase(iter - 1, iter + 2);
                fac_clone.insert(iter - 1, new_s);
            }
        }
        for(auto c: fac_clone) if(abs(stoll(c)) > answer) answer = abs(stoll(c));
        fac_clone = fac;
    }while(next_permutation(oper.begin(), oper.end()));

    return answer;
}