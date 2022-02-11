package com.learning.java8;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;

public class SortTest {

    @Test
    public void sortTest(){
        Integer[] a = {4, 3, 2, 1, 0, 5, 6, 7, 8};
        Integer[] b = {4, 3, 2, 1, 0, 5, 6, 7, 8};
        mergeSort(a, b, 0, 9, 0);
        System.out.println(JSONObject.toJSONString(b));
    }

    private  void mergeSort(Object[] src,
                                  Object[] dest,
                                  int low,
                                  int high,
                                  int off) {
        int length = high - low;

        // Insertion sort on smallest arrays
        if (length < 7) {
            for (int i=low; i<high; i++)
                for (int j=i; j>low &&
                        ((Comparable) dest[j-1]).compareTo(dest[j])>0; j--)
                    swap(dest, j, j-1);
            return;
        }

        // Recursively sort halves of dest into src
        int destLow  = low;
        int destHigh = high;
        low  += off;
        high += off;
        int mid = (low + high) >>> 1;
        mergeSort(dest, src, low, mid, -off);
        mergeSort(dest, src, mid, high, -off);

        // If list is already sorted, just copy from src to dest.  This is an
        // optimization that results in faster sorts for nearly ordered lists.
        if (((Comparable)src[mid-1]).compareTo(src[mid]) <= 0) {
            System.arraycopy(src, low, dest, destLow, length);
            return;
        }

        // Merge sorted halves (now in src) into dest
        for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if (q >= high || p < mid && ((Comparable)src[p]).compareTo(src[q])<=0)
                dest[i] = src[p++];
            else
                dest[i] = src[q++];
        }
    }

    private void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    @Test
    public void testRoll(){
        Integer[] a = {0};
        add(a);
        System.out.println(a[0]);
    }

    private void add(Integer[] a){
        if(a[0] > 5){
            return;
        }
        a[0]++;
        add(a);
    }

}
