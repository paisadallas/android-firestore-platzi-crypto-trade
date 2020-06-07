package com.platzi.android.firestore.network

import com.google.firebase.firestore.FirebaseFirestore

import com.platzi.android.firestore.model.Crypto
import com.platzi.android.firestore.model.User
import java.lang.Exception


/**
 * @author Santiago Carrillo
 * 3/7/19.
 */

const val CRYPTO_COLLECTION_NAME = "cryptos"
const val USERS_COLLECTION_NAME = "users"


class FirestoreService(val firebaseFirestore: FirebaseFirestore) {   //module de firebase

    //Set document
    fun setDocument(data: Any, collectionName: String, id:String, callback: Callback<Void>){
        firebaseFirestore.collection(collectionName).document(id).set(data)
            .addOnSuccessListener { callback.onSuccess(null) }
            .addOnFailureListener{exception -> callback.OnFailed(exception) }
    }

    //Update user

    fun updateUser(user: User, callback: Callback<User>?){
        firebaseFirestore.collection(USERS_COLLECTION_NAME)
            .document(user.username)
            .update("cryptosList",user.cryptoList)
            .addOnSuccessListener { result ->
                if(callback != null)
                    callback.onSuccess(user)
            }
            .addOnFailureListener() { exeption -> callback!!.OnFailed(exeption)}
    }

    fun updateCrypto(crypto: Crypto){
        firebaseFirestore.collection(CRYPTO_COLLECTION_NAME).document(crypto.getDocumentId())
            .update("availble",crypto.available)
    }



}