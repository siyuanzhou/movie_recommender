package com.my.recommender.model;

public class Comment {
    private int idComment;
    private int idUser;
    private int idFilm;
    private String content;

    public Comment() {
        // TODO Auto-generated constructor stub
    }

    public Comment(int idUser, String content) {
        // TODO Auto-generated constructor stub
        super();
        this.idUser = idUser;
        this.content = content;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
