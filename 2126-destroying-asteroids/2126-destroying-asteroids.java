class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
         long newMass = mass;
        Stack<Integer> st = new Stack<>();

        for(int val : asteroids) {
            st.push(val);
            while(!st.isEmpty() && st.peek() <= newMass) {
                newMass += st.pop();
            }
        }
        return st.isEmpty(); 
    }
}