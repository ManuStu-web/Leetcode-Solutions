class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int idx;
        while((idx=sb.indexOf(part))!=-1)
        {
            sb.delete(idx,idx+part.length());
        }

        return sb.toString();
    }
}
