//https://leetcode.com/problems/reverse-words-in-a-string/

public class SplitString {

    public static void main(String[] args) {


        String s = "a good   example";

        String ch[] = s.trim().split(" ");

        System.out.println(Arrays.toString(ch));

        StringBuilder ans = new StringBuilder();

        for (int i = ch.length-1; i >= 0; i--) {

            if (!ch[i].isEmpty()){
                ans.append(ch[i].trim());

                if (i > 0) {
                    ans.append(" ");
                }
            }


        }

        System.out.println(ans.toString());

    }

}
