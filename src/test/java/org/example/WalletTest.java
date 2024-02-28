package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Wallet wallet;

    @BeforeEach
    public void setUp() {
        String ownerName = "Robertus Dimas Sena Kusuma";
        System.out.println("calling");
        wallet = new Wallet(ownerName);
    }

    @Test
    public void testAddCard() {
        String cardName = "Mandiri";
        wallet.addCard(cardName);
        assertTrue(wallet.getlistCard().contains(cardName));
    }


    @Test
    public void testAmbilCard() {
        // Menambahkan kartu "Mandiri" ke dalam dompet
        wallet.addCard("Mandiri");

        // Mengambil kartu "Mandiri" dari dompet
        String card = wallet.AmbilCard("Mandiri");

        // Memeriksa apakah kartu yang diambil adalah "Mandiri"
        assertEquals("Mandiri", card);

        // Memastikan bahwa kartu "Mandiri" telah dihapus dari dompet
        assertFalse(wallet.getlistCard().contains("Mandiri"));
    }

    @Test
    public void TambahUangRupiah() {
        // Menambahkan uang kertas 15000 ke dalam dompet
        wallet.TambahUangRupiah(15000);

        // Memeriksa apakah uang kertas 5000 telah ditambahkan ke dalam daftar uang kertas dalam dompet
        assertTrue(wallet.gelistUangLembar().contains(15000));

        // Menambahkan uang koin 500 ke dalam dompet
        wallet.TambahUangRupiah(500);

        // Memeriksa apakah uang koin 500 telah ditambahkan ke dalam daftar uang koin dalam dompet
        assertTrue(wallet.getlistUangKoin().contains(500));
    }

    @Test
    public void MenarikUang() {
        // Menambahkan uang sebesar 10000 ke dalam dompet
        wallet.TambahUangRupiah(10000);

        // Mengambil uang sebesar 10000 dari dompet
        int uang = wallet.MenarikUang(10000);

        // Memeriksa apakah uang yang diambil adalah 1000
        assertEquals(10000, uang);

        // Memastikan bahwa uang 1000 telah diambil dari dompet
        assertFalse(wallet.listUangLembar.contains(1000));
    }

    @Test
    public void TampilkanJumlahUang() {
        // Menambahkan uang kertas 5000 ke dalam dompet
        wallet.TambahUangRupiah(50000);

        // Menambahkan uang koin 500 ke dalam dompet
        wallet.TambahUangRupiah(500);

        // Mengambil total uang yang ada dalam dompet
        int jumlahUang = wallet.TampilkanJumlahUang();

        // Memeriksa apakah total uang yang ada dalam dompet adalah 5500
        assertEquals(50500, jumlahUang);
    }
    @Test
    public void testAmbilKartu_tidakkeluar() {
        // Mengambil kartu "KTP" dari dompet
        String card = wallet.AmbilCard("KTP");

        // Memeriksa apakah kartu "KTP" tidak keluar dari dompet (null)
        assertNull(card);
    }
}