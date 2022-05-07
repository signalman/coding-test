#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<vector<int>> math{ {1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5} };
    vector<int> count = { 0, 0, 0 };
    for (int i = 0; i < answers.size(); i++) {
        if (answers[i] == math[0][i % math[0].size()]) count[0]++;

        if (answers[i] == math[1][i % math[1].size()]) count[1]++;

        if (answers[i] == math[2][i % math[2].size()]) count[2]++;

    }

    int max = *max_element(count.begin(), count.end());

    for (int i = 0; i < 3; i++)
        if (max == count[i]) answer.push_back(i + 1);

    return answer;
}