package Heap;

public class HeapStudy {

    public int[] heap;
    public int size;
    
    //힙 구축
    public void build_min_heal(int[] arr){
        this.size = arr.length;
        this.heap = new int[size+1];

        System.arraycopy(arr,0,heap,1,size);

        for(int i=size/2;i>=1;i--){
            min_heapify(i);
        }
    }

    public void min_heapify(int i){
        int left = 2*i;
        int right = 2*i+1;
        int smallest;
        
        //왼쪽 자식 노드와 비교
        if(left<size&&heap[left]<heap[i]){
            smallest = left;
        }else{
            smallest = i;
        }
        
        //위에서 비교한 값과 오른쪽 자식 노드와 비교
        if(right<size&&heap[right]<heap[smallest]){
            smallest = right;
        }
        
        //자식 노드가 더 작으면 위치를 바꾸고, min_heafify 재귀 호출
        if(smallest!=i){
            swap(i, smallest);
            min_heapify(smallest);
        }
    }
    
    //위치 바꾸기
    public void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeapArray(){
        for(int i=1; i<=size; i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
}
