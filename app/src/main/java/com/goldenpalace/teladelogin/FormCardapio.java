package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.goldenpalace.teladelogin.adapter.FoodAdapter;
import com.goldenpalace.teladelogin.databinding.ActivityFormCardapioBinding;
import com.goldenpalace.teladelogin.model.Food;

import java.util.ArrayList;

public class FormCardapio extends AppCompatActivity {

    private ActivityFormCardapioBinding binding;
    private FoodAdapter foodAdapter;
    private ArrayList<Food> foodList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormCardapioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerViewFood = binding.RecyclerViewFood;
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFood.setHasFixedSize(true);
        foodAdapter = new FoodAdapter(foodList, this);
        recyclerViewFood.setAdapter(foodAdapter);
        getFood();
    }

    private void getFood(){

        Food food1 = new Food(
        R.drawable.lasanha,
                "Lasanha",
                "A Lasanha à Bolonhesa  é um prato tipicamente originado na Itália é composta por uma deliciosa massa, recheada com molho à bolonhesa, carne moída e presunto, coberta com molho branco e mussarela, essa receita reúne também uma seleção de produtos de alta qualidade.",
                "$ 25.00"
                );
        foodList.add(food1);



            Food food2 = new Food(
                    R.drawable.macarrao,
                    "Macarrão",
                    "O macarrão é um alimento que está presente na mesa dos brasileiros há muitos anos e é extremamente popular. Ele é versátil, pois pode ser combinado com diversos tipos de molhos e acompanhamentos e também rápido e fácil de fazer sendo um dos pratos preferidos de quem mora só.",
                    "$ 30.00"
            );
            foodList.add(food2);


                Food food3 = new Food(
                        R.drawable.salada,
                        "Salada",
                        "A salada é um prato originalmente montado apenas com vegetais, mas isso não significa que algumas fontes de proteína animal não combinem com esses alimentos. Ao escolher tipos de proteínas que podem ser consumidas frias – como camarões, embutidos, queijos e carpaccios – você pode dar um toque especial para o seu prato de salada.",
                        "$ 20.00"
                );
                foodList.add(food3);


                    Food food4 = new Food(
                            R.drawable.spagetti,
                            "Spagetti Carbonara",
                            "O spaghetti carbonara é um tipo de massa que leva pancetta, queijo, gemas de ovos e pimenta. É um clássico servido em qualquer restaurante de culinária internacional.",
                            "$ 35.00"
                    );
                    foodList.add(food4);



                        Food food5 = new Food(
                                R.drawable.negroni,
                                "Negroni",
                                "Em sua essência, o Negroni tem três ingredientes: gim, vermute doce e o bitter italiano Campari. Essa mistura de apenas 3 ingredientes é um toque genial de simplicidade que facilita a mistura para o happy hour em casa ou mesmo para o alto movimento de um bar. ",
                                "$ 28.00"
                        );
                        foodList.add(food5);
    }

}