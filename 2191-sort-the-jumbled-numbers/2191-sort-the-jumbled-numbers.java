class Pair implements Comparable<Pair>{
    int num;
    int newNum;

    public Pair(int num,int newNum){
         this.num=num;
         this.newNum=newNum;
    }

    @Override
    public int compareTo(Pair p){
        if(this.newNum==p.newNum){
            return p.num-this.num;
        }
        else{
            return this.newNum-p.newNum;
        }
    }
}
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
       List<Pair> list = new ArrayList<>();
        for (int num : nums) {
            int mappedNum = getMappedNumber(mapping, num);
            list.add(new Pair(num, mappedNum));
        }
        Collections.sort(list);
        int[] result = new int[nums.length];
        int idx = 0;
        for (Pair p : list) {
            result[idx++] = p.num;
        }
        return result;
    }
     public int getMappedNumber(int[] mapping, int num) {
        if (num == 0) {
            return mapping[0];
        }
       StringBuilder mappedNumStr = new StringBuilder();
        while (num > 0) {
            int digit = num % 10;
            mappedNumStr.insert(0, mapping[digit]);
            num /= 10;
        }
        return Integer.parseInt(mappedNumStr.toString());
    }
}