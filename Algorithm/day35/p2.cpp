#include <bits/stdc++.h>
using namespace std;

vector<string> split(string in, string del) {
	vector<string> ret;
	long long pos = 0;
	string tmp = "";
	while ((pos = in.find(del)) != string::npos) {
		tmp = in.substr(0, pos);
		ret.push_back(tmp);
		in.erase(0, pos + del.length());
	}
	ret.push_back(in);
	return ret;
}

int main() {
	//split함수
	// string s = "hello, my name is hoin";
    
	// vector<string> ans = split(s, " ");
	// for (string s : ans) {
	// 	cout << s << '\n';
	// }

    // string s1, s2;
    // getline(cin, s1);
    // getline(cin, s2);
    // cout<<s1;
    // cout<<'\n'<<s2;
    string str;
    getline(cin, str);
    stringstream ss(str);
    vector<string> v;
    string tmp;
    while(getline(ss, tmp, ' ')){
        v.push_back(tmp);
    }
    for(auto s: v){
        cout<<s<<'\n';
    }


}