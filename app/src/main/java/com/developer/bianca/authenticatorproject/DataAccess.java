package com.developer.bianca.authenticatorproject;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataAccess {

        private static DatabaseReference databaseReference;

        private static FirebaseAuth autentication;

        public static DatabaseReference getFirebase(){
            if (databaseReference == null){
                databaseReference = FirebaseDatabase.getInstance().getReference();
            }
            return databaseReference;
        }

        public static FirebaseAuth getFireBaseAuthentication(){
            if (autentication == null) {
                autentication = FirebaseAuth.getInstance();
            }
            return autentication;
        }
}
