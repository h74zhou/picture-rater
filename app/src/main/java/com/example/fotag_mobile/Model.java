package com.example.fotag_mobile;

import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.*;

class CustomPicture {
    Integer numStars = 0;
    String pictureURL = "";
    Integer currentLoadValue = 0;


    CustomPicture(String newURL) {
        pictureURL = newURL;
    };

}


public class Model {
    public int currentNumStars = 0;

    public Boolean onclick = true;

    public Boolean currentLoaded = false;

    public String popUpURL = "";

    // Bunny
    CustomPicture bunny = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/bunny.jpg");

    // Chinchilla
    CustomPicture chinchilla = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/chinchilla.jpg");

    // Doggo
    CustomPicture doggo = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/doggo.jpg");

    // fox
    CustomPicture fox = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/fox.jpg");

    // Hamster
    CustomPicture hamster = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/hamster.jpg");

    // Husky
    CustomPicture husky = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/husky.jpg");

    // Kitten
    CustomPicture kitten = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/kitten.png");

    // Loris
    CustomPicture loris = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/loris.jpg");

    // Puppy
    CustomPicture puppy = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/puppy.jpg");

    // Sleepy
    CustomPicture sleepy = new CustomPicture("https://www.student.cs.uwaterloo.ca/~cs349/s19/assignments/images/sleepy.png");

    public CustomPicture[] pictures = new CustomPicture[] { bunny, chinchilla, doggo, fox, hamster, husky, kitten, loris, puppy, sleepy};


}
