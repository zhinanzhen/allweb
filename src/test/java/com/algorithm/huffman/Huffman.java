package com.algorithm.huffman;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * huffman压缩
 * @author xxn
 * @date 2015年11月27日  下午12:10:51
 */
public class Huffman {
	
	/**
	 * 频率的统计信息
	 * @param charArray
	 * @return
	 */
	public static Map<Character, Integer> statistics(char[] charArray) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : charArray) {
			Character character = new Character(c);
			if (map.containsKey(character)) {
				map.put(character, map.get(character) + 1);
			} else {
				map.put(character, 1);
			}
		}

		return map;
	}
	/**
	 * 构建树是Huffman编码算法的核心步骤。
	 * 思想是把所有的字符挂到一颗完全二叉树的叶子节点，任何一个非页子节点的左节点出现频率不大于右节点。
	 * 算法为把统计信息转为Node存放到一个优先级队列里面，每一次从队列里面弹出两个最小频率的节点，
	 * 构建一个新的父Node(非叶子节点), 字符内容刚弹出来的两个节点字符内容之和，频率也是它们的和，
	 * 最开始的弹出来的作为左子节点，后面一个作为右子节点，并且把刚构建的父节点放到队列里面。
	 * 重复以上的动作N-1次，N为不同字符的个数(每一次队列里面个数减1)。结束以上步骤，队列里面剩一个节点，弹出作为树的根节点
	 * @param statistics
	 * @param leafs
	 * @return
	 */
	private static Tree buildTree(Map<Character, Integer> statistics, List<Node> leafs) {
		Character[] keys = statistics.keySet().toArray(new Character[0]);

		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
		for (Character character : keys) {
			Node node = new Node();
			node.setChars(character.toString());
			node.setFrequence(statistics.get(character));
			priorityQueue.add(node);
			leafs.add(node);
		}

		int size = priorityQueue.size();
		for (int i = 1; i <= size - 1; i++) {
			Node node1 = priorityQueue.poll();
			Node node2 = priorityQueue.poll();

			Node sumNode = new Node();
			sumNode.setChars(node1.getChars() + node2.getChars());
			sumNode.setFrequence(node1.getFrequence()+ node2.getFrequence());

			sumNode.setLeftNode(node1);
			sumNode.setRightNode(node2);

			node1.setParent(sumNode);
			node2.setParent(sumNode);

			priorityQueue.add(sumNode);
		}

		Tree tree = new Tree();
		tree.setRoot(priorityQueue.poll());
		return tree;
	}
	
	/**
	 * 某个字符对应的编码为，从该字符所在的叶子节点向上搜索，如果该字符节点是父节点的左节点，编码字符之前加0，反之如果是右节点，加1，直到根节点。
	 * 只要获取了字符和二进制码之间的mapping关系，编码就非常简单
	 * @param originalStr
	 * @param statistics
	 * @return
	 */
	public static String encode(String originalStr, Map<Character, Integer> statistics) {
		if (originalStr == null || originalStr.equals("")) {
			return "";
		}

		char[] charArray = originalStr.toCharArray();
		List<Node> leafNodes = new ArrayList<Node>();
		buildTree(statistics, leafNodes);
		Map<Character, String> encodInfo = buildEncodingInfo(leafNodes);

		StringBuffer buffer = new StringBuffer();
		for (char c : charArray) {
			Character character = new Character(c);
			buffer.append(encodInfo.get(character));
		}

		return buffer.toString();
	}

	private static Map<Character, String> buildEncodingInfo(List<Node> leafNodes) {
		Map<Character, String> codewords = new HashMap<Character, String>();
		for (Node leafNode : leafNodes) {
			Character character = new Character(leafNode.getChars().charAt(0));
			String codeword = "";
			Node currentNode = leafNode;

			do {
				if (currentNode.isLeftChild()) {
					codeword = "0" + codeword;
				} else {
					codeword = "1" + codeword;
				}

				currentNode = currentNode.getParent();
			} while (currentNode.getParent() != null);

			codewords.put(character, codeword);
		}

		return codewords;
	}
	/**
	 * 因为Huffman编码算法能够保证任何的二进制码都不会是另外一个码的前缀，解码非常简单，依次取出二进制的每一位，从树根向下搜索，
	 * 1向右，0向左，到了叶子节点(命中)，退回根节点继续重复以上动作
	 * @param binaryStr
	 * @param statistics
	 * @return
	 */
	public static String decode(String binaryStr, Map<Character, Integer> statistics) {
		if (binaryStr == null || binaryStr.equals("")) {
			return "";
		}

		char[] binaryCharArray = binaryStr.toCharArray();
		LinkedList<Character> binaryList = new LinkedList<Character>();
		int size = binaryCharArray.length;
		for (int i = 0; i < size; i++) {
			binaryList.addLast(new Character(binaryCharArray[i]));
		}

		List<Node> leafNodes = new ArrayList<Node>();
		Tree tree = buildTree(statistics, leafNodes);

		StringBuffer buffer = new StringBuffer();

		while (binaryList.size() > 0) {
			Node node = tree.getRoot();

			do {
				Character c = binaryList.removeFirst();
				if (c.charValue() == '0') {
					node = node.getLeftNode();
				} else {
					node = node.getRightNode();
				}
			} while (!node.isLeaf());

			buffer.append(node.getChars());
		}

		return buffer.toString();
	}
	
	public static void main(String[] args) {
		String oriStr = "Huffman codes compress data very effectively: savings of 20% to 90% are typical, "
				+ "depending on the characteristics of the data being compressed. 中华崛起";
		Map<Character, Integer> statistics = statistics(oriStr.toCharArray());
		String encodedBinariStr = encode(oriStr, statistics);
		String decodedStr = decode(encodedBinariStr, statistics);

		System.out.println("Original sstring: " + oriStr);
		System.out.println("Huffman encoed binary string: " + encodedBinariStr);
		System.out.println("decoded string from binariy string: " + decodedStr);

		System.out.println("binary string of UTF-8: "
				+ getStringOfByte(oriStr, Charset.forName("UTF-8")));
		System.out.println("binary string of UTF-16: "
				+ getStringOfByte(oriStr, Charset.forName("UTF-16")));
		System.out.println("binary string of US-ASCII: "
				+ getStringOfByte(oriStr, Charset.forName("US-ASCII")));
		System.out.println("binary string of GB2312: "
				+ getStringOfByte(oriStr, Charset.forName("GB2312")));
	}

	public static String getStringOfByte(String str, Charset charset) {
		if (str == null || str.equals("")) {
			return "";
		}
		byte[] byteArray = str.getBytes(charset);
		int size = byteArray.length;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < size; i++) {
			byte temp = byteArray[i];
			buffer.append(getStringOfByte(temp));
		}
		return buffer.toString();
	}

	public static String getStringOfByte(byte b) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 7; i >= 0; i--) {
			byte temp = (byte) ((b >> i) & 0x1);
			buffer.append(String.valueOf(temp));
		}
		return buffer.toString();
	}
}
