package com.example.geomap12;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RocamicroContentFragment extends Fragment {


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable
          Bundle savedInstanceState) {
    View layout = inflater.inflate(R.layout.rocamicro_fragment, container, false);

    ((HomeActivity) getActivity()).setTitulo(R.string.menu_micro);


    return layout;
  }
}

