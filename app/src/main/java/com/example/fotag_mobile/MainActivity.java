package com.example.fotag_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    public Model myModel = new Model();
    RatingBar myRatingBar1;
    RatingBar myRatingBar2;
    RatingBar myRatingBar3;
    RatingBar myRatingBar4;
    RatingBar myRatingBar5;
    RatingBar myRatingBar6;
    RatingBar myRatingBar7;
    RatingBar myRatingBar8;
    RatingBar myRatingBar9;
    RatingBar myRatingBar10;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;

    Button clearButton1;
    Button clearButton2;
    Button clearButton3;
    Button clearButton4;
    Button clearButton5;
    Button clearButton6;
    Button clearButton7;
    Button clearButton8;
    Button clearButton9;
    Button clearButton10;


    RatingBar ratingBarArray [] = new RatingBar[] {myRatingBar1, myRatingBar2, myRatingBar3, myRatingBar4,
    myRatingBar5, myRatingBar6, myRatingBar7, myRatingBar8, myRatingBar9, myRatingBar10};

    int[] view_id_array = new int[] {R.id.cardImage1, R.id.cardImage2, R.id.cardImage3, R.id.cardImage4,
            R.id.cardImage5, R.id.cardImage6, R.id.cardImage7, R.id.cardImage8, R.id.cardImage9, R.id.cardImage10};

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d("ConfigChange", "REACHED HEREkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        for (int i = 0; i < myModel.pictures.length; ++i) {
            Log.d("ConfigChange","Num Stars: " + myModel.pictures[i].numStars);
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("Config", "Bunny Stars is: " + myModel.pictures[0].numStars);
//            setContentView(R.layout.activity_main_land);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("Config", "Bunny Stars is: " + myModel.pictures[0].numStars);
            setContentView(R.layout.activity_main);
        }

        new DownloadImageFromInternet((ImageView) findViewById(R.id.cardImage1)) .execute(myModel.pictures[0].pictureURL);
        myModel.onclick = false;
        myRatingBar1.setRating((float) myModel.pictures[0].numStars);
        myModel.onclick = true;

