class Solution {

    public String encode(List<String> strs) {
        String encodedStr = "";

        for(int i=0; i<strs.size(); i++){
            String l = String.valueOf(strs.get(i).length());
            encodedStr += (l + "#" + strs.get(i));
        }
        System.out.println(encodedStr);
        return encodedStr;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i = 0;
        while(i < str.length()){
            int l = 0;
            int j = i;
            while(j < str.length() && str.charAt(j) != '#'){
                int digit = str.charAt(j) - '0';
                l = (l*10) + digit;
                j++;
            }
            int start = j+1;
            int end = start + l;
            System.out.println( l);
            ans.add(str.substring(start, end));
            i = end;
        }

        return ans;
    }
}
