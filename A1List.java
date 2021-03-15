

//Implements Dictionary using Doubly Linked List (DLL)
//Implement the following functions using the specifications provided in the class List

public class A1List extends List {

private A1List  next; // Next Node
private A1List prev;  // Previous Node 

public A1List(int address, int size, int key) { 
   super(address, size, key);
}

public A1List(){
   super(-1,-1,-1);
   // This acts as a head Sentinel

   A1List tailSentinel = new A1List(-1,-1,-1); // Intiate the tail sentinel
   
   this.next = tailSentinel;
   tailSentinel.prev = this;
}

public A1List Insert(int address, int size, int key)
{
   A1List newnode = new A1List(address,size,key);
   if(this.next!= null && this.prev!=null) {
   newnode.next = this.next;
   this.next.prev = newnode;
   this.next = newnode;
   newnode.prev = this;
	 
	 
	 return newnode;}
	
	else if ( !(this.address == -1 && this.size == -1 && this.key == -1 ) && this.next == null && this.prev != null) {
	 newnode.next = null;
	 this.next = newnode;
	 newnode.prev = this;	
	 return newnode;
	 
	 
	}
   
	else if ( this.next == null && this.prev == null) {
		this.next = newnode;
		newnode.prev = this;
		return newnode;
		
		
	}
   
	else if (this.next!=null && this.prev == null) {
		newnode.next = this.next;
		this.next.prev = newnode;
		this.next = newnode;
		newnode.prev = this;
		return newnode;
		
	}
   
	else{
		
		return null;
	}

		
}

public boolean Delete(Dictionary d) 
{	if(d==null){

	return false;}
	 
	 
	 A1List temp = this.getFirst();
	A1List temp1 = this.getFirst();
	
	 while( temp!= null || temp1 !=null ) {
		if(temp != null && temp1 != null ) {
			if( temp.key == d.key && temp ==d ) {
				if(temp.key==-1 && temp.size == -1 && temp.address == -1 && temp.next == null && temp.prev!= null) {
					return false;
				}
				if(temp.key==-1 && temp.size == -1 && temp.address == -1 && temp.next != null && temp.prev== null) {
					return false;
				}
				else if (temp.next == null && temp.prev != null) {
					
					temp.prev.next = null;
					temp.prev=null;
					return true;
				}
				else if (temp.next!= null && temp.prev!= null) {
				temp.prev.next=temp.next ;
				temp.next.prev= temp.prev;
				temp.prev = null;
				temp.next = null;
				return true;}
				
				else if (temp.prev== null && temp.next != null) {
					temp.next.prev = null;
					temp.next = null;
					return true;
				}
				else {
					temp = null;
					return true;
				}
				
				
			}
			else if ( temp1.key == d.key && temp1 ==d ) {
				if(temp1.key==-1 && temp1.size == -1 && temp1.address == -1 && temp1.next == null && temp1.prev!= null) {
					return false;
				}
				if(temp1.key==-1 && temp1.size == -1 && temp1.address == -1 && temp1.next != null && temp1.prev== null) {
					return false;
				}
				else if (temp1.next == null && temp1.prev != null) {
					
					temp1.prev.next = null;
					temp1.prev=null;
					return true;
				}
				else if (temp1.next!= null && temp1.prev!= null) {
				temp1.prev.next=temp1.next ;
				temp1.next.prev= temp1.prev;
				temp1.prev = null;
				temp1.next = null;
				return true;}
				
				else if (temp1.prev== null && temp1.next != null) {
					temp1.next.prev = null;
					temp1.next = null;
					return true;
				}
				else {
					temp1 = null;
					return true;
				}
				
				
				

				
			}
			temp = temp.next;
			temp1 = temp1.prev;
			}
		
		else if ( temp == null && temp1 != null) {
			if ( temp1.key == d.key && temp1 ==d  ) {
				
				if(temp1.key==-1 && temp1.size == -1 && temp1.address == -1 && temp1.next == null && temp1.prev!= null) {
					return false;
				}
				if(temp1.key==-1 && temp1.size == -1 && temp1.address == -1 && temp1.next != null && temp1.prev== null) {
					return false;
				}
				else if (temp1.next == null && temp1.prev != null) {
					
					temp1.prev.next = null;
					temp1.prev=null;
					return true;
				}
				else if (temp1.next!= null && temp1.prev!= null) {
				temp1.prev.next=temp1.next ;
				temp1.next.prev= temp1.prev;
				temp1.prev = null;
				temp1.next = null;
				return true;}
				
				else if (temp1.prev== null && temp1.next != null) {
					temp1.next.prev = null;
					temp1.next = null;
					return true;
				}
				else {
					temp1 = null;
					return true;
				}
				
				
				
			}
			temp1 = temp1.prev;
			
		}
		else {
			if( temp.key == d.key && temp ==d) {
				
				if(temp.key==-1 && temp.size == -1 && temp.address == -1 && temp.next == null && temp.prev!= null) {
					return false;
				}
				if(temp.key==-1 && temp.size == -1 && temp.address == -1 && temp.next != null && temp.prev== null) {
					return false;
				}
				else if (temp.next == null && temp.prev != null) {
					
					temp.prev.next = null;
					temp.prev=null;
					return true;
				}
				else if (temp.next!= null && temp.prev!= null) {
				temp.prev.next=temp.next ;
				temp.next.prev= temp.prev;
				temp.prev = null;
				temp.next = null;
				return true;}
				
				else if (temp.prev== null && temp.next != null) {
					temp.next.prev = null;
					temp.next = null;
					return true;
				}
				else {
					temp = null;
					return true;
				}
				
				
			}
			temp = temp.next;
			
			
		}
		
	}
	 
	 
		 return false;
	 
	 
}

public A1List Find(int k, boolean exact)
{ 
	 A1List temp = this.getFirst();
	A1List temp1 = this.getFirst();
	
   if(exact == true) {
  	 
  	 while( temp!= null || temp1 !=null ) {
   		if(temp != null && temp1 != null ) {
   			if(temp.key ==k) {
   				if(k== -1 && ( (temp.key==-1 && temp.address==-1 && temp.size == -1 && temp.prev == null && temp.next!=null) || (temp.key==-1 && temp.address==-1 && temp.size == -1 && temp.next == null && temp.prev!=null) ) ){
   					return null;
   				}
   				return temp;
   				
   			}
   			else if (temp1.key ==k) {
   				if(k== -1 && ( (temp1.key==-1 && temp1.address==-1 && temp1.size == -1 && temp1.prev == null && temp1.next!=null) || (temp1.key==-1 && temp1.address==-1 && temp1.size == -1 && temp1.next == null && temp1.prev!=null) ) ){
   					return null;
   				}
   				
   				
   				return temp1;
   			}
   			temp = temp.next;
   			temp1 = temp1.prev;
   			}
   		
   		else if ( temp == null && temp1 != null) {
   			if (temp1.key ==k) {
   				if(k== -1 && ( (temp1.key==-1 && temp1.address==-1 && temp1.size == -1 && temp1.prev == null && temp1.next!=null) || (temp1.key==-1 && temp1.address==-1 && temp1.size == -1 && temp1.next == null && temp1.prev!=null) ) ){
   					return null;
   				}
   				
   				return temp1;
   			}
   			temp1 = temp1.prev;
   			
   		}
   		else {
   			if(temp.key ==k) {
   				
   				if(k== -1 && ( (temp.key==-1 && temp.address==-1 && temp.size == -1 && temp.prev == null && temp.next!=null) || (temp.key==-1 && temp.address==-1 && temp.size == -1 && temp.next == null && temp.prev!=null) ) ){
   					return null;
   				}
   				return temp;}
   			temp = temp.next;
   			
   			
   		}
   		
   	}
   	 
   	 return null;
  	 
  	}
   
   else 
   {
  	
  	while( temp!= null || temp1 !=null ) {
  		if(temp != null && temp1 != null ) {
  			if(temp.key >=k) {
  				if(k== -1 && ( (temp.key==-1 && temp.address==-1 && temp.size == -1 && temp.prev == null && temp.next!=null) || (temp.key==-1 && temp.address==-1 && temp.size == -1 && temp.next == null && temp.prev!=null) ) ){
   					return null;
   				}
  				
  				return temp;
  				
  			}
  			else if (temp1.key >=k) {
  				if(k== -1 && ( (temp1.key==-1 && temp1.address==-1 && temp1.size == -1 && temp1.prev == null && temp1.next!=null) || (temp1.key==-1 && temp1.address==-1 && temp1.size == -1 && temp1.next == null && temp1.prev!=null) ) ){
   					return null;
   				}
  				
  				return temp1;
  			}
  			temp = temp.next;
  			temp1 = temp1.prev;
  			}
  		
  		else if ( temp == null && temp1 != null) {
  			if (temp1.key >=k) {
  				if(k== -1 && ( (temp1.key==-1 && temp1.address==-1 && temp1.size == -1 && temp1.prev == null && temp1.next!=null) || (temp1.key==-1 && temp1.address==-1 && temp1.size == -1 && temp1.next == null && temp1.prev!=null) ) ){
   					return null;
   				}
  				
  				return temp1;
  			}
  			temp1 = temp1.prev;
  			
  		}
  		else {
  			if(temp.key >=k) {
  				if(k== -1 && ( (temp.key==-1 && temp.address==-1 && temp.size == -1 && temp.prev == null && temp.next!=null) || (temp.key==-1 && temp.address==-1 && temp.size == -1 && temp.next == null && temp.prev!=null) ) ){
   					return null;
   				}
  				
  				return temp;}
  			temp = temp.next;
  			
  			
  		}
  		
  	}
  	 
  	 return null;
  	 
  	 
   }
	 
	 
	 
	 
	 
}

public A1List getFirst()
{
   A1List temp;
   temp = this;
   A1List x = this;
   while(temp.prev != null) {
  	 temp = temp.prev;
   }
   while(x.next!=null) {
  	 x= x.next;
   }
   if (  !(temp.size == -1 && temp.key == -1 && temp.address == -1 ) ) {
  	 return temp;
   }
   
   
   
   if(temp.size == -1 && temp.key == -1 && temp.address == -1 && temp.next != null &&  temp.next.size == -1 && temp.next.key == -1 && temp.next.address == -1  && temp.next.next == null) {
  	 return null;
   }
   if (temp.size == -1 && temp.key == -1 && temp.address == -1 && temp.next == null) {
  	 return null;
   }
	 if( temp.size == -1 && temp.key == -1 && temp.address == -1 && temp.next != null && temp.next!=x &&  x.size == -1 && x.key == -1 && x.address == -1) {
		 return temp.next;
	 }
	 return null;
}




public A1List getNext() 
{
	 A1List temp = this;
	 if(temp.next == null) {
		 return null;
	 }
	 else if(temp.size == -1 && temp.key == -1 && temp.address == -1 && temp.prev == null && temp.next != null &&  temp.next.size == -1 && temp.next.key == -1 && temp.next.address == -1  && temp.next.next == null) {
		 return null;
	 }
	 
	 else if (temp.next!= null && temp.next.next == null && temp.next.size == -1 && temp.next.key == -1 && temp.next.address == -1) {
		 return null;
	 }
	 else if (temp.next!=null && temp.next.next!= null) {
		 return temp.next;
	 }
	 
	 
	 
   
	 return this.next;
}


public boolean sanity()
{
	 A1List temp = this;
	 A1List x= this.next ;
	 while(temp != null && x!= null && x.next!= null  && temp.next!= null) {
		 if(temp == x) {
			 return false;
		 }
		 temp=temp.next;
		 x=x.next.next;
		 
	 }
	 

	 if(x!= null && x.next == null) {
		 
		 if(!(x.size == -1 && x.address == -1 && x.key == -1)) {
			 return false;
		 }
	 }
	 
	 temp =this;
	 x=this;
	 while(temp!= null && temp.prev!=null) {
		 if(temp.prev.next != temp) {
			 return false;
		 }
			 temp=temp.prev;
			 
		 }
	 if(temp.prev == null) {
		 if(!(temp.size == -1 && temp.address == -1 && temp.key == -1)) {
			 return false;
		 }
	 }
	 
	 while(x!= null && x.next!=null) {
		 
		 if(x.next.prev!=x) {
			 return false;
		 }
		 x=x.next;
	 }
	 
	 if(x.next == null) {
		 if(!(x.size == -1 && x.address == -1 && x.key == -1)) {
			 return false;
		 }
		 
	 }
		return true; 
	 }
	 
	 
	 
 



}


