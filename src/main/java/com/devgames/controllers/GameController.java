package com.devgames.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgames.dto.GameMinDTO;
import com.devgames.entities.Game;
import com.devgames.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

  @Autowired
	private GameService gameService;
  

    @GetMapping
    public List<GameMinDTO> findAll() {
      List<GameMinDTO> result = gameService.findAll();
      return result;
    }
  }


