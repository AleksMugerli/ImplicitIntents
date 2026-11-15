package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText loca;
    private EditText websiteEditText;
    private EditText shareEditText;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Povezava elementov iz XML postavitve
        websiteEditText = findViewById(R.id.wb);
        loca = findViewById(R.id.loc);
        shareEditText = findViewById(R.id.sh);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        // button1 (ID: button) -> Odpiranje spletne strani v Google Chromu
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite(v);
            }
        });

        // button2 (ID: button2) -> Odpiranje lokacije v Google Zemljevidih
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocation(v);
            }
        });

        // button3 (ID: button3) -> Deljenje besedila
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareText(v);
            }
        });
    }

    public void openWebsite(View view) {
        String url = websiteEditText.getText().toString().trim();
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Usmeri namen neposredno v Google Chrome
        intent.setPackage("com.android.chrome");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Če Chrome ni nameščen, odpre v privzetem brskalniku
            intent.setPackage(null);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    public void openLocation(View view) {
        String loc = loca.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + Uri.encode(loc));
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Usmeri namen neposredno v Google Zemljevide
        intent.setPackage("com.google.android.apps.maps");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Če Google Zemljevidi niso nameščeni, odpre lokacijo v brskalniku
            Uri fallbackUri = Uri.parse("https://google.com" + Uri.encode(loc));
            Intent fallbackIntent = new Intent(Intent.ACTION_VIEW, fallbackUri);
            startActivity(fallbackIntent);
        }
    }

    public void shareText(View view) {
        // 1. Preberite besedilo iz tretjega vnosnega polja
        String txt = shareEditText.getText().toString();

        // 2. Določite MIME tip za navadno besedilo
        String mimeType = "text/plain";

        // 3. Zgradite in zaženite izbirnik za deljenje s pomočjo ShareCompat.IntentBuilder
        new ShareCompat.IntentBuilder(this)
                .setType(mimeType)
                .setChooserTitle("Deli besedilo z:")
                .setText(txt)
                .startChooser();
    }
}
