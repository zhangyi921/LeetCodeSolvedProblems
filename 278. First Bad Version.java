/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {

    // Your runtime beats 99.54 % of java submissions
    public int firstBadVersion(int n) {
        
        if (isBadVersion(1))
            return 1;
            
        
        // binary search
        long start = 1, end = (long) n;
        while (start < end-1){
            long middle = (start+end)/2;
            if (isBadVersion((int) middle))
                end = middle;
            else
                start = middle;
        }
        return (int) end;
    }
}