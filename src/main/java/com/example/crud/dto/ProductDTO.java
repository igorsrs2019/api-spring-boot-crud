package com.example.crud.dto;

public class ProductDTO {
    private String id;
    private String name;
    private Integer price_in_cents;

    public ProductDTO (String id, String name, Integer price_in_cents){
     this.id = id;
     this.name = name;
     this.price_in_cents = price_in_cents;



    }

    // Getters


    public String getId (){
        return id;
    }

    public String getName () {
        return name;
    }

    public Integer getPrice_in_cents () {
        return price_in_cents;
    }

}
