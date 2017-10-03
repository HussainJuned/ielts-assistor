package com.teamjsnbd.ieltsassistor;

/**
 * Created by Hussain Juned on 27/08/2017.
 */

public class McqLibrary {

    private int a = 0;
    private int b = 1;
    private int c = 2;
    private int d = 3;

    private String[] passages = {"Passage 1:\t\tIs violence innate?\n" +
            "\n" +" In 1983, archaeologists in southern Germany discovered a mass grave containing 34 skeletons." +
            " They included 9 adult males, 7 adult females and 16 children.\n" +
            "\n" + " All of the skeletons showed signs of fatal trauma, including head wounds. None of them showed " +
            "any signs of defensive wounds, suggesting they were killed whilst running away.\n" +
            "\n" + " The \"Talheim Death Pit\" dates from the Stone Age, around 7,000 years ago. It offers some of the" +
            " oldest evidence of organised group violence between two communities: that is, of war.\n" +
            "\n" + " Clearly, humans have been fighting wars for thousands of years, and we may not be the only ones. " +
            "There is growing evidence that several other species also engage in warfare, including our closest relatives " +
            "the chimpanzees.\n" + "\n" + " That suggests we have inherited our predilection for warfare from our ape-like" +
            " ancestors. But not everyone agrees that warfare is inbuilt.",

            "Second passage",
            "Third Passage"
    };

    private String[][] questions = { {"Question 1. What did archaeologists in southern Germany discover?",
            "Question 2. Why did scientists suggested that those people were killed whilst running away?",
            "Question 3. Why do human beings fight, according to the article?",
            "Question 4. Which of the following phrases best describes the main aim of the Reading Passage?"
            },

            {"Question 1. ", "Question 2. ", "Question 3. "},
            {"Question 1. ", "Question 2. ", "Question 3. "}
    };

    private String[][][] choices = {
            {

                    {
                        " a) Remains of 34 dead animals",
                        " b) Graveyard containing 34 skeletons",
                        "c) Relics of early civilization",
                        "d) 9 adult males, 7 adult females and 16 children"
                    },

            {
                    "a) Their skeletons showed signs of fatal trauma",
                    "b) There were 16 children",
                    "c) During that period organised group violence was very frequent",
                    "d) Their skeletons didn't show any signs of defensive wounds"
            },

            {
                    "a) To describe fighting among different species",
                    "b) To intoduce principles of contemporary archaeology and its application",
                    "c) To introduce some relics of humans' warfare for further discussion whether violence is innate or not",
                    "d) To suggest ways of interperting humans' violence"},
            {
                    "a) To describe fighting among different species",
                    "b) To intoduce principles of contemporary archaeology and its application",
                    "c) To introduce some relics of humans' warfare for further discussion whether violence is innate or not",
                    "d) To suggest ways of interperting humans' violence" }
    },
            {
                    {"alu :D", "Fotol :D", "Mula", "Gazor"}, {"pepe", "sosha", "begun", "korolla"},{"j","u","n","ed"}
            },

            {
                    {"Alu :D", "potol :D", "bash", "Gira"}, {"badam", "chatni", "bhortha", "sidhdho"},{"j","u","n","ed"}
            }

    };

    private int[][] correctAnswers = {{b, d, c, c}, {a, b, c}, {d,a,c}};

    private String[][] explanations = { {"Answer A is incorrect because archaeologists discovered remains of people, \n" +
            "answer C is incorrect because nothing was said about early civilization,\n" +
            " answer D is incorrect because it doesn't mention that discovered people were dead.",

            "It is written in the second paragraph: None of them showed any signs of defensive" +
                    " wounds, suggesting they were killed whilst running away.",

            "Althought answers A and B give true information, they are not the reasons why human beings fight. \n" +
                    "Answer D gives false information (fighting is never mentioned as instinct). \n" +
                    "Answer C is correct (it is written directly in the last paragraph).",

            "The Reading Passage didn't give any information about fighting among different species. \n" +
            "Though achaeologists were mentioned, nothing was written about archaeology. \n" +
            "Humans' violence was not suggested to be interpreted, author only gave one reason of practising warfare. \n" +
            "In the beginning of the text some relics of humans' warfare were introduced, and the last sentence in this passage: \n" +
            "\"But not everyone agrees that warfare is inbuilt\" gives start for further discussion whether violence is innate or not. "
    },

            {"Explanation 1", "Explanation 2","Explanation 3"},
            {"Explanation 1", "Explanation 2","Explanation 3"}
    };

    //private String[] explanations = {"ex1", "ex2", "ex3", "ex4"};

    public int getTotalPassageCount () {
        int i = passages.length;
        return i;
    }

    public String getPassage(int index) {
        String s = passages[index];
        return s;
    }

    public int getTotalQuestionCount (int passageIndex) {
        int i = questions[passageIndex].length;
        return i;
    }

    public String getQuestion(int passageIndex, int questionIndex) {
        String question = questions[passageIndex][questionIndex];
        return question;
    }

    public String getChoice1(int passageIndex, int questionIndex) {
        String choice1 = choices[passageIndex][questionIndex][0];
        return choice1;
    }

    public String getChoice2(int passageIndex, int questionIndex) {
        String choice2 = choices[passageIndex][questionIndex][1];
        return choice2;
    }

    public String getChoice3(int passageIndex, int questionIndex) {
        String choice3 = choices[passageIndex][questionIndex][2];
        return choice3;
    }

    public String getChoice4 (int passageIndex, int questionIndex) {
        String choice4 = choices[passageIndex][questionIndex][3];
        return choice4;
    }


    public int getCorrectAnswer(int passageIndex, int questionIndex) {
        int answer = correctAnswers[passageIndex][questionIndex];
        return answer;
    }

    public String getExplanation(int passageIndex, int questionIndex) {
        String expla = explanations[passageIndex][questionIndex];
        return expla;
    }

}
