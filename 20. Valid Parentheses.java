class Solution {
    
    HashSet<Character> open;
    HashMap<Character, Character> close;
    
    public boolean isValid(String s) {
        if (open == null){
            open = new HashSet<>();
            open.add('[');
            open.add('(');
            open.add('{');
            close = new HashMap<>();
            close.put(']', '[');
            close.put(')', '(');
            close.put('}', '{');
        }
        
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if (open.contains(ch))
                stack.push(ch);
            else if (stack.empty() ||  stack.pop() != close.get(ch))
                return false;
        }
        return stack.empty();
    }
}