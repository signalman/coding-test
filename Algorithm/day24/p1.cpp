#include <bits/stdc++.h>
using namespace std;
/**
 * 1이닝에서 정해진 순서 대로 나머지 이닝의 순서도 바껴야함.
 * 0번부터 8번선수까지 있을때 
 * 0번선수는 4번째가 고정이므로
 * 1번부터 8번까지의 순열
*/
const int MX = 52;
int order[8] = {1, 2, 3, 4, 5, 6, 7, 8};//앞에 3명은 0,1,2번 뒤에 5명은 4,5,6,7,8번
int N;
int mx_ans;
vector<int> innings[MX];

vector<int> updateOrder(const vector<int>& nth_innings, int n_order[8]){

    vector<int> ret(9);
    ret[3] = nth_innings[0];
    for(int i=0; i<8; i++){
        int nth_person = n_order[i];
        if(i < 3){
            ret[i] = nth_innings[nth_person];
        }
        else{
            ret[i+1] = nth_innings[nth_person];
        }
    }
    return ret;
}
//list로는 안되고 deque로는 통과?
void playGame(vector<int> new_innings[MX]){
    int outCount = 0;
    int totalScore = 0;
    int person = 0;
    deque<int> list;

    for(int i=0; i<N; i++){ //새 이닝 시작
        outCount = 0;
        list.clear();
        while(outCount < 3){ //한 이닝 동안
            int hit = new_innings[i][person];
            if(hit == 0){
                outCount++;
            }
            else{
                if(!list.empty()){
                    for(auto& l: list){
                        l += hit;
                    }
                }
                list.push_back(hit);
                while(!list.empty() && list.front() >= 4){
                    totalScore++;
                    list.pop_front();
                }
            }
            person = (person + 1) % 9;
        }
    }
    mx_ans = max(mx_ans, totalScore);
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=0; i<N; i++){
        for(int p=0; p<9; p++){
            int result;
            cin>> result;
            innings[i].push_back(result);  //i번째 이닝의 결과가 들어있는 벡터 (선수 순서대로)
        }
    }

    vector<int> new_innings[N];
    //order의 변경
    do{
        for(int i=0; i<N; i++){
            new_innings[i] = updateOrder(innings[i], order);
        }
        playGame(new_innings);
        
    }while(next_permutation(order, order+8));

    cout<< mx_ans << '\n';
}