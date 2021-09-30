package com.sidorov.unittest.data

data class NoteDTO(
    var title: String,
    var description: String
) {
    fun toVO() =
        NoteVO(title = title, description = description, fullText = "$title - $description")
}

data class NoteVO(
    var title: String,
    var description: String,
    var fullText: String
) {
    fun toEntity() =
        NoteEntity(title = title, description = description, fullText = fullText, id = "testId")
}
