package com.tutorialscache.databindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tutorialscache.databindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String name,email,city;
    //Creating Instance of UserModel Class
    UserModel users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        users=new UserModel();
        //initializing class
        MyHandler handler=new MyHandler();
        //binding handler class
        binding.setHandler(handler);
    }
    //Inner Class
    public class MyHandler {
        //method for click on button
        public void onButtonClick(View view) {
            //storing edit text value in name
            name=binding.nameEdit.getText().toString();
            email=binding.emailEdit.getText().toString();
            city=binding.cityEdit.getText().toString();
            //check id stings are empty in edittext
            if (name.isEmpty()||email.isEmpty()||city.isEmpty())
            {
                Toast.makeText(MainActivity.this,"Empty Fields",Toast.LENGTH_SHORT).show();
            }
            else {

                users.setName("YourName:"+name);
                users.setEmail("YourEmail:"+email);
                users.setCity("YourCity:"+city);
                //sets values to data variable
                binding.setUser(users);
            }
        }
    }
}
