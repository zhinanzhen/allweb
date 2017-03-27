package com.thinkinginjava.eleven;

public class WordFall {
	public static void main(String[] args) {
		String words = "what are you nong sha lai";
		Stack<String> stack = new Stack<String>();
		for (String str : words.split(" ")) {
			stack.push(str);
		}
		/*while(!stack.empty()){
			System.out.print(stack.pop()+" ");
		}*/
		while(stack.peek() != null){
			System.out.print(stack.pop()+" ");
		}
	}
}
