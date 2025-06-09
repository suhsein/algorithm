class Solution {
    public int getSum(int a, int b) {
        if(b == 0) return a;

        int sumWithoutCarry = a ^ b; // XOR 연산 시 두 비트 다르면 1 -> 올림수 제외 더하기 수행
        int carry = (a & b) << 1;   // 둘 다 1이라면, 올림수가 되므로 1 비트 밀기
        
        return getSum(sumWithoutCarry, carry);
    }
}