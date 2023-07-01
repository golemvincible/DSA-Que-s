package src.dynamicProgrammingav;

public class NinjasTraining {
    private static int recursive(int[][] points,int n,int pa){
        if(n==1){
            int max = Integer.MIN_VALUE;

            for(int i=0;i<3;i++){
                if(pa==i)   continue;

                max = Math.max(max,points[0][i]);
            }

            return max;
        }

        int max=Integer.MIN_VALUE;

        for(int i=0;i<3;i++){

            if(pa==i)   continue;

            max = Math.max(max,points[n-1][i]+recursive(points,n-1,i));
        }

        return max;
    }
    public static int maximumPoints(int points[][],int N){

        return recursive(points,N,3);

    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,5},{3,1,1},{3,3,3}};


        System.out.println(maximumPoints(nums,3));


    }
}
