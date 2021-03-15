//deepansh

//Class: Height balanced AVL Tree
//Binary Search Tree

public class AVLTree extends BSTree {
 
 private AVLTree left, right;     // Children. 
 private AVLTree parent;          // Parent pointer. 
 private int height;  // The height of the subtree
     
 public AVLTree() { 
     super();
     // This acts as a sentinel root node
     // How to identify a sentinel node: A node with parent == null is SENTINEL NODE
     // The actual tree starts from one of the child of the sentinel node !.
     // CONVENTION: Assume right child of the sentinel node holds the actual root! and left child will always be null.
     
 }

 public AVLTree(int address, int size, int key) { 
     super(address, size, key);
     this.height = 0;
 }

 // Implement the following functions for AVL Trees.
 // You need not implement all the functions. 
 // Some of the functions may be directly inherited from the BSTree class and nothing needs to be done for those.
 // Remove the functions, to not override the inherited functions.
 
 public AVLTree Insert(int address, int size, int key) 
 { 	
  
	 
	 AVLTree newtree = new AVLTree(address , size , key);
	 AVLTree temp =this;
	 while(temp.parent != null) {
			temp = temp.parent;
		}
		if ( temp.right == null) {
			
			
		 temp.right = newtree;
			 newtree.parent = temp;
			 newtree.height = 1;
			 return newtree;
			 
		}
		temp = temp.right;
		while(temp != null) {
			if(temp.key >key) {
				if(temp.left !=null) {
					temp = temp.left;
				}
				else if (temp.left == null) {
					temp.left = newtree;
					newtree.parent = temp;
					break;
					
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
						break;
						
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
							break;
							
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
						 break;
					
					
				}
				
			}
			
			
			
			
			
			
		}
		
		AVLTree x = newtree;
		
		while(x.parent.parent != null && heightbalance(x) == true) {
			x.height = max(height(x.left) , height(x.right))  +1;
			//System.out.println(x.height + "h:x=" + x.key);
			x = x.parent;
			
		}
		//System.out.println(heightbalance(x) + "," +x.key);
		if(x.parent.parent == null && heightbalance(x) == true) {
			x.height = max(height(x.left) , height(x.right)) + 1;
			return newtree;
		}
		else {
			//System.out.println(x.key);
			rotate(x , newtree);
		}
		
	
	 
     return newtree;
 }

 
 private void rotate(AVLTree x , AVLTree tree) {
	 int key = tree.key;
	 int address = tree.address;
	 int a = height(x.left);
	 int b = height(x.right);
	 //System.out.println(key);
	 if(a- b >1) {
		 if(x.key >key && x.left.key > key) {
			 rightrotate(x);
			 return;
		 }
		 if(x.key > key && x.left.key == key && x.left.address>address) {
			 rightrotate(x);
			 return ;
		 }
 if(x.key == key && x.left.key == key && x.left.address > address) {
			 rightrotate(x);
			 return;
		 }
		 if(x.key == key && x.left.key == key && x.left.address < address) {
			 leftrotate(x.left);
			 rightrotate(x);
			 return;
		 }
		 if(x.key > key && x.left.key <key) {
			 leftrotate(x.left);
			 rightrotate(x);
			 return;
		 }
		 if(x.key > key && x.left.key == key && x.left.address < address) {
			 leftrotate(x.left);
			 rightrotate(x);
			 return;
		 }
 if(x.key == key && x.left.key > key ){
			 
			 rightrotate(x);
			 return;
		 }
		 if(x.key == key && x.left.key < key) {
			 leftrotate(x.left);
			 rightrotate(x);
			 return;
		 }
		 

		 
	 }
	 
	 else if (b-a > 1) {
		 //System.out.println(1);
		 //System.out.println(x.key + "," + x.right.key + ", );
		 if(x.key <key && x.right.key <key) {
			 //System.out.println(1);
			 leftrotate(x);
			 return;
		 }
		 if(x.key < key && x.right.key == key && x.right.address <address) {
			 leftrotate(x);
			 return;
		 }
 if(x.key == key && x.right.key == key && x.right.address > address) {
			 rightrotate(x.right);
			 leftrotate(x);
			 return;
		 }
		 if(x.key == key && x.right.key == key && x.right.address < address) {
			 leftrotate(x);
			 
			 return;
		 }
 if(x.key == key && x.right.key > key ){
			 
			 rightrotate(x.right);
			 leftrotate(x);
			 return;
		 }
		 if(x.key == key && x.right.key < key) {
			 leftrotate(x);
return;
		 }

		 
		 if(x.key < key && x.right.key >key) {
			 rightrotate(x.right);
			 leftrotate(x);
			 return;
		 }
		 if(x.key < key && x.right.key == key && x.right.address> address) {
			 rightrotate(x.right);
			 leftrotate(x);
			 return ;
		 }
		 
	 }
	 
	 
	 
 }
 