//        for (int i = 0; i < myModel.pictures.length; ++i) {
//            if (myModel.pictures[i].currentLoadValue != 0) {
//                new DownloadImageFromInternet((ImageView) findViewById(R.id.cardImage1)) .execute(myModel.pictures[i].pictureURL);
//            }
//        }
    }

    public void changeNumStars(Integer ratingBar, Integer numStars) {
        if (myModel.onclick) {
            for (int i = 0; i < myModel.pictures.length; ++i) {
                if (myModel.pictures[i].currentLoadValue == ratingBar) {
                    myModel.pictures[i].numStars = numStars;
                    Log.d("changenums", "Ratingbar: " + ratingBar + " Numstars: " + numStars);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRatingBar1 = (RatingBar) findViewById(R.id.ratingBar1);
        myRatingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
        myRatingBar3 = (RatingBar) findViewById(R.id.ratingBar3);
        myRatingBar4 = (RatingBar) findViewById(R.id.ratingBar4);
        myRatingBar5 = (RatingBar) findViewById(R.id.ratingBar5);
        myRatingBar6 = (RatingBar) findViewById(R.id.ratingBar6);
        myRatingBar7 = (RatingBar) findViewById(R.id.ratingBar7);
        myRatingBar8 = (RatingBar) findViewById(R.id.ratingBar8);
        myRatingBar9 = (RatingBar) findViewById(R.id.ratingBar9);
        myRatingBar10 = (RatingBar) findViewById(R.id.ratingBar10);

        imageView1 = (ImageView) findViewById(R.id.cardImage1);
        imageView2 = (ImageView) findViewById(R.id.cardImage2);
        imageView3 = (ImageView) findViewById(R.id.cardImage3);
        imageView4 = (ImageView) findViewById(R.id.cardImage4);
        imageView5 = (ImageView) findViewById(R.id.cardImage5);
        imageView6 = (ImageView) findViewById(R.id.cardImage6);
        imageView7 = (ImageView) findViewById(R.id.cardImage7);
        imageView8 = (ImageView) findViewById(R.id.cardImage8);
        imageView9 = (ImageView) findViewById(R.id.cardImage9);
        imageView10 = (ImageView) findViewById(R.id.cardImage10);

        clearButton1 = (Button) findViewById(R.id.clearButton1);
        clearButton2 = (Button) findViewById(R.id.clearButton2);
        clearButton3 = (Button) findViewById(R.id.clearButton3);
        clearButton4 = (Button) findViewById(R.id.clearButton4);
        clearButton5 = (Button) findViewById(R.id.clearButton5);
        clearButton6 = (Button) findViewById(R.id.clearButton6);
        clearButton7 = (Button) findViewById(R.id.clearButton7);
        clearButton8 = (Button) findViewById(R.id.clearButton8);
        clearButton9 = (Button) findViewById(R.id.clearButton9);
        clearButton10 = (Button) findViewById(R.id.clearButton10);

        clearButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 1) {
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar1.setRating(0F);
                        myModel.onclick = true;
                    }
                }
            }
        });

        clearButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < myModel.pictures.length; ++i) {
                    Log.d("SUPER", "Picture" + myModel.pictures[i].pictureURL + " has load value: " + myModel.pictures[i].currentLoadValue);
                }
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 2) {
                        Log.d("Config", "CLEAR BUTTON 2 NOT WORKING");
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar2.setRating(0F);
                        myModel.onclick = true;
                        break;
                    }
                }
            }
        });

        clearButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 3) {
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar3.setRating(0F);
                        myModel.onclick = true;
                    }
                }
            }
        });

        clearButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 4) {
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar4.setRating(0F);
                        myModel.onclick = true;
                    }
                }
            }
        });

        clearButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 5) {
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar5.setRating(0F);
                        myModel.onclick = true;
                    }
                }
            }
        });

        clearButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 6) {
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar6.setRating(0F);
                        myModel.onclick = true;
                    }
                }
            }
        });

        clearButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 7) {
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar7.setRating(0F);
                        myModel.onclick = true;
                    }
                }
            }
        });

        clearButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 8) {
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar8.setRating(0F);
                        myModel.onclick = true;
                    }
                }
            }
        });

        clearButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 9) {
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar9.setRating(0F);
                        myModel.onclick = true;
                    }
                }
            }
        });

        clearButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 10) {
                        myModel.pictures[i].numStars = 0;
                        myModel.onclick = false;
                        myRatingBar10.setRating(0F);
                        myModel.onclick = true;
                    }
                }
            }
        });


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 1) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 2) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 3) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 4) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 5) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 6) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 7) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 8) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 9) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for (int i = 0; i < myModel.pictures.length; ++i) {
                    if (myModel.pictures[i].currentLoadValue == 10) {
                        image_url = myModel.pictures[i].pictureURL;
                    }
                }
                Intent intent = new Intent(MainActivity.this, Pop1.class);
                intent.putExtra("imageURL", image_url);
                startActivity(intent);
            }
        });

        myRatingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(1, (int) ratingBar.getRating());
                Log.d("PictureURL1","GOT HERE");
            }
        });

        myRatingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(2, (int) ratingBar.getRating());
                Log.d("PictureURL2","GOT HERE");
            }
        });

        myRatingBar3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(3, (int) ratingBar.getRating());
                Log.d("PictureURL3","GOT HERE");
            }
        });

        myRatingBar4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(4, (int) ratingBar.getRating());
                Log.d("PictureURL4","GOT HERE");
            }
        });

        myRatingBar5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(5, (int) ratingBar.getRating());
                Log.d("PictureURL5","GOT HERE");
            }
        });

        myRatingBar6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(6, (int) ratingBar.getRating());
                Log.d("PictureURL2","GOT HERE");
            }
        });

        myRatingBar7.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(7, (int) ratingBar.getRating());
                Log.d("PictureURL2","GOT HERE");
            }
        });

        myRatingBar8.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(8, (int) ratingBar.getRating());
                Log.d("PictureURL2","GOT HERE");
            }
        });

        myRatingBar9.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(9, (int) ratingBar.getRating());
                Log.d("PictureURL2","GOT HERE");
            }
        });

        myRatingBar10.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                changeNumStars(10, (int) ratingBar.getRating());
                Log.d("PictureURL2","GOT HERE");
            }
        });

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("Config", "REACHED SAVE INSTANCE STATE");
        Log.d("Config", "Bunny Stars is: " + myModel.pictures[0].numStars);

        int bunnyNumStars = myModel.bunny.numStars;
        int bunnyLoadValue = myModel.bunny.currentLoadValue;

        outState.putInt("filterN", myModel.filterNumber);

        outState.putInt("bunnyN", bunnyNumStars);
        outState.putInt("bunnyL", bunnyLoadValue);

        outState.putInt("chinN", myModel.chinchilla.numStars);
        outState.putInt("chinL", myModel.chinchilla.currentLoadValue);

        outState.putInt("dogN",myModel.doggo.numStars);
        outState.putInt("dogL",myModel.doggo.currentLoadValue);

        outState.putInt("foxN",myModel.fox.numStars);
        outState.putInt("foxL",myModel.fox.currentLoadValue);

        outState.putInt("hamN",myModel.hamster.numStars);
        outState.putInt("hamL",myModel.hamster.currentLoadValue);

        outState.putInt("huskyN",myModel.husky.numStars);
        outState.putInt("huskyL",myModel.husky.currentLoadValue);

        outState.putInt("kitN",myModel.kitten.numStars);
        outState.putInt("kitL",myModel.kitten.currentLoadValue);

        outState.putInt("lorN",myModel.loris.numStars);
        outState.putInt("lorL",myModel.loris.currentLoadValue);

        outState.putInt("pupN",myModel.puppy.numStars);
        outState.putInt("pupL",myModel.puppy.currentLoadValue);

        outState.putInt("sleepyN",myModel.sleepy.numStars);
        outState.putInt("sleepyL",myModel.sleepy.currentLoadValue);



    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        myModel.filterNumber = savedInstanceState.getInt("filterN");

        myModel.pictures[0].numStars = savedInstanceState.getInt("bunnyN");;
        myModel.pictures[0].currentLoadValue = savedInstanceState.getInt("bunnyL");;

        myModel.pictures[1].numStars = savedInstanceState.getInt("chinN");
        myModel.pictures[1].currentLoadValue = savedInstanceState.getInt("chinL");

        myModel.pictures[2].numStars = savedInstanceState.getInt("dogN");
        myModel.pictures[2].currentLoadValue = savedInstanceState.getInt("dogL");

        myModel.pictures[3].numStars = savedInstanceState.getInt("foxN");
        myModel.pictures[3].currentLoadValue = savedInstanceState.getInt("foxL");

        myModel.pictures[4].numStars = savedInstanceState.getInt("hamN");
        myModel.pictures[4].currentLoadValue = savedInstanceState.getInt("hamL");

        myModel.pictures[5].numStars = savedInstanceState.getInt("huskyN");
        myModel.pictures[5].currentLoadValue = savedInstanceState.getInt("huskyL");

        myModel.pictures[6].numStars = savedInstanceState.getInt("kitN");
        myModel.pictures[6].currentLoadValue = savedInstanceState.getInt("kitL");

        myModel.pictures[7].numStars = savedInstanceState.getInt("lorN");
        myModel.pictures[7].currentLoadValue = savedInstanceState.getInt("lorL");

        myModel.pictures[8].numStars = savedInstanceState.getInt("pupN");
        myModel.pictures[8].currentLoadValue = savedInstanceState.getInt("pupL");

        myModel.pictures[9].numStars = savedInstanceState.getInt("sleepyN");
        myModel.pictures[9].currentLoadValue = savedInstanceState.getInt("sleepyL");

        int cardViewIndex = 0;
        for (int i = 0; i < myModel.pictures.length; ++i) {
            if (myModel.pictures[i].currentLoadValue != 0 && myModel.pictures[i].numStars >= myModel.filterNumber) {
                int cardImageID = view_id_array[cardViewIndex];
                new DownloadImageFromInternet((ImageView) findViewById(cardImageID)) .execute(myModel.pictures[i].pictureURL);

                // Update Rating
                if (cardViewIndex == 0) {
//                        myModel.onclick = false;
                    myModel.onclick = false;
                    myRatingBar1.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
//                        myModel.onclick = true;
                }

                if (cardViewIndex == 1) {
                    myModel.onclick = false;
                    myRatingBar2.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
                    Log.d("Does it get removed", "num stars: " + myModel.pictures[i].numStars);
                }

                if (cardViewIndex == 2) {
                    myModel.onclick = false;
                    myRatingBar3.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
                }

                if (cardViewIndex == 3) {
                    myModel.onclick = false;
                    myRatingBar4.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
                }

                if (cardViewIndex == 4) {
                    myModel.onclick = false;
                    myRatingBar5.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
                }

                if (cardViewIndex == 5) {
                    myModel.onclick = false;
                    myRatingBar6.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
                }

                if (cardViewIndex == 6) {
                    myModel.onclick = false;
                    myRatingBar7.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
                }

                if (cardViewIndex == 7) {
                    myModel.onclick = false;
                    myRatingBar8.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
                }

                if (cardViewIndex == 8) {
                    myModel.onclick = false;
                    myRatingBar9.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
                }

                if (cardViewIndex == 9) {
                    myModel.onclick = false;
                    myRatingBar10.setRating((float) myModel.pictures[i].numStars);
                    myModel.onclick = true;
                }

                cardViewIndex += 1;

            }
        }

        myModel.onclick = false;
        myRatingBar1.setRating((float) myModel.pictures[0].numStars);
        myModel.onclick = true;
        Log.d("Config", "Bunny Stars is: " + myModel.pictures[0].numStars);

    }

    // Adding Buttons to Actionbar code was taken from:
    // https://stackoverflow.com/questions/38158953/how-to-create-button-in-action-bar-in-android
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }


    // Downloading images from internet code was taken from:
    // https://www.viralandroid.com/2015/11/load-image-from-url-internet-in-android.html
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.refresh) {
            // Image link from internet
            myModel.currentLoaded = true;

            // Clear everything
            for (int i = 0; i < myModel.pictures.length; ++i) {
                myModel.pictures[i].numStars = 0;
            }

            myModel.onclick = false;
            myRatingBar1.setRating(0F);
            myRatingBar2.setRating(0F);
            myRatingBar3.setRating(0F);
            myRatingBar4.setRating(0F);
            myRatingBar5.setRating(0F);
            myRatingBar6.setRating(0F);
            myRatingBar7.setRating(0F);
            myRatingBar8.setRating(0F);
            myRatingBar9.setRating(0F);
            myRatingBar10.setRating(0F);
            myModel.onclick = true;


            // new DownloadImageFromInternet((ImageView) findViewById(R.id.cardImage1)) .execute("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/bunny.jpg");
            int image_id;

            String image_url;
            for(int i = 0; i < myModel.pictures.length; ++i) {
                image_id = view_id_array[i];
                image_url = myModel.pictures[i].pictureURL;
                new DownloadImageFromInternet((ImageView) findViewById(image_id)).execute(image_url);

                // update it the picture id
                myModel.pictures[i].currentLoadValue = i + 1;
                changeNumStars(i + 1,myModel.pictures[i].numStars);


            }

        } else if (id == R.id.clear) {
            // Image link from internet
            myModel.currentLoaded = false;

            // new DownloadImageFromInternet((ImageView) findViewById(R.id.cardImage1)) .execute("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/bunny.jpg");
            int image_id;
            for(int i = 0; i < myModel.pictures.length; ++i) {
                image_id = view_id_array[i];

                ImageView imageView = findViewById(image_id);
                imageView.setImageResource(0);

                // update it the picture id
                changeNumStars(i + 1,0);
                myModel.pictures[i].currentLoadValue = 0;
            }

            // Clear All ratings
            myRatingBar1.setRating(0F);
            myRatingBar2.setRating(0F);
            myRatingBar3.setRating(0F);
            myRatingBar4.setRating(0F);
            myRatingBar5.setRating(0F);
            myRatingBar6.setRating(0F);
            myRatingBar7.setRating(0F);
            myRatingBar8.setRating(0F);
            myRatingBar9.setRating(0F);
            myRatingBar10.setRating(0F);

            // Log.d("Pictureurl", "Picture URL: " + myModel.pictures[0].pictureURL + " Numstars: " + myModel.pictures[0].numStars);
        } else if (id == R.id.star0 || id == R.id.star1 || id == R.id.star2 || id == R.id.star3 || id == R.id.star4 || id == R.id.star5) {
            // sets filter numbner
            int filter_number;
            if (id == R.id.star0) {
                filter_number = 0;
            } else if (id == R.id.star1) {
                filter_number = 1;
            } else if (id == R.id.star2) {
                filter_number = 2;
            } else if (id == R.id.star3) {
                filter_number = 3;
            } else if (id == R.id.star4) {
                filter_number = 4;
            } else {
                filter_number = 5;
            }

            myModel.filterNumber = filter_number;

            // Clear everything
            int image_id;
            for(int i = 0; i < myModel.pictures.length; ++i) {
                image_id = view_id_array[i];

                ImageView imageView = findViewById(image_id);
                imageView.setImageResource(0);
            }


            // new DownloadImageFromInternet((ImageView) findViewById(R.id.cardImage1)) .execute("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/bunny.jpg");
            int image_id2;
            String image_url;
            int view_id_index = 0;
            for(int i = 0; i < myModel.pictures.length; ++i) {
                if (myModel.pictures[i].numStars >= filter_number) {
                    image_id2 = view_id_array[view_id_index];
                    image_url = myModel.pictures[i].pictureURL;
                    new DownloadImageFromInternet((ImageView) findViewById(image_id2)).execute(image_url);
                    myModel.pictures[i].currentLoadValue = view_id_index + 1;

                    // Update Rating
                    if (view_id_index == 0) {
//                        myModel.onclick = false;
                        myModel.onclick = false;
                        myRatingBar1.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
//                        myModel.onclick = true;
                    }

                    if (view_id_index == 1) {
                        myModel.onclick = false;
                        myRatingBar2.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
                        Log.d("Does it get removed", "num stars: " + myModel.pictures[i].numStars);
                    }

                    if (view_id_index == 2) {
                        myModel.onclick = false;
                        myRatingBar3.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
                    }

                    if (view_id_index == 3) {
                        myModel.onclick = false;
                        myRatingBar4.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
                    }

                    if (view_id_index == 4) {
                        myModel.onclick = false;
                        myRatingBar5.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
                    }

                    if (view_id_index == 5) {
                        myModel.onclick = false;
                        myRatingBar6.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
                    }

                    if (view_id_index == 6) {
                        myModel.onclick = false;
                        myRatingBar7.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
                    }

                    if (view_id_index == 7) {
                        myModel.onclick = false;
                        myRatingBar8.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
                    }

                    if (view_id_index == 8) {
                        myModel.onclick = false;
                        myRatingBar9.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
                    }

                    if (view_id_index == 9) {
                        myModel.onclick = false;
                        myRatingBar10.setRating((float) myModel.pictures[i].numStars);
                        myModel.onclick = true;
                    }

                    view_id_index += 1;
                }
            }

            Log.d("View ID INDex", "Current id: " + view_id_index);
            // Clear the rest
            for (int i = view_id_index; i < myModel.pictures.length; ++i) {
                // Update Rating
                if (i == 0) {
                    myModel.onclick = false;
                    myRatingBar1.setRating(0F);
                    myModel.onclick = true;
                }

                if (i == 1) {
                    myModel.onclick = false;
                    myRatingBar2.setRating(0F);
                    myModel.onclick = true;
                }

                if (i == 2) {
                    myModel.onclick = false;
                    myRatingBar3.setRating(0F);
                    myModel.onclick = true;
                }

                if (i == 3) {
                    myModel.onclick = false;
                    myRatingBar4.setRating(0F);
                    myModel.onclick = true;
                }

                if (i == 4) {
                    myModel.onclick = false;
                    myRatingBar5.setRating(0F);
                    myModel.onclick = true;
                }

                if (i == 5) {
                    myModel.onclick = false;
                    myRatingBar6.setRating(0F);
                    myModel.onclick = true;
                }

                if (i == 6) {
                    myModel.onclick = false;
                    myRatingBar7.setRating(0F);
                    myModel.onclick = true;
                }

                if (i == 7) {
                    myModel.onclick = false;
                    myRatingBar8.setRating(0F);
                    myModel.onclick = true;
                }

                if (i == 8) {
                    myModel.onclick = false;
                    myRatingBar9.setRating(0F);
                    myModel.onclick = true;
                }

                if (i == 9) {
                    myModel.onclick = false;
                    Log.d("View ID In", "GOT HEEEEEEERRRREEE");
                    myRatingBar10.setRating(0F);
                    myModel.onclick = true;
                }
            }
        }

        return super.onOptionsItemSelected(item);
    }


    public class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}
