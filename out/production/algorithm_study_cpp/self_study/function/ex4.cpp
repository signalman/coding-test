#include <iostream>
#include <array>
using namespace std;

class Vector2
{
public:
  Vector2() : x(0), y(0){};
  Vector2(float x_, float y_) : x(x_), y(y_){};
  float GetX()const{return x;}
  float GetY()const{return y;}
  Vector2 operator+(const Vector2 rhs)const;
  Vector2 operator-(const Vector2 rhs)const;
  Vector2 operator*(const float rhs)const;
  Vector2 operator/(const float rhs)const;
  float operator*(const Vector2 rhs)const;
private:
  float x, y;
};

  Vector2 Sum(Vector2 a, Vector2 b){
    return Vector2(a.GetX()+b.GetX(), a.GetY()+b.GetY());
  }

int main(){
  Vector2 a(2,3);
  Vector2 b(-1,4);
  Vector2 c1= Sum(a, b);
  Vector2 c2 = a.operator+(b);
  Vector2 c3 = a+b;
  Vector2 c4 = a-b;

  cout<<c1.GetX() << ", " <<c1.GetY()<<endl;
  cout<<c2.GetX() << ", " <<c2.GetY()<<endl;
  cout<<c3.GetX() << ", " <<c3.GetY()<<endl;
  cout<<c4.GetX() << ", " <<c4.GetY()<<endl;

  
  
  return 0;
}


Vector2 Vector2::operator+(const Vector2 rhs)const{
    return Vector2(x+rhs.x, y+rhs.y);
  }
Vector2 Vector2:: operator-(const Vector2 rhs)const{
    return Vector2(x-rhs.x, y-rhs.y);
  }
Vector2 Vector2:: operator*(const float rhs)const{
    return Vector2(x*rhs, y*rhs);
  }
Vector2 Vector2:: operator/(const float rhs)const{
    return Vector2(x/rhs, y/rhs);
  }
float Vector2::operator*(const Vector2 rhs)const{
    return x*(rhs.x)+y*(rhs.y);
  }

  