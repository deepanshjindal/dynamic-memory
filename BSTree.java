

//Class: Implementation of BST in A2
//Implement the following functions according to the specifications provided in Tree.java

public class BSTree extends Tree {

 private BSTree left, right;     // Children.
 private BSTree parent;          // Parent pointer.
     
 public BSTree(){  
     super();
     // This acts as a sentinel root node
     // How to identify a sentinel node: A node with parent == null is SENTINEL NODE
     // The actual tree starts from one of the child of the sentinel node!.
     // CONVENTION: Assume right child of the sentinel node holds the actual root! and left child will always be null.
 }    

 public BSTree(int address, int size, int key){
     super(address, size, key); 
 }

 public BSTree Insert(int address, int size, int key) {
	 
	 BSTree newtree = new BSTree(address , size,key);
	 BSTree temp = this;
	while(temp.parent != null) {
		temp = temp.parent;
	}
	if ( temp.right == null) {
		
		
	 temp.right = newtree;
		 newtree.parent = temp;
		 return newtree;
		 
	}
	temp = temp.right;
	while(temp != null) {
		if(temp.key > key) {
			if(temp.left != null) {
				temp = temp.left;
			}
			else if (temp.left == null) {
				 temp.left = newtree;
					 newtree.parent = temp;
					 return newtree;
				
				
			}
			
		}
		else if (temp.key == key) {
			if(temp.address > address) {
				if(temp.left != null) {
					temp = temp.left;
				}
				else if (temp.left == null) {
					temp.left = newtree;
					newtree.parent = temp;
					return newtree;
					
				}
			}
			else if(temp.address < address) {
				if(temp.address< address ) {
					if(temp.right != null) {
						temp= temp.right;
					}
					else if ( temp.right == null) {
						temp.right = newtree;
						newtree.parent = temp;
						return newtree;
						
					}
				}
			}
			
		}
		
		else if (temp.key < key) {
				if(temp.right != null) {
					temp = temp.right;
				}
				else if (temp.right == null) {
					 temp.right = newtree;
						 newtree.parent = temp;
						 return newtree;
					
					
				}
				
			}
			
			
			
		}
	return null;
		
	}
 public boolean Delete(Dictionary e)
 { 
	 if(e==null) {
		 return false;
	 }
	 if(e.key == -1 && e.address == -1 && e.size == -1) {
		 return false;
	 }
	 BSTree temp = this;
	 while(temp.parent!=null) {
    	 temp=temp.parent;
     }
	 
	 
	 while(temp != null) {
 		if(temp.key == e.key && temp.address == e.address && temp.size == e.size ) {
 			break;
 		}
 		if(temp.key == e.key && temp.address > e.address ) {
 			temp= temp.left;
 			
 			
 		}
 		else if(temp.key == e.key && temp.address < e.address) {
 			temp = temp.right;
 		}
 		
 		
 		else if (temp.key > e.key) {
 			if(temp.left == null) {
 				return false;
 			}
 			else {
 				temp = temp.left;
 			}
 			
 		}
 		
 		else if(temp.key < e.key){
 			if(temp.right == null) {
 				return false;
 			}
 			else {
 				temp = temp.right;
 			}
 			
 			
 		}
 		
 	}
	 
	 if(temp == null) {
		 return false;
	 }
	 
	 else {
		  if (temp.left == null && temp.right == null) {
			  if(temp.parent.left == temp) {
				  temp.parent.left = null;
				  temp.parent = null;
				  return true;
			  }
			  else {
				  temp.parent.right = null;
				  temp.parent = null;
				  return true;
			  }
		  }
		 
		  else if(temp.left == null && temp.right != null ) {
			  if(temp.parent.left == temp) {
				  
				  temp.parent.left = temp.right;
				  temp.right.parent = temp.parent;
				  temp.parent = null;
				  temp.right = null;
				  return true;
			  }
			  else {
				  temp.parent.right = temp.right;
				  temp.right.parent = temp.parent;
				  temp.parent = null;
				  temp.right = null;
				  return true;
			  }
			  
		  }
		  
		  else if (temp.right == null && temp.left != null) {
			  
			  if(temp.parent.left == temp) {
				  
				  temp.parent.left = temp.left;
				  temp.left.parent = temp.parent;
				  temp.parent=null;
				  temp.left = null;
				  return true;
			  }
			  else {
				  temp.parent.right = temp.left;
				  temp.left.parent = temp.parent;
				  temp.parent = null;
				  temp.left = null;
				  return true;
			  } }
			  
		else {
				  
				  BSTree successor = temp.getNext();
				  temp.key = successor.key;
				  temp.address = successor.address;
				  temp.size = successor.size;
				  temp = successor;
				  if(temp.left == null && temp.right == null) {
					  
					  if(temp.parent.left == temp) {
						  temp.parent.left = null;
						  temp.parent = null;
						  return true;
					  }
					  else {
						  temp.parent.right = null;
						  temp.parent = null;
						  return true;
					  }
				  }
				  
				  else if (temp.right != null && temp.left == null) {
					  
					  if(temp.parent.left == temp) {
						  
						  temp.parent.left = temp.right;
						  temp.right.parent = temp.parent;
						  temp.parent=null;
						  temp.left = null;
						  return true;
					  }
					  else {
						  temp.parent.right = temp.right;
						  temp.right.parent = temp.parent;
						  temp.parent = null;
						  temp.left = null;
						  return true;
					  } }
				  
				  
					  
					  
					  
					  
				  }
				  
				  
			  }
			  
			  return false;
		  }
		 
	 
	 
	 
	 
	 
	 
	 
 
     
 public BSTree Find(int key, boolean exact)
 { 		
	BSTree ans = null;
    BSTree temp = this;
    while(temp.parent != null) {
		temp = temp.parent;
	}
    if(temp.right == null) {
    	return null;
    }
    temp = temp.right;
    if(exact == true) {
    	while(temp != null) {
    		if(temp.key == key) {
  			ans = temp;
  			temp = temp.left;
    	
  
    		}
    		else if (temp.key >key) {
    			if(temp.left == null) {
    				return ans;
    			}
    			else {
    				temp = temp.left;
    			}
    			
    		}
    		
    		else if(temp.key < key){
    			if(temp.right == null) {
    				return ans;
    			}
    			else {
    				temp = temp.right;
    			}
    			
    			
    		}
    		
    	}
    	
    	if(ans == null) {
    		return null;
    	}
   return ans;
    	
    }
    
    else{
    	BSTree x = null ;
    	while(temp != null) {
    		
    		if(temp.key == key) {
    			x = temp;
    			temp=temp.left;
    		}
    		else if(temp.key > key) {
    			x=temp;
    			temp =temp.left;
    			
    			
    		}
    		else {
    			
    			temp = temp.right;
    			
    		}
    		
    		
    	}
    	
    	return x;
    	
    	
    	
    	
    	
    }
	 
	 
	 
	 
 }

