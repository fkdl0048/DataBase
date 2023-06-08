package org.dfpl.db.hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.dfpl.db.hash.m18011690.MyHashSet;

public class UnitTest4 {
	public static void main(String[] args) {
		//Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set = new MyHashSet();
		
		// 위의 set이 아니라 학생들의 MyHashSet으로 동일하게 동작해야 함
		// Set<Integer> set = new MyHashSet<Integer>();
		// MyHashSet이 MyThreeWayBTree로 구현되어 있다면, 한 항목당 1점
		// 배열 혹은 LinkedList 등의 제공된 컬렉션으로 구현되어 있다면, 한 항목당 0.5점
		System.out.println("[1] " + set.isEmpty());
		for (int i = 0; i < 30; i++) {
			set.add(i);
		}
		System.out.println("[2] " + set.contains(3));
		System.out.println("[3] " + set.contains(30));
		System.out.println("[4] " + set.isEmpty());
		System.out.println("[5] " + set.size());
		Iterator<Integer> iter = set.iterator();
		String join = "";
		while (iter.hasNext()) {
			join += iter.next() + ",";
		}
		join = join.substring(0, join.length() - 1);
		// B-Tree 점수 획득을 위해서는 각 Hash Table Bucket 내의 요소는 '오름차순'으로 출력되어야 한다.
		// 부분점수를 위한 구현이라면 순서 상관없이 모든 항목이 출력되어야 한다. 
		// 예 1: 0,3,6,9,12,15,18,21,24,27,1,4,7,10,13,16,19,22,25,28,2,5,8,11,14,17,20,23,26,29
		// 예 2: 1,4,7,10,13,16,19,22,25,28,0,3,6,9,12,15,18,21,24,27,2,5,8,11,14,17,20,23,26,29
		System.out.println("[6] " + join);
		
	}
}
