#include <bits/stdc++.h>
using namespace std;

int n;
vector<string> strVector;
bool comp(string s1, string s2){
    
    if(s1.length() != s2.length()){
        return s1.length() < s2.length();
    }
    return s1 < s2;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n;
    while(n--){
        string str;
        cin>>str;

        strVector.push_back(str);
    }
    sort(strVector.begin(), strVector.end(), comp);
    vector<string>::iterator iter;
    iter = unique(strVector.begin(), strVector.end());

    
    for(int i=0; i<iter - strVector.begin(); i++){
        cout<< strVector[i]<<'\n';
    }

}