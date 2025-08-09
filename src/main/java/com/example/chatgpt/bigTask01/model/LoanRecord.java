package com.example.chatgpt.bigTask01.model;

import java.time.LocalDate;

public class LoanRecord {
    private final Book book;
    private final LocalDate loanDate;
    private final LocalDate dueDate;

    public LoanRecord(Book book, LocalDate dueDate) {
        this.book = book;
        loanDate =  LocalDate.now();
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof LoanRecord that)) return false;

        return book.getIsbn().equals(that.book.getIsbn());
    }

    @Override
    public int hashCode() {
        return book.hashCode();
    }

    @Override
    public String toString(){
        return String.format("LoanRecord:[isbn=`%s`, taken=`%s`, due=`%s`]",book.getIsbn(),loanDate,dueDate);
    }
}