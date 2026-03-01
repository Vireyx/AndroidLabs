package com.example.lab6_7;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.dialogBtn).setOnClickListener(v -> showColorDialog());
    }

    private void showColorDialog() {
        String[] colors = {"Красный", "Жёлтый", "Зелёный"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выбрать фон");
        builder.setItems(colors, (dialog, which) -> {
            switch (which) {
                case 0:
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                    break;
                case 1:
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                    break;
                case 2:
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    break;
            }
        });
        builder.show();
    }
}