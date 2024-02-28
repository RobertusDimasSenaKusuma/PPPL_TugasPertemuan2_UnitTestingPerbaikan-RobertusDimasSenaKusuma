package org.example;


import java.util.ArrayList;
import java.util.List;

public class Wallet {
    String pemilikWallet  ;
    ArrayList<String> listCard;
    ArrayList<Integer> listUangKoin;
    ArrayList<Integer> listUangLembar;
    
    public Wallet(String pemilikWallet) {
        this.pemilikWallet =  pemilikWallet;
        this.listCard = new ArrayList<>();
        this.listUangKoin = new ArrayList<>();
        this.listUangLembar = new ArrayList<>();
    }
    public void setPemilikWallet(String pemilikWallet) {
        this.pemilikWallet = pemilikWallet;
    }

    public void addCard(String cardName) {
        this.listCard.add(cardName);
    }

    public String AmbilCard(String cardName) {
        boolean isRemoved = this.listCard.remove(cardName);
        if (isRemoved) {
            return cardName;
        }
        return null;
    }

    public void TambahUangRupiah(Integer uang) {
        if (uang < 0) {
            throw new IllegalArgumentException("uang anda kurang");
        }
        if (uang > 1000) {
            listUangLembar.add(uang);
        } else {
            listUangKoin.add(uang);
        }
    }

    public int MenarikUang(int uang) {
        boolean AmbilUangLembar = this.listUangLembar.remove(Integer.valueOf(uang));
        if (AmbilUangLembar) {
            return uang;
        }

        boolean AmbilUangKoin = this.listUangKoin.remove(Integer.valueOf(uang));
        if (AmbilUangKoin) {
            return uang;
        }

        return 0;
    }

    public int TampilkanJumlahUang() {
        int jumlahUang = 0;
        for (Integer uang : listUangKoin) {
            jumlahUang += uang;
        }
        for (Integer uang : listUangLembar) {
            jumlahUang += uang;
        }
        return jumlahUang;
    }

    public String getPemilikWallet() {
        return pemilikWallet;
    }

    public List<String> getlistCard() {
        return new ArrayList<>(listCard);
    }

    public List<Integer> gelistUangLembar() {
        return new ArrayList<>(listUangLembar);
    }

    public List<Integer> getlistUangKoin() {
        return new ArrayList<>(listUangKoin);
    }
}