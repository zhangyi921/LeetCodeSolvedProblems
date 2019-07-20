class Solution {
    
    public int myAtoi(String str) {
        str=str.trim();
        if(str==null || str.length()==0)
            return 0;
        //str=str.trim();
        double result=0;
        char flag='+';
        int i=0;
        if(str.charAt(0)=='-'){
            flag='-';
            i++;
        }else  {
            if(str.charAt(0)=='+')
                i++;
        }
        System.out.println(str);
        while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
            System.out.println(result);
            result=result*10 + (str.charAt(i)-'0');
            i++;
        }
        if(flag=='-')
            result=-result;
        if(result<-2147483648)
            return -2147483648;
        if(result>2147483647)
            return 2147483647;
        
        return (int)result;
    }
    
    public int myAtoi1(String str) {
        
        str=str.trim();
        System.out.println(str);
        
        // initialize a hast table to check if a char is a number
        int[] hashTable = new int[128];
        for (int i = 0; i < hashTable.length; ++i){
            hashTable[i] = -2;
        }
        hashTable[45] = -1;
        for (int i = 0; i < 10; ++i){
            hashTable[i+48] = i;
        }
        int result = 0;
        
        // remove white space
        str = str.replaceAll(" ",""); 
          
        // check if first and second char are numbers
        if (str.length() > 1){
            // System.out.println(str+" "+hashTable[str.charAt(0)]+" "+hashTable[str.charAt(1)]);
            if (hashTable[str.charAt(0)] < 0 && hashTable[str.charAt(1)] < 0)
                return 0;
        }
        
        // remove every thing after a .
        int dotAt = str.indexOf('.');
        if (dotAt != -1)
            str = str.substring(0, dotAt);
        
        // if string is empty
        if (str.length() == 0)  return 0;
        
        // if first char is +
        if (str.charAt(0) == '+')
            str = str.substring(1, str.length());
        // System.out.println(str);
        
        // if string is empty
        if (str.length() == 0)  return 0;
        
        
        
        // if the leading char is not number, return 0
        if (hashTable[str.charAt(0)] == -2)  return 0;
        
        // go through each char, construct the result
        if (hashTable[str.charAt(0)] != -1){
            for (int i = 0; i < str.length(); ++i){
                if (hashTable[str.charAt(i)] != -2){
                    if ( result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && hashTable[str.charAt(i)]>7))
                        return Integer.MAX_VALUE;
                    result = result * 10 + hashTable[str.charAt(i)];
                }
                else{
                    return result;
                }

            }
        }
        else{
            for (int i = 1; i < str.length(); ++i){
                if (hashTable[str.charAt(i)] != -2){
                    if ( result < Integer.MIN_VALUE /10 || (result == Integer.MIN_VALUE /10 && hashTable[str.charAt(i)]<-8))
                        return Integer.MIN_VALUE;
                    result = result * 10 - hashTable[str.charAt(i)];
                }
                else{
                    return result;
                }

            }
        }
        return result;
    }
}