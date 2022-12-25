package models

data class Customer (val name: String) {
    fun customerHasLongName() = name.length > 10
}