import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    /*
      Returns the number of elements in the half-open range [begin, end).
      Time complexity: O(n)
     */
    public static <E>
    int distance(Iterator<E> begin, Iterator<E> end) {
        int n = 0;
        for (Iterator<E> i = begin.clone(); !i.equals(end); i.advance()) {
            ++n;
        }
        return n;
    }

    /*
     Copies the elements in the range `[source_begin,source_end)` into the
     range `[destintation_begin, destination_end)`
     where `destintation_end` is the return value of `copy`.
     Time complexity: O(n)
     */
    public static <E>
    Iterator<E> copy(Iterator<E> source_begin, Iterator<E> source_end, Iterator<E> destination_begin) {
        Iterator<E> destination_end = destination_begin.clone();
        for (Iterator<E> i = source_begin.clone(); !i.equals(source_end); i.advance()) {
            destination_end.set(i.get());
            destination_end.advance();
        }
        return destination_end;
    }

    /*
      Create an array of the specified size, with all the elements initialized to `null`.
     */
    public static <E>
    ArrayList<E> make_array(int size) {
        ArrayList<E> array = new ArrayList<>(size);
        for (int i = 0; i != size; ++i) {
            array.add(null);
        }
        return array;
    }

    /*
     Precondition: the input ranges [begin1,end1) and [begin2,end2) are sorted.
     Let n be the number of elements in the first range and m be the number of elements in the second range.
     The elements from both ranges are written to the range [result, result.advance(n+m)) in such a way
     that the result is in sorted order according to `Comparable`.
     Returns an iterator for the position result.advance(n+m).
     */
    public static <E extends Comparable<? super E>>
    Iterator<E> merge(Iterator<E> begin1, Iterator<E> end1,
                      Iterator<E> begin2, Iterator<E> end2,
                      Iterator<E> result) {
        Iterator<E> i1 = begin1.clone();
        Iterator<E> i2 = begin2.clone();
        Iterator<E> res = result.clone();

        while (!i1.equals(end1) && !i2.equals(end2)) {
            if (i1.get().compareTo(i2.get()) <= 0) {
                res.set(i1.get());
                i1.advance();
            } else {
                res.set(i2.get());
                i2.advance();
            }
            res.advance();
        }

        while (!i1.equals(end1)) {
            res.set(i1.get());
            i1.advance();
            res.advance();
        }

        while (!i2.equals(end2)) {
            res.set(i2.get());
            i2.advance();
            res.advance();
        }

        return res;
    }

    public static <E extends Comparable<? super E>>
    void sort(Iterator<E> begin, Iterator<E> end) {
        int n = distance(begin, end);
        if (n <= 1) return;
    
        Iterator<E> mid = begin.clone();
        for (int i = 0; i < n / 2; i++) {
            mid.advance();
        }
    
        sort(begin, mid);
        sort(mid, end);
    
        List<E> tempArray = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tempArray.add(null);
        }
    
        Iterator<E> begin1 = begin.clone();
        Iterator<E> end1 = mid.clone();
        Iterator<E> begin2 = mid.clone();
        Iterator<E> end2 = end.clone();
        int tempIndex = 0;
    
        while (!begin1.equals(end1) && !begin2.equals(end2)) {
            if (begin1.get().compareTo(begin2.get()) <= 0) {
                tempArray.set(tempIndex++, begin1.get());
                begin1.advance();
            } else {
                tempArray.set(tempIndex++, begin2.get());
                begin2.advance();
            }
        }
    
        while (!begin1.equals(end1)) {
            tempArray.set(tempIndex++, begin1.get());
            begin1.advance();
        }
    
        while (!begin2.equals(end2)) {
            tempArray.set(tempIndex++, begin2.get());
            begin2.advance();
        }
    
        begin = begin.clone();
        for (int i = 0; i < n; i++) {
            begin.set(tempArray.get(i));
            begin.advance();
        }
    }
}
