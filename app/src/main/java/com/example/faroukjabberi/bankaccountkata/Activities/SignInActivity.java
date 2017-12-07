package com.example.faroukjabberi.bankaccountkata.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.faroukjabberi.bankaccountkata.R;
import com.example.faroukjabberi.bankaccountkata.utils.Manager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * The type Sign in activity.
 */
public class SignInActivity extends AppCompatActivity {

    /**
     * The Username.
     */
    @BindView(R.id.username)
    EditText username;
    /**
     * The Password.
     */
    @BindView(R.id.password)
    EditText password;

    /**
     * Sign in.
     */
    @OnClick(R.id.button)
    public void signIn() {
        switch (username.getText().toString()) {
            case "farouk.jabberi":
                switch (password.getText().toString()) {
                    case "Aaxyff15H":
                        // login to user account
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        // show error message
                        Manager.showMessage(getApplicationContext(), "Password incorrect");
                }

                break;
            default:
                switch (password.getText().toString()) {
                    case "Aaxyff15H":
                        // show error message
                        Manager.showMessage(getApplicationContext(), "Username  incorrect");
                        break;
                    default:
                        // show error message
                        Manager.showMessage(getApplicationContext(), "Username and Password incorrect");
                }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }

}
