package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/

//see the ways to use priority queue
class Pair{
    int ind,val;
    Pair(int ind,int val){
        this.ind=ind;
        this.val=val;
    }
}
public class FindScoreofanArrayAfterMarkingAllElements {
    public static long findScore(int[] nums) {
        long score=0;
        int n=nums.length;

        //min heap
        PriorityQueue<Pair> q = new PriorityQueue<>((Pair a, Pair b)->{
            if(a.val!=b.val)
                return a.val-b.val;
            else
                return a.ind-b.ind;
        });
//        PriorityQueue<Pair> q = new PriorityQueue<>((x,y)->y.val-x.val);

        for(int i=0;i<n;i++){
            q.offer(new Pair(i,nums[i]));
        }
        boolean[] marked = new boolean[n];

        while(!q.isEmpty()){
            Pair p = q.poll();
            int ind = p.ind;
            int val = p.val;

            if(marked[ind])
                continue;

            marked[ind]=true;
            score+=val;

            if(ind-1>=0)
                marked[ind-1]=true;

            if(ind+1<n)
                marked[ind+1]=true;

        }
        return score;
    }
    public long findScore2(int[] nums) {
        PriorityQueue<Pair>pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a,Pair b)
            {
                if(a.val==b.val)
                    return a.ind-b.ind;
                else
                    return a.val-b.val;
            }
        });
        int n=nums.length;
        boolean[] mark=new boolean[n];
        for(int i=0;i<n;i++)
        {
            pq.add(new Pair(i,nums[i]));
        }
        long score=0;
        while(pq.size()>0)
        {
            Pair p=pq.poll();
            int v=p.val;
            int idx=p.ind;
            if(mark[idx]==true)
                continue;
            score+=v;
            if(idx-1>=0 && !mark[idx-1])
                mark[idx-1]=true;
            if(idx+1<n && !mark[idx+1])
                mark[idx+1]=true;
        }
        return score;
    }
    public static void main(String[] args) {
        int[] arr= {2,3,5,1,3,2};
        System.out.println(findScore(arr));
    }
}