 private AVLTree leftrotate(AVLTree z ) {
	 
	 AVLTree y = z.right;
	 AVLTree t3 = y.left;
	 AVLTree parent = z.parent;
	 
	 if(parent.left == z) {
		 
		 parent.left = y;
		 y.parent = parent;
		 y.left = z;
		 z.parent = y;
		 if(t3 == null) {
			 z.right = null;
		 }
		 else if(t3!=null) {
			 z.right = t3;
			 t3.parent = z;
			 
		 }
	 }
	 
	 else if (parent.right ==z) {
		 
		 parent.right = y;
		 y.parent = parent;
		 y.left = z;
		 z.parent = y;
		 if(t3 == null) {
			 z.right = null;
		 }
		 else if ( t3!= null) {
			 
			 z.right = t3;
			 t3.parent = z;
		 }
	 }
	 z.height = max( height(z.left) , height(z.right))+1;
	 y.height = max(height(y.left),height(y.right)  ) +1;
	 return y.parent ;
	 
	 
 }
 
 
 
 
 
 private AVLTree rightrotate(AVLTree z) {
	 
	 AVLTree y = z.left;
	 
	 AVLTree t3 = y.right; 
	 
	 AVLTree parent = z.parent;
	 if(parent.left == z) {
		 parent.left = y;
		 y.parent = parent;
		 y.right = z;
		 z.parent = y;
		 if(t3 == null) {
			 z.left = null;
		 }
		 else if (t3!= null) {
			 z.left = t3;
			 t3.parent = z;
		 }
		 
		 
	 }
	 else if(parent.right ==z) {
		 parent.right = y;
		 y.parent = parent;
		 y.right = z;
		 z.parent = y;
		 if(t3 ==null) {
			 z.left = null;
			 
		 }
		 else if(t3!=null) {
			 z.left = t3;
			 t3.parent = z;
		 }
		 
	 }
	
	 z.height = max( height(z.left) , height(z.right))+1;
	 y.height = max(height(y.left), height(y.right)  ) +1;
	 return y.parent ;
	 
 }
 
 
 private boolean heightbalance(AVLTree x) {
	 int a = height(x.left);
	 int b = height(x.right);
	 if( a-b > 1 || a-b <-1  ) {
		 return false;
	 }
	 return true;
 }
 
 private int max(int a , int b) {
	 if(a>=b) {
		 return a;
	 }
	 return b;
 }
 private int height(AVLTree x) {
	 if(x == null) {
		 return 0;
	 }
	 return x.height;
	 
 }

 public AVLTree getFirst()
 { 
     if(this.parent == null  && this.right == null) {
    	 return null;
     }
	 if (this.parent == null && this.right!= null) {
		 return this.right.getFirst();
	 }
     else {
    	 AVLTree temp = this;
    	 while(temp.left != null) {
    		 temp = temp.left;
    	 }
    	 return temp;
     }
	
 }

 public AVLTree getNext()
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
    		AVLTree temp = this.parent;
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
 
