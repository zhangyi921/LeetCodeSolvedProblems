class Solution {
    
    // a slighly better one
    // beats 100% java submission in runtime and memory usage
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        // add one to the last number
        if (digits[digits.length-1] == 9){
            carry = true;
            digits[digits.length-1] = 0;
        }else{
            ++digits[digits.length-1];
        }
        
        // if carry is true
        // keep adding one to the previous nubmers
        // until hit the first number
        int i = digits.length-2;
        while (carry){
            if (i < 0){
                // need to construct a new arry
                // copy the number in the digits to the result
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                for (int j = 1; j < result.length; ++j)
                    result[j] = digits[j-1];
                return result;
            }
            if (digits[i] == 9){
                digits[i] = 0;
                --i;
            }
            else{
                carry = false;
                ++digits[i];
            }
        }
        return digits;
    }
    
    // this is my first version
    // which already beats 100% java submission
    public int[] plusOne1(int[] digits) {
        boolean carry = false;
        // add one to the last number
        if (++digits[digits.length-1] == 10){
            carry = true;
            digits[digits.length-1] = 0;
        }
        
        // if carry is true
        // keep adding one to the previous nubmers
        // until hit the first number
        int i = digits.length-2;
        while (carry){
            if (i < 0){
                // need to construct a new arry
                // copy the number in the digits to the result
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                for (int j = 1; j < result.length; ++j)
                    result[j] = digits[j-1];
                return result;
            }
            if (++digits[i] == 10){
                digits[i] = 0;
                --i;
            }
            else{
                carry = false;
            }
        }
        return digits;
    }
}