package com.mobapplic.autoparts.model.interactor.login;


import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mobapplic.autoparts.presenter.login.LoginPresenter;

public class LoginInteractor {

    FirebaseAuth mAuth;

    public LoginInteractor(FirebaseAuth auth) {
        mAuth = auth;
    }

    public void login(String user, String pass, final LoginPresenter.OnLoginListener loginListener) {
        mAuth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            //todo error msg
                            loginListener.onError();
                        } else {
                            loginListener.onSuccess();
                        }
                    }
                });

    }
}