 public boolean Delete(Dictionary e)
 { 	

	
	int k = 0;
	 AVLTree checker = null;
	 if(e==null) {
		 return false;
	 }
	 if(e.key == -1 && e.address == -1 && e.size == -1) {
		 return false;
	 }
	 AVLTree temp = this;
	 while(temp.parent!=null) {
    	 temp=temp.parent;
     }
	 
	 
	 while(temp != null) {
 		if(temp.key == e.key && temp.address == e.address && temp.size == e.size ) {
 			//System.out.println(000);
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
	 //System.out.println(temp.size + "," + temp.address + ","+temp.key);
	 if(temp == null) {
		 return false;
	 }
	 
	 else {
		 //System.out.println(11);
		  if (temp.left == null && temp.right == null) {
			  	checker = temp.parent;
			  if(temp.parent.left == temp) {
				  
				  temp.parent.left = null;
				  //temp.parent = null;
				  
				  k++;
			  }
			  else {
				  temp.parent.right = null;
				  //temp.parent = null;
				  k++;
			  }
		  }
		 
		  else if(temp.left == null && temp.right != null ) {
			  checker = temp.parent;
			  if(temp.parent.left == temp) {
				  
				  temp.parent.left = temp.right;
				  temp.right.parent = temp.parent;
				  //temp.parent = null;
				  //temp.right = null;
				  k++;
			  }
			  else {
				  temp.parent.right = temp.right;
				  temp.right.parent = temp.parent;
				  //temp.parent = null;
				  //temp.right = null;
				  k++;
			  }
			  
		  }
		  
		  else if (temp.right == null && temp.left != null) {
			  checker = temp.parent;
			  if(temp.parent.left == temp) {
				  
				  temp.parent.left = temp.left;
				  temp.left.parent = temp.parent;
				  //temp.parent=null;
				  //temp.left = null;
				  k++;
			  }
			  else {
				  temp.parent.right = temp.left;
				  temp.left.parent = temp.parent;
				  //temp.parent = null;
				  //temp.left = null;
				  k++;
			  } }
			  
		else {
			//System.out.println(33);
				  
				  AVLTree successor = temp.getNext();
				  //System.out.println(successor.key);
				  temp.key = successor.key;
				  temp.address = successor.address;
				  temp.size = successor.size;
				  //System.out.println(temp.size + "," + temp.address + ","+temp.key);
				  temp = successor;
				  
				  if(temp.left == null && temp.right == null) {
					  checker = temp.parent;
					  if(temp.parent.left == temp) {
						  temp.parent.left = null;
						  //temp.parent = null;
						  k++;
					  }
					  else {
						  temp.parent.right = null;
						  //temp.parent = null;
						  k++;
					  }
				  }
				  
				  else if (temp.right != null && temp.left == null) {
					  checker = temp.parent;
					  if(temp.parent.left == temp) {
						  
						  temp.parent.left = temp.right;
						  temp.right.parent = temp.parent;
						  //temp.parent=null;
						  //temp.left = null;
						  k++;
					  }
					  else {
						  temp.parent.right = temp.right;
						  temp.right.parent = temp.parent;
						  //temp.parent = null;
						  //temp.left = null;
						  k++;
					  } }
				  
				  
					  
					  
					  
					  
				  }
				  
				  
			  }
	 
	 			if(k==0) {
	 				return false;
	 			}
	 			checker.height = max( height(checker.left) , height(checker.right)) + 1;
	 			while(checker.parent!=null) {
	 				if(checker.parent.parent == null && heightbalance(checker) == true) {
	 					checker.height = max( height(checker.left) , height(checker.right)) + 1;

	 					
return true;
	 					
	 				}
	 				if(checker.parent.parent == null && heightbalance(checker) == false ) {
	 					rotatedel(checker);

	 					return true;
	 				}
	 				else if (heightbalance(checker) == true) {
	 					checker.height = max( height(checker.left) , height(checker.right)) + 1;
	 					checker = checker.parent;
	 					
	 				}
	 				else if (heightbalance(checker) == false) {
	 					checker = rotatedel(checker);
	 					checker.height = max( height(checker.left) , height(checker.right)) + 1;
	 				}
	 			}
	 
	 		
			  
			  return true;
		  }
		 

 
 private AVLTree rotatedel(AVLTree x ) {
	
	 int a = height(x.left);
	 int b = height(x.right);
	 //System.out.println(key);
	 if(a- b >1) {
		 int c = height(x.left.left);
		 int d = height(x.left.right);
		 if( c>=d  ) {
			 return rightrotate(x);
			 
		 }
		 if(d>c) {
			 leftrotate(x.left);
			 return rightrotate(x);
			 
		 }

		 
	 }
	 
	 else if (b-a > 1) {
		 int c = height(x.right.right);
		 int d = height(x.right.left);
		 
		 if(c>=d) {
			 
			 return leftrotate(x);
			 
		 }
		 
		 if(d>c) {
			 rightrotate(x.right);
			return leftrotate(x);
			
		 }
		
		 
	 }
	 
	 return x;
	 
 }
	 
 public AVLTree Find(int key, boolean exact)
 { 		
	AVLTree ans = null;
	AVLTree temp = this;
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
    	AVLTree x = null ;
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
	 
	 
 private boolean avlvariant(AVLTree x ) {
	 
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
		 
		 return ( (avlvariant(x.left) && heightbalance(x.left)) &&  (avlvariant(x.right) && heightbalance(x.right) ));
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
		 return (avlvariant(x.right) && heightbalance(x.right));
		 
		 
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
		 return (avlvariant(x.left)&&heightbalance(x.left));
		 
	 }
	 
	 else {
		 
		 
		 return true;
	 }
	 
 }
 public boolean sanity()
 { 
	 AVLTree slow = this;
	 AVLTree fast = this.parent;
	 while(slow!= null && slow.parent != null && fast !=null && fast.parent != null) {
		 if(slow == fast) {
			 return false;
		 }
		 slow = slow.parent;
		 fast = fast.parent.parent;
	 }
 
	 
	 AVLTree temp = this;
	   
	 while(temp.parent != null) {
			temp = temp.parent;
		}
	    
	    if(temp.left != null) {
	    	//System.out.println(2);
	    	return false; 
	    	
	    	
	    }
	    if(  !(temp.size == -1 && temp.key == -1 && temp.address == -1 )) {
	    	//System.out.println(1);
	    	return false;
	    }
	    if(temp.right != null) {
	    boolean x = avlvariant(temp.right) && heightbalance(temp.right);
	    if(x == false) {
	    	return false;
	    }
	    
	    }
	 
	 return true;
 }
	 
	 
 

 
 
 
 




 
}



