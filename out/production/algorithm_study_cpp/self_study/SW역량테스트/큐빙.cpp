#include <bits/stdc++.h>
using namespace std;

int tCase;

void rotate(char arr[3][4]){
  char arr1[3][4]={};
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      int a = j;
      int b = 2-i;
      arr1[a][b] = arr[i][j];
    }
  }
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      arr[i][j] = arr1[i][j];
    }
  }
}
void crotate(char arr[3][4]){
  char arr1[3][4]={};
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      int a = 2-j;
      int b = i;
      arr1[a][b] = arr[i][j];
    }
  }
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      arr[i][j] = arr1[i][j];
    }
  }
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>tCase;
  while(tCase--){
    char cube[6][3][4] = {
      {{'w','w','w'},{'w','w','w'},{'w','w','w'}},
      {{'y','y','y'},{'y','y','y'},{'y','y','y'}},
      {{'r','r','r'},{'r','r','r'},{'r','r','r'}},
      {{'o','o','o'},{'o','o','o'},{'o','o','o'}},
      {{'g','g','g'},{'g','g','g'},{'g','g','g'}},
      {{'b','b','b'},{'b','b','b'},{'b','b','b'}},
    };
    int n;
    cin>>n;
    while(n--){
      char arr[3];
      cin>>arr[0]>>arr[1];
      switch (arr[0])
      {
      case 'U':
        if(arr[1]=='+'){
          swap(cube[2][0], cube[4][0]);
          swap(cube[2][0], cube[5][0]);
          swap(cube[3][0], cube[5][0]);
          rotate(cube[0]);
        }
        else{
          swap(cube[3][0], cube[5][0]);
          swap(cube[2][0], cube[5][0]);
          swap(cube[2][0], cube[4][0]);
          crotate(cube[0]);
        }
        break;
      case 'D':
        if(arr[1]=='+'){
          swap(cube[3][2], cube[5][2]);
          swap(cube[2][2], cube[5][2]);
          swap(cube[2][2], cube[4][2]);
          rotate(cube[1]);
        }
        else{
          swap(cube[2][2], cube[4][2]);
          swap(cube[2][2], cube[5][2]);
          swap(cube[3][2], cube[5][2]);
          crotate(cube[1]);
        }
        break;
      case 'F':
        if(arr[1]=='+'){
          swap(cube[0][2][0], cube[5][0][0]);
          swap(cube[0][2][1], cube[5][1][0]);
          swap(cube[0][2][2], cube[5][2][0]);

          swap(cube[0][2][0], cube[4][2][2]);
          swap(cube[0][2][1], cube[4][1][2]);
          swap(cube[0][2][2], cube[4][0][2]);

          swap(cube[1][0][0], cube[4][0][2]);
          swap(cube[1][0][1], cube[4][1][2]);
          swap(cube[1][0][2], cube[4][2][2]);
          rotate(cube[2]);

        }
        else{
          swap(cube[0][2][0], cube[5][0][0]);
          swap(cube[0][2][1], cube[5][1][0]);
          swap(cube[0][2][2], cube[5][2][0]);

          swap(cube[1][0][0], cube[5][2][0]);
          swap(cube[1][0][1], cube[5][1][0]);
          swap(cube[1][0][2], cube[5][0][0]);

          swap(cube[1][0][0], cube[4][0][2]);
          swap(cube[1][0][1], cube[4][1][2]);
          swap(cube[1][0][2], cube[4][2][2]);
          crotate(cube[2]);
        }
        break;
      case 'B':
        if(arr[1]=='+'){
          swap(cube[0][0][0], cube[5][0][2]);
          swap(cube[0][0][1], cube[5][1][2]);
          swap(cube[0][0][2], cube[5][2][2]);

          swap(cube[1][2][0], cube[5][2][2]);
          swap(cube[1][2][1], cube[5][1][2]);
          swap(cube[1][2][2], cube[5][0][2]);

          swap(cube[1][2][0], cube[4][0][0]);
          swap(cube[1][2][1], cube[4][1][0]);
          swap(cube[1][2][2], cube[4][2][0]);
          rotate(cube[3]);
        }
        else{
          swap(cube[0][0][0], cube[5][0][2]);
          swap(cube[0][0][1], cube[5][1][2]);
          swap(cube[0][0][2], cube[5][2][2]);

          swap(cube[0][0][0], cube[4][2][0]);
          swap(cube[0][0][1], cube[4][1][0]);
          swap(cube[0][0][2], cube[4][0][0]);
          
          swap(cube[1][2][0], cube[4][0][0]);
          swap(cube[1][2][1], cube[4][1][0]);
          swap(cube[1][2][2], cube[4][2][0]);
          crotate(cube[3]);
        }
        break;
      case 'L':
        if(arr[1]=='+'){
          swap(cube[0][0][0],cube[2][0][0]);
          swap(cube[0][1][0],cube[2][1][0]);
          swap(cube[0][2][0],cube[2][2][0]);
          
          swap(cube[0][0][0],cube[3][2][2]);
          swap(cube[0][1][0],cube[3][1][2]);
          swap(cube[0][2][0],cube[3][0][2]);

          swap(cube[1][0][0],cube[3][2][2]);
          swap(cube[1][1][0],cube[3][1][2]);
          swap(cube[1][2][0],cube[3][0][2]);
          rotate(cube[4]);
        }
        else{
          swap(cube[0][0][0],cube[2][0][0]);
          swap(cube[0][1][0],cube[2][1][0]);
          swap(cube[0][2][0],cube[2][2][0]);
          
          swap(cube[2][0][0],cube[1][0][0]);
          swap(cube[2][1][0],cube[1][1][0]);
          swap(cube[2][2][0],cube[1][2][0]);

          swap(cube[1][0][0],cube[3][2][2]);
          swap(cube[1][1][0],cube[3][1][2]);
          swap(cube[1][2][0],cube[3][0][2]);
          crotate(cube[4]);
        }
        break;
      case 'R':
        if(arr[1]=='+'){
          swap(cube[0][0][2], cube[3][2][0]);
          swap(cube[0][1][2], cube[3][1][0]);
          swap(cube[0][2][2], cube[3][0][0]);

          swap(cube[0][0][2], cube[2][0][2]);
          swap(cube[0][1][2], cube[2][1][2]);
          swap(cube[0][2][2], cube[2][2][2]);

          swap(cube[2][0][2], cube[1][0][2]);
          swap(cube[2][1][2], cube[1][1][2]);
          swap(cube[2][2][2], cube[1][2][2]);   
          rotate(cube[5]);       
        }
        else{
          swap(cube[0][0][2], cube[3][2][0]);
          swap(cube[0][1][2], cube[3][1][0]);
          swap(cube[0][2][2], cube[3][0][0]);

          swap(cube[3][0][0], cube[1][2][2]);
          swap(cube[3][1][0], cube[1][1][2]);
          swap(cube[3][2][0], cube[1][0][2]);

          swap(cube[2][0][2], cube[1][0][2]);
          swap(cube[2][1][2], cube[1][1][2]);
          swap(cube[2][2][2], cube[1][2][2]);  
          crotate(cube[5]);
        }
        break;
      }
    }
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        cout<<cube[0][i][j];
      }
      cout<<'\n';
    }
  }
}
