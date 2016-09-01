package cg.stevendende.myappportfolio;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;


//#UdacityHonorCode
public class MainActivity extends AppCompatActivity {

    private String[] myAppsNameList;
    private LinearLayout appsContainer;
    private Resources res;
    ArrayList<Button> buttonsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = getResources();

        appsContainer = (LinearLayout) findViewById(R.id.apps_container);
        myAppsNameList = res.getStringArray(R.array.my_apps_list);

        buttonsArray = new ArrayList<>();
        for (int i=0; i<myAppsNameList.length; i++){

            MyButton button = new MyButton(this);
            button.setId(i+1);
            button.setText(myAppsNameList[i]);
            button.setBackgroundResource(R.drawable.button_radius_background);
            button.setTypeface(Typeface.MONOSPACE);

            //Inspired online, as i was stacked to add dynamic margins
            //Credits... http://www.techotopia.com/index.php/Creating_an_Android_User_Interface_in_Java_Code
            LinearLayout.LayoutParams buttonParams =
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT);
            buttonParams.setMargins(0,5,0,5);
            //End of credits
            
            buttonsArray.add(button);

            appsContainer.addView(buttonsArray.get(i), buttonParams);
            buttonsArray.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = res.getString(R.string.toast_prefix)+" " + ((MyButton)view).getText().toString() +" "+ res.getString(R.string.toast_sufix);
                    Toast.makeText(MainActivity.this,str , Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}