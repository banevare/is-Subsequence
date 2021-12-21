import java.util.*;
class IsSubsequence {
    static int COUNT = 0;
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        if(s.length() == 0 || s.equals(t)) return true;
        String[] s_split = s.split(""), t_split = t.split(""); // charAt()
        if(s_split.length == 1 && t_split.length == 1) return s_split[0].equals(t_split[0]);
        Map<String, Integer> subsequence = new HashMap<> ();
        int i = 0, count = 1;
        for (int j = 0; j < t_split.length; j++){
            if(s_split[i].equals(t_split[j])){
                subsequence.put(s_split[i],j);
                if(i > 0 && subsequence.get(s_split[i]) > i-1) count++;
                i++;
            }
            if(i == s_split.length) break;
        }
        return count == s_split.length;
    }
    public static void test(String s, String t, boolean b){                                                           // general test function
        IsSubsequence l = new IsSubsequence();
        boolean a = l.isSubsequence(s,t);
		assert(b == a);
        COUNT++;
    }
    public static void main(String args[]){
        test("", "", true);
        test("a", "c", false);
        test("abc", "abcd", true);
        test("abc", "ahbgdc", true);
        test("cba", "cdgbha", true);
        test("abc", "cdgbha", false);
        test("axc", "ahbgdc", false);
        test("acb", "ahbgdc", false);
        test("aaaaaa", "bbaaaa", false);
        test("abcdefg", "abcdef", false);
        test("abcabc", "ahbgdcahbgdc", true);
        test("aabbc","zzzabbcaabcaabbcxxx", true);
        System.out.println("Passes: "+ COUNT + " Tests");
    }    
}