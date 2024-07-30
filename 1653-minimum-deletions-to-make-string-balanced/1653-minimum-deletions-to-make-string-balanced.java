class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st=new Stack<>();
        int cnt=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(!st.isEmpty() && st.peek()=='b' && ch=='a'){
                cnt++;
                st.pop();
            }
            else{
                st.push(ch);
            }
            
        }
        return cnt;
    }
}