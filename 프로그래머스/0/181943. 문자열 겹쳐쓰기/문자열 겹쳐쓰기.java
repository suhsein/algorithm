class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int overwrite_sz = overwrite_string.length();
        int sz = my_string.length();
        answer = my_string.substring(0, s);
        answer += overwrite_string;
        int offset = s+ overwrite_sz;
        if(offset < sz) {
            answer += my_string.substring(offset, sz);
        }
        return answer;
    }
}