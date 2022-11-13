#include <bits/stdc++.h>
using namespace std;

map<int, int> ratioOfMoney;
int ret;
int gthreshold;

void dfs(int money, int months, int cnt){
    if(cnt == months) {ret = money; return;}

    int virMoney = money - money % 100;
    if(virMoney < gthreshold) {ret = money; return;}

    int rate = --ratioOfMoney.end() -> second;
    auto iter = ratioOfMoney.begin();

    while(iter != ratioOfMoney.end()){
        if(iter->first > virMoney){
            rate = iter -> second;
            break;
        }
        ++iter;
    }
    cout<<money<<' ';

    int dif = virMoney * rate / 100;
    dfs(money - dif, months, cnt + 1);
}

int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
    if(maxratio == 0) return money;
    gthreshold = threshold;
    int i = threshold;
    int j = minratio;
    while(true){
        ratioOfMoney.insert({i, j});
        if(j == maxratio) break;
        i += ranksize;
        j += 1;
    }

    dfs(money, months, 0);
    return ret;
}