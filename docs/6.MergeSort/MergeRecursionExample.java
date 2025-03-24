public class MergeRecursionExample {
    2	
    3	    public static void main(String[] args) {
    4	        String[] a = {"A", "G", "L", "O", "R", "H", "I", "M", "S", "T"};
    5	        sort(a, 0, a.length - 1);
    6	    }
    7	
    8	    private static void sort(Comparable[] a, int lo, int hi) {
    9	        if (hi <= lo) {
    10	            System.out.println("Base case: lo = " + lo + ", hi = " + hi);
    11	            return;
    12	        }
    13	        int mid = lo + (hi - lo) / 2;
    14	        
    15	        // Split and sort left half
    16	        System.out.println("Split left:  [" + lo + "..." + mid + "]");
    17	        sort(a, lo, mid);
    18	        
    19	        // Split and sort right half
    20	        System.out.println("Split right: [" + (mid+1) + "..." + hi + "]");
    21	        sort(a, mid + 1, hi);
    22	        
    23	        // Merge step (hypothetical)
    24	        System.out.println("Merge: [" + lo + "..." + mid + "] and [" + (mid+1) + "..." + hi + "]");
    25	    }
    26	}