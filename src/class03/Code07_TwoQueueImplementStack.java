package class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code07_TwoQueueImplementStack {
// 两个队列实现栈：
	public static class TwoQueueStack<T> {
		public Queue<T> queue;
		public Queue<T> help;

		public TwoQueueStack() {
			queue = new LinkedList<>();
			help = new LinkedList<>();
		}
		// 实现入栈
		public void push(T value) {
			queue.offer(value);				// 入队列
		}
		// 实现出栈
		public T poll() {					// 出队列
			while (queue.size() > 1) {	// 把数据存入help队列，剩余最后一个
				help.offer(queue.poll());
			}
			T ans = queue.poll();		// 弹出队列最后加入的数据，作为栈的弹出（模拟后进先出）
			Queue<T> tmp = queue;		// 交换队列：queue仍为原始数据队列，help仍为空的队列
			queue = help;
			help = tmp;
			return ans;
		}
		// 栈顶
		public T peek() {
			while (queue.size() > 1) {
				help.offer(queue.poll());
			}
			T ans = queue.poll();		// 获取栈顶
			help.offer(ans);		// 再把数据存回help队列，
			Queue<T> tmp = queue;		// 交换队列：queue仍为原始数据队列，help仍为空的队列
			queue = help;
			help = tmp;
			return ans;
		}

		public boolean isEmpty() {
			return queue.isEmpty();
		}

	}

	public static void main(String[] args) {
		System.out.println("test begin");
		TwoQueueStack<Integer> myStack = new TwoQueueStack<>();
		Stack<Integer> test = new Stack<>();
		int testTime = 1000000;
		int max = 1000000;
		for (int i = 0; i < testTime; i++) {
			if (myStack.isEmpty()) {
				if (!test.isEmpty()) {
					System.out.println("Oops");
				}
				int num = (int) (Math.random() * max);
				myStack.push(num);
				test.push(num);
			} else {
				if (Math.random() < 0.25) {
					int num = (int) (Math.random() * max);
					myStack.push(num);
					test.push(num);
				} else if (Math.random() < 0.5) {
					if (!myStack.peek().equals(test.peek())) {
						System.out.println("Oops");
					}
				} else if (Math.random() < 0.75) {
					if (!myStack.poll().equals(test.pop())) {
						System.out.println("Oops");
					}
				} else {
					if (myStack.isEmpty() != test.isEmpty()) {
						System.out.println("Oops");
					}
				}
			}
		}

		System.out.println("test finish!");

	}

}
