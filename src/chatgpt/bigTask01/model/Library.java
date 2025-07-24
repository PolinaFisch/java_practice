
package chatgpt.bigTask01.model;

import chatgpt.bigTask01.exception.AlreadyRegisteredException;
import chatgpt.bigTask01.exception.BookAlreadyLoanedException;
import chatgpt.bigTask01.exception.BookNotFoundException;
import chatgpt.bigTask01.exception.MemberNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Library {
    private List<Book> catalog = new ArrayList<>();
    private Set<Member> members = new HashSet<>();
    private Map<Member, List<LoanRecord>> loans = new HashMap<>();

    public void registerMember(Member m) {
        if (members.contains(m)) {
            throw new AlreadyRegisteredException("Member with ID = %s already registered.".formatted(m.getMemberId()));
        }
        members.add(m);
    }

    public void addBook(Book b) {
        catalog.add(b);
    }

    public void loanBook(String isbn, String memberId) {
        if (catalog.stream().noneMatch(book -> book.getIsbn().equals(isbn))) {
            throw new BookNotFoundException("Book with isbn %s is not found in catalog.".formatted(isbn));
        }

        if (members.stream().noneMatch(member -> member.getMemberId().equals(memberId))) {
            throw new MemberNotFoundException(String.format("Member with this %s ID is not found", memberId));
        }
        Member member = members.stream()
                .filter(mem -> mem.getMemberId().equals(memberId))
                .findFirst()
                .get();
        Book book = catalog.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .get();
        List<LoanRecord> loanRecords = loans.entrySet().stream()
                .filter(pair -> pair.getKey().equals(member))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(new ArrayList<>());
        if (loanRecords.stream().anyMatch(b -> b.equals(book))) {
            throw new BookAlreadyLoanedException(String.format("Book with isbn %s is already loaned by member %s", isbn, memberId));
        } else {
            LoanRecord loanRecord = new LoanRecord(book, LocalDate.now().plusDays(15));
            loanRecords.add(loanRecord);
            loans.put(member, loanRecords);
            catalog.remove(book);
        }
    }


    public void returnBook(String isbn, String memberId) {
        Member member = members.stream()
                .filter(memb -> memb.getMemberId().equals(memberId))
                .findFirst()
                .orElseThrow(() -> new MemberNotFoundException(String.format("Member with this %s ID is not found", memberId)));
        List<LoanRecord> memberLoans = loans.get(member);
        LoanRecord loanRecord = memberLoans.stream()
                .filter(x -> x.getBook().getIsbn().equals(isbn))
                .findFirst()
                .get();
        if (memberLoans.contains(loanRecord)) {
            memberLoans.remove(loanRecord);
            loans.put(member, memberLoans);
            catalog.add(loanRecord.getBook());
        }
    }

    public List<Book> findBooksByAuthor(String author) {
        return catalog.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList()); //-изменяемый список, а этот нет: .toList
    }

    // HA

    public List<Book> findBooksByGenre(Genre genre) {
        return catalog.stream()
                .filter(book -> book.getGenre() == genre)
                .collect(Collectors.toList());
    }

    public List<Book> listAvailableBooks() {
        return catalog;
    }

    public List<Book> listLoanedBooks() {
        return loans.values().stream()
                .flatMap(x -> x.stream())
                .map(LoanRecord::getBook)
                .toList();
    }

    public void sortCatalog() {
        Collections.sort(catalog);
    }

    public void sortMembers(Comparator<Member> comp) {
        Set<Member> sortedMembers = new TreeSet<>(comp);
        sortedMembers.addAll(members);
        members = sortedMembers;
    }

    public List<LoanRecord> listOverdueBooks(LocalDate onDate) {
        return loans.values().stream()
                .flatMap(Collection::stream)
                .filter(loanRecord -> loanRecord.getDueDate().isBefore(onDate))
                .toList();
    }

}


