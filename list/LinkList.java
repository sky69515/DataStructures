package linearlist1;

import java.util.List;
/**
 * 
 * @author lilingyun
 *
 * @param <T>  线性表中的泛型对象
 * 
 * 线性表:只有一个表头一个表尾，表头无前驱，表尾无后继，其他元素只有一个直接前驱，也只有一个直接后继。
 * 链表：线性表的链式存储结构称为链表。
 * 每个节点包含元素之间逻辑关系的信息，也就是前驱结点包含后继结点的地址信息。
 * 
 */
public class LinkList<T> {
	/**
	 * 
	 * @author lilingyun	链表节点
	 *
	 * @param <T>	节点中的泛型对象
	 */
	private static class Node<T> {
		T data=null;
		Node<T> next=null;
		
	}
	
	private Node<T> head=null;//头节点作为第一个节点保存数据
	/**
	 * 添加元素到线性表
	 * @param t	需要添加到线性表中的元素
	 * @return	添加操作是否成功
	 */
	public boolean add(T t){
		Node<T> node=new Node<>();
		node.data=t;
		node.next=null;
		if (isEmpty()) {
			head=node;
			return true;
		}
		
		Node<T> pNode=head;
		while (pNode.next!=null) {
			pNode=pNode.next;
		}
		pNode.next=node;
		return true;
	}
	/**
	 * 线性表是否为空
	 * @return	当前线性表是否为空
	 */
	private boolean isEmpty() {
		return head==null;
	}
	/**
	 * 线性表当前节点个数
	 * @return	线性表当前节点个数
	 */
	private int length() {
		int length=0;
		Node<T> node=head;
		while (node!=null) {
			length++;
			node=node.next;
		}
		return length;
	}
	/**
	 * 打印线性表
	 */
	public void print(){
		if (head!=null) {
			Node<T> node=head;
			while (node!=null) {
				System.out.println(node.data);
				node=node.next;
			}
		}
	}
	/**
	 * 获取线性表指定位置的节点中的信息
	 * @param index	线性表中的节点索引，从1开始
	 * @return	指定位置节点信息
	 */
	public T get(int index){
		if (!isBeyondBoder(index)) {
			int i=1;
			Node<T> node=head;
			while (i<index) {
				node=node.next;
				i++;
			}
			return node.data;
		}else {
			throw new RuntimeException("索引越界");
		}
	}
	/**
	 * 
	 * 移除线性表指定位置的节点
	 * @param index	线性表中的节点索引，从1开始
	 * @return	指定位置节点的信息
	 */
	public T remove(int index){
		T temp=null;
		if (!isBeyondBoder(index)) {
			if (index==1) {
				Node<T> node=head;
				head=head.next;
				node.next=null;
				temp=node.data;
			}else {
				Node<T> preNode=findNodeByIndex(index-1);
				Node<T> curNode=preNode.next;
				temp=curNode.data;
				preNode.next=curNode.next;	
				curNode.next=null;
			}
		}
		return temp;
	}
	
	/**
	 * 获取线性表指定位置的节点
	 * @param index	线性表中的节点索引，从1开始
	 * @return	线性表指定位置的节点
	 */
	public Node<T> findNodeByIndex(int index) {
		int i=1;
		Node<T> node=head;
		while (i<index) {
			node=node.next;
			i++;
		}
		return node;
	}
	/**
	 * 索引是否越界
	 * @param index	索引，>=1&&<=线性表中元素个数
	 * @return	是否越界
	 */
	private boolean isBeyondBoder(int index) {
		return index<1||index>length();
	}
	/**
	 * 反转线性表的节点
	 * @param linkList	待反转线性表
	 */
	public void reverse(LinkList<T> linkList){
		for (int i = 1; i <= linkList.length(); i++) {
			linkList.add(linkList.remove(i),1);	
		}
	}
	/**
	 * 指定位置添加信息
	 * @param t	待添加信息
	 * @param index	索引
	 * @return	操作是否成功
	 */
	public boolean add(T t, int index) {
		Node<T> newNode=new Node<>();
		newNode.data=t;
		if (index==1) {
			newNode.next=head;
			head=newNode;
			return true;
		}
		
		if (!isBeyondBoder(index)) {
			Node<T> preNode=findNodeByIndex(index-1);
			Node<T> curNode=findNodeByIndex(index);
			preNode.next=newNode;
			newNode.next=curNode;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		LinkList<Integer> linkList=new LinkList<>();
//		System.out.println(linkList.isEmpty());
//		System.out.println(linkList.length());
		linkList.add(1);
//		System.out.println(linkList.isEmpty());
//		System.out.println(linkList.length());
		linkList.add(7);
		linkList.add(3);
		linkList.add(1);
		linkList.add(4);
		linkList.add(0);
		linkList.add(1);
		linkList.add(0);
//		linkList.print();
//		System.out.println(linkList.get(5));
		
//		System.out.println(linkList.findNodeByIndex(linkList.length()).data);
		
//		linkList.remove(linkList.length());
//		linkList.print();
		
//		linkList.add(2, 2);
//		linkList.print();
		
		linkList.reverse(linkList);
		linkList.print();
	}
	
}
