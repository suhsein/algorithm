public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        int bits = 32 - s.length();
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--) 
            sb.append(s.charAt(i));
        
        int answer = Integer.parseUnsignedInt(sb.toString(), 2);

        while(bits-- > 0) 
            answer <<= 1;
        
        return answer;
    }
}