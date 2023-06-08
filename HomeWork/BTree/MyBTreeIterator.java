package org.dfpl.db.hash.m18011690;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyBTreeIterator implements Iterator<Integer> {

	private MyThreeWayBTreeNode currentNode;
	private Iterator<Integer> currentIterator;
	
	private Stack<MyThreeWayBTreeNode> stack;
	
	public MyBTreeIterator(MyThreeWayBTreeNode root)
	{
		stack = new Stack<MyThreeWayBTreeNode>();
		pushAll(root);
		
		if (!stack.isEmpty())
		{
			currentNode = stack.pop();
			currentIterator = currentNode.getKeyIterator();
		}
	}
	
	@Override
	public boolean hasNext() {
		if(currentIterator == null)
			return false;
		if (stack.isEmpty() && !currentIterator.hasNext())
			return false;
		return true;
	}

	@Override
	public Integer next() {
		
		if(!hasNext())
		{
			throw new NoSuchElementException("No more elements in the iterator.");
		} 
		
		if (!currentIterator.hasNext())
		{
			currentNode = stack.pop();
			currentIterator = currentNode.getKeyIterator();
		}
		
		return currentIterator.next();
	}

	private void pushAll(MyThreeWayBTreeNode node)
	{
		if (node != null)
		{
			stack.push(node);
			for (int i = 0; i < node.getChildrenSize(); i++) {
				pushAll(node.getChildren(i));
			}
		}
	}
}
