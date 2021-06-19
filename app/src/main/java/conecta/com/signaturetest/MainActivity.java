package conecta.com.signaturetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import conecta.com.signaturepad.views.ConectaSignaturePad;

public class MainActivity extends AppCompatActivity {

    ConectaSignaturePad signaturePad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signaturePad = findViewById(R.id.signature);

    }

    public void onClick(View view){
        signaturePad.finishSignature();

        System.out.println("Stroke count: " + String.valueOf(signaturePad.getStrokeCount()));
        System.out.println("Generation Id: " + String.valueOf(signaturePad.getIdGeneration()));
        System.out.println("Elapsed Time: " + String.valueOf(signaturePad.getElapsedTime() + " millis"));
        System.out.println("SVG string: " + String.valueOf(signaturePad.getSignatureSvg()));

        signaturePad.clear();

    }


}
