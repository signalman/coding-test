#include <bits/stdc++.h>
using namespace std;

void rotate(vector<string>& v){
    vector<string> tmp;
    tmp = v;
    v[0][0] = tmp[2][0];
    v[0][1] = tmp[1][0];
    v[0][2] = tmp[0][0];

    v[1][0] = tmp[2][1];
    v[1][1] = tmp[1][1];
    v[1][2] = tmp[0][1];

    v[2][0] = tmp[2][2];
    v[2][1] = tmp[1][2];
    v[2][2] = tmp[0][2];
}

struct Cube{
    vector<string> side[6] = {
        {"www", "www", "www"}, //위 0
        {"yyy", "yyy", "yyy"}, //아래 1
        {"rrr", "rrr", "rrr"}, //앞 2
        {"ooo", "ooo", "ooo"}, //뒤 3
        {"ggg", "ggg", "ggg"}, //왼 4
        {"bbb", "bbb", "bbb"}, //오 5
    };
    void upPlus(){
        string tmp = side[2][0];
        side[2][0] = side[5][0];
        side[5][0] = side[3][0];
        side[3][0] = side[4][0];
        side[4][0] = tmp;
        rotate(side[0]);
    }
    void upMinus(){
        upPlus();
        upPlus();
        upPlus();
    }
    void downPlus(){
        string tmp = side[3][2];
        side[3][2] = side[5][2];
        side[5][2] = side[2][2];
        side[2][2] = side[4][2];
        side[4][2] = tmp;
        rotate(side[1]);
    }
    void downMinus(){
        downPlus();
        downPlus();
        downPlus();
    }//0
    void frontPlus(){
        string tmp = side[0][2];
        string s = "";
        s += side[4][2][2];
        s += side[4][1][2];
        s += side[4][0][2];
        side[0][2] = s;

        side[4][0][2] = side[1][0][0];
        side[4][1][2] = side[1][0][1];
        side[4][2][2] = side[1][0][2];

        s = "";
        s += side[5][2][0];
        s += side[5][1][0];
        s += side[5][0][0];
        side[1][0] = s;

        side[5][0][0] = tmp[0];
        side[5][1][0] = tmp[1];
        side[5][2][0] = tmp[2];

        rotate(side[2]);

    }//o
    //위0  아래1  앞2 뒤3  왼4  오5
    void frontMinus(){
        frontPlus();
        frontPlus();
        frontPlus();
    }//o
    void backPlus(){
        string tmp = side[0][0];
        string s = "";
        s += side[5][0][2];
        s += side[5][1][2];
        s += side[5][2][2];
        side[0][0] = s;

        side[5][0][2] = side[1][2][2];
        side[5][1][2] = side[1][2][1];
        side[5][2][2] = side[1][2][0];

        s = "";
        s += side[4][0][0];
        s += side[4][1][0];
        s += side[4][2][0];
        side[1][2] = s;

        side[4][0][0] = tmp[2];
        side[4][1][0] = tmp[1];
        side[4][2][0] = tmp[0];
        rotate(side[3]);

    }//o
    //위0  아래1  앞2 뒤3  왼4  오5
    void backMinus(){
        backPlus();  
        backPlus();  
        backPlus();  
    }
    //위0  아래1  앞2 뒤3  왼4  오5
    void leftPlus(){
        string tmp =  "";
        tmp += side[0][0][0];
        tmp += side[0][1][0];
        tmp += side[0][2][0];
        side[0][0][0] = side[3][2][2];
        side[0][1][0] = side[3][1][2];
        side[0][2][0] = side[3][0][2];

        side[3][0][2] = side[1][2][0];
        side[3][1][2] = side[1][1][0];
        side[3][2][2] = side[1][0][0];

        side[1][0][0] = side[2][0][0];
        side[1][1][0] = side[2][1][0];
        side[1][2][0] = side[2][2][0];

        side[2][0][0] = tmp[0];
        side[2][1][0] = tmp[1];
        side[2][2][0] = tmp[2];
        rotate(side[4]);

    }
    void leftMinus(){
        leftPlus();
        leftPlus();
        leftPlus();
    }

    //위0  아래1  앞2 뒤3  왼4  오5
    void rightPlus(){
        string tmp = "";
        tmp += side[0][0][2];
        tmp += side[0][1][2];
        tmp += side[0][2][2];
        side[0][0][2] = side[2][0][2];
        side[0][1][2] = side[2][1][2];
        side[0][2][2] = side[2][2][2];

        side[2][0][2] = side[1][0][2];
        side[2][1][2] = side[1][1][2];
        side[2][2][2] = side[1][2][2];

        side[1][0][2] = side[3][2][0];
        side[1][1][2] = side[3][1][0];
        side[1][2][2] = side[3][0][0];

        side[3][0][0] = tmp[2];
        side[3][1][0] = tmp[1];
        side[3][2][0] = tmp[0];
        rotate(side[5]);

    }
    void rightMinus(){
        rightPlus();
        rightPlus();
        rightPlus();
    }
};


vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;

    while (getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }

    return answer;
}
int main(){  //위:흰, 아래:노, 앞:빨, 왼:초, 오른:파
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int testCase;
    cin>>testCase;

    while(testCase--){
        Cube cube;
        int count;
        cin>>count;
        while(count--){
            char arr[3];
            cin>>arr;

            if(arr[0] == 'F' && arr[1] == '+'){
                cube.frontPlus();
            }
            else if(arr[0] == 'F' && arr[1] == '-'){
                cube.frontMinus();
            }
            else if(arr[0] == 'B' && arr[1] == '+'){
                cube.backPlus();

            }
            else if(arr[0] == 'B' && arr[1] == '-'){
                cube.backMinus();

            }
            else if(arr[0] == 'U' && arr[1] == '+'){
                cube.upPlus();

            }
            else if(arr[0] == 'U' && arr[1] == '-'){
                cube.upMinus();

            }
            else if(arr[0] == 'D' && arr[1] == '+'){
                cube.downPlus();

            }
            else if(arr[0] == 'D' && arr[1] == '-'){
                cube.downMinus();

            }
            else if(arr[0] == 'R' && arr[1] == '+'){
                cube.rightPlus();

            }
            else if(arr[0] == 'R' && arr[1] == '-'){
                cube.rightMinus();

            }    
            else if(arr[0] == 'L' && arr[1] == '+'){
                cube.leftPlus();

            }
            else if(arr[0] == 'L' && arr[1] == '-'){
                cube.leftMinus();
            }                                                                                                      
        }

        auto side = cube.side[0];
        for(string s: side){
            cout<< s << '\n';
        }
    }
}