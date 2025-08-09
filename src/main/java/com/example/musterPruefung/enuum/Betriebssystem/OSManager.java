package com.example.musterPruefung.enuum.Betriebssystem;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

enum Betriebssystem {
    WINDOWS("Microsoft", false, "11"),
    LINUX("Community", true, "6.6"),
    MACOS("Apple", false, "14.0"),
    UBUNTU("Canonical", true, "22.04");

    private final String hersteller;
    private final boolean openSource;
    private final String version;

    Betriebssystem(String hersteller, boolean openSource, String version) {
        this.hersteller = hersteller;
        this.openSource = openSource;
        this.version = version;
    }

    public String getHersteller() {
        return hersteller;
    }

    public boolean isOpenSource() {
        return openSource;
    }

    public String getVersion() {
        return version;
    }

    static Optional<Betriebssystem> fromName(String name) {
        return Arrays.stream(values())
                .filter(x -> x.name().equalsIgnoreCase(name))
                .findFirst();

    }


    public String getBeschreubung() {
        return String.format("%s (%s, %s, Version %s)",
                name(),
                hersteller,
                isOpenSource() ? "Open Source" : "Closed Source",
                version
        );
    }

}

public class OSManager {
    public static void main(String[] args) {

        for (Betriebssystem el : Betriebssystem.values()) {
            System.out.printf("[%d] %s%n", el.ordinal(), el.getBeschreubung());
        }

        System.out.println("Введите операционную систему: ");
        Scanner sc = new Scanner(System.in);
        String osName = sc.nextLine();

        var optionalOsEnum = Betriebssystem.fromName(osName);

        if (optionalOsEnum.isPresent()) {
            Betriebssystem osEnum = optionalOsEnum.get();
            System.out.printf(
                    """
                            Найдено: %s
                            Производитель: %s
                            Версия: %s
                            Enum-индекс (ordinal): %d
                            """,
                    osEnum.getBeschreubung(),
                    osEnum.getHersteller(),
                    osEnum.getVersion(),
                    osEnum.ordinal()
            );
        }
    }
}

