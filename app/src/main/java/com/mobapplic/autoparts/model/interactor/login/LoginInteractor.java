package com.mobapplic.autoparts.model.interactor.login;


import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mobapplic.autoparts.model.entity.user.User;
import com.mobapplic.autoparts.model.repository.user.UserRepository;
import com.mobapplic.autoparts.presenter.login.LoginPresenter;
import com.mobapplic.autoparts.utils.secure.SecureUtils;

import io.realm.Realm;

public class LoginInteractor {

    FirebaseAuth mAuth;
    UserRepository mUserRepository;
    Realm mRealm;

    public LoginInteractor(FirebaseAuth auth, Realm realm) {
        mAuth = auth;
        mRealm = realm;
    }

    public void login(final String user, final String pass, final LoginPresenter.OnLoginListener loginListener) {
        mAuth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            //todo error msg
                            loginListener.onError();
                        } else {
                            User u = new User();
                            u.setUserName(user);
                            u.setPassword(SecureUtils.encrypt(pass));
                            mRealm.beginTransaction();
                            mUserRepository.addObject(u);
                            mRealm.commitTransaction();
                            loginListener.onSuccess();
                        }
                    }
                });

    }
}
