import java.util.ArrayList;
import java.util.List;

public class Problem_22 {
    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        back(n,n,new StringBuilder(),result);
        return result;
    }

    public static void back(int n1,int n2,StringBuilder sb,List<String> result){
        if (n1 == 0 && n2 == 0) {
            result.add(sb.toString());
            return;
        }
        if (n1 > 0) {
           sb.append('(');
           back(n1 - 1,n2,sb,result);
           sb.setLength(sb.length() - 1);
        }
        if (n2 > 0 && n2 > n1) {
            sb.append(')');
            back(n1,n2 - 1,sb,result);
            sb.setLength(sb.length() - 1);
        }
    }
}
