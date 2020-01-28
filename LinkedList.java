import java.util.*;
public class LinkedList {

	Node head;
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	public static LinkedList insertLast(LinkedList l,int ele)
	{
		Node n = new Node(ele);
		n.next=null;
		if(l.head==null)
		{
			l.head=n;
		}
		else
		{
			Node t = l.head;
			while(t.next!=null)
				t=t.next;
			t.next=n;
		}
		System.out.println("\n"+ele+" inserted at the end");
		return l;
	}
	/* public static LinkedList insertBegin(LinkedList l,int ele)
	{
		Node n = new Node(ele);
		if(l.head==null)
			l.head=n;
		else
		{
			n.next=l.head;
			l.head=n;
		}
		System.out.println("\n"+ele+" inserted at the beginning");
		return l;
	}
	public static LinkedList insertAt(LinkedList l,int ele, int pos)
	{
		Node n = new Node(ele);
		if(pos==1)
			insertBegin(l,ele);
		if(pos<1)
			System.out.println("Insertion not possible");
		else
		{
			if(l.head==null)
				l.head=n;
			else
			{
				Node t = l.head;
				for(int i=1;i<pos;i++)
					t=t.next;
				if(t.next!=null)
					n.next=t.next;
				t.next=n;
			}
		}
		System.out.println("\n"+ele+" inserted at "+pos);
		return l;
	} */
	public static void printList(LinkedList l)
	{
		if(l.head==null)
			System.out.println("List is empty");
		else
		{
			Node t= l.head;
			while(t!=null)
			{
				System.out.print(t.data+"\t");
				t=t.next;
			}
		}
	}
	public static void  reverseList(Node n)
	{
		if(n==null)
			return ;
		else
		{
			reverseList(n.next);
			System.out.println("\t"+n.data+"\t");
		}
	}
	public static void deleteAt(LinkedList l,int pos,int ele)
	{
		if(l.head==null)
		{
			System.out.print("List is empty");
			return;
		}
		Node del;
		Node t=l.head;
		for(int i=1;i<pos;i++)
			t=t.next;
	    del=t.next;
	    if(ele!=del.data)
	    {
	    	System.out.println("Wrong element/position given");
	    	return;
	    }
	    System.out.print("\n"+ele + " is deleted");
	    if(t.next!=null)
	    	t.next=del.next;
	    return;
	}
	public static int middleElement(LinkedList l)
	{
		int c=0;
		if(l.head==null) { 
			System.out.println("List is empty");
			return -1; }
		else
		{
			Node t =l.head;
			while(t!=null)
			{
				t=t.next;
				c++;
			}
			t=l.head;
			for(int i=0;i<=c/2;i++)
			{
				t=t.next;
			}
			return t.data;
				
		}
	}
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		Scanner in = new Scanner(System.in);
		int ele,ch,pos;
		do
		{
			System.out.println("\n1.Insert Last\n2.Delete\n3.Display\n4.reverse\n5.Middle element\n6.exit");
			ch=in.nextInt();
			switch(ch)
			{
			case 1 : System.out.println("Enter element");
					 ele=in.nextInt();
					 l=insertLast(l,ele);
					 break;
			/* case 2 : System.out.println("Enter element");
			 		 ele=in.nextInt();
			 		 l=insertBegin(l,ele);
			 		 break;
			case 3 : System.out.println("Enter element");
	 		 		 ele=in.nextInt();
	 		 		 System.out.println("Enter position");
	 		 		 pos=in.nextInt();
	 		 		 l=insertAt(l,ele,pos);
	 		 		 break; */
			case 2 : System.out.println("Enter position");
					 pos=in.nextInt();
					 System.out.println("Enter element");
					 ele=in.nextInt();
					 deleteAt(l,pos,ele);
					 break;
			case 3 : printList(l);
					 break;
			case 4 :  reverseList(l.head);
					 break;
			case 5 : int x=middleElement(l);
					 System.out.println(x+" is the middle most element");
					 break;
			case 6 : break;
			}
			
		}while(ch!=6);
	}
}
