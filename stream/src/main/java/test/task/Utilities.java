package test.task;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utilities {
    //English stop words
    public static String stopWords = "i\n" +
            "me\n" +
            "my\n" +
            "myself\n" +
            "we\n" +
            "our\n" +
            "ours\n" +
            "ourselves\n" +
            "you\n" +
            "your\n" +
            "yours\n" +
            "yourself\n" +
            "yourselves\n" +
            "he\n" +
            "him\n" +
            "his\n" +
            "himself\n" +
            "she\n" +
            "her\n" +
            "hers\n" +
            "herself\n" +
            "it\n" +
            "its\n" +
            "itself\n" +
            "they\n" +
            "them\n" +
            "their\n" +
            "theirs\n" +
            "themselves\n" +
            "what\n" +
            "which\n" +
            "who\n" +
            "whom\n" +
            "this\n" +
            "that\n" +
            "these\n" +
            "those\n" +
            "am\n" +
            "is\n" +
            "are\n" +
            "was\n" +
            "were\n" +
            "be\n" +
            "been\n" +
            "being\n" +
            "have\n" +
            "has\n" +
            "had\n" +
            "having\n" +
            "do\n" +
            "does\n" +
            "did\n" +
            "doing\n" +
            "a\n" +
            "an\n" +
            "the\n" +
            "and\n" +
            "but\n" +
            "if\n" +
            "or\n" +
            "because\n" +
            "as\n" +
            "until\n" +
            "while\n" +
            "of\n" +
            "at\n" +
            "by\n" +
            "for\n" +
            "with\n" +
            "about\n" +
            "against\n" +
            "between\n" +
            "into\n" +
            "through\n" +
            "during\n" +
            "before\n" +
            "after\n" +
            "above\n" +
            "below\n" +
            "to\n" +
            "from\n" +
            "up\n" +
            "down\n" +
            "in\n" +
            "out\n" +
            "on\n" +
            "off\n" +
            "over\n" +
            "under\n" +
            "again\n" +
            "further\n" +
            "then\n" +
            "once\n" +
            "here\n" +
            "there\n" +
            "when\n" +
            "where\n" +
            "why\n" +
            "how\n" +
            "all\n" +
            "any\n" +
            "both\n" +
            "each\n" +
            "few\n" +
            "more\n" +
            "most\n" +
            "other\n" +
            "some\n" +
            "such\n" +
            "no\n" +
            "nor\n" +
            "not\n" +
            "only\n" +
            "own\n" +
            "same\n" +
            "so\n" +
            "than\n" +
            "too\n" +
            "very\n" +
            "s\n" +
            "t\n" +
            "can\n" +
            "will\n" +
            "just\n" +
            "don\n" +
            "should\n" +
            "now";

    public static Function<String, List<String>> nonStopWordsPerSent() {
        return s -> {
            String[] allWords = s.split("\\W+");
            List<String> nonStopWords = Stream.of(allWords)
                    .filter(word -> (!Utilities.stopWords.contains(word)))
                    .collect(Collectors.toList());
            return nonStopWords;
        };
    }

    public static Function<List<String>, Integer> totalNonStopWordsPerSent() {
        return strings -> strings.size();
    }

    public static Function<String, Integer> sentToIndex(List<String> sentsList) {
        return sentsList::indexOf;
    }

    public static Function<String, List<Integer>> giveWordGetIndices(List<String> sentsList) {
        return word -> {
            return sentsList.stream()
                    .filter(sent -> sent.contains(word))
                    .map(sentsList::indexOf)
                    .collect(Collectors.toList());
        };
    }

    public static Function<String, String> firstWord(){
        return s -> {
            return s.split(" ")[0];
        };
    }

}
