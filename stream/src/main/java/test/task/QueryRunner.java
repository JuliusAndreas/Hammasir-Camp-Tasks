package test.task;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static test.task.Utilities.*;

public class QueryRunner {
    private String mainFileContent = "";
    private List<String> sentsList;

    public QueryRunner(String pathString) {
        try {
            Path filePath = Path.of(pathString);
            this.mainFileContent = Files.readString(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stream<String> preProcess() {
        String[] sentencesArr = mainFileContent.split("\\.");
        this.sentsList = List.of(sentencesArr);
        Stream<String> rawSentStream = Stream.of(sentencesArr);
        Predicate<String> removeEmpty = (s -> (!s.isBlank()));
        Function<String, String> removeSpaces = (s -> {
            return s.trim();
        });
        return sentsList.stream();
    }

    public Long query1(Stream<String> preProcessedStream) {
        Long totalSentences = preProcessedStream.count();
        return totalSentences;
    }

    public List<Integer> query2(Stream<String> preProcessedStream) {
        return preProcessedStream
                .map(nonStopWordsPerSent())
                .map(totalNonStopWordsPerSent())
                .collect(Collectors.toList());
    }

    public Long query3(Stream<String> preProcessedStream) {
        return preProcessedStream
                .map(nonStopWordsPerSent())
                .flatMap(strings -> strings.stream())
                .count();
    }

    public Map<String, Long> query4(Stream<String> preProcessedStream) {
        return preProcessedStream
                .map(nonStopWordsPerSent())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Map<String, List<Integer>> query5(Stream<String> preProcessedStream) {
        return preProcessedStream.map(nonStopWordsPerSent())
                .flatMap(strings -> strings.stream())
                .distinct()
                .collect(Collectors.toMap(Function.identity(), giveWordGetIndices(this.sentsList)));
    }

    public Map<String, List<String>> query6(Stream<String> preProcessedStream) {
        return preProcessedStream
                .collect(Collectors.groupingBy(firstWord(), Collectors.toList()));
    }

    public Double query7(Stream<String> preProcessedStream) throws NoSuchElementException {
        OptionalDouble avg = preProcessedStream
                .mapToDouble(s -> s.length())
                .average();
        if (avg.isPresent()) {
            return (avg.getAsDouble());
        } else {
            throw new NoSuchElementException();
        }
    }

    public Integer query8(Stream<String> preProcessedStream){
        return preProcessedStream
                .map(nonStopWordsPerSent())
                .map(totalNonStopWordsPerSent())
                .reduce(0, (integer, integer2) -> {
                    return integer + ((integer2 % 2 == 0) ? (integer2) : (0 - integer2));
                });
    }
}
