package com.platzi.android.firestore.network

import java.lang.Exception

/**
 * @author Santiago Carrillo
 * 3/7/19.
 */
interface  Callback<T>{         //Tipo generico
    fun onSuccess(result :T?)    //Operacion exitosa

    fun OnFailed(exception: Exception) //operacion fracaso
}