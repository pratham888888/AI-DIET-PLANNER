package com.example.aidietplanner_v1.Java.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.aidietplanner_v1.R;
import com.example.aidietplanner_v1.databinding.FragmentSignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupFragment extends Fragment {
    View v;
    private FragmentSignupBinding binding;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private String username,email,pass;

    public SignupFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignupBinding.inflate(inflater,container,false);
        v = binding.getRoot();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                username = binding.userSuName.getText().toString();
                email = binding.userSuMail.getText().toString();
                pass = binding.userSuPass.getText().toString();

                if(username.isEmpty() || email.isEmpty() || pass.isEmpty())
                    Toast.makeText(getContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                else if(validateMail(email) && validatePass(pass))
                    registerUser(email,pass);
            }
        });

        binding.existingUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frag_frame,new LoginFragment()).commit();
            }
        });

        binding.userSuPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    binding.passParameters.setText(String.format("%s",
                            "Should contain at least 8 characters and at most 20 characters.\n" +
                            "Should contain at least one digit.\n" +
                            "Should contain at least one upper case alphabet.\n" +
                            "Should contain at least one lower case alphabet.\n" +
                            "Should contain at least one special character which includes !@#$%&*()-+=^.\n" +
                            "It should not contain any white space."));
            }
        });
    }

    public void registerUser(String email, String pass){
        firebaseAuth.createUserWithEmailAndPassword(email,pass).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                            Bundle b = new Bundle();
                            b.putString("emailAddress",email);
                            LoginFragment loginFragment = new LoginFragment();
                            loginFragment.setArguments(b);

                            getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.main_frag_frame,new LoginFragment()).commit();
                        }
                        else{
                            Toast.makeText(getContext(), "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public boolean validateMail(String email){
        if(email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))
            return true;
        binding.userSuMail.setError("Invalid email address");
        return false;
    }

    public boolean validatePass(String pass){
        if(pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"))
            return true;
        binding.userSuPass.setError("Re-create password following given parameters");
        return false;
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View currentFocusedView = getActivity().getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}