#include <bits/stdc++.h>
using namespace std;

bool solution(vector<string> phone_book) {
    bool flag = true;
    sort(phone_book.begin(), phone_book.end());
    for(int i=0; i<phone_book.size()-1; i++){
        string st1;
        string st2;
        st1 = phone_book[i];
        st2 = phone_book[i+1];
        for(int j=0; j<st1.size(); j++){
            if(st1[j] != st2[j]){
                flag = true;
                break;
            }
            else{
                flag = false;
            }
        }
       if(!flag) return flag;
    }
    return flag;

}