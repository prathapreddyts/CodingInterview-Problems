package recursion40DayChallenge;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> generatedParenthesis = generateParenthesis.generateParenthesis(3);
        System.out.println("generatedParenthesis --> " + generatedParenthesis);
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> resultList = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, "", resultList);
        return resultList;

    }

    public void generateParenthesisHelper(int n, int openCount, int closeCount, String parenthesis, ArrayList<String> resultList) {
        if (parenthesis.length() == 2 * n) {
            resultList.add(parenthesis);
            return;
        }
        if (openCount < n) {
            generateParenthesisHelper(n, openCount + 1, closeCount, parenthesis + "(", resultList);
        }
        if (closeCount < openCount) {
            generateParenthesisHelper(n, openCount, closeCount + 1, parenthesis + ")", resultList);
        }

    }

}
