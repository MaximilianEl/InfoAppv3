package com.example.infoappv3.ui.institute;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.infoappv3.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

// Hier kommen noch verlinkungen zu ErstiHilfe, Personen und veranstaltungen rein
// Link zu Kursen kommt auch noch rein

/**
 * A simple {@link Fragment} subclass. Use the {@link InstituteFragment#newInstance} factory method
 * to create an instance of this fragment.
 */
public class InstituteFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InstituteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided
     * parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InstituteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InstituteFragment newInstance(String param1, String param2) {
        InstituteFragment fragment = new InstituteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment1
        return inflater.inflate(R.layout.fragment_institute, container, false);
    }

    public void onActivityCreated(Bundle SavedInstanceState, ViewModel viewModel, View view) {
        super.onActivityCreated(SavedInstanceState);
        getInsData(view);

        TextView ins_header2 = view.findViewById(R.id.ins_header2);

        ins_header2.setOnClickListener(ins_secondclick);
    }

    private View.OnClickListener ins_secondclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            TextView ins_secondtext = view.findViewById(R.id.ins_secondtext);
            TextView ins_header2 = view.findViewById(R.id.ins_header2);

            if (ins_secondtext.length() <= 0 ) {
                ins_header2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);
                //ins_secondtext.visibility = VISIBLE;
                fillTextTwo(view);
            } else {
                ins_header2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
                ins_secondtext.setText("");
                //ins_secondtext.visibility = GONE;
            }
        }
    };

    static void getInsData(View view) {
        String url =
                "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/#c8477468";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements text = doc.getElementsByTag("p");

        Elements header = doc.select("a[data-toggle]");

        String firsttext = text.get(0).text();
        String secondtext = text.get(1).text();
        String thirdtext = text.get(2).text();
        String fourthtext = text.get(3).text();
        String fulltext = firsttext + secondtext + thirdtext + fourthtext;

        TextView insText = view.findViewById(R.id.insText);
        TextView ins_header1 = view.findViewById(R.id.ins_header1);
        TextView ins_header2 = view.findViewById(R.id.ins_header2);
        TextView ins_header3 = view.findViewById(R.id.ins_header3);

        insText.setText(fulltext);
        ins_header1.setText(header.get(0).text());
        ins_header2.setText(header.get(1).text());
        ins_header3.setText(header.get(2).text());
    }

    static void fillTextTwo(View view) {
        String url =
                "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/#c8477468";
        Document doc = Jsoup.connect(url).get();

        Elements p = doc.getElementsByTag("p");

        String text1 = p[4].text();
        String text2 = p[5].text();
        String text3 = p[6].text();
        String fulltext = text1 + text2 + text3;

        TextView ins_secondtext = view.findViewById(R.id.ins_secondtext);

        ins_secondtext.setText(fulltext);
    }

    static void fillTextThree(View view) {
        String url =
                "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/#c8477468";
        Document doc = Jsoup.connect(url).get();

        Elements p = doc.getElementsByTag("p");

        String text1 = p[8].text();
        String text2 = p[9].text();
        String text3 = p[10].text();
        String fulltext = text1 + " " + text2 + " " + text3;

        TextView ins_thirdtext = view.findViewById(R.id.ins_thirdtext);

        ins_thirdtext.setText(fulltext);
    }
}