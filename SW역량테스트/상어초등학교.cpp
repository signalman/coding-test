#include <bits/stdc++.h>
using namespace std;
#define MAX 20

int n;
int board[MAX][MAX];
struct STUDENT
{
  int num;
  int like[4];
};
vector<STUDENT> dt;
void solve(){

}
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<pow(n,2); i++){
    STUDENT s;
    int number;
    cin>>number;
    s.num = number;
    for(int t = 0; t < 4; t++){
      int like;
      cin>>like;
      s.like[t] = like;
    }
    dt.push_back(s);
  }

  for(int i=0; i<dt.size(); i++){
    int st_num = dt[i].num;
    
  }

  //현재 dt에 num의 좋아하는 학생의 번호를 파악 후 인접한 자리를 +1
  //max 값을 추적, 찾으면 업데이트 (vector 초기화 후 i, j저장)
  //같은 값이 나오면 새로운 vector에 i, j를 저장
  //vector의 값이 하나 이면 그대로 확정
  //두개 이상이면 그 칸 중 인접한 칸중 가장 많은 칸으로 자리 확정
  //그래도 두개 이상이면 맨 앞의 값으로 확정
}