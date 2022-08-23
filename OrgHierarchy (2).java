import java.io.*; 
import java.util.*; 

// Tree node
class Node {
	int data;
	Vector<Node> children=new Vector<>();
	Node parent;
	int le;
	 Node(int id) {
		data=id;
		le=0;
		parent=null;
	}
	
}


public class OrgHierarchy implements OrgHierarchyInterface{

//root node
Node root=null;
int cou=0;



public boolean isEmpty(){
	if(root==null) {
		return true;
	}	
	return false;
} 

int a=0;
Node na=null;

public Node trav(Node ro,int id) {
	

    if(a==0 && na!=null) {
    	a++;
    	na=null;
    }
	
	if(ro.data==id) {
		return ro;
	}
	else{
		if(ro.children.size()==0) {
		return null;
	}

	for(int i=0;i<ro.children.size();i++) {
		
		
			 if(na==null) {
			  na=trav(ro.children.elementAt(i),id);
		
	}
}
    }
	
 	
 	

 	if(na.data==ro.data) {
 		a=0;

 	}
 	return na;
 	
}

public int size(){
	return trav(root,12).children.get(0).data;


	}



public int level(int id) throws IllegalIDException, EmptyTreeException{
	if(isEmpty()) {
		throw new EmptyTreeException(" sasaa");
		
	}
	else if(trav(root,id)==null) {
		throw new IllegalIDException("this one");
	}
	else{
		return(trav(root,id).le);
	}
} 

public void hireOwner(int id) throws NotEmptyException{
	if(!isEmpty()) {
		throw new NotEmptyException("here we go");
	}
	else{
		Node n=new Node(id);
		n.le=1;
		root=n;
		 
		
		
		

		cou++;
		
	}
}

public void hireEmployee(int id, int bossid) throws IllegalIDException, EmptyTreeException{
	if(isEmpty()) {
		throw new EmptyTreeException("hireempty");
	}
	else if(trav(root,bossid)==null) {
		throw new IllegalIDException("hireillegal");

	}
	else {
		Node pa=trav(root,bossid);
		Node naa=new Node(id);
		
		naa.parent=pa;
		cou++;
		naa.le=pa.le+1;
		pa.children.add(naa);
	}
} 

public void fireEmployee(int id) throws IllegalIDException,EmptyTreeException{
	if(isEmpty()) {
		throw new EmptyTreeException("fire1emp");
	}
	if(root.data==id) {
		throw new IllegalIDException("fire1roo");
	}
	else{
		Node naa=trav(root,id);
		if(naa.children.size()!=0) {
			throw new IllegalIDException("fire1chi");
		}
		else{
			naa.parent.children.remove(naa);
			naa.parent=null;

		}
	}
}
public void fireEmployee(int id, int manageid) throws IllegalIDException,EmptyTreeException{
	if(isEmpty()) {
		throw new EmptyTreeException("a1");
	}
} 

public int boss(int id) throws IllegalIDException,EmptyTreeException{
	if(isEmpty()) {
		throw new EmptyTreeException("hireempty");
	}
	else if(trav(root,id)==null) {
		throw new IllegalIDException("hireillegal");

	}
	else if(root.data==id) {
		return -1;
	}
	else{
		return(trav(root,id).parent.data);
	}
}

public int lowestCommonBoss(int id1, int id2) throws IllegalIDException,EmptyTreeException{
	if(isEmpty()) {
		throw new EmptyTreeException("a");
	}
	else if(root.data==id1 || root.data==id2) {
		return -1;
	}
	else if(trav(root,id1)==null || trav(root,id2)==null) {
		throw new IllegalIDException("aaa");
	}
	else{
		Node m=trav(root,id1);
		Node n=trav(root,id2);

		if(m.parent.le>n.parent.le) {
			m.parent=m.parent.parent;
		}
		else if(n.parent.le>m.parent.le) {
			n.parent=n.parent.parent;
		}
		else{
			if(m.parent==n.parent) {
				return m.parent.data;
			}
			else{
				m.parent=m.parent.parent;
				n.parent=n.parent.parent;
			}


	}


}
return 1;
}

public String toString(int id) throws IllegalIDException, EmptyTreeException{
	return "testing";
} 
}


