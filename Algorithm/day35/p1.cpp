#include <bits/stdc++.h>
using namespace std;


void dfs(int* arr){
    *(arr + 1)= 5;
}
int main(){
    bool isTree = true;
    int arr[] = {1,2 ,34};
    dfs(arr);
    for(auto i: arr){
        cout<<i<<' ';
    }
}