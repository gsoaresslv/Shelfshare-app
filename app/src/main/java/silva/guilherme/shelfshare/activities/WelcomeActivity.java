package silva.guilherme.shelfshare.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import silva.guilherme.shelfshare.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn_welcome_login = findViewById(R.id.btn_welcome_login); // Pega o botão de login
        btn_welcome_login.setOnClickListener(v -> { // Quando o botão de login for clicado:
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
        Button btn_welcome_signup = findViewById(R.id.btn_welcome_signup); // Pega o botão de cadastro
        btn_welcome_signup.setOnClickListener(v -> { // Quando o botão de cadastro for clicado:
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}