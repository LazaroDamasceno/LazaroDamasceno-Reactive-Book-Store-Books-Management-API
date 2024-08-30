package com.api.v1.mappers;

import com.api.v1.domain.entities.Book;
import com.api.v1.dtos.responses.BookResponseDto;

public class BookResponseMapper {

    public static BookResponseDto map(Book book) {
        return new BookResponseDto(
                book.getFullTitle(),
                book.getIsbn(),
                book.getAuthor(),
                book.getField(),
                book.getNumberOfPages(),
                book.getVersion(),
                book.getPrice(),
                book.getPublisher()
        );
    }

}
