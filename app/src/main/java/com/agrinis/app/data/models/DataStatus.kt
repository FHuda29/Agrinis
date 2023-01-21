package com.agrinis.app.data.models

class DataStatus<T>(var status: Status, var data: T? = null, var message: String? = null) {

    companion object {
        fun <T> loading(message: String?): DataStatus<T> {
            return DataStatus(Status.LOADING, null, message)
        }

        fun <T> success(data: T?): DataStatus<T> {
            return DataStatus(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String?): DataStatus<T> {
            return DataStatus(Status.ERROR, null, message)
        }
    }

    enum class Status {
        LOADING,
        SUCCESS,
        ERROR
    }
}