package com.devsuperior.list.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable // mostra que os dois campos irão relacionar uma chave pk no banco relacional(encapsula dois elementos em uma unica classe
public class BelongingPK {
	
	@ManyToOne
	@JoinColumn(name= "Game_id")//configurar as duas chaves 
	private Game game;
	
	@ManyToOne
	@JoinColumn(name= "list_id")
	private GameList list;
	
	public BelongingPK () {
		
	}

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
		
		// quando a PK for multipla deve-se comparar as duas 	
	}
	

	
}
