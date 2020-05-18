package com.simileoluwaaluko.unittesting.ui

/**
 * Created by Simileoluwa Aluko on 2020-05-12.
 */
class Resource<T>(status: Status, data: T?, message: String?) {
    val status: Status
    val data: T?
    val message: String?

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    override fun equals(obj: Any?): Boolean {
        if (obj?.javaClass != javaClass || obj.javaClass != Resource::class.java) {
            return false
        }
        val resource: Resource<T> = obj as Resource<T>
        if (resource.status != status) {
            return false
        }
        if (data != null) {
            if (resource.data !== data) {
                return false
            }
        }
        if (resource.message != null) {
            if (message == null) {
                return false
            }
            if (resource.message != message) {
                return false
            }
        }
        return true
    }

    override fun hashCode(): Int {
        var result = status.hashCode()
        result = 31 * result + (data?.hashCode() ?: 0)
        result = 31 * result + (message?.hashCode() ?: 0)
        return result
    }

    companion object {
        fun <T> success(data: T, message: String): Resource<T> {
            return Resource(Status.SUCCESS, data, message)
        }

        fun <T> error(data: T?, msg: String): Resource<T?> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T?> {
            return Resource(Status.LOADING, data, null)
        }
    }

    init {
        this.status = status
        this.data = data
        this.message = message
    }
}
