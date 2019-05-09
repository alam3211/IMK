package com.example.watchit;

public class Card {

    private int image;
    private String title;
    private int rating;
    private int watched;
    private String cast;
    private String synopsis;
    private String genre;
    private String releasedate;

    public Card(int image, String title, int rating, int watched) {
        this.image = image;
        this.title = title;
        this.rating = rating;
        this.watched = watched;
        this.cast = "Rosa Salazar, Christoph Waltz, Jennifer \n" +
                    "Connelly, Mahershala Ali, Ed Skrein,\n" +
                    " Jackie Earle Haley, Keean Johnson";
        this.synopsis = "Alita terbangun di dunia masa depan yang tak ia kenal, dan tanpa ingatan tentang siapa dirinya. Ia kemudian dibawa oleh Ido, seorang dokter simpatik yang menyadari bahwa di dalam tubuh robot Alita yang sempat terbengkalai itu terdapat hati dan jiwa seorang wanita muda dengan kisah masa lalu yang luar biasa";
        this.genre = "action , sci-fi, romance,\n" + "comedy";
        this.releasedate = "5 Februari  2019";
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getWatched() {
        return watched;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }
}
