#include <bits/stdc++.h>
using namespace std;


bool cmp(tuple<int, int, int> a, tuple<int, int, int> b){
    return get<0>(a) * get<1>(a) + get<0>(a) * get<2>(a) + get<1>(a) * get<2>(a) < get<0>(b) * get<1>(b) + get<0>(b) * get<2>(b) + get<1>(b) * get<2>(b);
}

int main(){
    int m;
    cin>>m;
    vector<tuple<int, int, int>> v;
    for(int w=1; w<=50; w++){
        for(int r=w; r<=50; r++){
            for(int h=r; h<=50; h++){
                if(w * r * h >= m){
                    v.push_back(make_tuple(w, r, h));
                }
            }
        }
    }

    sort(v.begin(), v.end(), cmp);
    tuple<int, int ,int> a = v.front();
    cout<<get<0>(a) << get<1>(a) << get<2>(a);

}