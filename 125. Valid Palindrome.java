class Solution {
    public boolean isPalindrome(String s) {
        String temp = s.toLowerCase();
        int i = 0, j = temp.length()-1;
        int c = 0;
        while (j > i){
            // move i to the char at left ignore none letter
            c = temp.charAt(i);
            while((c < 48 || (c > 57 && c < 97) || c > 122) && i < j){
                ++i;
                c = temp.charAt(i);
            }
            
            // move j to the char at right ignore none letter
            c = temp.charAt(j);
            while((c < 48 || (c > 57 && c < 97) || c > 122) && i < j){
                --j;
                c = temp.charAt(j);
            }
            
            // check if they are eauql
            System.out.println(temp.charAt(i) + " " + temp.charAt(j));
            if (temp.charAt(i) != temp.charAt(j))
                return false;
            
            // move i and j
            ++i;
            --j;
            
        }
        return true;
    }
}