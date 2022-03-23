#include <iostream>
#include <string>
#include <vector>
#define X first
#define Y second
using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int board[4][3] = {
        {1, 2, 3}, 
        {4, 5, 6}, 
        {7, 8, 9}, 
        {-1, 0, -1}
    };
    pair<int, int> left = {3, 0};
    pair<int, int> right = {3, 2};
    for(int i=0; i<numbers.size(); i++){
        if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
            answer.push_back('L');
            for(int x=0; x<4; x++){
                for(int y=0; y<3; y++){
                    if(board[x][y] == numbers[i]){
                        left = {x, y};
                    }
                }
            }
        }
        else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
            answer.push_back('R');
            for(int x=0; x<4; x++){
                for(int y=0; y<3; y++){
                    if(board[x][y] == numbers[i]){
                        right = {x, y};
                    }
                }
            }
        }
        else {
            int rdist = 0; 
            int ldist = 0;
            for(int x=0; x<4; x++){
                for(int y=0; y<3; y++){
                    if(board[x][y] == numbers[i]){
                        rdist = abs(right.X - x) + abs(right.Y - y);
                        ldist = abs(left.X - x) + abs(left.Y - y);
                    }
                }
            }
            
            if(rdist<ldist){
                answer.push_back('R');
                for(int x=0; x<4; x++){
                    for(int y=0; y<3; y++){
                        if(board[x][y] == numbers[i]){
                            right = {x, y};
                        }
                    }
                }
            }
            else if(rdist>ldist){
                answer.push_back('L');
                for(int x=0; x<4; x++){
                    for(int y=0; y<3; y++){
                        if(board[x][y] == numbers[i]){
                        left = {x, y};
                        }
                    }
                }
            }
            else{
                if(hand == "left"){
                    answer.push_back('L');
                    for(int x=0; x<4; x++){
                        for(int y=0; y<3; y++){
                            if(board[x][y] == numbers[i]){
                            left = {x, y};
                            }
                        }
                    }
                }
                else{
                    answer.push_back('R');
                    for(int x=0; x<4; x++){
                        for(int y=0; y<3; y++){
                            if(board[x][y] == numbers[i]){
                                right = {x, y};
                            }
                        }
                    }
                }
            }
            cout<<"rdist: "<< rdist << ' ' << "ldist: "<< ldist <<'\n';
        }
        cout<<"right: "<<right.X<<' ' <<right.Y<<'\n';
        cout<<"left: "<<left.X << ' ' << left.Y <<'\n';
        
    }
    return answer;
}

int main(){
  vector<int> numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
  string hand = "right";
  
  string ans = solution(numbers, hand);
  for(int i=0; i<ans.size(); i++){
    cout<<ans[i];
  }
}