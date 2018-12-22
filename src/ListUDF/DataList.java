package ListUDF;

public class DataList {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
		
      }
	void push1(int data) {
		Node node =new Node(data);
		node.next=head;
		head=node;
	}
	void display() {
		Node tmp=head;
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp=tmp.next;
		}
		
	}
	boolean detectLoop() {
		Node slowNode=head;
		Node fastNode=head;
		while(slowNode!=null&&fastNode!=null&&fastNode.next!=null) {
			slowNode=slowNode.next;
			fastNode=fastNode.next.next;
			if(slowNode==fastNode)
			return true;
		}
		return false;
	}
	void getSeggregateOddEven(){
		Node oddHead=null,oddEnd=null;
		Node evenHead=null,evenEnd=null;
		Node tmp=head;
		while(tmp!=null) {
			if(tmp.data%2!=0) {
			if(oddHead==null) {
				oddHead=tmp;
				oddEnd=oddHead;
			}else {
				oddEnd.next=tmp;
				
			}
			oddEnd=oddEnd.next; 
					}
			else {
				if(evenHead==null) {
					evenHead=tmp;
					evenEnd=evenHead;
				}else {
					evenEnd.next=tmp;
				}
				evenEnd=evenEnd.next;
			}
			tmp=tmp.next;
		}
	}
	Node reverseList() {
		Node pre=null;
		Node current=head;
		Node next1=null;
		while(current!=null) {
			next1=current.next;
			current.next =pre;
			pre=current;
			current=next1; 
		}
		head=pre;
		return head;
	}
	public static void main(String[] args) {
		DataList dl=new DataList();
		dl.push1(12);
		dl.push1(1);
		dl.push1(10);
		dl.push1(29);
		dl.push1(9);
		dl.head.next.next=dl.head.next;
		System.out.println(dl.detectLoop());
		//dl.reverseList();
		
		//dl.display();

		
	}

}
