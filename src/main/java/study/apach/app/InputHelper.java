package study.apach.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class InputHelper {

    public String getOperation(String prompt) {
        System.out.println(prompt);
        String input = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = reader.readLine().toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public Map<String, String> getInputData() {

        Map<String, String> inputData = new HashMap<>();

        String input;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a user's name: ");
            input = reader.readLine();
            inputData.put("name", input);

            System.out.println("Enter a user's age: ");
            input = reader.readLine();
            inputData.put("age", input);

            System.out.println("Enter a user's role: ");
            input = reader.readLine();
            inputData.put("role", input);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputData;
    }
}
