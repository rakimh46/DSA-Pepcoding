public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        //method 1
        int i = 0, m = name.length(), n = typed.length();
        if(m>n) return false;

        for(int j = 0; j < n; ++j){
            if(i < m && name.charAt(i) == typed.charAt(j))
                ++i;
            else if(j == 0 || typed.charAt(j) != typed.charAt(j-1))
                return false;
        }

        return i==m;
        //method 2
        // if (name.length() > typed.length())
        //     return false;

        // int i = 0, j = 0;
        // while (i != name.length() && j != typed.length()) {
        //     if (name.charAt(i) == typed.charAt(j)) {
        //         i++;
        //         j++;
        //     } else if (i - 1 >= 0 && name.charAt(i - 1) == typed.charAt(j)) {
        //         j++;
        //     } else {
        //         return false;
        //     }
        // }

        // while (j < typed.length()) {
        //     if (name.charAt(i - 1) != typed.charAt(j)) {
        //         return false;
        //     }
        //     j++;
        // }
        // return i < name.length() ? false : true;
    }

    public static void main(String[] args) {

    }
}
