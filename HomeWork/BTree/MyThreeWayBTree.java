package org.dfpl.db.hash.m18011690;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.SortedSet;

@SuppressWarnings("unused")
public class MyThreeWayBTree implements NavigableSet<Integer> {

	// 멤버 변수
	private int way;
	private int maxKey;
	private int minKey;
	private int left;
	private int middle;
	private int right;
	
	private MyThreeWayBTreeNode root;
	
	public MyThreeWayBTree()
	{
		this.way = 3; // 고정 값(리터럴) 이후에 생성자 인자로 way변경 가능하도록 설계
		this.maxKey = way - 1;
		// this.minkey = 
		
		// 각 way에 맞는 범위 설정
		this.left = (int)(Math.floor((way - 1) / 2) - 1);
		this.middle = (int)(Math.floor((way - 1) / 2));
		this.right = (int)(Math.floor((way - 1) / 2)) + 1;
	}
	
	@Override
	public boolean add(Integer e) {
		// 첫 삽입 연산 시 생성
		if (root == null)
			root = new MyThreeWayBTreeNode(null);
		
		var node = getInsertNode(e); // 값을 넣을 node 탐색
		node.addKey(e); // 값을 바로 넣음
		
		if (node.getKeySize() >= way) // max를 초과한다면 Reorganize
			Reorganize(node);
		
		return true;
	}
	
	private MyThreeWayBTreeNode getInsertNode(int e)
	{
		MyThreeWayBTreeNode node = root;

		// 리프 노드까지 반복하여 값을 넣을 노드 반환
		// *리프 노드에만 key삽입 가능
		while(!node.isLeafNode()) 
		{
			for (int i = 0; i <= node.getKeySize(); i++) 
			{
				// 즉 해당 노드에서 가장 오른쪽 자식으로 들어갈 경우
				// 기본적으로 keySize보다 많을 수 있기 때문에 예외를 여기서 처리
				if (i == node.getKeySize() || node.getKey(i) > e)
				{
					node = node.getChildren(i);
					break;
				}
			}
		}
		
		return node;
	}
	
	private void Reorganize(MyThreeWayBTreeNode node)
	{
		// 기본적인 설계 전략
		// 1. Reorganize 기본적으로 분할의 성격을 지님 
		// 따라서 분할하여 설계(부모, 왼쪽자식, 오른쪽 자식)
		// 2. 2가지 케이스로 구분
		
		// 들어온 노드가 root노드일 경우
		// 설계 전략으로 parent가 null이면 root, Children이 null이면 leaf을 정함
		
		MyThreeWayBTreeNode parentNode;
		int index;
		
		if (node.getParent() == null)
		{
			// 부모가 없다면 새로 생성 즉, 루트의 경우
			// 중간 키 값 삭제 후 바로 root로 지정
			parentNode = new MyThreeWayBTreeNode(null);
			index = parentNode.addKey(node.getKey(middle)); 
			root = parentNode;
		}
		else
		{
			// 부모가 있다면 해당 부모에 값 삽입
			parentNode = node.getParent();
			parentNode.removeChildren(node);
			index = parentNode.addKey(node.getKey(middle));
		}
		
		// 왼쪽 오른쪽 자식 키 복사 과정
		var newLeftNode = new MyThreeWayBTreeNode(parentNode);
		for (int i = 0; i <= left; i++) {
			newLeftNode.addKey(node.getKey(i));
		}
		
		var newRightNode = new MyThreeWayBTreeNode(parentNode);
		for (int i = right; i <= way - 1; i++) {
			newRightNode.addKey(node.getKey(i));
		}
		
		// 양방향 연결 재구축
		BidirectionalConnection(node, newLeftNode, newRightNode);
		
		// 삽입한 값 위치로 부터 자식 지정
		parentNode.setChildren(newLeftNode, index);
		parentNode.setChildren(newRightNode, index + 1);
		
		// 노드 삭제
		node.setParent(null);
		
		// 만약 해당 부모노드도 규칙을 위반한 경우 재귀
		if (parentNode.getKeySize() >= way)
		{
			Reorganize(parentNode);
		}
	}
	
	// 재정렬할 때 node의 자식관계 정리
	private void BidirectionalConnection(MyThreeWayBTreeNode node, MyThreeWayBTreeNode leftNode, MyThreeWayBTreeNode rightNode)
	{
		int leftIndex = 0;
		int rightIndex = 0;
		
		// 자식이 있을 경우에만 작동
		for (int i = 0; i < node.getChildrenSize(); i++) {
			if (i <= left + 1)
			{
				leftNode.setChildren(node.getChildren(i), leftIndex++);
				node.getChildren(i).setParent(leftNode);
			}
			else
			{
				rightNode.setChildren(node.getChildren(i), rightIndex++);
				node.getChildren(i).setParent(rightNode);
			}
		}
	}	
	
