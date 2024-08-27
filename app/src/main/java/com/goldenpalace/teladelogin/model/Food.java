package com.goldenpalace.teladelogin.model;

public class Food {
    int imgFood;
    String FoodName;
    String FoodDescricao;
    String Preco;

    public Food(int imgFood, String foodName, String foodDescricao, String preco) {
        this.imgFood = imgFood;
        FoodName = foodName;
        FoodDescricao = foodDescricao;
        Preco = preco;
    }

    public int getImgFood() {
        return imgFood;
    }


    public String getFoodName() {
        return FoodName;
    }


    public String getFoodDescricao() {
        return FoodDescricao;
    }


    public String getPreco() {
        return Preco;
    }

}
