package com.teamjsnbd.ieltsassistor;

import android.content.Context;

/**
 * Created by Hussain Juned on 27/08/2017.
 */

public class McqLibrary {

    Context context;
    private int a = 0;
    private int b = 1;
    private int c = 2;
    private int d = 3;

    private String[] passages;

    private String[] passageTitle = {"Is violence innate?", "August 1985: The worst month for air disasters", "Why does coffee shoot out of the lid of your cup?"};

    private String[][] questions = { {"Question 1. What did archaeologists in southern Germany discover?",
            "Question 2. Why did scientists suggested that those people were killed whilst running away?",
            "Question 3. Why do human beings fight, according to the article?",
            "Question 4. Which of the following phrases best describes the main aim of the Reading Passage?"
            },

            {"1.\tWhen did the 720 travellers die?", "2.\tTwin engine turboprop could carry:", "3.\tThe worst accident in history, according to the paragraph, was:",
                "4.\tWhy did the Japan Air Lines Flight 123 crashed?"
            },
            {"1.\tWhat accident might occur at work in the morning, after you bought coffee? ", "2.\tRob Kaczmarek explains to us that: ",
                    "3.\tThe main reason coffee spils is: ", "4.\tThis text might be classified as: "}
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
                    "b) To introduce principles of contemporary archaeology and its application",
                    "c) To introduce some relics of humans' warfare for further discussion whether violence is innate or not",
                    "d) To suggest ways of interperting humans' violence"},
            {
                    "a) To describe fighting among different species",
                    "b) To intoduce principles of contemporary archaeology and its application",
                    "c) To introduce some relics of humans' warfare for further discussion whether violence is innate or not",
                    "d) To suggest ways of interperting humans' violence" }
    },
            {
                    {"A.\t Thirteen decades ago.", "B.\t A few decades ago.", "C.\t 30 years ago.", "D.\t There is no information about it."},
                    {"A.\t Eight people.", "B.\t Four people.", "C.\t Two people.", "D.\t Only a pilot."},
                    {"A.\t Only a pilot.", "B.\t Delta flight 191.","C.\t British Airtours flight 28M.","D.\t Bar Harbor Airlines flight 1808."},
                    {"A.\t The change in pressure blew off the vertical stabiliser.", "B.\t Destruction of the hydraulic systems.",
                            "C.\t The airtight bulkhead between its cabin and tail tore open.", "D.\t It is unknown."}
            },

            {
                    {"A.\t You spill it all over the place accidently.", "B.\t You get burns from the hot coffee.",
                            "C.\t You contaminate your clothes with it.", "D.\t Nothing out of ordinary."},
                    {"A.\t The coffee shoots out very far.", "B.\t He sat his experiment as a joke.", "C.\t  He was really intrigued by spilling the coffee.",
                            "D.\t  Coffee spils because of the design of the lid."},
                    {"A.\t  Velocity.","B.\t  Sloshing.","C.\t  Design of the cup.","D.\t  It is not stated."},
                    {"A.\t  Scientific.", "B.\t  Humorous.", "C.\t  Fictional.", "D.\t  Romantic."}
            }

    };

    private int[][] correctAnswers = {{b, d, c, c}, {c, a, a, c}, {c, d, b, a}};

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

            {"Answer A is incorrect because 13 decades = 130 years, answer B is incorrect because few decades can mean either 2, 3 or" +
                    " more decades, answer D is incorrect because there is information about it in the text.",

                    "At the end of second paragraph we can clearly see, that a twin engine turboprop can carry eight people.",

                    "In the beginnig of the third paragraph we can read that: \"Japan Air Lines flight 123, the worst single-aircraft accident in history...\".",

                    "Although answer A and B seem plausible, they are the consequences of answer C."
            },

            {"Answer A is incorrect because there is no information about spilling coffee all over the place. Also, there is nothing said about burning yourself.",

            "Although all 4 answers are present in the second paragraph, answers A, B and C are not important and they are not really explained to us, unlike answer D.",

            "The answers C and D aren't in the third paragraph. And the answer A is not the reason coffee is spilling.",

            "All answers, exept for A, are invalid. this text has no humour in it, and no romance. And it is not a fictional text."
            }
    };

    //private String[] explanations = {"ex1", "ex2", "ex3", "ex4"};


    public McqLibrary(Context context) {
        this.context = context;
        passages = context.getResources().getStringArray(R.array.mcq_passage_list);

    }

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

    public String getPassageTitle(int passageNumber) {
        return passageTitle[passageNumber];
    }
}
