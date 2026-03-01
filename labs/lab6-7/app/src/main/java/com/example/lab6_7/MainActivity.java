package com.example.lab6_7; // пакет (должен совпадать с манифестом)

import android.app.AlertDialog; // класс для создания диалоговых окон AlertDialog
import android.content.Intent; // Intent нужен для перехода между Activity (экранами)
import android.os.Bundle; // Bundle хранит состояние (например при повороте экрана)
import android.widget.ArrayAdapter; // адаптер: связывает массив строк со списком ListView
import android.widget.Button; // класс кнопки
import android.widget.ListView; // класс списка
import android.widget.Toast; // Toast - всплывающая подсказка снизу
import android.view.View; // базовый класс View (элемент интерфейса)
import android.widget.LinearLayout; // контейнер layout, чтобы менять фон

import androidx.appcompat.app.AppCompatActivity; // базовая Activity с поддержкой AppCompat

public class MainActivity extends AppCompatActivity { // объявляем класс экрана и наследуемся от AppCompatActivity

    private final String[] items = { // массив строк — что будет в списке
            "Канары", // пункт 0
            "Курилы", // пункт 1
            "Мальдивы", // пункт 2
            "Филиппины", // пункт 3
            "Tabs / Слайдинг-вкладки" // пункт 4
    }; // конец массива

    private LinearLayout rootLayout; // переменная для доступа к корневому layout (фон менять будем тут)
    private Button dialogButton; // переменная для кнопки "Открыть диалог"
    private ListView islandsListView; // переменная для списка островов

    @Override // аннотация: мы переопределяем метод родителя
    protected void onCreate(Bundle savedInstanceState) { // onCreate вызывается при создании Activity
        super.onCreate(savedInstanceState); // обязательно вызываем родителя
        setContentView(R.layout.activity_main); // подключаем разметку activity_main.xml

        rootLayout = findViewById(R.id.rootLayout); // находим rootLayout по id из XML
        dialogButton = findViewById(R.id.dialogButton); // находим кнопку по id
        islandsListView = findViewById(R.id.islandsListView); // находим ListView по id

        ArrayAdapter<String> adapter = new ArrayAdapter<>( // создаём адаптер для списка
                this, // контекст: текущая Activity
                android.R.layout.simple_list_item_1, // стандартный шаблон строки списка
                items // данные (массив строк)
        ); // конец создания адаптера

        islandsListView.setAdapter(adapter); // подключаем адаптер к ListView => список отображается

        islandsListView.setOnItemClickListener((parent, view, position, id) -> { // обработчик клика по пункту списка
            switch (position) { // смотрим индекс нажатого пункта
                case 0: // если выбрали "Канары"
                    startActivity(new Intent(MainActivity.this, CanariActivity.class)); // переходим на CanariActivity
                    break; // выходим из switch
                case 1: // если выбрали "Курилы"
                    startActivity(new Intent(MainActivity.this, CuriliActivity.class)); // переходим на CuriliActivity
                    break; // выходим
                case 2: // если выбрали "Мальдивы"
                    startActivity(new Intent(MainActivity.this, MaldiviActivity.class)); // переходим на MaldiviActivity
                    break; // выходим
                case 3: // если выбрали "Филиппины"
                    startActivity(new Intent(MainActivity.this, PhilippiniActivity.class)); // переходим на PhilippiniActivity
                    break; // выходим
                case 4: // если выбрали "Tabs / Слайдинг-вкладки"
                    startActivity(new Intent(MainActivity.this, TabsActivity.class)); // переходим на TabsActivity
                    break; // выходим
            } // конец switch

            Toast.makeText( // создаём Toast
                    getApplicationContext(), // контекст приложения
                    "Вы выбрали " + parent.getItemAtPosition(position), // текст, показываем выбранный пункт
                    Toast.LENGTH_SHORT // длительность короткая
            ).show(); // показать Toast
        }); // конец обработчика клика по списку

        dialogButton.setOnClickListener(v -> { // обработчик нажатия на кнопку диалога
            openColorDialog(); // вызываем метод который показывает диалог
        }); // конец обработчика кнопки
    } // конец onCreate

    private void openColorDialog() { // метод открытия диалога выбора цвета
        final CharSequence[] colors = { // массив пунктов меню в диалоге
                getText(R.string.red), // берём строку "Красный"
                getText(R.string.yellow), // берём строку "Жёлтый"
                getText(R.string.green) // берём строку "Зелёный"
        }; // конец массива

        AlertDialog.Builder builder = new AlertDialog.Builder(this); // создаём builder диалога
        builder.setTitle(R.string.message); // заголовок диалога: "Хотите поменять фон?"
        builder.setItems(colors, (dialog, which) -> { // устанавливаем список и обработчик выбора пункта
            switch (which) { // which = индекс выбранного пункта (0/1/2)
                case 0: // если выбрали красный
                    rootLayout.setBackgroundResource(R.color.redColor); // меняем фон rootLayout на красный
                    Toast.makeText(this, R.string.red, Toast.LENGTH_SHORT).show(); // показываем Toast "Красный"
                    break; // выходим
                case 1: // если выбрали жёлтый
                    rootLayout.setBackgroundResource(R.color.yellowColor); // меняем фон на жёлтый
                    Toast.makeText(this, R.string.yellow, Toast.LENGTH_SHORT).show(); // Toast "Жёлтый"
                    break; // выходим
                case 2: // если выбрали зелёный
                    rootLayout.setBackgroundResource(R.color.greenColor); // меняем фон на зелёный
                    Toast.makeText(this, R.string.green, Toast.LENGTH_SHORT).show(); // Toast "Зелёный"
                    break; // выходим
            } // конец switch
        }); // конец setItems

        AlertDialog dialog = builder.create(); // создаём диалог из builder
        dialog.show(); // показываем диалог на экране
    } // конец openColorDialog
} // конец класса MainActivity