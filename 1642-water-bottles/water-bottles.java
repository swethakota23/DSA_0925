class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumed=0;
        while(numBottles>=numExchange){
            int k= numBottles/numExchange;
            consumed += k*numExchange;
            numBottles -=k*numExchange;
            numBottles+=k;  
        }
        return consumed+numBottles;
    }
}