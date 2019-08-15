class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb;
        
        for (int i = 1; i < n+1; ++i){
            sb = new StringBuilder();
            if (i%3 == 0)
                sb.append("Fizz");
            if (i%5 == 0)
                sb.append("Buzz");
            if (sb.length() == 0)
                sb.append(i);
            result.add(sb.toString());
            
        }
        return result;
    }
}