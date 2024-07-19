class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        HashSet<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();

        //row
        for(int i=0;i<m;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                }
            }
            set.add(min);
        }

        //col
        for(int j=0;j<n;j++){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<m;i++){
                if(matrix[i][j]>max){
                    max=matrix[i][j];
                }
            }
            if(set.contains(max)){
                list.add(max);
                set.remove(max);
            }
        }
        return list;
    }
}