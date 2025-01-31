package silva.guilherme.shelfshare.activities;

import android.content.Intent;
import android.os.Bundle;
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

import silva.guilherme.shelfshare.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        Toolbar tb_signup = findViewById(R.id.tb_cadastro);
        setSupportActionBar(tb_signup);
        ActionBar cad_actionBar = getSupportActionBar();
        cad_actionBar.setDisplayHomeAsUpEnabled(true);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn_acc_create = findViewById(R.id.btn_acc_create); // Pega o botão de criar conta
        btn_acc_create.setOnClickListener(v -> { // Quando o botão de criar conta for clicado

            EditText et_cad_email = findViewById(R.id.et_cad_email); // Pega o campo de email
            String str_cad_email = et_cad_email.getText().toString(); // Converte o campo de email para string
            EditText et_cad_username = findViewById(R.id.et_cad_username); // Pega o campo de nome de usuário
            String str_cad_username = et_cad_username.getText().toString(); // Converte o campo de nome de usuário para string
            EditText et_cad_phone = findViewById(R.id.et_cad_phone); // Pega o campo de telefone
            String str_cad_phone = et_cad_phone.getText().toString(); // Converte o campo de telefone para string
            EditText et_cad_password = findViewById(R.id.et_cad_password); // Pega o campo de senha
            String str_cad_password = et_cad_password.getText().toString(); // Converte o campo de senha para string
            EditText et_confirmPassword = findViewById(R.id.et_confirmPassword); // Pega o campo de confirmação de senha
            String str_confirmPassword = et_confirmPassword.getText().toString(); // Converte o campo de confirmação de senha para string

            if (!str_cad_email.isEmpty() || !str_cad_username.isEmpty() || !str_cad_phone.isEmpty() || !str_cad_password.isEmpty() || !str_confirmPassword.isEmpty()) { // Se todos os campos estiverem preenchidos
                if (str_cad_password.equals(str_confirmPassword)) { // Se a senha e a confirmação de senha forem iguais
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else { // Se a senha e a confirmação de senha forem diferentes
                    Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                }
            } else { // Se qualquer campo estiver vazio ou nulo
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}