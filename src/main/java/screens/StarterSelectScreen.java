package screens;

import backend.Pokemon;
import backend.PokemonFactory;
import main.GamePanel;
import main.KeyHandler;

import javax.net.ssl.KeyManager;
import java.awt.*;
import java.util.ArrayList;

import static main.ApplicationMain.userInput;

public class StarterSelectScreen extends Screen {
    int dialogueIndex = 0;
    boolean hint;

    public StarterSelectScreen(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/PokemonSelectScreen.png");
        dialogues[0] = "Hint:\nEvery pokemon has its own\nunique type and abilities\n\nChoose wisely~";
        hint = false;
        cityMap = false;
    }

    public void update() {
        super.update();

        long elapsedTime = System.currentTimeMillis() - startTime;

        if (elapsedTime > 500) {
            hint = true;
        }

        if (userInput.equals("/bulbasaur")) {
            Pokemon pokemon = PokemonFactory.createPokemon("Bulbasaur");
            pokemon.setLevel(5);
            gp.player.setStarterPokemon(pokemon);
            dialogues[1] = "You have chosen " + gp.player.getPokemonList().getFirst().getName()+"\n\nGood luck on your journey!\n\n                         /begin";
            dialogueIndex++;
        }
        if (userInput.equals("/charmander")) {
            Pokemon pokemon = PokemonFactory.createPokemon("Charmander");
            pokemon.setLevel(5);
            gp.player.setStarterPokemon(pokemon);
            dialogues[1] = "You have chosen " + gp.player.getPokemonList().getFirst().getName()+"\n\nGood luck on your journey!\n\n                         /begin";
            dialogueIndex++;
        }
        if (userInput.equals("/squirtle")) {
            Pokemon pokemon = PokemonFactory.createPokemon("Squirtle");
            pokemon.setLevel(5);
            gp.player.setStarterPokemon(pokemon);
            dialogues[1] = "You have chosen " + gp.player.getPokemonList().getFirst().getName()+"\n\nGood luck on your journey!\n\n                         /begin";
            dialogueIndex++;
        }




        if (userInput.equals("/begin") && !gp.player.getPokemonList().isEmpty()) {
            gp.stopMusic();
            gp.currentScreen = new PalletTown(gp, keyH);
        }
    }

    public void draw(Graphics2D g2) {
        super.draw(g2);
        currentDialogue = dialogues[dialogueIndex];

        if (hint) {
            drawDialogueBox(g2);
        }
    }
}
