package aaron.cs407_hw1;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class QuizFragment extends Fragment{

    private static final String ARG_1 = "Arg1";
    private static final String ARG_2 = "Arg2";
    private static final int QUESTIONS = 2;

    // Create a directory of questions and answers here
    // The quiz question is selected by the number of total_questions


    private int correct_responses;
    private int total_questions;

    private Button answerOne;
    private Button answerTwo;
    private TextView question;
    private TextView headerTextView;

    public static QuizFragment newInstance(int correct_responses, int total_questions){
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_1, correct_responses);
        args.putInt(ARG_2, total_questions);
        fragment.setArguments(args);
        return fragment;
    }

    public QuizFragment(){}

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            correct_responses = getArguments().getInt(ARG_1);
            total_questions = getArguments().getInt(ARG_2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = null;
        view = inflater.inflate(R.layout.fragment_quiz, container, false);

        // Update total questions
        total_questions += 1;

        // instantiate widgets here
        answerOne = (Button) view.findViewById(R.id.answerOne);
        answerTwo = (Button) view.findViewById(R.id.answerTwo);
        question = (TextView) view.findViewById(R.id.textView);
        question.setText("Question " + total_questions);
        headerTextView = (TextView) view.findViewById(R.id.header);
        headerTextView.setText("Put Question Here");



        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        answerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // If correct increment correct_responses

                // create next QuizFragment or the results page
                if (total_questions == QUESTIONS) {
                    displayResults(correct_responses, total_questions);
                } else {
                    // Go to a QuizFragment
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_fragment_container, QuizFragment.newInstance(correct_responses, total_questions))
                            .addToBackStack(null)
                            .commit();
                }

            }
        });

        answerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // If correct increment correct_responses

                // create next QuizFragment or the results page
                if (total_questions == QUESTIONS) {
                    displayResults(correct_responses, total_questions);
                } else {
                    // Go to a QuizFragment
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_fragment_container, QuizFragment.newInstance(correct_responses, total_questions))
                            .addToBackStack(null)
                            .commit();
                }

            }
        });
    }

    private void displayResults(final int correct_responses, final int total_questions){

        //TODO finish implementing this AlertDialog

        //do a prompt about the winner
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("Your Score is :")
                .setMessage(correct_responses + " / " + total_questions)
                .setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO start a rematch!

                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_fragment_container, QuizFragment.newInstance(0, 0))
                                .addToBackStack(null)
                                .commit();


                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO back out the the start screen
                        getActivity().finish();
                    }
                })
                .show();

    }

}