package com.example.hollis.fragmentinterfacepractice;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimalClickInterface{
    AnimalListFragment animalListFragment;
    DetailFragment detailFragment;
    List<Animal> animalList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAnimalList();
        FragmentManager fragmentManager = getSupportFragmentManager();

        animalListFragment = new AnimalListFragment();

        animalListFragment.setAnimalList(animalList);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, animalListFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void setAnimalList(){
        animalList = new ArrayList<>();
        Animal animal = new Animal("Lion", "big", 4);
        Animal animal1 = new Animal("Fish", "small", 0);
        Animal animal2 = new Animal("Koala", "medium", 2);
        animalList.add(animal);
        animalList.add(animal1);
        animalList.add(animal2);
    }

    @Override
    public void onAnimalClicked(Animal animal) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(detailFragment == null ){
            detailFragment = new DetailFragment();
        }
        detailFragment.setAnimal(animal);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
