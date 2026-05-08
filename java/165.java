class Solution {
    public int compareVersion(String version1, String version2) {
        // .是特殊正则符号 要转译. 还要转译\ 于是有2个\\
        String ar1[] = version1.split("\\.");
        String ar2[] = version2.split("\\.");

        for(int i=0;i<ar1.length || i<ar2.length;i++){
            // 默认值为0
            Integer num1 = 0, num2 = 0;
            if(i<ar1.length){
                num1 = Integer.valueOf(ar1[i]);
            }
            if(i<ar2.length){
                num2 = Integer.valueOf(ar2[i]);
            }

            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }
        }
        return 0;

    }
}