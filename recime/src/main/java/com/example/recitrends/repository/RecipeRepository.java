package com.example.recitrends.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recitrends.dto.Recipes;

public interface RecipeRepository extends JpaRepository<Recipes, Long>{

}
