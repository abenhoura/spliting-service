package com.adneom;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/***
 * @author Abderrahmane.Benhoura
 * @version 1.0.0
 * @param <T>
 */

public final class Partition<T> extends AbstractList<List<T>> {

    /***
     *     @param list
     *     list to split -must be not null-
     *
     *     @return splited list with the chunkSize specified
     *
     *     @throws IllegalArgumentException  if bad arguments (list null or chunkSize<=0)
     */
    private final List<T> list;
    private final int chunkSize;

    public Partition(List<T> list, int chunkSize) {
        if(chunkSize <= 0 || list==null ) throw new IllegalArgumentException();
        this.list = new ArrayList<>(list);
        this.chunkSize = chunkSize;
    }

    public static <T> Partition<T> partition(List<T> list , int chunkSize ) {
        return new Partition<>(list, chunkSize);
    }

    @Override
    public List<T> get(int index) {
        int start = index * chunkSize;
        int end = Math.min(start + chunkSize, list.size());
        return new ArrayList<>(list.subList(start, end));
    }

    @Override
    public int size() {
        return (int) Math.ceil((double) list.size() / (double) chunkSize);
    }
}