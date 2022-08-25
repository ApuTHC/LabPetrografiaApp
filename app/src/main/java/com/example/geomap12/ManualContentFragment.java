package com.example.geomap12;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class ManualContentFragment extends Fragment {


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable
          Bundle savedInstanceState) {
    View layout = inflater.inflate(R.layout.manual_fragment, container, false);

    ((HomeActivity) getActivity()).setTitulo(R.string.menu_manual);



    return layout;
  }
}

