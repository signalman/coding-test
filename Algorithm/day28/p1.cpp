#include <bits/stdc++.h>
using namespace std;
/**
 * fill, memcpy, split, 
*/
vector<string> split(string str, string deli){
    vector<string> ret;
    string s = "";
    long long pos = 0;
    while((pos = str.find(deli)) != string::npos){
        s = str.substr(0, pos);
        ret.push_back(s);
        str.erase(0, pos + deli.length());
    }
    ret.push_back(str);
    return ret;
}

vector<string> split(string str, string deli){
    vector<string> ret;
    string tmp = "";
    long long pos = 0;

    while((pos = str.find(deli)) != string::npos){
        tmp = str.substr(0, pos);
        ret.push_back(tmp);
        str.erase(0, pos + deli.length());
    }
    ret.push_back(str);
    return ret;
}

struct Point{
    int x, y;

    bool operator < (const Point &p){
        if(x == p.x){
            return y < p.y;
        }
        return x < p.x;
    }
};

vector<string> split(string str, string deli){
    vector<string> ret;
    string tmp = "";
    long long pos = 0;

    while((pos = str.find(deli)) != string::npos){
        tmp = str.substr(0, pos);
        ret.push_back(tmp);
        str.erase(0, pos + deli.length());
    }
    ret.push_back(str);
    return ret;
}



vector<string> split(string str, string deli){
    vector<string> ret;
    string tmp = "";
    long long pos = 0;

    while((pos = str.find(deli)) != string::npos){
        tmp = str.substr(0, pos);
        ret.push_back(tmp);
        str.erase(0, pos + deli.length());
    }
    ret.push_back(str);
    return ret;
}

int tmp[5];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int a[5] = {1,2,3,4,5};
    

    string str = "hello my name is hoin";
    vector<string> vec = split(str, " ");

    for(auto a: vec){
        cout<< a << '\n';
    }

    for(int i=0; i<5; i++){

        memcpy(tmp, a, sizeof(a));  //깊은 복사
    }
    tmp[2] = 122;
    for(auto i: a){
        cout<< i << ' ';
    }
    cout<<'\n';
    for(auto i: tmp){
        cout<< i << ' ';
    }

    fill(a, a+5, -1);
    for(auto i: a){
        cout<< i << ' ';
    }
}