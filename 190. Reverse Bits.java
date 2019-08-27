public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        
        // check first 31 bits
        for (int i = 0; i < 31; ++i){
            int temp  = n & 1;
            if (temp == 1)
                result = result | 1;
            result <<= 1 ;
            n >>= 1;
            
        }
        
        // check last bit, don't shfit
        int temp  = n & 1;
        if (temp == 1)
            result = result | 1;
        return result;
    }
}