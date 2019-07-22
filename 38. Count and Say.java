class Solution {
    public String countAndSay(int n) {
        int i = 1;
        String result = "1";
        while (i < n){
            int j = 1, count = 1;
            String temp = "";
            for (; j < result.length(); ++j, ++count){
                if (result.charAt(j-1) != result.charAt(j)){
                    // put same number in temp
                    temp = temp.concat(Integer.toString(count));
                    temp = temp.concat(Character.toString(result.charAt(j-1)));
                    count = 0;
                }
            }
            temp = temp.concat(Integer.toString(count));
            temp = temp.concat(Character.toString(result.charAt(j-1)));
            // System.out.println(temp);
            result = temp;
            ++i;
        }
        return result;
    }
}