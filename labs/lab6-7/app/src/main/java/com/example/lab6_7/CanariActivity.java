package com.example.lab6_7; // пакет

import android.os.Bundle; // Bundle для состояния
import androidx.appcompat.app.AppCompatActivity; // базовый класс Activity

public class CanariActivity extends AppCompatActivity { // активити для Канар

    @Override // переопределяем метод
    protected void onCreate(Bundle savedInstanceState) { // создаём экран
        super.onCreate(savedInstanceState); // родительский onCreate
        setContentView(R.layout.activity_canari); // подключаем макет activity_canari.xml
    } // конец onCreate
} // конец класса