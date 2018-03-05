package md.gva.translatetraining.domain

data class Message(var code: Int = -1, var lang: String = "", var text: List<String> = emptyList())
