package com.mobapplic.autoparts.model.interactor.signup;


import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.mobapplic.autoparts.model.user.User;
import com.mobapplic.autoparts.presenter.signup.SignUpPresenter;
import com.mobapplic.autoparts.utils.secure.SecureUtils;

import io.realm.Realm;

import static com.mobapplic.autoparts.App.getContext;

public class SignUpInteractor {

    private FirebaseAuth mAuth;
    private Realm mRealm;

    public SignUpInteractor(FirebaseAuth auth) {
        mAuth = auth;
        mRealm = Realm.getInstance(getContext());
    }

    public void signUp(final String username, final String password, final SignUpPresenter.SignUpListener signUpListener) {
        mRealm.beginTransaction();
        mAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            //todo error msg
                            try {
                                throw task.getException();
                            } catch(FirebaseAuthWeakPasswordException e) {
                                signUpListener.onError(); //setError(getString(R.string.password_length_error));
                            } catch(FirebaseAuthInvalidCredentialsException e) {
                                signUpListener.onError(); //setError(getString(R.string.error_invalid_email));
                            } catch(FirebaseAuthUserCollisionException e) {
                                signUpListener.onError(); //setError(getString(R.string.error_user_exists));
                            } catch(Exception e) {
                                signUpListener.onError();
                            }

                        } else {
                            User user = mRealm.createObject(User.class);
                            user.setUserName(username);
                            user.setPassword(SecureUtils.encrypt(password));
                            mRealm.commitTransaction();
                            signUpListener.onSuccess();
                        }
                    }
                });
    }
}
