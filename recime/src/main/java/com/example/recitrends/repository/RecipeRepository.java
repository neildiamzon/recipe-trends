package com.example.recitrends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recitrends.dto.Recipes;
import com.example.recitrends.enums.Difficulty;

public interface RecipeRepository extends JpaRepository<Recipes, Long>{

	List<Recipes> findByDifficulty(Difficulty d);

}
