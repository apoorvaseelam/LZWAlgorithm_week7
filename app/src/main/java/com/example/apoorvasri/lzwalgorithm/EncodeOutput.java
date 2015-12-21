package com.example.apoorvasri.lzwalgorithm;

/**
 * Created by ApoorvaSri on 12/14/2015.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EncodeOutput extends AppCompatActivity {
    private TextView inputTF;
    private TextView outputTF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoding);

        this.inputTF = (TextView)this.findViewById(R.id.inputTF);
        this.inputTF.setText(Compression.input);
        this.outputTF = (TextView)this.findViewById(R.id.outputTF);
        this.outputTF.setText(getEncodeOutput(Compression.input));
    }

    private String getEncodeOutput(String input)
    {
        Encode e = new Encode();
        String result = e.output(input + "#");
        return result;
    }

    public void decodingButtonPressed(View v)
    {
        Compression.bits = getEncodeOutput(Compression.input);
        Intent i = new Intent(this, CompareDecoding.class);
        startActivity(i);
    }
}
