package backend;

import java.io.Serializable;
import java.util.ArrayList;


public class Pokemon implements Serializable {
	
	
	/*
	-name
	-type
	-lvl
	-move -> 2 moves
	-strength -> type
	-weakness -> type
	-hp
	-exp
	
	*/
	
	//----------------Attribute----------------------------//
	
	private String Name;
	private ArrayList<String> type = new ArrayList<String>();
	private int level = 5;
	private ArrayList<String> Strength = new ArrayList<String>();
	private ArrayList<String> Weakness = new ArrayList<String>();
	private double FullHealth;
	private int Exp;
	private Moves[] Move = new Moves[2];
	private double CurrentHealth;
	private boolean downed = false;
	private int maxExp;
	private String pokemonEvolve;
	private int lvlEvolve;
	private Weather weather;
	
	//----------------Attribute----------------------------//
	
	//-------------------setter and getter-----------------------//
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		
		this.Move[0].setDamage(Move[0].getDamage() + (2*level));
		this.Move[1].setDamage(Move[1].getDamage() + (2*level));
		this.FullHealth += level*30;
		this.CurrentHealth = FullHealth;
		
		this.level = level;
	}
	public double getFullHealth() {
		return FullHealth;
	}
	public void setCurrentHealth(double health) {
		CurrentHealth = health;
	}
	public double getCurrentHealth() {
		return CurrentHealth;
	}
	public int getExp() {
		return Exp;
	}
	public void setExp(int exp) {
		Exp = exp;
	}
	public Moves[] getMove() {
		return Move;
	}
        
	public ArrayList<String> getMoveNames() {
        ArrayList<String> moveNames = new ArrayList<String>();
        for (Moves move : Move) {
            if (move != null) {
                moveNames.add(move.getMovesName());
            }
        }
        return moveNames;
    }
	
	public ArrayList<String> getType() {
		return type;
	}
	public ArrayList<String> getWeakness() {
		return Weakness;
	}
	public ArrayList<String> getStrength() {
		return Strength;
	}
	public void setDowned(boolean downed) {
		this.downed = downed;
	}
	
	public void setFullHealth(double fullHealth) {
		FullHealth = fullHealth;
	}
	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}
	public int getMaxExp() {
		
		if(this.level < 10) {
			
			this.maxExp = 100;
			
		} else if (this.level < 20) {
			
			this.maxExp = 200;
		
		} else if (this.level < 30) {
			
			this.maxExp = 300;
			
		} else {
			
			this.maxExp = 400;
			
		}
		
		
		
		return maxExp;
	}

	public int getLvlEvolve() {
		return lvlEvolve;
	}

	public Weather getWeather() {
		return this.weather;
	}
	
	//-------------------setter and getter-----------------------//
	
	//----------------constructor--------------------------//
	
	public Pokemon(String name, double health, String[] type, int level, String[] strength, String[] weakness, Moves move1, Moves move2) {
		
		this.Name = name;
		this.FullHealth = health;
		this.CurrentHealth = health;
	
		for(int i = 0; i< type.length; i++)
			this.type.add(type[i]);
		
		for(int i = 0; i< weakness.length; i++)
			this.Weakness.add(weakness[i]);
		

		for(int i = 0; i< strength.length; i++)
			this.Strength.add(strength[i]);
		
		this.Move[0] = move1;
		this.Move[1] = move2;
		
		this.level = level;
		this.maxExp = 100;
	}
        
        
        
	public Pokemon(String name, double health, String[] type, int level, String[] strength, String[] weakness, Moves move1, Moves move2, String pokemonEvolve, int lvlEvolve) {

		this.Name = name;
		this.FullHealth = health;
		this.CurrentHealth = health;
	
		for(int i = 0; i< type.length; i++)
			this.type.add(type[i]);
		
		for(int i = 0; i< weakness.length; i++)
			this.Weakness.add(weakness[i]);
		

		for(int i = 0; i< strength.length; i++)
			this.Strength.add(strength[i]);
		
		this.Move[0] = move1;
		this.Move[1] = move2;
		
		this.level = level;
                
		this.pokemonEvolve = pokemonEvolve;
		this.lvlEvolve = lvlEvolve;
		
	}

	public Pokemon(String name, double health, String[] type, int level, String[] strength, String[] weakness, Moves move1, Moves move2, String pokemonEvolve, int lvlEvolve, Weather weather) {

		this.Name = name;
		this.FullHealth = health;
		this.CurrentHealth = health;

		for(int i = 0; i< type.length; i++)
			this.type.add(type[i]);

		for(int i = 0; i< weakness.length; i++)
			this.Weakness.add(weakness[i]);


		for(int i = 0; i< strength.length; i++)
			this.Strength.add(strength[i]);

		this.Move[0] = move1;
		this.Move[1] = move2;

		this.level = level;

		this.pokemonEvolve = pokemonEvolve;
		this.lvlEvolve = lvlEvolve;

		this.weather = weather;

	}
	
	//----------------constructor--------------------------//
	
	//---------------------public method------------------------//
	
	public void healFull() { //heal fully pokemon
		CurrentHealth = FullHealth;
	}
	
	public void heal(int hp){ //heal partially, dont know what could be use for, but its here
		if ((CurrentHealth + hp) > FullHealth) {
			CurrentHealth=FullHealth;
			return;
		}
			
		CurrentHealth += hp;
	}
	
	public void revive() { //change the parameter, use easier naming, pretty much the same as setter for downed
		this.downed = false;
		this.CurrentHealth = 10;
	}
	

	// Clone method
    public Pokemon clone() {
        if (this.lvlEvolve != 0 && this.pokemonEvolve != null && this.weather != null) {
			return new Pokemon(this.Name, this.FullHealth, this.type.toArray(new String[this.type.size()]), this.level, this.Strength.toArray(new String[this.Strength.size()]), this.Weakness.toArray(new String[this.Weakness.size()]), this.Move[0].clone(), this.Move[1].clone(), this.pokemonEvolve, this.lvlEvolve, this.weather);
		} else if (this.lvlEvolve != 0 && this.pokemonEvolve != null) {
			return new Pokemon(this.Name, this.FullHealth, this.type.toArray(new String[this.type.size()]), this.level, this.Strength.toArray(new String[this.Strength.size()]), this.Weakness.toArray(new String[this.Weakness.size()]), this.Move[0].clone(), this.Move[1].clone(), this.pokemonEvolve, this.lvlEvolve);
		} else {
			return new Pokemon(this.Name, this.FullHealth, this.type.toArray(new String[this.type.size()]), this.level, this.Strength.toArray(new String[this.Strength.size()]), this.Weakness.toArray(new String[this.Weakness.size()]), this.Move[0].clone(), this.Move[1].clone());
		}
    }
	
	
    public void evolve () {

		// current weather not done yet
//		if (this.level < this.lvlEvolve && !(this.weather.getCurrentWeather().equals(Main.currentWeather.getCurrentWeather())) ) {
//			System.out.println("Cant evolve level requirement doesnt met");
//			return;
//		}

                
		Pokemon pokemon = PokemonFactory.createPokemon(this.pokemonEvolve);
		pokemon.setLevel(this.level);
                
                
		this.Name = pokemon.Name;
		this.FullHealth = pokemon.FullHealth;
		this.type = pokemon.type;
		this.level = this.level;
		this.Strength = pokemon.Strength ;
		this.Weakness = pokemon.Weakness;
		this.Move[0] = pokemon.Move[0];
		this.Move[1] = pokemon.Move[1];
		
    }
	
	public void increaseEXP(int xp) {
		
		this.Exp += xp;
		
		System.out.printf("\n%s earned %d exp\n", this.getName(), xp);
		
		
		
		System.out.printf("%s [XP: %d/%d]\n\n", this.getName(), this.Exp, this.getMaxExp());
		
		if (this.Exp >= this.getMaxExp()) {
			this.Exp -= this.maxExp;
			this.increaseLevel();
			
		}
		
		
		
		
		
	}
	
	public Pokemon increaseLevel() {
		
		this.level +=1;
		this.Move[0].setDamage(Move[0].getDamage() + 2);
		this.Move[1].setDamage(Move[1].getDamage() + 2);
		
		System.out.println(this.getName() + " level increased: lvl " + (this.level - 1) + " --> lvl " + this.level);
		return this;
	}
	
	public Pokemon increaseLevel(int LeveledUp) {
		this.level += LeveledUp;
		
		this.Move[0].setDamage(Move[0].getDamage() + (2*LeveledUp));
		this.Move[1].setDamage(Move[1].getDamage() + (2*LeveledUp));
		System.out.println(this.getName() + " level increased: lvl " + (this.level - 1) + " --> lvl " + this.level);
		
		return this;
	}
	
	public Pokemon increaseHP(int HP) {
		this.FullHealth += HP;
		
		return this;
	}
	
	public boolean isDown() {	
		return (this.CurrentHealth <= 0) || (this.downed);
	}
	
	
	
	
}
