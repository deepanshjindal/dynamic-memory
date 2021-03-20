# dynamic-memory
• First Fit Algorithm: Here the Allocation system will go through all the Free Memory
blocks, stored using any Data structure (here we focus on DLL, BST and AVL Trees), and
first block that is big enough to fulfill the needs of the program will be returned. The process
of finding the first such block will finish quickly in general (so it is good in time), but there
will be an issue regarding the loss of memory (so it is bad in space utilisation). Say the
program wants 4KB of memory and the first free block (larger than 4KB) found by the
system is of the size 16KB. Then here, there is a loss of 12KB which won’t be useful until
the program releases this block and marks it free again!


Best Fit Algorithm: Rather than finding the first adequate memory block, the system will
go through all the free blocks and will return the smallest block which will be big enough to
fulfill the needs of the program. Here as it will need to go through the entire data structure
of free blocks so it will be slower (so it is bad in time). But there will be a minimum loss of
memory here, as it is finding the best block possible to be assigned (so it is good in space
utilisation). Say in the previous scenario of the program wanting 4KB of space, there are
overall four free blocks with sizes of 2KB, 12KB, 5KB, 6KB (in order). So, when used this
algorithm, the system will go through all these free blocks, detect the smallest block which
is larger than 4KB (in this case, it is the 5KB block), and return it to the program that
requested memory
