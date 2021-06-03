package com.bignerdranch.nyethack.extensions

fun <T> Iterable<T>.randomItem(): T = this.shuffled().first()