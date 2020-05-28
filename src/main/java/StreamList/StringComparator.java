package StreamList;

public class StringComparator {
    public static boolean firstOfTwoStringsIsHigherInAlphabeticalOrder(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int minLength = Math.min(l1, l2);

        for(int i = 0; i < minLength; i++){
            int s1Char = (int)s1.charAt(i);
            int s2Char = (int)s2.charAt(i);
            if(s1Char != s2Char){
                return s1Char > s2Char;
            }
        }
        return false;
    }
}
