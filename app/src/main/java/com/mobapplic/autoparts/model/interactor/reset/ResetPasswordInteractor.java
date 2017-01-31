package com.mobapplic.autoparts.model.interactor.reset;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.mobapplic.autoparts.presenter.reset.ResetPasswordPresenter;

public class ResetPasswordInteractor {

    FirebaseAuth mAuth;

    public ResetPasswordInteractor(FirebaseAuth auth) {
        mAuth = auth;
    }

    public void resetPassword(String email, final ResetPasswordPresenter.OnResetListener resetListener) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            resetListener.onSuccess();
                        } else {
                            resetListener.onError();
                        }
                    }
                });
    }
}
