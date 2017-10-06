package com.teamjsnbd.ieltsassistor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PracticeClassificationSelection extends AppCompatActivity {

    private String[] passageList;
    String[] optionSet;
    private String[][] questionSet = {{
            "1) There are three main behavioural features incident to sleep. \n",
            "2) The idea that we sleep because we have nothing else to do is absurd. \n",
            "3) At some point in the evolution, a new stage of sleep appeared: rapid eye movement sleep. \n",
            "4) Natural selection did not suppress sleep, but developed it. \n",
            "5) Sleep makes animals' reaction slower. \n",
            "6) Every major system in human's body suffers because of lack of sleep. \n",
            "7) Muscles are not very active during sleep. "
    }, {
            "1.\tMismatch between the number of people looking for jobs and the number of jobs available results in a long-term unemployment.",
            "2.\tIn 2008 many Americans who were employed as construction workers lost their jobs.",
            "3.\tDownturns in the economy’s business cycle results in temporary job losses. ",
            "4.\tIt is not difficult to reduce this kind of unemployment. ",
            "5.\tAs jobs in industries like mining and manufacturing have withered, this type of unemployment has started to rise in advanced economies.",
            "6.\tMismatch between the characteristics of supply and demand on job market results in this type of unemployment.",
            "7.\tDuring the economy’s most massive downfalls, many people give up looking for a job and withdraw from the labour force."
    }, {
          "1.\tMajor changes in Earth's pattern of biological production and consumption are quite rare. ",
            "2.\tRock and soil strata have traces of human activity. ",
            "3.\tHumans are the first species to dominate the planet's primary biological production and to be the top predator both on land and at sea. ",
            "4.\tAnthropocene can be characterized as a new geological time unit, because of the changes in the relationship between Earth's production and consumption. ",
            "5.\tHumans have affected the Earth's global energy flow, resulting in an unprecedented pattern for maintaining the complexity of modern societies. ",
            "6.\tPeople are exploiting soil and animals to increase their productivity well above natural levels.",
            "7.\tModern human society is structured around economic production."
    }};

    private String[][] answerSet = {
            {"B", "A", "A", "C", "B", "C", "B" },
            {"C", "B", "B", "A", "C", "A", "C"},
            {"A", "C", "B", "A", "C", "B", "B"}
    };

    private int questionNumber = 0;
    private String[] passageHeading = {"Why do we sleep", "Fluctuation of unemployment rate",
            "New pattern in planet's energy flow"};
    private String[][] radioOptions = {
            {
                "A. Mathew Walker", "B. Ravi Allada", "C. Paul-Antoine Libourel"
            },
            {
                 "A. frictional unemployment", "B.\tcyclical unemployment", "C.\tstructural unemployment"},
            {
                "A.\tProfessor Zalasiewicz\n",
                        "B.\tDr Carys Bennett\n",
                        "C.\tDr Matthew Edgeworth\n"
            }
    };
    private int fetched_passageNumber = 1;

    private TextView stringPassage;
    private TextView questionsOfClassificationSelection;
    private TextView optionsOfClassification;
    private TextView dynamicQuestions;
    private TextView resultView;
    private TextView passagetitle;

    private RadioGroup radioGroup;
    private RadioButton radioOption1;
    private RadioButton radioOption2;
    private RadioButton radioOption3;

    private Button nextQuestion;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_classification_selection);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Practice Classification");
        getSupportActionBar().setSubtitle("Reading Practice");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        stringPassage = (TextView)findViewById(R.id.stringPassageClassification);
        questionsOfClassificationSelection = (TextView)findViewById(R.id.optionsOfClassification);
        dynamicQuestions = (TextView)findViewById(R.id.dynamicQuestions);
        resultView = (TextView)findViewById(R.id.resultView);
        passagetitle = (TextView)findViewById(R.id.passagetitle);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioOption1 = (RadioButton) findViewById(R.id.radioOption1);
        radioOption2 = (RadioButton) findViewById(R.id.radioOption2);
        radioOption3 = (RadioButton) findViewById(R.id.radioOption3);

        nextQuestion = (Button) findViewById(R.id.nextQuestion);

        String passage_1 = "Researchers have found that sleep is beneficial to humans in many ways:\n" +
                "it helps us process memories, and keeps our social and emotional lives on track.\n" +
                "Yet we still do not really know how, why or even exactly when sleep evolved.\n" +
                "\n" +
                "“The cost of losing consciousness to survival is astronomical,” \n" +
                "says Matthew Walker at the University of California in Berkeley.\n" +
                " Whatever functions sleep performs, they must be so fundamentally\n" +
                "important that they far outweigh the obvious vulnerability associated with being asleep.\n" +
                "\n" +
                "This means we can confidently reject one of the simplest theories of sleep:\n" +
                " that we drift off simply because we have nothing better to do. \n" +
                "This could be described as the indolence theory of sleep. Once an animal has eaten,\n" +
                "seen off any rivals and exhausted any potential mating opportunities,\n" +
                "it effectively has an empty schedule, and losing consciousness kills time for a few hours.\n" +
                "\n" +
                "It is a fun idea, but considering that a sleeping animal is significantly more likely\n" +
                "to be caught and eaten than a waking animal,\n" +
                " this hypothesis makes “zero sense”, says Walker.\n" +
                "\n" +
                "There is now an emerging consensus on the behavioural features that define sleep,\n" +
                " and these features can be used to look for sleep in simple animals,\n" +
                " says Ravi Allada at Northwestern University in Evanston, Illinois.\n" +
                "\n" +
                "There are three main elements, says Allada. First and foremost, \n" +
                "sleep renders an animal quiet and still: muscles are not very active during sleep. \n" +
                "Second, sleep makes animals slower to respond. For instance, \n" +
                "if you make a loud noise near a sleeping animal, \n" +
                "it will react more slowly than an awake animal. And finally,\n" +
                "we can recognise sleep because it keeps animals from getting tired.";

        String passage_2 = "During the recent downturn, the unemployment rate in America jumped from 4.4% to 10%. Economic growth has since pepped up. But unemployment is nowhere near pre-crisis lows: America’s rate, at 6.2%, is still 40% higher than late 2006. Economists are raising the spectre of “structural” unemployment to explain this puzzle. What is it?\n" +
                "Economists often refer to three types of unemployment: \"frictional\", “cyclical” and “structural”. Cold-hearted economists are not too worried about the first two, which refer to people moving between jobs and those temporarily laid-off during a downturn.\n" +
                "Frictional unemployment exists because both jobs and workers are heterogeneous (in other words, they have different expectations). And a mismatch can result between the characteristics of supply and demand. Such a mismatch can be related to skills, payment, worktime, location, attitude, taste, and a multitude of other factors. New entrants (such as graduating students) and re-entrants (such as former homemakers) can also suffer a spell of frictional unemployment. Workers as well as employers accept a certain level of imperfection, risk or compromise, but usually not right away; they will invest some time and effort to find a match. This is in fact beneficial to the economy since it results in a better allocation of resources. However, if the search takes too long and mismatches are too frequent, the economy suffers, since some work will not get done. Therefore, governments seek ways to reduce unnecessary frictional unemployment, and hopefully it’s not hard to do so.\n" +
                "The second type, cyclical unemployment deals with an economy's business cycle. Cyclical unemployment occurs when there are job losses during downturns and contractions in the business cycle. A lack of demand is one of the main factors that cause cyclical unemployment. When there is a drop in consumer demand, business revenues usually decline. Consequently, companies have to lay off workers to cut their costs to maintain their profit margins.\n" +
                "For example, the U.S. economy faced cyclical unemployment during the 2008 financial crisis. As more and more subprime mortgage lenders filed for bankruptcy, homes were not being constructed. Consequently, many people who were employed as construction workers and home builders lost their jobs and experienced cyclical unemployment.\n" +
                "The third kind refers to people who are excluded, perhaps permanently, from the labour market. In econo-speak, structural unemployment refers to the mismatch between the number of people looking for jobs and the number of jobs available. It is bad news both for those who suffer from it and for the society in which they live. People out of work for long periods tend to have poorer health than average. The structurally unemployed also squeeze social-security budgets.\n" +
                "Structural unemployment in advanced economies has been rising for decades, as jobs in industries like mining and manufacturing have withered. In Britain between 1984 and 1992, employment in coal mining fell by 77% and in steelmaking by 72%. Communities that were built around a single profession were devastated. Many of the people affected only had experience of a specific, high-skill job. They did not have the skills or attributes needed to be successful in many service-sector jobs (such as working in a call centre or in a restaurant). Hence they were structurally unemployed. A different problem may be afflicting advanced economies today. The downturn was truly nasty and has lasted for years. Many people gave up looking for a job and withdrew from the labour force. In America the number of these “discouraged workers” jumped from 370,000 in 2007 to 1.2m in 2010. (Today it is twice its 2007 level.)  \n";

        String passage_3 = "The impact humans have made on Earth in terms of how we produce and consume resources has formed a 'striking new pattern' in the planet's global energy flow, according to researchers from the University of Leicester.\n" +
                "Archaeologist Dr Matthew Edgeworth, Honorary Visiting Research Fellow at the University of Leicester's School of Archaeology and Ancient History, said: \"Earth is now characterised by a geologically unprecedented pattern of global energy flow that is pervasively influenced by humans - and which is necessary for maintaining the complexity of modern human societies.\"\n" +
                "Professor Zalasiewicz said: \"Very big changes in our planet's pattern of biological production and consumption do not happen very often. The appearance of photosynthesis was one, about two and a half billion years ago. Then, a little over half a billion years ago, animals like trilobites appeared, to add scavengers and predators into a food web of increasing complexity. Other major events have happened since, such as five major mass extinctions, but even measured against these events, human-driven changes to production and consumption are distinctly new.\"\n" +
                "Dr Carys Bennett, co-author on the study from the University of Leicester's Department of Geology, added: \"It is without precedent to have a single species appropriating something like one quarter of the net primary biological production of the planet and to become effectively the top predator both on land and at sea.\n" +
                "In addition, by digging phosphorus out of the ground and by fixing nitrogen out of the air to make fertilizers; and by exploiting hundreds of millions of years-worth of stored carbon-based energy in a still-accelerating trend, humans are increasing productivity well above natural levels - and directing much of it towards animals that have been re-engineered to suit our purposes. \"\n" +
                "Professor Zalasiewicz added: \"The relationship between Earth's production and consumption is being refashioned, and this is the key feature to characterize the Anthropocene as a geological time unit. It also has wider and more fundamental importance in signaling a new biological stage in this planet's evolution.\"\n" +
                "Dr Matthew Edgeworth added: \"Recent changes in Earth's biosphere, caused in part by human activity, are starting to become evident in rock and soil strata. Unprecedented stratigraphic signals are challenging disciplines like geology and archaeology to assess such changes and put them in temporal context, relative to other major transitions in Earth's history.\"\n" +
                "Dr Carys Bennett said: \"Modern human society is structured around economic production and consumption and our recent perturbation of the balance between the two, notably since the mid-20th century, will leave a signal that will provide a lasting legacy of our existence on this planet.\"\n" +
                "Professor Zalasiewicz concluded that we should gather more evidence on the Anthropocene, which will help inform recommendations on whether this new time unit should be formalized and, if so, how it might be defined and characterized.\n";
        optionSet = new String[]{"Questions 1-7\n" +
                "\n" +
                "Classify the following statements as referring to\n\n" +
                "    A Matthew Walker\n" +
                "    B Ravi Allada\n" +
                "    C Paul-Antoine Libourel\n" +
                "\n\n" +
                "Select the appropriate letters A, B or C in boxes 1-7:\n" +
                "\n",

                "Classify the following statements as referring to:\n\n" +
                        "A.\tfrictional unemployment\n" +
                        "B.\tcyclical unemployment\n" +
                        "C.\tstructural unemployment\n" +
                        "\nSelect the appropriate letters A, B or C in boxes 1-7:\n" +
                        "\n",

                "Classify the following statements as referring to:\n\n" +
                        "A.\tProfessor Zalasiewicz\n" +
                        "B.\tDr Carys Bennett\n" +
                        "C.\tDr Matthew Edgeworth\n" +
                        "\nSelect the appropriate letters A, B or C in boxes 1-7:\n" +
                        "\n"

        };

        passageList = new String[]{passage_1, passage_2, passage_3};

        fetched_passageNumber = getIntent().getIntExtra("passage_no", 0);
        fetched_passageNumber--;

        stringPassage.setText(passageList[fetched_passageNumber]);
        questionsOfClassificationSelection.setText(optionSet[fetched_passageNumber]);
        passagetitle.setText(passageHeading[fetched_passageNumber]);

        radioOption1.setText(radioOptions[fetched_passageNumber][0]);
        radioOption2.setText(radioOptions[fetched_passageNumber][1]);
        radioOption3.setText(radioOptions[fetched_passageNumber][2]);

        updateQuestion();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,  int checkedId) {

                String correctAnswer = answerSet[fetched_passageNumber][questionNumber];

                switch (checkedId) {
                    case R.id.radioOption1:
                        if(correctAnswer.equals("A")) {
                            resultView.setText("Your Answer is Correct");
                        } else {
                            resultView.setText("Your Answer is Incorrect. Correct Answer is: " + correctAnswer);
                        }
                        break;

                    case R.id.radioOption2:
                        if(correctAnswer.equals("B")) {
                            resultView.setText("Your Answer is Correct");
                        } else {
                            resultView.setText("Your Answer is Incorrect. Correct Answer is: " + correctAnswer);
                        }
                        break;

                    case R.id.radioOption3:
                        if(correctAnswer.equals("C")) {
                            resultView.setText("Your Answer is Correct");
                        } else {
                            resultView.setText("Your Answer is Incorrect. Correct Answer is: " + correctAnswer);
                        }
                        break;
                }

                resultView.setVisibility(View.VISIBLE);
            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Please Select an answer", Toast.LENGTH_SHORT).show();
                } else {
                    if(questionNumber < 6) {
                        questionNumber++;
                        updateQuestion();
                    } else {
                        Toast.makeText(PracticeClassificationSelection.this, "No more Question", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
        });

    }
    /*Back button */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    private void updateQuestion() {
        radioGroup.clearCheck();
        resultView.setVisibility(View.GONE);
        dynamicQuestions.setText(questionSet[fetched_passageNumber][questionNumber]);
    }
}