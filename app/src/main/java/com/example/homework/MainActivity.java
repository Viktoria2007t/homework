package com.example.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float Coat = 70; // пальто
    byte CoatDiscount = 77; // скидка (в процентах)
    float Hat = 25; // шляпа
    byte HatDiscount =37;
    float Businesssuit=53; // деловой костюм
    byte BusinesssuitDiscount=44; // скидка (в процентах)
    float Shirt = 19; // сорочка
    byte ShirtDiscount=0;
    float Shoes = 41; // туфли
    byte ShoesDiscount = 32;
    float account = 312; // счёт пользователя

    // метод подсчёта стоимости делового гардероба
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (Coat * (100 - CoatDiscount) + Hat * (100 - HatDiscount)
                + Businesssuit * (100 - BusinesssuitDiscount) +Shirt* (100 -ShirtDiscount )
                + Shoes * (100 - ShoesDiscount)) / 100;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки делового гардероба
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость делового гардероба меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить делового гардероба
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить делового гардероба
            possibilityOut.setText("Имеется достаточно средств для покупки делового гардероба");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки делового гардероба");

            balanceOut.setText(" - ");
        }
    }
}