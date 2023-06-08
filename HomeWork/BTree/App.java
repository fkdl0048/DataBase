package org.dfpl.db.hash.m18011690;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		
		var myBTree = new MyThreeWayBTree();
		
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			int next = r.nextInt(7000);
			myBTree.add(next);
		}
	}
	// 6,0,3,7,1,4,8,2,5
	// 3,6,0,4,7,1,5,8,2


}
