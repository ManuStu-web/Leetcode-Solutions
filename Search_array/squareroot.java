//Leetcode 69
public class squareroot 
{
    public static void main(String[] args) {
        
        int x=36;
        int low=0;
        int high=x-1;
        int result=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid<=x/mid){
                result=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        System.out.println(result);
        
    }
    
}
