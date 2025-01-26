package silva.guilherme.shelfshare;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        Toolbar tb_login = findViewById(R.id.tb_login);
        setSupportActionBar(tb_login);
        ActionBar login_actionbar = getSupportActionBar();
        login_actionbar.setDisplayHomeAsUpEnabled(true);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText et_login_email = findViewById(R.id.et_login_email); // Pega o campo de email
        String str_login_email = et_login_email.toString(); // Converte o campo de email para string
        EditText et_login_password = findViewById(R.id.et_login_password); // Pega o campo de senha
        String str_login_password = et_login_password.toString(); // Converte o campo de senha para string
        Button btn_login_send = findViewById(R.id.btn_login_send); // Pega o botão de login
        btn_login_send.setOnClickListener(v -> { // Quando o botão de login for clicado:
            if (str_login_email.isEmpty() || str_login_password.isEmpty()) { // Se todos os campos estiverem preenchidos
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            } 
            else { // Se qualquer campo estiver vazio ou nulo
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}