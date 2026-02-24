package com.example.lab4_5;
// ВАЖНО: пакет должен совпадать с твоим (слева в дереве проекта)

import android.content.Intent;      // Для открытия ссылки (Intent)
import android.net.Uri;             // Для преобразования строки в Uri
import android.os.Bundle;           // Для onCreate(savedInstanceState)
import android.widget.Button;       // Кнопка
import android.widget.EditText;     // Поле ввода
import android.widget.TextView;     // Текст
import android.widget.Toast;        // Всплывающее сообщение

import androidx.appcompat.app.AppCompatActivity; // Базовая активность (совместимость)

public class MainActivity extends AppCompatActivity {

    // Объявляем элементы интерфейса (из XML)
    private EditText etQuery;
    private Button btnGo, btnOpen, btnLike, btnDislike;
    private TextView tvSourceUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Подключаем разметку activity_main.xml
        setContentView(R.layout.activity_main);

        // Находим элементы по id (те же id должны быть в activity_main.xml)
        etQuery = findViewById(R.id.etQuery);
        btnGo = findViewById(R.id.btnGo);
        btnOpen = findViewById(R.id.btnOpen);
        btnLike = findViewById(R.id.btnLike);
        btnDislike = findViewById(R.id.btnDislike);
        tvSourceUrl = findViewById(R.id.tvSourceUrl);

        // Кнопка Go: показываем, что ввёл пользователь
        btnGo.setOnClickListener(v -> {
            String text = etQuery.getText().toString().trim(); // Берём текст из поля
            if (text.isEmpty()) { // Если ничего не ввели
                Toast.makeText(this, "Введите запрос", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Вы ввели: " + text, Toast.LENGTH_SHORT).show();
            }
        });

        // Кнопка Open: открываем сайт из строки tvSourceUrl
        btnOpen.setOnClickListener(v -> {
            String url = tvSourceUrl.getText().toString().trim(); // Берём URL

            // Если URL не начинается с http/https — добавим https автоматически
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }

            // Intent для открытия ссылки в браузере
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        // Like: просто показываем Toast (по заданию оценка)
        btnLike.setOnClickListener(v ->
                Toast.makeText(this, "Liked 👍", Toast.LENGTH_SHORT).show()
        );

        // Dislike: просто показываем Toast (по заданию оценка)
        btnDislike.setOnClickListener(v ->
                Toast.makeText(this, "Disliked 👎", Toast.LENGTH_SHORT).show()
        );
    }
}
