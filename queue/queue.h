#include <iostream>
using namespace std;

class Queue{
private:
  int maxQueueSize;
  int queue[100]={0,};
  int front;
  int rear;

public:
  Queue(int);
  void isEmpty();
  void isFull();
  void push(int item);
  void pop();
  void showQueue();
};