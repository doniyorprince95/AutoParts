package com.mobapplic.autoparts.model.interactor.signup;


import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.mobapplic.autoparts.model.entity.user.User;
import com.mobapplic.autoparts.model.repository.user.UserRepository;
import com.mobapplic.autoparts.presenter.signup.SignUpPresenter;
import com.mobapplic.autoparts.utils.secure.SecureUtils;

import io.realm.Realm;

public class SignUpInteractor {

    private FirebaseAuth mAuth;
    private Realm mRealm;
    UserRepository mUserRepository;

    public SignUpInteractor(FirebaseAuth auth, Realm realm) {
        mAuth = auth;
        mUserRepository = new UserRepository(realm);
    }

    public void signUp(final String username, final String password, final SignUpPresenter.SignUpListener signUpListener) {
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
                            User user = new User();
                            user.setUserName(username);
                            user.setPassword(SecureUtils.encrypt(password));
                            mUserRepository.addObject(user);
                            signUpListener.onSuccess();
                        }
                    }
                });
    }
}
