package com.example.ventazapas.data.fireStore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ventazapas.data.model.ResponseShoes
import com.example.ventazapas.data.model.ResponseUser
import com.google.firebase.firestore.FirebaseFirestore

class FireStoreImp : FireStoreService {

    private val fireStore = FirebaseFirestore.getInstance()
    private val liveUser = MutableLiveData<ResponseUser>()

    override fun addUser(
        title: String,
        debt: Int,
        direction: String,
        dni: String,
        email: String,
        favorite: List<Int>,
        idEdit: Int,
        name: String,
        number: String,
        orders: List<Int>,
        shopping: List<Int>,
        state_account: Int,
        type: String
    ): String {
        if (fireStore.collection("user").document(title).set(
                hashMapOf(
                    "debt" to title,
                    "direction" to direction,
                    "dni" to dni,
                    "email" to email,
                    "favorite" to favorite,
                    "id_edit" to idEdit,
                    "name" to name,
                    "number" to number,
                    "orders" to orders,
                    "shopping" to shopping,
                    "state_account" to state_account,
                    "type" to type

                )
            ).isCanceled
        ) {
            return "success"

        } else {
            return "error"
        }
    }


    override fun getUser(title: String): MutableLiveData<ResponseUser> {
        fireStore.collection("user").document(title).get().addOnSuccessListener {
            if (!it.data.isNullOrEmpty()) {
                liveUser.postValue(
                    ResponseUser(
                        it.get("debt").toString().toInt(),
                        it.get("direction").toString(),
                        it.get("dni").toString(),
                        it.get("email").toString(),
                        it.get("favorite") as List<String>,
                        it.get("id_edit").toString().toInt(),
                        it.get("name").toString(),
                        it.get("number").toString(),
                        it.get("orders") as List<String>,
                        it.get("shopping") as List<String>,
                        it.get("state_account").toString().toInt(),
                        it.get("type").toString()
                    )
                )
            }else{
                liveUser.postValue(
                    ResponseUser(
                        0,
                        "",
                        "",
                        "",
                        listOf(),
                        0,
                        "empty",
                        "",
                        listOf(),
                        listOf(),
                        0,
                        ""
                    )
                )
            }

        }.addOnFailureListener {
            Log.d("res","error")

        }
        return liveUser
    }

    override fun editUser(): MutableLiveData<ResponseUser> {
        TODO("Not yet implemented")
    }

    override fun addShoes(): MutableLiveData<ResponseShoes> {
        TODO("Not yet implemented")
    }

    override fun getShoes(): MutableLiveData<ResponseShoes> {
        TODO("Not yet implemented")
    }

    override fun editShoes(): MutableLiveData<ResponseShoes> {
        TODO("Not yet implemented")
    }
}