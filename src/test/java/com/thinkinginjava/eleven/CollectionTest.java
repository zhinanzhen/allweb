package com.thinkinginjava.eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 使用接口能够创建更加通用的代码，通过面向接口的编程能够应用于更多的对象类型
 * @author xxn
 * @date 2016年3月25日  上午10:06:56
 */
public class CollectionTest {
	public static void main(String[] args) {
//		list();
//		listCopy();
//		listIterator();
//		random();
//		priorityQueue();
		environment();
	}

	private static void environment() {
		Set<Entry<String,String>> entrySet = System.getenv().entrySet();
		for (Map.Entry entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	private static void iterableClass(){
	}
	private static void priorityQueue(){
		// 队列规则，优先级队列
		List<Integer> asList = Arrays.asList(34,1,3,5,6,8,9,20,7,34);
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(asList);
		/*Random rand = new Random(47);
		for(int i = 0; i < 10; i++)
			priorityQueue.offer(rand.nextInt(i + 10));*/
		while(priorityQueue.peek()!=null){
			System.out.print(priorityQueue.remove()+" ");
		}
		System.out.println();
		System.out.println("----------------");
		Collections.reverseOrder();  //--->new Comparator
		priorityQueue = new PriorityQueue<>(asList.size(), new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
		}});
		priorityQueue.addAll(asList);
		while(priorityQueue.peek()!=null){
			System.out.print(priorityQueue.remove()+" ");
		}
	}
	private static void random(){
		Random rand = new Random();
		// treeSet 数据结构为红黑树，按照字典顺序排序
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		while(treeSet.size() != 100){
			for(int i=0;i<100;i++){
				treeSet.add(rand.nextInt(100));
				if(treeSet.size() == 100){
					break;
				}
			}
		}
		int i = 0;
		for (Integer integer : treeSet) {
			System.out.print(integer+" ");
			i++;
		}
		System.out.println();
		System.out.println("---");
		System.out.println(i);
	}
	private static void stack(){
		Stack stack = new Stack();
	}
	private static void listIterator(){
		List<String> list = Arrays.asList("a","b","c","d","e");
		ListIterator<String> lt = list.listIterator();
		while(lt.hasNext()){
			System.out.println("   next:"+lt.next()+"-->"+list.get(lt.previousIndex())+"   nextIndex:"+lt.nextIndex()+"   previousIndex:"+lt.previousIndex());
		}
		
	}
	private static void listCopy(){
		Collection<Integer> cc = new ArrayList<Integer>(Arrays.asList(1,3,7,8,9));
		System.arraycopy(cc, 1, cc, 2, 2);
		for (Integer ie : cc) {
			System.out.println(ie);
		}
	}
	private static void list(){
		Collection<Integer> cc = new ArrayList<Integer>(Arrays.asList(1,3,7,8,9));
		/*Collection<String> cca = new ArrayList<String>(Arrays.asList("1","2","4","5"));
		cca.retainAll(cc);
		for (String str : cca) {
			System.out.println(str);
		}*/
		int[] i = new int[]{1,5,3,6};
		int w = 0;
		for (int j = 0; j < i.length; j++) {
			if(cc.contains(i[j])){
				i[w++] = i[j];
			}
		}
		if(w != i.length){
			for (int j = w; j < i.length; j++) {
				i[j] = 0;
			}
		}
		for (int j = 0; j < i.length; j++) {
			System.out.println(i[j]);
		}
	}
	private static void aslist(){
		ArrayList a = new ArrayList();
		a.add("");
		Set s = new HashSet();
		Collection<String> cc = new ArrayList<String>(Arrays.asList("1","2","3","4","5"));
		cc.add("");
		Iterator itc = cc.iterator();
		while(itc.hasNext()){
			System.out.println(itc.next());
		}
		System.out.println("------------------");
		boolean remove = cc.remove("1");//可以删除
		Iterator itcc = cc.iterator();
		while(itcc.hasNext()){
			System.out.println(itcc.next());
		}
		
		System.out.println("------------------");
		List<? extends Object> asList = Arrays.asList(1,2,3,4);
//		Collections.addAll(c, Arrays.asList(1,2,3,4));
		/*asList.remove(0);
		for (Object object : asList) {
			System.out.println(object);
		}*/
		Iterator it = asList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		Object remove2 = asList.remove(0);// 不可以删除
		it = asList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	private void look(){
		List ar = new ArrayList();
		ar.add("23");
		ar.add(34);
		ar.get(0);
		Object set2 = ar.set(0, "23");
		System.out.println(set2);
		ar.set(0, "24");
		List<? extends Object> asList = Arrays.asList("1",2,4,5);
		for (Object object : asList) {
			System.out.println(object);
		}
		/*Set set = new HashSet();
		set.add(3);
		set.add(5);
		set.add(8);
		set.add(null);
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
	}
	
	private void ortest(){
		boolean isTrue = false;  
        isTrue |= true;  
        System.out.println(isTrue);  
          
        isTrue = false;  
        isTrue |= false;  
        System.out.println(isTrue);  
          
        isTrue = true;  
        isTrue |= true;  
        System.out.println(isTrue);  
          
        isTrue = true;  
        isTrue |= false;  
        System.out.println(isTrue);  
	}
	
	public <T> T[] test(T[] a){
		return a;
	}
	
}
