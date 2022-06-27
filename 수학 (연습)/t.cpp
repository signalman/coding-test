#include <bits/stdc++.h>
using namespace std;

int main(){
    string s ="hello world";
    if(s.find("world") != string::npos){
        cout<<s.find("world");
    }
    string::iterator iter = find(s.begin(), s.end(), "world");
    if(iter != s.end()){
        cout<< "hi";
    }
}