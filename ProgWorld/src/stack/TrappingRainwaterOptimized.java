package stack;
// consumes less space than last solution

public class TrappingRainwaterOptimized {
    public static int trap(int[] height) {
        int res=0;
        int leftM=0,rightM=0,l=0,r=height.length-1;

        while(l<=r){
            /*
                we know left height is less than right height so water stored
                will not be more than left height
                i.e. left height aur left max ke hisaab se water store hoga
                qki left max bhi kbhi left th aur hum tb uske liye check kr
                chuke hai ki vo right se chota h so esa nhi ho skta ki left
                max bada ho jaye right height se
            */
            if(height[l]<height[r]){
                //no water will be stored
                if(height[l]>=leftM)
                    leftM=height[l];
                    //water will be stored equals left max - current height
                else
                    res+=leftM-height[l];
                l++;
            }
            /*
                we know right height is less than left height so water stored
                will not be more than right height
                i.e. right height ke hisaab se water store hoga
            */
            else{
                //no water will be stored
                if(height[r]>=rightM)
                    rightM=height[r];
                    //water will be stored equals left max - current height
                else
                    res+=rightM-height[r];
                r--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
