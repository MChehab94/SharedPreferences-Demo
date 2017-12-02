package mchehab.com.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAge;
    private CheckBox checkBox;
    private Button buttonDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        checkBox = findViewById(R.id.checkbox);
        buttonDone = findViewById(R.id.buttonDone);

        setButtonDoneOnClickListener();

        if(areValuesInPreferences()){
            restoreFromPreferences();
        }
    }

    private void setButtonDoneOnClickListener(){
        buttonDone.setOnClickListener(e -> {
            String name = editTextName.getText().toString();
            int age;
            if(editTextAge.getText().toString().equals("")){
                age = 0;
            }else{
                age = Integer.parseInt(editTextAge.getText().toString());
            }
            boolean isChecked = checkBox.isChecked();

            SharedPreferencesHelper.putString(this, SharedPreferencesConstants.NAME, name);
            SharedPreferencesHelper.putInt(this, SharedPreferencesConstants.AGE, age);
            SharedPreferencesHelper.putBoolean(this, SharedPreferencesConstants.CHECKBOX, isChecked);
            SharedPreferencesHelper.putBoolean(this, SharedPreferencesConstants.ARE_VALUES_STORED, true);
        });
    }

    private boolean areValuesInPreferences(){
        return SharedPreferencesHelper.getBoolean(this, "isStored", false);
    }

    private void restoreFromPreferences(){
        editTextName.setText(SharedPreferencesHelper.getString(this, SharedPreferencesConstants.NAME, ""));
        editTextAge.setText("" + SharedPreferencesHelper.getInt(this, SharedPreferencesConstants.AGE, 0));
        checkBox.setChecked(SharedPreferencesHelper.getBoolean(this, SharedPreferencesConstants.CHECKBOX, false));
    }
}