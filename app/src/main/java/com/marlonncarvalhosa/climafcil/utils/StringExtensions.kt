package com.marlonncarvalhosa.climafcil.utils

fun Double.beforeDot(): String {
    return this.toString().split(".").firstOrNull() ?: this.toString()
}