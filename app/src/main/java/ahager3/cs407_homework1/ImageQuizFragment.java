package ahager3.cs407_homework1;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ImageQuizFragment extends Fragment {


    private static final String ARG_1 = "Arg1";
    private static final String ARG_2 = "Arg2";
    private static final int QUESTIONS = 2;

    // Create a directory of questions and answers here
    // The quiz question is selected by the number of total_questions


    private int correct_responses;
    private int total_questions;

    private TextView headerTextView;
    private EditText question;

    public static ImageQuizFragment newInstance(int correct_responses, int total_questions) {
        ImageQuizFragment fragment = new ImageQuizFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_1, correct_responses);
        args.putInt(ARG_2, total_questions);
        fragment.setArguments(args);
        return fragment;
    }

    public ImageQuizFragment() {
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            correct_responses = getArguments().getInt(ARG_1);
            total_questions = getArguments().getInt(ARG_2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = null;
        view = inflater.inflate(R.layout.fragment_quiz_image, container, false);

        // Update total questions
        total_questions += 1;

        // instantiate widgets here
        question = (EditText) view.findViewById(R.id.editText);

        return view;
    }




    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(question.getText().toString().equals("Yes")){
            correct_responses += 1;
        }

        // Go to a QuizFragment
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, QuizFragment.newInstance(correct_responses, total_questions))
                .addToBackStack(null)
                .commit();


    }


}