	@Override
	public int size() {
		return getBTreeNodeSize(root);
	}
	
	// 재귀로 사이즈 체크
	private int getBTreeNodeSize(MyThreeWayBTreeNode node)
	{
		int size = 0;
		if (node != null)
		{
			for (int i = 0; i < node.getChildrenSize(); i++) {
				size += getBTreeNodeSize(node.getChildren(i));
			}
			size += node.getKeySize();
		}
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return containsLogic(root, o);
	}
	
	// 재귀로 순회하여 값 체크
	private boolean containsLogic(MyThreeWayBTreeNode node, Object o)
	{
		boolean isContain = false;
		if (node != null)
		{
			isContain = node.contains(o);
			for (int i = 0; i < node.getChildrenSize(); i++) {
				isContain = isContain || containsLogic(node.getChildren(i), o);
			}
		}
		
		return isContain;
	}
	
	// 모든 키를 InOrder로 반환
	public List<Integer> getAllTreeKey()
	{
		var keyList = new ArrayList<Integer>();
		inOrder(keyList, root);
		
		return keyList;
	}
	
	private void inOrder(List<Integer> keyList, MyThreeWayBTreeNode node)
	{
		if (node != null)
		{
			for (int i = 0; i < node.getKeySize(); i++)
			{
				keyList.add(node.getKey(i));
			}
			for (int i = 0; i < node.getChildrenSize(); i++) {
				inOrder(keyList, node.getChildren(i));
			}
		}
	}

	// Iterator반환
	@Override
	public Iterator<Integer> iterator() {
		return new MyBTreeIterator(root);
	}

	// ---------------
	
	@Override
	public Comparator<? super Integer> comparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer last() {
		// TODO Auto-generated method stub
		return null;
	}

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
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public Integer lower(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer floor(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer ceiling(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer higher(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<Integer> descendingSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<Integer> subSet(Integer fromElement, boolean fromInclusive, Integer toElement,
			boolean toInclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<Integer> headSet(Integer toElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<Integer> tailSet(Integer fromElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Integer> headSet(Integer toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Integer> tailSet(Integer fromElement) {
		// TODO Auto-generated method stub
		return null;
	}

//	if (node.getParent() == null)
//	{
//		// 새로운 부모를 생성하고 부모를 null로 둠 즉, root노드
//		var parentNode = new MyThreeWayBTreeNode(null);
//		
//		// 노드의 중간 값 삽입
//		int index = parentNode.addKey(node.getKey(middle));
//		
//		// 해당 노드의 left노드를 생성하여 값을 복사
////		var newLeftNode = new MyThreeWayBTreeNode(parentNode);
////		for (int i = 0; i <= left; i++) {
////			newLeftNode.addKey(node.getKey(i));
////		}
////		
////		var newRightNode = new MyThreeWayBTreeNode(parentNode);
////		for (int i = right; i <= way - 1; i++) {
////			newRightNode.addKey(node.getKey(i));
////		}
//		
////		BidirectionalConnection(node, newLeftNode, newRightNode);
////		
////		parentNode.setChildren(newLeftNode, index);
////		parentNode.setChildren(newRightNode, index + 1);
//		
//		root = parentNode;
//		
//	}
//	else // 2. 부모가 있으면 삽임 연산 값 지우고..
//	{
//		var parentNode = node.getParent();
//		
//		parentNode.removeChildren(node);
//		
//		int index = parentNode.addKey(node.getKey(middle));
//		
////		var newLeftNode = new MyThreeWayBTreeNode(parentNode);
////		for (int i = 0; i <= left; i++) {
////			newLeftNode.addKey(node.getKey(i));
////		}
////		
////		var newRightNode = new MyThreeWayBTreeNode(parentNode);
////		for (int i = right; i <= way - 1; i++) {
////			newRightNode.addKey(node.getKey(i));
////		}
//		
//
////		BidirectionalConnection(node, newLeftNode, newRightNode);
////		
////		parentNode.setChildren(newLeftNode, index);
////		parentNode.setChildren(newRightNode, index + 1);
//			
//		if (parentNode.getKeySize() >= way)
//		{
//			Reorganize(parentNode);
//		}
//	}
}
