package rds.com.mywallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListernerOnButton();
    }

    public void addListernerOnButton() {
        final Context context = this;
        button = (Button)findViewById(R.id.btnNewWallet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WalletActivity.class);
                startActivity(intent);
            }
        });
    }
}
