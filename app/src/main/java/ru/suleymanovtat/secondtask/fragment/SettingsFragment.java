package ru.suleymanovtat.secondtask.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import ru.suleymanovtat.secondtask.R;
import ru.suleymanovtat.secondtask.SharedPreferencesHelper;

public class SettingsFragment extends Fragment {

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        final SharedPreferencesHelper helper = new SharedPreferencesHelper(getActivity());
        final RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        ((RadioButton) radioGroup.getChildAt(helper.getRadioButtonIndex())).setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = radioGroup.findViewById(checkedId);
                helper.saveRadioButtonIndex(radioGroup.indexOfChild(checkedRadioButton));
            }
        });
        return view;
    }
}
