package ictgradschool.industry.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecretNumber {
    private List<Integer> secretCode;

//   Randomly generate secret code
    public List<Integer> generateSecret() {
        List<Integer> digits = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
//        Randomly generates secret code from List
        Collections.shuffle(digits);
       this.secretCode = digits.subList(0, 4);

//        Convert List to String then print
        StringBuilder sb = new StringBuilder();
        for (Integer element : secretCode
        ) {
            sb.append(element);
        }
        String secretCodeFromComputer = sb.toString();
        System.out.println("The secret code from computer is " + secretCodeFromComputer);
        return secretCode;
    }


//    player enter secret code
    public List<Integer> generateSecret(String customSecretCode) {
        // Validate the custom secret code (you may want to add additional validation)
        if (customSecretCode.matches("\\d{4}")) {
            this.secretCode = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
               this.secretCode.add(Character.getNumericValue(customSecretCode.charAt(i)));
            }
        } else {
            System.out.println("Invalid custom secret code. Using the default generated code.");

        }
        return secretCode;
    }

    public Feedback checkGuess(String guess) {
        Feedback feedback = new Feedback();

        try {
            for (int i = 0; i < 4; i++) {
                int digit = Character.getNumericValue(guess.charAt(i));

                if (digit ==this.secretCode.get(i)) {
                    feedback.incrementBulls();
                } else if (this.secretCode.contains(digit)) {
                    feedback.incrementCows();
                }
            }
        } catch (Exception e) {
//            System.out.println("secretCode is null");
        }


        return feedback;
    }

    public List<Integer> getSecretCode() {


        return this.secretCode;
    }


}
