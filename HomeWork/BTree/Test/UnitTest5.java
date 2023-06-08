package org.dfpl.db.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.dfpl.db.hash.m18011690.MyHashSet;

public class UnitTest5 {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		//Set<Integer> set2 = new HashSet<Integer>();
		Set<Integer> set2 = new MyHashSet();
		// 위의 set2이 아니라 학생들의 MyHashSet으로 동일하게 동작해야 함
		// Set<Integer> set2 = new MyHashSet<Integer>();
		// 과제5는 MyHashSet이 MyThreeWayBTree로 구현되어야만 채점합니다.

		Random r = new Random();
		for (int i = 0; i < 10000; i++) {
			int next = r.nextInt(7000);
			set1.add(next);
			set2.add(next);
		}

		// true가 반환되어야만 합니다.
		System.out.println("[1] " + (set1.size() == set2.size()));
		
		boolean isDifferent = false;
		for (int set1Value : set1) {
			if (!set2.contains(set1Value)) {
				isDifferent = true;
				break;
			}
		}

		// true가 반환되어야만 합니다.
		System.out.println("[2] " + !isDifferent);

		Iterator<Integer> set2Iter = set2.iterator();
		int cnt = 0;
		while (set2Iter.hasNext()) {
			set2Iter.next();
			cnt++;
		}

		// true가 반환되어야만 합니다.
		System.out.println("[3] " + (set1.size() == cnt));

		ArrayList<Integer> removedList = new ArrayList<Integer>();
		Iterator<Integer> removeIter = set1.iterator();
		int rCount = 0;
		while (removeIter.hasNext()) {
			if (rCount == 1000)
				break;
			int valueToRemove = removeIter.next();
			removeIter.remove();
			removedList.add(valueToRemove);
			set2.remove(valueToRemove);
			rCount++;
		}

		boolean isNotRemoved = false;
		for (int removed : removedList) {
			if (set2.contains(removed)) {
				isNotRemoved = true;
				break;
			}
		}

		// true가 반환되어야만 합니다.
		System.out.println("[4] " + !isNotRemoved);
	}
}
