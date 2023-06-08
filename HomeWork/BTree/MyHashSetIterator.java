package org.dfpl.db.hash.m18011690;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyHashSetIterator implements Iterator<Integer> {

	private List<Integer> data;

    public MyHashSetIterator(MyThreeWayBTree[] hashTable) {
    	data = new ArrayList<Integer>();
    	
    	for (var bTree : hashTable) {
			data.addAll(bTree.getAllTreeKey());
		}
    	
    	data.sort(null);
    }

    @Override
    public boolean hasNext() {
    	if (data.isEmpty())
    		return false;
    	return true;
    }

    @Override
    public Integer next() {
    	if (hasNext())
    	{
    		Integer key = data.get(0);
    		data.remove(0);
    		return key;
    	}
    	else
    	{
    		throw new NoSuchElementException();
    	}
    }
}
