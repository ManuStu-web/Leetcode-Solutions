class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, startIdx = -1, count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ic = t.charAt(i);
            map.put(ic, map.getOrDefault(ic, 0) + 1);
        }

        while (r < s.length()) {
            char rc = s.charAt(r);
            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc) - 1);
                if (map.get(rc) >= 0) {
                    count++;
                }
            }

            while (count == t.length()) {
                char lc = s.charAt(l);
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }

                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) {
                        count--;
                    }
                }
                l++;
            }
            r++;
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
