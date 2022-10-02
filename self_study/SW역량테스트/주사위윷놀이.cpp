#include <bits/stdc++.h>
using namespace std;

int dices[10];
vector<int> locs(4); //말 4개의 공간 할당
int blue_to[33];
int red_to[33];
int scores[33] = 
  { 0, 2, 4, 6, 8, 10,
    12, 14, 16, 18, 20,
    22, 24, 26, 28, 30,
    32, 34, 36, 38, 40,
    13, 16, 19, 22, 24,
    28, 27, 26, 25, 30,
    35, 0 };
int ans;
void INPUT(){
  for(int i=0; i<10; i++){
    cin>>dices[i];
  }
}
void INIT(){
  //파란색 라인을 따라가야 하는 경우
  blue_to[5] = 21;
  blue_to[10] = 24;
  blue_to[15] = 26;
  //빨간색 라인을 따라가야 하는 경우
  for(int i=0; i<33; i++){
    red_to[i] = i + 1;
  }
  //빨간색 라인 중 예외경우 처리
  red_to[23] = 29;
  red_to[25] = 29;
  red_to[31] = 20;
  red_to[20] = 32;
}
void sol(int k, int tot){ //k 번째 주사위 처리, tot은 현재까지 총 score
  if(k==10){ //주사위 10개를 모두 처리했으면 ans변수 update 후 종료
    if(tot>ans) {
      ans = tot; 
      return;
    }
  }
  int dice = dices[k];//k번째 주사위의 눈금을 dice변수에 저장
  for(int i=0; i<4; i++){ //몇번째 말을 선택할 것인지
    int loc = locs[i]; //i번째 말의 현재 위치
    if(loc == 32) continue; //그 위치가 도착점이면 스킵
    for(int j=0; j<dice; j++){ //주사위 눈금만큼 움직임
      if(loc == 32) break; //움직이다가 도착점이면 끝냄
      if(j==0 && blue_to[loc]) loc = blue_to[loc]; //blue지점에서 움직일때는 blue라인을 따라감
      else{
        loc = red_to[loc]; //그렇지 않을 때는 red라인을 따라감
      }
    }
    if(loc != 32 && find(locs.begin(), locs.end(), loc) != locs.end()) continue; //움직인 자리가 도착지가 아니면서 다른 말이 있을 경우에는 스킵한다.
    int tmp = locs[i]; //백트래킹을 위한 tmp변수
    locs[i] = loc; //i번째 말의 현재 위치 update
    sol(k+1, tot+scores[loc]); //k+1번째 주사위 처리로 넘어감
    locs[i] = tmp; //백트래킹 원복시키기
  }
}
void SOLVE(){
  sol(0, 0);
  cout<<ans;
}
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  INPUT();
  INIT();
  SOLVE();
}