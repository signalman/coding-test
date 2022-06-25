#include <bits/stdc++.h>
using namespace std;

bool cmp(string a, string b){
    //모두 소문자로 치환
    for(int i=0; i<a.size(); i++) if(a[i]>='A' && a[i]<='Z') a[i] = tolower(a[i]);
    for(int i=0; i<b.size(); i++) if(b[i]>='A' && b[i]<= 'Z') b[i]= tolower(b[i]);
    //사용할 변수 생성
    string head1, head2, number1, number2 = "";
    int idx_header1;
    int idx_header2;
    //head1, head2, number1, number2에 값 대입
    for(int i=0; i<a.size(); i++){
        if(a[i] >= '0' && a[i] <='9') {idx_header1 = i; break;}
        head1 += a[i];
    }
    for(int i=0; i<b.size(); i++){
        if(b[i] >= '0' && b[i] <='9') {idx_header2 = i; break;}
        head2 += b[i];
    }
    for(int i=idx_header1; i<a.size(); i++){
        if(a[i] < '0' || a[i] >'9') break;
        if(number1.size()>=5) break;
        number1+=a[i];
    }
    for(int i=idx_header2; i<b.size(); i++){
        if(b[i] < '0' || b[i] >'9') break;
        if(number2.size()>=5) break;
        number2+=b[i];
    }
    if(head1 != head2) return head1 < head2;
    if(stoi(number1) != stoi(number2)) return stoi(number1) < stoi(number2);
}


vector<string> solution(vector<string> files) {
    vector<string> answer;
    stable_sort(files.begin(), files.end(), cmp);
    answer = files;
    return answer;
}