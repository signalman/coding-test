#include <bits/stdc++.h>
using namespace std;

// struct Shark{
//     int x,y,z,s,d;
//     Shark(int x, int y, int z, int s, int d){
//         x = x;
//         y = y;
//         z= z;
//         s = s;
//         d = d;
//     }
// };
class Shark{
public:
    int x, y, z, d, s;
    Shark(){
        this->z= 0;
    }
    Shark(int x, int y, int z, int d, int s){
        this->x = x;
        this->y = y;
        this->d = d;
        this->s = s;
        this->z = z;
    }
};
int main(){
    int x = 3, y =3;
    cout<<x<<y;
    Shark shark = Shark();
    cout<<shark.z;

}