 public BSTree getFirst()
 { 
     if(this.parent == null  && this.right == null) {
    	 return null;
     }
	 if (this.parent == null && this.right!= null) {
		 return this.right.getFirst();
	 }
     else {
    	 BSTree temp = this;
    	 while(temp.left != null) {
    		 temp = temp.left;
    	 }
    	 return temp;
     }
	
 }

 public BSTree getNext()
 { 
     if(this.parent == null && this.right == null) {
    	 return null;
     }
     
     else if(this.right != null) {
    	 return this.right.getFirst();
    	 
     }
     else if (this.right == null && this.parent.parent == null) {
    	 return null;
     }
     else {
    	 
    	int t = this.key;
    	BSTree temp = this.parent;
    	while( temp != null && (temp.key< t || (temp.key == t && temp.address < this.address))  ) {
    		temp =temp.parent;
    	}
    	if(temp == null) {
    		return null;
    	}
    	else {
    		if(temp.key > t) {
    			return temp;
    		}
    		else if (temp.key == t && temp.address > this.address) {
    			return temp;
    		}
    		else {
    	 return null;}
    	 
     }
 }
 }
 
 
 private boolean bstvariant(BSTree x ) {
	 
	 if(x.left != null && x.right != null) {
		 if( !(x.left.parent == x && x.right.parent == x)) {
			 return false;
		 }
		 if( (x.key < x.left.key) ||( x.key > x.right.key) ){
			 return false;
		 }
		 if( (x.key == x.left.key&& x.left.address > x.address) || (x.key == x.right.key && x.right.address < x.address)  ) {
			 return false;
		 }
		 
		 return ( bstvariant(x.left) && bstvariant(x.right));
	 }
	 
	 
	 else if (x.left == null &&x.right!=null) {
		 if(x.right.parent!=x) {
			 return false;
		 }
		 if(x.right.key < x.key) {
			 return false;
		 }
		 else if (x.key==x.right.key && x.address > x.right.address) {
			 return false;
		 }
		 return bstvariant(x.right);
		 
		 
	 }
	 else if (x.right == null && x.left != null) {
		 if(x.left.parent != x) {
			 return false;
		 }
		 
		 if(x.left.key > x.key) {
			 
			 return false;
		 }
		 else if (x.key == x.left.key && x.address<x.left.address) {
			 return false;
		 }
		 return bstvariant(x.left);
		 
	 }
	 
	 else {
		 
		 
		 return true;
	 }
	 
 }
 public boolean sanity()
 { 
	 BSTree slow = this;
	 BSTree fast = this.parent;
	 while(slow!= null && slow.parent != null && fast !=null && fast.parent != null) {
		 if(slow == fast) {
			 return false;
		 }
		 slow = slow.parent;
		 fast = fast.parent.parent;
	 }
	


 BSTree temp = this;
	    while(temp.parent != null) {
			temp = temp.parent;
		}
	    if(temp.left != null) {
	    	return false; 
	    	
	    }
	    if(  !(temp.size == -1 && temp.key == -1 && temp.address == -1 )) {
	    	return false;
	    }
	    if(temp.right != null) {
	    boolean x = bstvariant(temp.right);
	    if(x == false) {
	    	return false;
	    }
	    
	    }
	 
	 return true;
 }

}






