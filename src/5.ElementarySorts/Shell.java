/*
* Shellsort:  Java implementation
*/

@SuppressWarnings("rawtypes")
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        // 3x+1 increment sequence
        while (h < N / 3)
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) {
                // insertion sort
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            // move to next increment
            h = h / 3;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable v, Comparable w) {
        /* as before */
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        /* as before */ 
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}