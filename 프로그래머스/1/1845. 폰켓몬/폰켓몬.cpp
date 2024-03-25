#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int solution(vector<int> nums)
{
    unordered_map<int,int> monster;
    for(auto n : nums) monster[n]++;
    return min(monster.size(), nums.size() / 2);
}