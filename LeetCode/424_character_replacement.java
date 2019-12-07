class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int start = 0;
        int[] count = new int[26];
        for (int end = 0; end < s.length(); end++) {
            max = Math.max(max, ++count[s.charAt(end) - 'A']);
            while (max + k <= end - start) {
                count[s.charAt(start++) - 'A']--;
            }
        }
        return s.length()-start;
    }
}
