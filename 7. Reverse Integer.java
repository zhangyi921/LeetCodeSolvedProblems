class Solution {
    // my first version
    // slow and dum
    public int reverse2(int x) {
        int remainder = -1, divider = 10, result = 0, pop;
        Stack<Integer> stack = new Stack<Integer>(); 
        while (x != 0){
            // remainder = x%divider;
            // stack.push(remainder*10/divider);
            // x -= remainder;
            // divider *= 10;
            pop = x % 10;
            x /= 10;
            stack.push(pop);
        }
        System.out.println(stack);
        divider = 1;
        while (!stack.empty()){
            // System.out.println(result);
            if (stack.peek()>0 && (stack.peek() > Integer.MAX_VALUE/divider || Integer.MAX_VALUE-stack.peek()*divider < result)){
                // System.out.println("positive overflow");
                return 0;
            }
            else if (stack.peek()<0 && (stack.peek() < Integer.MIN_VALUE/divider || Integer.MIN_VALUE-stack.peek()*divider > result)){
                // System.out.println("negative overflow: "+stack.peek()+" "+divider);
                return 0;
            }
            result += stack.pop()*divider;
            divider *= 10;
        }
        // System.out.println(result);
        // System.out.println(Integer.MAX_VALUE);
        return result;
    }
    public int reverse(int x){
        int result = 0, pop;
        while (x != 0){
            pop = x %10;
            x /= 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && pop > Integer.MAX_VALUE - result*10)){
                
                return 0;
            }
                
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && pop < Integer.MIN_VALUE - result*10))
                return 0;
            
            result = result * 10 + pop;
        }
        return result;
    }
    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}