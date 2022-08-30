package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        boolean gameActivity = true;
        //Representation of no with symbol
        //0-X
        //1-O
        int activePlayer = 0;
        int[] gameState = {2,2,2,2,2,2,2,2,2};



       // Meaning of states here is
        //if at that position
        // 0 is there then its X     0-X
        // 1 is there then its O iff    1-O
        // 2 is there its blank at starting all are blank   2-NULL first annintini blank ga initialize chesamu

        int[][]WinningPositions  = {{0,1,2},{3,4,5},{6,7,8},
                                    {0,3,6},{1,4,7},{2,5,8},
                                    {0,4,8},{2,4,6}};
    public void playerTap(View view){
        if(gameActivity == false){
            resetGame(view);//it will again reset on tapping
        }

        //edaite image ni click chesaro adi img lopaliki potundi
        ImageView img = (ImageView) view;

        //nuv tapp chesina image ki sambandinchina tag tappedImg lopatiki potundi
        int tappedImg = Integer.parseInt(img.getTag().toString());

        //ae view deggara click chesaro aa particular tag lo blank unteney kada fill ayyedi
        if(gameState[tappedImg] == 2){
            gameState[tappedImg] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0){
                img.setImageResource(R.drawable.x);//X symbol chupistundi
                activePlayer = 1;//malli next time ki O symbol chupiyali ga
                TextView status = findViewById(R.id.status);//status aney id loni TextView tiskonni status lo pettamu
                status.setText("O's Turn Tap To Play");//ippudu active player 1 kabatti X di turn
            }
            else if(activePlayer == 1){
                img.setImageResource(R.drawable.o);//O symbol chupistundi
                activePlayer = 0;//malli next time ki O symbol chupiyali ga
                TextView status = findViewById(R.id.status);//status aney id loni TextView tiskonni status lo pettamu
                status.setText("X's Turn Tap To Play");//ippudu active player 0 kabatti 0 di turn
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //Checking if any player had won or not
        for(int[] WinningPositions : WinningPositions)
        {
            //WinningPositions lo unna 2-D array di prati yokka 1-D array tiskoni dainlo unna index values unna
            // gameState array tiskoni aa particular indexes lo same element undemo ani check chestunnamu

            if(gameState[WinningPositions[0]] == gameState[WinningPositions[1]] &&
                    gameState[WinningPositions[1]] == gameState[WinningPositions[2]] &&
                    gameState[WinningPositions[1]] != 2){//ee condition true aindi antey edo oka player gelicharu ani ardam
                //SomeOne Has Won so;
                gameActivity = false;
                String str;
                if(gameState[WinningPositions[0]] == 0){
                    str = "X Has Won The Game!!";
                }
                else{
                    str = "O Has Won The Game!!";
                }
                TextView status = findViewById(R.id.status);//status aney id loni TextView tiskonni status lo pettamu
                status.setText(str);//Status Bar lo evarithe gelicharo adi update chestundi
            }

        }}
public void resetGame(View view){
    int activePlayer = 0;//again active player is made as X
    for(int i=0;i<9;i++){
        gameState[i]=2;//Here all Views are made blank again
    }
    gameActivity = true;//again made it as true it again resets

    //Now all views become Black as inthe Beginning
    ((ImageView) findViewById(R.id.imageView0)) .setImageResource(0);//if we put it as 0 then it will become Black
    ((ImageView) findViewById(R.id.imageView1)) .setImageResource(0);//if we put it as 0 then it will become Black
    ((ImageView) findViewById(R.id.imageView2)) .setImageResource(0);//if we put it as 0 then it will become Black
    ((ImageView) findViewById(R.id.imageView3)) .setImageResource(0);//if we put it as 0 then it will become Black
    ((ImageView) findViewById(R.id.imageView4)) .setImageResource(0);//if we put it as 0 then it will become Black
    ((ImageView) findViewById(R.id.imageView5)) .setImageResource(0);//if we put it as 0 then it will become Black
    ((ImageView) findViewById(R.id.imageView6)) .setImageResource(0);//if we put it as 0 then it will become Black
    ((ImageView) findViewById(R.id.imageView7)) .setImageResource(0);//if we put it as 0 then it will become Black
    ((ImageView) findViewById(R.id.imageView8)) .setImageResource(0);//if we put it as 0 then it will become Black
    TextView status = findViewById(R.id.status);
    status.setText("O's Turn Tap To Play");

        }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}