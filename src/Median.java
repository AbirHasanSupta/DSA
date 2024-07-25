
import java.util.Collections;
import java.util.PriorityQueue;

public class Median {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public Median(){
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
    }

    public void insert(int num){
        small.add(num);
        if(!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()){
            large.add(small.poll());
        }
        if(small.size() > large.size() + 1){
            large.add(small.poll());
        }
        if(large.size() > small.size() + 1){
            small.add(large.poll());
        }
    }

    public double getMedian(){
        if(small.size() > large.size()){
            return (double) small.peek();
        } else if (small.size() < large.size()) {
            return (double) large.peek();
        }
        return (double) (small.peek() + large.peek()) / 2;
    }
}
