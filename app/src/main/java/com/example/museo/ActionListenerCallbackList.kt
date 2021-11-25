package com.example.museo

interface ActionListenerCallbackList {

    fun onActionSuccess(successMessage:item_list)

    fun onActionFailure(throwableError: Throwable)

}