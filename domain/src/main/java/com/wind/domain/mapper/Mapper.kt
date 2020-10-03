package com.wind.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}