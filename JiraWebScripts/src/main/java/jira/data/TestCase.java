package jira.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
//@AllArgsConstructor
public
class TestCase {
    String type = "Test Case";
    String summary;
    String labels;
    String requirement;
    List<List<String>> steps;

    public static List<TestCase> getTestCasesFromFile(String file) {
        List<String> allLines = null;
        try {
            allLines = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert allLines != null;
        int i = 0;
        TestCase testCase = null;
        List<TestCase> testCases = new ArrayList<>();
        if (!allLines.isEmpty()) {
            for (String line : allLines) {
                if(i==0){
                    testCase = new TestCase();
                    testCase.summary = line;
                    testCase.steps = new ArrayList<>();
                }
                if(i==1){
                    testCase.labels = line;
                }
                if(i==2){
                    testCase.requirement = line;
                }
                if(i>2){
                    if (line.isEmpty() || "end".equalsIgnoreCase(line)){
                        i=-1;
                        testCases.add(testCase);
                        testCase = new TestCase();
                    } else{
                        testCase.steps.add(Arrays.asList(line.split(" \\| ")));
                    }
                }
                i++;
                System.out.println(line);
            }
        }
        return testCases;
    }
}
