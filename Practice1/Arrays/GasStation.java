package Arrays;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;
        int fuelBalance = 0;
        int startIndex = 0;

        for (int i = 0; i < cost.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];

            /*
             * By finding whether total gas is lesser than
             * the total travel cost we are ensuring we are avoiding all
             * the '-1' negative scenarios where the array will not lead to 
             * complete circle
             * 
             * Once we avoid the negative scenarios there are only positive scenarios
             * where the array must need to complete a full circle so we just need to 
             * find only the starting point index once we find the starting point index we can return the 
             * actual solution 
            */

            fuelBalance += gas[i] - cost[i];

            if(fuelBalance < 0){
                startIndex = i + 1;
                fuelBalance = 0;
            }
        }

        return totalGas < totalCost ? -1 : startIndex;
        
    }
    public static void main(String[] args) {
        int gasArray1[] = {1,2,3,4,5};
        int costArray1[] = {3,4,5,1,2};
        int gasArray2[] = {2,3,4};
        int costArray2[] = {3,4,3};

        System.out.println(canCompleteCircuit(gasArray1, costArray1));
        System.out.println(canCompleteCircuit(gasArray2, costArray2));
    }    
}
