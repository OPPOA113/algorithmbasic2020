package class03;

import java.util.Stack;


// 栈：先进后出，后进先出
// 队列：先进先出，后进后出
public class Code06_TwoStacksImplementQueue {
	
// 两个栈实现队列：
	public static class TwoStacksQueue {
		public Stack<Integer> stackPush;		// 一个是入栈，当做queue的push
		public Stack<Integer> stackPop;			// 一个数出站，当做queue的pop

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		// push栈向pop栈倒入数据;当出栈队列为空时，就把入栈的数据倒入到出栈中
		private void pushToPop() {
			if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
		}
// 实现队列添加
		public void add(int pushInt) {
			stackPush.push(pushInt);
			pushToPop();
		}
// 实现队列弹出
		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			}
			pushToPop();
			return stackPop.pop();
		}

// 实现队列头
		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			}
			pushToPop();
			return stackPop.peek();	
		}
	}

	public static void main(String[] args) {
		TwoStacksQueue test = new TwoStacksQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
	}

}
