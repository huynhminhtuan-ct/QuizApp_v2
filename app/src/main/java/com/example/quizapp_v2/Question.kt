package com.example.quizapp_v2

class Question(
    _id: Int, _question: String, _answer: String,
    _listAnswer: List<String>, _img: Int
) {
     var id: Int = _id
        get() = field
        set(value) {
            field = value
        }
     var question: String = _question
        get() = field
        set(value) {
            field = value
        }
     var answer: String = _answer
        get() = field
        set(value) {
            field = value
        }
     var listAnswer: List<String> = _listAnswer
        get() = field
        set(value) {
            field = value
        }
     var img: Int = _img
        get() = field
        set(value) {
            field = value
        }

}