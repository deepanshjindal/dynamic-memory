//deepansh 
//Class: A2DynamicMem
//Implements Degragment in A2. No other changes should be needed for other functions.



public class A2DynamicMem extends A1DynamicMem {
   
 public A2DynamicMem() {  super(); }

 public A2DynamicMem(int size) { super(size); }

 public A2DynamicMem(int size, int dict_type) { super(size, dict_type); }

 // In A2, you need to test your implementation using BSTrees and AVLTrees. 
 // No changes should be required in the A1DynamicMem functions. 
 // They should work seamlessly with the newly supplied implementation of BSTrees and AVLTrees
 // For A2, implement the Defragment function for the class A2DynamicMem and test using BSTrees and AVLTrees. 

 public void Defragment() {

	 if(this.type == 2) {
		 
		 
	 
	 
BSTree x = new BSTree();
for (Dictionary d = freeBlk.getFirst() ;d != null; d = d.getNext()) {  
	//System.out.println(d.address + " ," + d.size);
	x.Insert(d.address, d.size, d.address);

	
}

BSTree y = x.getFirst();
//System.out.println(y.getNext().getNext().key);
while(y!=null && y.getNext() != null) {
	BSTree z = y.getNext();
	//System.out.println(y.size + "ys" + y.address + "ya" + z.key + "zs" + z.size);
	if(y.address + y.size == z.address) {
	
		int address = y.address;
		int size = y.size + z.size;
		x.Delete(z);
		x.Delete(y);
		
		x.Insert(address,size, address );

		
		
		y = x.getFirst();
		
	}
	else {
		y = y.getNext();
	}
	
}
Dictionary o = freeBlk.getFirst();
while( o!=null) {
	
	//System.out.println(o.size);
	freeBlk.Delete(o);
	 o = freeBlk.getFirst();
	
}

for(Dictionary a = x.getFirst(); a!= null ; a = a.getNext()) {
	freeBlk.Insert(a.address, a.size, a.size);
}
Dictionary p = x.getFirst();
while( p!= null ) {
	x.Delete(p);
	p = x.getFirst();
}

	 }
	 
	 
	 else if(this.type == 3) {
		 
		 
		 AVLTree x = new AVLTree();
		 for (Dictionary d = freeBlk.getFirst() ;d != null; d = d.getNext()) {  
		 	//System.out.println(d.address + " ," + d.size);
		 	x.Insert(d.address, d.size, d.address);

		 	
		 }

		 AVLTree y = x.getFirst();
		 //System.out.println(y.getNext().getNext().key);
		 while(y!=null && y.getNext() != null) {
		 	AVLTree z = y.getNext();
		 	//System.out.println(y.size + "ys" + y.address + "ya" + z.key + "zs" + z.size);
		 	if(y.address + y.size == z.address) {
		 	
		 		int address = y.address;
				int size = y.size + z.size;
				Dictionary p = new AVLTree(address,y.size,y.size);
				Dictionary q = new AVLTree(z.address,z.size,z.size);
freeBlk.Delete(p);
freeBlk.Delete(q);				
freeBlk.Insert(address,size,size);
		 		x.Delete(z);
		 		x.Delete(y);
		 		
		 		x.Insert(address,size, address );

		 		
		 		
		 		y = x.getFirst();
		 		
		 	}
		 	else {
		 		y = y.getNext();
		 	}
		 	
		 }
		//  Dictionary o = freeBlk.getFirst();
		//  while( o!=null) {
		 	
		//  	//System.out.println(o.size);
		//  	freeBlk.Delete(o);
		//  	 o = freeBlk.getFirst();
		 	
		//  }

		//  for(Dictionary a = x.getFirst(); a!= null ; a = a.getNext()) {
		//  	freeBlk.Insert(a.address, a.size, a.size);
		//  }
		  Dictionary pq = x.getFirst();
		  while( pq!= null ) {
		  	x.Delete(pq);
		  	pq = x.getFirst();
		  }
		 
		 
		 
		 
	 }




return ;
 }
 
public int Allocate(int blockSize) {
	if(blockSize <= 0 ) {
		 return -1;
	 }
	 
	 Dictionary block = freeBlk.Find(blockSize, false);
	 
//	 if(blockSize == 1 ) {
//		 System.out.println(block.address + "ll");
//	 }
	 if(block == null) {
		 return -1;
	 }
	 int y = block.address;
	
	 if(blockSize <= 0 ) {
		 return -1;
	 }
	 if( block.size == blockSize) {
		 //System.out.println(block.address);

		 freeBlk.Delete(block);
		 //System.out.println(block.address);
		 allocBlk.Insert(y, blockSize, y);
		 //System.out.println(block.address);
		 return y;
	 }
	 
	 else if ( block.size > blockSize) {

		 allocBlk.Insert(block.address, blockSize, block.address);
		 if(blockSize == 3 && block.size ==16) {
		 //System.out.println(901);
	 }
		 int a = block.address + blockSize;
		 int b  = block.size - blockSize;
		 int x = block.address;
		 
		 freeBlk.Insert(a, b,b);
		 freeBlk.Delete(block);
	
			
		
		
		
		
		 return x;
		 
	 }
	 
	 
   return -1;
} 

public int Free(int startAddr) {
	 if(startAddr<0) {
		 return -1;
	 }
	 if ( allocBlk.getFirst() == null) {
		 return -1;
	 }
	 
	 Dictionary temp = allocBlk.Find(startAddr,true);
//	 if(temp.address == 18) {
//		 System.out.println(temp.size + "kk");
//	 }
	 //while(temp!= null && temp.address != startAddr ) {
	//	 temp = temp.getNext();
	 //}
	 if(temp == null) {
		 return -1;
	 }
	
	 else if ( temp.address == startAddr) {
		 
		 int a = temp.address;
		 int b = temp.size;
		 //System.out.println(9999);
		 allocBlk.Delete(temp);
		 //System.out.println(900999);
		 freeBlk.Insert(a, b, b);
		 return 0;
		 
		 
	 }
	 
	 
	 
	 
	 
	 
   return -1;
}
 
 
 
 
}