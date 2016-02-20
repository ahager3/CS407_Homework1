package ahager3.cs407_homework1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, ImageQuizFragment.newInstance(0, 0))
                .addToBackStack(null)
                .commit();
    }

}