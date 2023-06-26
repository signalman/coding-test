#include <bits/stdc++.h>
using namespace std;

vector<int> ryan(11,0), ryanResult;
vector<int> apeach;
int diffResult = -1;

pair<int, int> calculate(){
    pair<int, int> score; //first-apeach  second-ryan
    for(int i=0; i<11; i++){
        if(ryan[i] + apeach[i] == 0) continue;
        else{
            if(ryan[i]>apeach[i]) score.second += (10 - i);
            else score.first += (10 - i);
        }
    }
    return score;
}

void check(){
    pair<int, int> score = calculate();
    int apeachScore = score.first;
    int ryanScore = score.second;
    int diff = ryanScore - apeachScore;

    if(diff <= 0) return;
    if(diffResult == -1 && diff > 0){
        ryanResult = ryan;
        diffResult = diff;
        return;
    }
    if(diffResult < diff){
        ryanResult = ryan;
        diffResult = diff;
    }
    else if(diffResult == diff){
        for(int i=10; i>=0; i--){
            if(ryan[i] > ryanResult[i]){
                //변경로직
                ryanResult = ryan;
                diffResult = diff;
            }
            else if(ryan[i] == ryanResult[i]){
                continue;
            }
            break;
        }
    }
    return;
}

void dfs(int cnt, int idx, int n){
    int curArrow = n - cnt; //현재 남아있는 화살
    if(idx > 10){
        check();
        return;
    }
    if(idx == 10 && curArrow > 0) {ryan[10] = curArrow; dfs(cnt+curArrow, idx+1, n);}
    if(apeach[idx] < curArrow){
        ryan[idx] = apeach[idx]+1;
        dfs(cnt+ryan[idx],idx+1, n);
        ryan[idx] = 0;
        dfs(cnt, idx+1, n);
    }
    else{
        ryan[idx] = 0;
        dfs(cnt, idx+1, n);
    }
}

vector<int> solution(int n, vector<int> info) { //n은 총 화살개수, info는 어피치 점수벡터
    vector<int> answer;
    apeach = info;
    dfs(0, 0, n); //cnt, idx, n
    if(diffResult == -1) answer.push_back(-1);
    else{
        answer = ryanResult;
    }
    return answer;
}

int main(){
    int n = 5;
    vector<int> info = {2,1,1,1,0,0,0,0,0,0,0};
    vector<int> answer = solution(n, info);

    for(auto a: answer){
        cout<<a<<' ';
    }
    
}