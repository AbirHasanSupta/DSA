import java.util.ArrayList;
import java.util.List;

class Heap{
    List<Integer> heap;
    public Heap(){
        this.heap = new ArrayList<>();
        heap.add(0);
    }

    public void heapPush(int val){
        heap.add(val);
        int i = heap.size() - 1;
        while(i > 1 && heap.get(i) < heap.get(i / 2)){
            int temp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, temp);
            i = i / 2;
        }
    }

    public int heapPop(){
        if (heap.size() == 1){
            return -1;
        }
        if(heap.size() == 2){
            return heap.remove(1);
        }

        int res = heap.get(1);
        heap.set(1,heap.removeLast());
        int i = 1;

        while ( 2 * i < heap.size()){
            if(2 * i + 1 < heap.size() && heap.get(2*i + 1) < heap.get(2*i) && heap.get(i) > heap.get(2 * i + 1)){
                int temp = heap.get(i);
                heap.set(i, heap.get(2*i + 1));
                heap.set(i*2 + 1, temp);
                i = i * 2 + 1;
            }else if(heap.get(i) > heap.get(2 * i)){
                int temp = heap.get(i);
                heap.set(i, heap.get(2*i));
                heap.set(i*2, temp);
                i = i * 2;
            }else{
                break;
            }
        }
        return res;
    }
    public void heapify(ArrayList<Integer> arr){
        arr.add(arr.getFirst());
        heap = arr;
        int curr = (heap.size() - 1) / 2;
        while (curr > 0){
            int i = curr;
            while ( 2 * i < heap.size()){
                if(2 * i + 1 < heap.size() && heap.get(2*i + 1) < heap.get(2*i) && heap.get(i) > heap.get(2 * i + 1)){
                    int temp = heap.get(i);
                    heap.set(i, heap.get(2*i + 1));
                    heap.set(i*2 + 1, temp);
                    i = i * 2 + 1;
                }else if(heap.get(i) > heap.get(2 * i)){
                    int temp = heap.get(i);
                    heap.set(i, heap.get(2*i));
                    heap.set(i*2, temp);
                    i = i * 2;
                }else{
                    break;
                }
            }
            curr -= 1;
        }
    }
}


public class HeapTest {
    public static void main(String[] args){
        Heap heap = new Heap();
//        heap.heapPush(20);
//        heap.heapPush(12);
//        heap.heapPush(14);
//        heap.heapPush(8);
//        heap.heapPush(1);
//        heap.heapPush(11);

        System.out.println(heap.heap.toString());

    }
}
