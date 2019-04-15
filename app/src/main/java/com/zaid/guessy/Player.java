package com.zaid.guessy;

// Class untuk PLAYER Game yang main
public class Player {
    // id PLAYER
    private int id;
    // username PLAYER
    private String username;
    // score PLayer
    private int score;

    public Player(int id, String username, int score) {
        this.id = id;
        this.username = username;
        this.score = score;
    }
    // Mendapatkan Id Player
    public int getId() {
        return id;
    }

    // Mengatur Id Player sesuai dengan inputan id
    public void setId(int id) {
        this.id = id;
    }

    // Mendapatkan Username Player
    public String getUsername() {
        return username;
    }

    // Mengatur Username Player sesuai dengan inputan username
    public void setUsername(String username) {
        this.username = username;
    }

    // Mendapatkan Score Player
    public int getScore() {
        return score;
    }

    // Mengatur Score Player sesuai dengan inputan score
    public void setScore(int score) {
        this.score = score;
    }
}
