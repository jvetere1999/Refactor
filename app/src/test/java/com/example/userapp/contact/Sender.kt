package com.example.userapp.contact

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserter
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.client.WebClient


data class Content(val id: String, val start: String, val end: String)

fun contentFromString(content: String): Content {
    TODO("Implement string capture")
}


val client: WebClient = WebClient.create("http://localhost:8080")

fun POST(uri: String, body: Content): String {
    return client.post()
        .uri("uri")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .accept(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(body))
        .retrieve()
        .bodyToMono(String.javaClass)
        .block()?.toString() ?: "ERR"
}


fun checkIn(data: String): Boolean {
    val mapping: String = "/check-in"

    return POST(mapping, contentFromString(data)) == ""
}