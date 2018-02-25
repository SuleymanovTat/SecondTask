package ru.suleymanovtat.secondtask.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.suleymanovtat.secondtask.R;
import ru.suleymanovtat.secondtask.SharedPreferencesHelper;

public class SearchFragment extends Fragment {

    private EditText edText;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        final SharedPreferencesHelper helper = new SharedPreferencesHelper(getActivity());
        edText = view.findViewById(R.id.edText);
        Button btnSearch = view.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edText.getText().toString().trim().isEmpty()) {
                    showMessage(R.string.enter_text);
                }else {
                    String[] stringArrayLink = getActivity().getResources().getStringArray(R.array.string_array_link);
                    Uri uri = Uri.parse(stringArrayLink[helper.getRadioButtonIndex()] + edText.getText());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    private void showMessage(int string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }
}
