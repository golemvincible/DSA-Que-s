package src.contestQues;

import java.util.PriorityQueue;
/*
    Step1 : Assume we select all the elements in reward 2.
    Step2:  Now, we wanted to select k from reward1 so, lets pick those k elements from reward1 which are highest from their
            corresponding values in reward2 on the same index. In other words, just pick those elements who differ from their corresponding reward2
            by max amount and add them. Now, note that since we already added the reward2 values into the answer, we just need to add the
            difference of these elements.
    To implement step2 just create a heap of size k containing k maximum differences between reward1 and reward 2 elements at any given index.
* */

//https://leetcode.com/problems/mice-and-cheese/
public class MiceandCheese {
    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum=0;

        //first we will assume cheese from all the positions are eaten by mouse 2
        for(int it:reward2){
            sum+=it;
        }

        /*
            now we need to select k positions where reward1[i] is less than reward2[i]
            so that mouse 1 will eat from that position
            we can say reward1[i]-reward2[i] i.e. difference between both the rewards is
            what we need to make both rewards equal so we already took reward2[i] in our
            ans so to make it equal to reward1[i] we will add the difference of reward1 and
            reward2 i.e. reward1[i]-reward2[i] to our ans k times

            we will use max heap to do so as we need big differences so we will get k max
            differences and add it to our ans

            eg consider we need to pick reward1[i]=1 from reward1 and we have reward2[i]=4
            which is already included in our ans (but we don't have any other option but to
            pick reward1[i]=1) so to make reward1[i]==reward2[i] we will subtract reward1[i]-reward2[i]
            i.e. 1-4=-3, if we add -3 to reward1[i] it will be equal to reward2[i] and as we already have
            reward2[i] i.e 4 included in our final ans we just need to add this difference to our final ans
            it will imply that we took reward1[i] instead of reward2[i]
        */
        //max heap
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y)->y-x);
        for(int i=0;i<reward1.length;i++){
            q.offer(reward1[i]-reward2[i]);
        }

        while(k>0){
            int diff = q.poll();
            sum+=diff;
            k--;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] r1={4,1,5,3,3};
        int[] r2={3,4,4,5,2};

        System.out.println(miceAndCheese(r1,r2,3));
    }
}
