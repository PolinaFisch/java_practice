package chatgpt.bigTask01.model;

import java.util.Objects;

public class Member {
    private final String memberId;
    private String firstName;
    private String lastName;

    public Member(String memberId, String firstName, String lastName) {
        //this.memberId = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Member member)) return false;

        return memberId.equals(member.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }

    public String getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("member:[%s, %s, %s]", memberId, firstName, lastName);
    }

}