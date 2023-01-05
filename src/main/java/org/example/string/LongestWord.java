package org.example.string;
//I love dog
public class LongestWord {

    public static String LongestWord(String sen) {
        char[] words = sen.toCharArray();
        String ans = "";
        int len = 0;
        for(int i = 0; i<words.length; i++) {
            if(String.valueOf(words[i]).equals(" ")) {
                if(len < String.valueOf(words[i]).length())
                    ans = String.valueOf(words[i]);
            }


        }
        return ans;
    }

    public static void main(String[] args) {
        String d = "I love dog";
        System.out.println(LongestWord(d));
    }
}
