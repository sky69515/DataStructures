package linearlist1;

import java.util.Arrays;

/**
 * 
 * @author lilingyun
 *
 * @param <T>  线性表中的泛型对象
 * 
 * 顺序表：线性表的顺序存储结构称为顺序表。
 * 线性表只有一个表头一个表尾，表头无前驱，表尾无后继，其他元素只有一个直接前驱，也只有一个直接后继。
 * 把线性表中的所有元素按其逻辑顺序，依次存储到从指定的存储位置开始的一块连续的存储空间中
 */
public class SequenceList<T> {
	private Object[] data=null;
	private int n;	//容量
	private int length;//当前长度
	
	public SequenceList(){
		this(10);
	}
	
	public SequenceList(int n) {
		if (n>=0) {
			this.data=new Object[n];
			this.n=n;
			this.length=0;
		}else {
			throw new RuntimeException("初始化大小不能小于0!");
		}
	}
	/**
	 * 添加元素到线性表
	 * @param t	需要添加到线性表中的元素
	 * @return	添加操作是否成功
	 */
	public boolean add(T t){
		isFull();
		data[length]=t;
		length++;
		return true;
	}
	/**
	 * 顺序表是否填满
	 */
	private void isFull() {
		if (n==length) {
			length=2*length;
			data=Arrays.copyOf(data, length);
		}
	}
	/**
	 * 获取顺序表中指定位置的元素
	 * @param index 索引参数
	 * @return
	 */
	public T get(int index){
		if (!isBeyondBoder(index)) {
			return (T) data[index-1];	
		}else {
			throw new RuntimeException("索引越界！");
		}
	}
	/**
	 * 判断索引是否越界
	 * @param index 索引参数
	 * @return	索引是否越界
	 */
	private boolean isBeyondBoder(int index) {
		return index<=0||index>length;
	}
	/**
	 * 移除顺序表中指定位置的元素
	 * @param index 索引参数
	 * @return 被移除的元素
	 */
	public boolean remove(int index){
		if (!isBeyondBoder(index)) {
			for (int i = index; i <length; i++) {
				move(data,i-1,i);
			}
			data[length-1]=null;
			length--;
			return true;
		}
		return false;
	}
	/**
	 * 顺序表中两个指定位置中的元素互换
	 * @param data2 顺序表数组
	 * @param i	位置1
	 * @param j	位置2
	 */
	private void move(Object[] data2, int i, int j) {
		data2[i]=data2[j];
	}
	/**
	 * 当前顺序表中元素个数
	 * @return	当前顺序表中元素个数
	 */
	public int size(){
		return length;
	}
	/**
	 * 
	 * @return	当前顺序表中时候拥有元素
	 */
	public boolean isEmpty(){
		return length==0;
	}
	/**
	 * 打印线性表
	 */
	public void print(){
		for (int i = 0; i < length; i++) {
			System.out.println(data[i]);
		}
	}
	
	public static void main(String[] args) {
		SequenceList<Integer> list=new SequenceList<>();
//		System.out.println(list.size());
//		System.out.println(list.isEmpty());
		list.add(0);
		list.add(7);
		list.add(3);
		list.add(1);
		list.add(4);
		list.add(0);
		list.add(1);
		list.add(0);
//		System.out.println(list.size());
//		System.out.println(list.isEmpty());
//		list.print();
//		System.out.println(list.get(9));
//		System.out.println(list.remove(8));
		
		list.remove(5);
		list.remove(2);
		list.print();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	}
}
