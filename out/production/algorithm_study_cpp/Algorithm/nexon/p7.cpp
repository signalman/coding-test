#include <bits/stdc++.h>
using namespace std;

int main(){
    string word[] = {"pi", "ka", "chu"};
    string s;
    cin>>s;

    int i = 0;
    while(s.size() != 0){
        if(s[0] == 'p' && s[1] == 'i') {
            s.erase(0, 2);
        }
        else if(s[0]=='k' && s[1] =='a'){
            s.erase(0, 2);
        }
        else if(s[0]=='c' &&s[1]=='h' && s[2] =='u'){
            s.erase(0, 3);
        }
        else {cout<<"NO"; return 0;}
    }
    cout<<"YES";

}