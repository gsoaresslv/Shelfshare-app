package silva.guilherme.shelfshare;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText et_login_email = findViewById(R.id.et_login_email);
        String login_email = et_login_email.toString();
        EditText et_login_password = findViewById(R.id.et_login_password);
        String login_password = et_login_password.toString();
        if (!TextUtils.isEmpty(login_email) && !TextUtils.isEmpty(login_password)) {
            // Se ambos os campos estiverem preenchidos
            // Criar um Intent para iniciar a MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            // Opcionalmente, você pode finalizar a Activity atual para que o usuário não possa voltar para a tela de login
            finish();

        } else {
            // Se qualquer campo estiver vazio ou nulo
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
        }
    }
}