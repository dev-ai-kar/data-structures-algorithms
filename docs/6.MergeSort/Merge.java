/*
Merging:  Java implementation
       lo    i mid   j   hi
aux[]  A G L O R H I M S T
a[]    A G H I L M

 */

public class Merge{

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
    assert isSorted(a, lo, mid);    // precondition: a[lo..mid]   sorted
    assert isSorted(a, mid+1, hi);  // precondition: a[mid+1..hi] sorted
    
    // copy
    for (int k = lo; k <= hi; k++)
    aux[k] = a[k];
    int i = lo, j = mid+1;
    
    // merge
    for (int k = lo; k <= hi; k++) 
        {
        if      (i > mid)              a[k] = aux[j++];
        else if (j > hi)               a[k] = aux[i++];
        else if (less(aux[j], aux[i])) a[k] = aux[j++];
        else                           a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);     // postcondition: a[lo..hi] sorted
    } 

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);

    }

    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi)
    {
        for (int i = lo + 1; i <= hi; i++)
        if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
        System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        String[] a = {"A", "G", "L", "O", "R", "H", "I", "M", "S", "T"};
        sort(a);
        show(a);
    }
}