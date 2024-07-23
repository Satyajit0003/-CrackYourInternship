class Pair implements Comparable<Pair> {
    int num;
    int freq;

    Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.freq == p.freq) {
            return p.num - this.num; // Descending order of num when frequencies are equal
        } else {
            return this.freq - p.freq; // Ascending order of frequency
        }
    }
}

class Solution {

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            list.add(p);
        }
        Collections.sort(list);

        int[] ans = new int[nums.length];
        int f = 0;
        for (Pair p : list) {
            for (int j = 0; j < p.freq; j++) {
                ans[f++] = p.num;
            }
        }

        return ans;
    }
}
