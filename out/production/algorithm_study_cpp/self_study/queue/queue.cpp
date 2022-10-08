#include "queue.h"

Queue::Queue(int maxSize){
  maxQueueSize=maxSize;
  this->front =-1;
  this->rear=-1;
}
void Queue::isEmpty() {
	if (rear == front) {
		cout << "큐가 비었습니다.\n";
	}
}

void Queue::isFull() {
	if (rear == maxQueueSize) {
		cout << "큐가 꽉찼습니다.\n";
	}
}
void Queue::push(int item) {
	if (rear >= maxQueueSize) {
		isFull();
	}
	else {
		queue[++rear] = item;
		cout << rear << "번째에 " << item << "이 push 되었습니다.\n";
	}
}

void Queue::pop() {
	if (rear == front) {
		isEmpty();
	}
	else {
		++front;
		cout << front << "번째에 " << queue[front] << "이 pop 되었습니다.\n";
	}
}

void Queue::showQueue(){
	cout << "현재 큐에 존재하는 수는\n";
	for (int i = 0; i < maxQueueSize; i++) {
		cout << queue[i] << " ";
	}
	cout << "\n";
}