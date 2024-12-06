public static void heapSort(Comparable[] a){
  int N = a .length;
  //sink nodes except leaf node, as a result, we heaplify given array
  for(int k =N/2; k>=1; k--){
    sink(a,k,N);//iterate by k, N is boundry
  }
  //pop root(the smallest or the biggest one), insert last node back to heap and sink. 
  while(N>1){
    exch(a,1,N--);//put root at the end of heap(end of array), then pop element by decrement N(as entry N alreay in right postion)
    sink(a,1,N);
  }
}

/*
  intput: 6,4,3,5,1,2
  N=7
  for(k=3;k>=1;k--){
    sink a[3]=3; 6,4,2,5,1,3
    sink a[2]=4; 6,1,2,5,4,3
    sink a[1]=6; 1,4,2,5,6,3
  }
    1
  4    2
5  6  3
After build heap from arbitrary array
Remove root by swap with last node and decrement N. sink(1)
As a result
Array is 6,5,4,3,2,1
Tree:
    6
  5    4
3  2  1
Conclusion: min Heap sort array by decrement order, max heap sort array by increment order.
*/
