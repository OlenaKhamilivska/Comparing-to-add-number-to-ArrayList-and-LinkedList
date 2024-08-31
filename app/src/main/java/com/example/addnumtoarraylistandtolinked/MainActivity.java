package com.example.addnumtoarraylistandtolinked;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            int randomValue = random.nextInt(100);
            arrayList.add(randomValue);
            linkedList.add(randomValue);
        }

        long startTimeArray = System.nanoTime();
        arrayList.add(100, 50);
        long endTimeArray = System.nanoTime();
        long elapsedTimeArray = endTimeArray - startTimeArray;
        System.out.println("Elapsed time Array is" + " " + elapsedTimeArray);

        long startTimeLinked = System.nanoTime();
        linkedList.add(100, 50);
        long endTimeLinked = System.nanoTime();
        long elapsedTimeLinked = endTimeLinked - startTimeLinked;
        System.out.println("Elapsed time Linked is" + " " + elapsedTimeLinked);
    }
}