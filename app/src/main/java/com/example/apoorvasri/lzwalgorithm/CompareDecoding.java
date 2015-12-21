package com.example.apoorvasri.lzwalgorithm;

/**
 * Created by ApoorvaSri on 12/14/2015.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CompareDecoding extends AppCompatActivity {

    private TextView originalTF;
    private TextView outputTF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoding);

        this.originalTF = (TextView)this.findViewById(R.id.originalTF);
        this.originalTF.setText(Compression.input);

        this.outputTF = (TextView)this.findViewById((R.id.outputTF));
        this.outputTF.setText(getDecodeOuput(Compression.bits));
    }

    private String getDecodeOuput(String bits)
    {
        Decode d = new Decode();
        String result = d.output(bits);
        return result;
    }
}