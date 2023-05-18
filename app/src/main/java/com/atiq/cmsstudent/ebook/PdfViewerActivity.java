package com.atiq.cmsstudent.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.atiq.cmsstudent.R;

public class PdfViewerActivity extends AppCompatActivity {
    private String url;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        url = getIntent().getStringExtra("pdfUrl");
        tv = findViewById(R.id.URLShow);
        tv.setText(""+url);
    }
}