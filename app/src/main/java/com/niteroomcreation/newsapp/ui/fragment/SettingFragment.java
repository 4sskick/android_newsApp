package com.niteroomcreation.newsapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.niteroomcreation.newsapp.R;
import com.niteroomcreation.newsapp.databinding.FSettingBinding;
import com.niteroomcreation.newsapp.ui.BaseFragment;
import com.niteroomcreation.newsapp.util.LogHelper;
import com.niteroomcreation.newsapp.util.SettingUtil;

/**
 * Created by Septian Adi Wijaya on 25/03/2021.
 * please be sure to add credential if you use people's code
 */
public class SettingFragment extends BaseFragment {

    public static final String TAG = SettingFragment.class.getSimpleName();

    private FSettingBinding binding;
    private SettingUtil settingUtil;

    @Override
    public View onInflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        settingUtil = new SettingUtil(getContext());

        binding = FSettingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void initUI() {
        switch (settingUtil.getTheme()) {
            case SettingUtil.THEME_LIGHT:
                binding.settingRbLight.setChecked(true);
                break;

            case SettingUtil.THEME_DARK:
                binding.settingRbDark.setChecked(true);
                break;

            default:
                binding.settingRbLight.setChecked(true);

        }

        binding.settingRgTheme.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                LogHelper.e(TAG, checkedId);

                switch (checkedId) {
                    case R.id.setting_rb_light:
                        settingUtil.setTheme(SettingUtil.THEME_LIGHT);
                        break;

                    case R.id.setting_rb_dark:
                        settingUtil.setTheme(SettingUtil.THEME_DARK);
                        break;

                    default:
                        settingUtil.setTheme(SettingUtil.THEME_LIGHT);
                }

                getActivity().recreate();
//                getActivity().finish();
//                getActivity().startActivity(getActivity().getIntent());
//                getActivity().overridePendingTransition(0, 0);


//                RadioButton rb = radioGroup.getRootView().findViewById(checkedId);
//                LogHelper.e(TAG, rb.getText(), rb.getId());
            }
        });
    }

    @Override
    public void destroyUI() {
        binding = null;
    }
}
