package org.dfpl.db.hash.m18011690;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet implements Set<Integer> {

	private MyThreeWayBTree[] hashTable;

	// 생성자 초기화 및 동적할당
	public MyHashSet() {
		hashTable = new MyThreeWayBTree[3];
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new MyThreeWayBTree();
		}
	}

	@Override
	public int size() {		
		int size = 0;	
		for (var bTree : hashTable) {
			size += bTree.size();
		}
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		for (var bTree : hashTable) {
			if (!bTree.isEmpty())
				return false;
		}
		
		return true;
	}

	@Override
	public boolean contains(Object o) {
		for (var bTree : hashTable) {
			if (bTree.contains(o))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean add(Integer e) {
		if (contains(e)) // 중복 넘김
			return false;
		
		hashTable[e.hashCode() % 3].add(e); // 해쉬 함수 (%3)
		return true;
	}
	
	@Override
	public boolean remove(Object o) {
		
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new MyHashSetIterator(hashTable);
	}

	// --------------------------------------------------
	
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
