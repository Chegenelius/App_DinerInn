package ke.co.dinerinn.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ke.co.dinerinn.RoomDatabase.UserDao;
import ke.co.dinerinn.RoomDatabase.UserDatabase;
import ke.co.dinerinn.RoomDatabase.UserEntity;
import ke.co.dinerinn.R;

public class LoginActivity extends AppCompatActivity {
    EditText userId,password,name;
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating User Entity
                UserEntity userEntity=new UserEntity();
                userEntity.setUserId(userId.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(name.getText().toString());
                if (validateInput(userEntity)){
                    //insert operation
                    UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
                   final UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //register user
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"User Registered",Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }).start();

                }else {
                    Toast.makeText(getApplicationContext(),"fill all fields!",Toast.LENGTH_LONG).show();
                }
            }
        });

        login = findViewById(R.id.buttonlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(LoginActivity.this, HomePage.class);
                startActivity(it);
            }
        });
    }
    private boolean validateInput(UserEntity userEntity){
        if (userEntity.getName().isEmpty()||
            userEntity.getPassword().isEmpty()||
                userEntity.getName().isEmpty()){
            return false;
        }
        return true;

    }


}