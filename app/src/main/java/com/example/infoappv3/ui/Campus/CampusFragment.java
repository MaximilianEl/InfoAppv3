package com.example.infoappv3.ui.Campus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.infoappv3.R;

// Hier kommt die campusmap hin mit den Extrahinweisen wo was ist usw.
// vllt noch Haltestellen

public class CampusFragment extends Fragment {

  private CampusViewModel campusViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    campusViewModel =
        ViewModelProviders.of(this).get(CampusViewModel.class);
    View root = inflater.inflate(R.layout.fragment_campus, container, false);
    final TextView textView = root.findViewById(R.id.text_gallery);
    campusViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}