package com.example.museo

interface ActionListenerCallback {

    fun onActionSuccess(successMessage: MuseumItem)

    fun onActionFailure(throwableError: Throwable)
}