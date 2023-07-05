public class KMPAlgorithm {

    public static CustomList<Integer> prefixFunction(String string) {
        int stringLength = string.length();
        CustomList<Integer> maxPrefixes = new CustomList<>();
        maxPrefixes.add(0);
        for (int i = 1; i < stringLength; i++) {
            int tmpIndex = maxPrefixes.get(i - 1);
            while (tmpIndex > 0 && string.charAt(i) != string.charAt(tmpIndex)) {
                tmpIndex = maxPrefixes.get(tmpIndex - 1);
            }
            if (string.charAt(i) == string.charAt(tmpIndex)) {
                tmpIndex++;
            }
            maxPrefixes.add(tmpIndex);
        }
        return maxPrefixes;
    }

    public static CustomList<Integer> knuthMorrisPratt(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        CustomList<Integer> answer = new CustomList<>();
        CustomList<Integer> prefixes = prefixFunction(pattern + '#' + text);
        for (int i = 0; i < textLength; i++) {
            if (prefixes.get(patternLength + i + 1) == patternLength) {
                answer.add(i - patternLength + 1);
            }
        }
        return answer;
    }

    public static void formatAnswer(CustomList<Integer> answer) {
        if (answer.size() > 0) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < answer.size(); i++) {
                result.append(answer.get(i)).append(",");
            }
            result.deleteCharAt(result.length() - 1); // Remove the trailing comma
            System.out.println(result.toString());
        } else {
            System.out.println(-1);
        }
    }
}
