package com.example.checkapartment.fragments.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.checkapartment.R;
import com.example.checkapartment.databinding.FragmentLoginBinding;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    TextInputLayout tilemail, tilpass;
    Button boton;
    private int contadorClicks = 2;
    private boolean loginBol = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        tilemail = binding.tilemail;
        tilpass = binding.tilpass;
        boton = binding.botonLogin;

        boton.setOnClickListener(view -> {


            if (contadorClicks != 0) {

                controlLogin();
                contadorClicks--;
                if (!loginBol) {
                    Toast.makeText(getContext(), "Restan " + (contadorClicks + 1) + " intentos"
                            , Toast.LENGTH_SHORT).show();
                }
            } else {
                boton.setEnabled(false);
                boton.setClickable(false);
                Toast.makeText(getContext(), "Demasiados intentos fallidos. Reinicie App"
                        , Toast.LENGTH_LONG).show();
            }

        });

        return binding.getRoot();


    }

    private void controlLogin() {
        String email = tilemail.getEditText().getText().toString();
        String pass = tilpass.getEditText().getText().toString();
        String validPass = "123Pass";
        boolean passOk = pass.equals(validPass);
        boolean validEmail = validEmail(email);

        if (email.isEmpty()) {
            tilemail.setError("Debe Ingresar un Emilio");
        }
        if (!validEmail) {
            tilemail.setError("Email inv??ildo");
        }

        if (pass.isEmpty()) {
            tilpass.setError("Debe Ingresar Su Password");
        } else if (!passOk) {
            tilpass.setError("Contrase??a incorrecta");
        }

        if (!email.isEmpty() && !pass.isEmpty() && passOk && validEmail) {
            tilpass.setError(null);
            tilemail.setError(null);
            loginBol = true;

            Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_listFragment);

        }

    }

    public boolean validEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}