package com.design_pattern.command;

/**
 * 命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开
 * @author xxn
 * @date 2016年4月11日  上午10:51:32
 */
public class CommandTest {
	public static void main(String[] args) {
		Solider solider = new Solider();//士兵执行命令
		Command command = new MyCommand(solider);//命令传递给士兵
		General general = new General(command);//将军下达命令
		general.action();
	}
}
