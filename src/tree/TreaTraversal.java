package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
	int data;
	Node left,right;
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
public class TreaTraversal {
	Node root;
	void inorderTraversal() {
		Stack<Node>stack=new Stack<Node>();
		while(root!=null) {
			stack.push(root);
			root=root.left;
		}
		while(!stack.isEmpty()) {
			root=stack.pop();
			System.out.print(root.data+" ");
			if(root.right!=null) {
				root=root.right;
			while(root!=null) {
				stack.push(root);
				root=root.left;
			  }
			
			}
			
		}
		
	}
	public void preorder() {
		Stack<Node>st=new Stack<Node>();
		Node tmp=root;
		while(tmp!=null) {
			st.push(tmp);
			System.out.print(tmp.data+" ");
			tmp=tmp.left;
		}
		while(!st.isEmpty()) {
			Node node=st.pop();
			if(node.right!=null) {
				node=node.right;
				
			while(node!=null) {
				System.out.print(node.data+" ");
				st.push(node);
				node=node.left;
				}
					}
				}
		
	}
	void updatedPostorder() {
		Node tmp=root;
		Stack<Node>st=new Stack<Node>();
		Stack <Node>tmpStack=new Stack<Node>();
		st.push(tmp);
		while(!st.isEmpty()) {
			 Node node=st.pop();
			 tmpStack.push(node);
			 if(node.left!=null) {
				 st.push(node.left);
			 }
			 if(node.right!=null) {
				 st.push(node.right);
			 }
		}
		while(!tmpStack.isEmpty()) {
			System.out.print(tmpStack.pop().data+" ");
		}
	}
	void postOrder() {
		Stack<Node>st1=new Stack<Node>();
		Stack<Node>st2=new Stack<Node>();
		st1.push(root);
	}
	void levelOderTraversal() {
		Node tmp=root;
		Queue<Node> qu=new LinkedList<Node>();
		int hegiht=0;
		qu.add(tmp);
		while(true) {
			int count=qu.size();
			if(count==0) {
				break;
			}
			while(count>0) {
				Node node =qu.remove();
				System.out.print(node.data+" ");
				if(node.left!=null)
					qu.add(node.left);
				if(node.right!=null)
					qu.add(node.right);
				count--;
			}
			System.out.println();
			hegiht++;
			
		}
		System.out.println("Height of Tree:::"+hegiht);
	}
	public static void main(String[] args) {
		TreaTraversal tr=new TreaTraversal();
		tr.root=new Node(10);
		tr.root.left=new Node(4);
		tr.root.right=new Node(8);
		tr.root.left.right=new Node(5);
		tr.root.right.left=new Node(6);
		//tr.inorderTraversal();
		//tr.updatedPostorder();
		tr.levelOderTraversal();
	}

}
