package com.api.v2.book

class BookResponseMapper {

    companion object {
        fun map(book: Book): BookResponseDto {
            return BookResponseDto(
                book.fullTitle(),
                book.isbn,
                book.author,
                book.field,
                book.publisher,
                book.numberOfPages,
                book.version,
                book.publishingYear
            )
        }
    }

}