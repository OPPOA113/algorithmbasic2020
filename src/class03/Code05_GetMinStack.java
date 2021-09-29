package class03;

import java.util.Stack;

public class Code05_GetMinStack {
// 获取栈中的最小值：
// 两个栈实现，min栈保存原始栈中，每个元素对于的当前原始栈的最小值
// 两个方式：第一种就原始栈和min栈的长度相同；第二种就是min栈比原始栈小（pop时，如果原始栈元素比min栈顶小，则min栈弹出）
	public static class MyStack1 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack1() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum <= this.getmin()) {
				this.stackMin.push(newNum);
			}
			this.stackData.push(newNum);
		}

		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			int value = this.stackData.pop();
			if (value == this.getmin()) {		// 弹出时，数原数据值与min栈顶相等时，min栈才弹出。这个关键！！
				this.stackMin.pop();
			}
			return value;
		}

		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}

// 两个栈实现，O(1)复杂度获取栈的最小值【应该也能是最大值】
	public static class MyStack2 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack2() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {				// 入栈，如果min栈空时，两个栈都入新元素。
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum < this.getmin()) {	// 如果min栈不为空，且newNum < this.getmin()，则min栈入newNum 
				this.stackMin.push(newNum);
			} else {
				int newMin = this.stackMin.peek();	// 如果如果min栈不为空，且newNum > this.getmin()，则min栈入this.getmin() 
				this.stackMin.push(newMin);
			}
			this.stackData.push(newNum);			// 新数据一定会入原始栈
		}

		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			this.stackMin.pop();						// 弹出时，两个栈都pop
			return this.stackData.pop();
		}

		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}

	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(3);
		System.out.println(stack1.getmin());
		stack1.push(4);
		System.out.println(stack1.getmin());
		stack1.push(1);
		System.out.println(stack1.getmin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getmin());

		System.out.println("=============");

		MyStack1 stack2 = new MyStack1();
		stack2.push(3);
		System.out.println(stack2.getmin());
		stack2.push(4);
		System.out.println(stack2.getmin());
		stack2.push(1);
		System.out.println(stack2.getmin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getmin());
	}

}
