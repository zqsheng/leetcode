import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_17 {
    public static void main(String[] args) {
        letterCombinations("23329").forEach(System.out::println);
    }
    static Map<Character,char[]> table;
    static {
        table = new HashMap<>();
        table.put('2',new char[]{'a','b','c'});
        table.put('3',new char[]{'d','e','f'});
        table.put('4',new char[]{'g','h','i'});
        table.put('5',new char[]{'j','k','l'});
        table.put('6',new char[]{'m','n','o'});
        table.put('7',new char[]{'p','q','r','s'});
        table.put('8',new char[]{'t','u','v'});
        table.put('9',new char[]{'w','x','y','z'});
    }
    public static List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> list = new ArrayList<>();
        back(chars,0,new char[chars.length],list);
        return list;
    }
    public static void back(char[] chars,int i,char[] tmps,List<String> result) {
        if(i == chars.length) {
            result.add(new String(tmps));
            return;
        }
        for (char c : table.get(chars[i])) {
            tmps[i] = c;
            back(chars,i + 1,tmps,result);
        }
    }
}
