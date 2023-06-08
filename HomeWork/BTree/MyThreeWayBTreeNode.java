package org.dfpl.db.hash.m18011690;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unused")
public class MyThreeWayBTreeNode {

	private MyThreeWayBTreeNode parent;
	private List<Integer> keyList;
	private List<MyThreeWayBTreeNode> children;
	
	// 생성자로 부모 설정
	public MyThreeWayBTreeNode(MyThreeWayBTreeNode parent)
	{
		keyList = new ArrayList<Integer>();
		children = new ArrayList<MyThreeWayBTreeNode>();
		this.parent = parent;
	}
	
	public int getKeySize()
	{
		return keyList.size();
	}
	
	public int getChildrenSize()
	{
		return children.size();
	}
	
	public MyThreeWayBTreeNode getChildren(int index)
	{
		return children.get(index);
	}
	
	public Integer getKey(int index)
	{
		return keyList.get(index);
	}
	
	public boolean isLeafNode()
	{
		return children.isEmpty();
	}
	
	public int addKey(int data)
	{
		keyList.add(data);
		keyList.sort(null);
		
		return keyList.indexOf(data);
	}
	
	public void setChildren(MyThreeWayBTreeNode node, int index)
	{
		children.add(index, node);
	}
	
	public void removeChildren(MyThreeWayBTreeNode node)
	{
		children.remove(node);
	}
	
	public MyThreeWayBTreeNode getParent()
	{
		return parent;
	}
	
	public void setParent(MyThreeWayBTreeNode node)
	{
		parent = node;
	}
	
	public boolean contains(Object o)
	{
		return keyList.contains(o);
	}
	
	public Iterator<Integer> getKeyIterator()
	{
		return keyList.iterator();
	}
}
