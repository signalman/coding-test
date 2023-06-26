#include <bits/stdc++.h>
using namespace std;

int n, w, L; //트럭수, 다리길이, 최대하중
int truck[11];
queue<int> q;
deque<pair<int,int>> bridge;  //트럭 무게, 다리에서의 위치
int main(){
    cin>>n>>w>>L;
    for(int i=0; i<n; i++){
        int truck;
        cin>>truck;
        q.push(truck);
    }

    int bridgeWeight = 0;
    int time = 0;

    while(!(q.empty() && bridge.empty())){
        time++;

        if(!bridge.empty()){
            //1씩 앞으로 옮김
            for(auto& t: bridge){
                t.second += 1;
            }
            //탈출조건
            if(bridge.front().second >= w) {
                bridgeWeight -= bridge.front().first;
                bridge.pop_front();
            }
        }

        if(!q.empty() &&bridgeWeight + q.front() <= L){
            bridgeWeight += q.front();
            bridge.push_back(make_pair(q.front(), 0));
            q.pop();
        }

    }

    cout<<time;

}

// #include <bits/stdc++.h>
// using namespace std;

// #define w first
// #define p second

// int main(){
//     ios::sync_with_stdio(0);
//     cin.tie(0);

//     int n, w, l;
//     cin >> n >> w >> l;

//     queue<int> truck;       // 다리 위에 올라가지 못한 트럭을 저장하는 queue

//     for(int i = 0; i < n; i++){ // 각 트럭의 무게 입력 받음
//         int w; cin >> w;
//         truck.push(w);  
//     }

//     deque<pair<int, int>> bridge;   // 다리 위에 있는 트럭을 저장하는 queue

//     int time = 0;   // 트럭들이 다리를 건너는 최단 시간
//     while(!truck.empty() || !bridge.empty()){  // 모두 다리를 건널 때까지 진행
//         for(int i = 0; i < bridge.size(); i++) bridge[i].p -= 1; // 다리 위 트럭 앞으로 1씩 이동

//         if(!bridge.empty() && bridge.front().p == 0) // 다리를 건넌 트럭은 bridge 큐에서 pop
//             bridge.pop_front();

//         int weight = 0;   
//         for(auto truck : bridge) weight += truck.w ;    // 다리 위에 있는 전체 트럭의 무게 계산

//         if(!truck.empty() && truck.front() + weight <= l  && bridge.size() < w){    // 다리 위에 트럭이 올라갈 자리가 있고, 다리의 최대 하중이 남은 경우
//             bridge.push_back({truck.front(), w});
//             truck.pop();
//         }

//         time++;
//     }

//     cout << time;
// }